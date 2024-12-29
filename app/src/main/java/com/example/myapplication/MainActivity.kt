package com.example.kalkulatorsederhana

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var inputBil1: EditText
    private lateinit var inputBil2: EditText
    private lateinit var btnTambah: Button
    private lateinit var btnKurang: Button
    private lateinit var btnKali: Button
    private lateinit var btnBagi: Button
    private lateinit var btnPangkat: Button
    private lateinit var btnAkarPangkat: Button
    private lateinit var txtHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi
        inputBil1 = findViewById(R.id.inputBil1)
        inputBil2 = findViewById(R.id.inputBil2)
        btnTambah = findViewById(R.id.btnTambah)
        btnKurang = findViewById(R.id.btnKurang)
        btnKali = findViewById(R.id.btnKali)
        btnBagi = findViewById(R.id.btnBagi)
        btnPangkat = findViewById(R.id.btnPangkat)
        btnAkarPangkat = findViewById(R.id.btnAkarPangkat)
        txtHasil = findViewById(R.id.txtHasil)

        // Event Tombol
        btnTambah.setOnClickListener { hitung("+") }
        btnKurang.setOnClickListener { hitung("-") }
        btnKali.setOnClickListener { hitung("*") }
        btnBagi.setOnClickListener { hitung("/") }
        btnPangkat.setOnClickListener { hitung("^") }
        btnAkarPangkat.setOnClickListener { akarPangkat() }
    }

    private fun hitung(operasi: String) {
        val bil1 = inputBil1.text.toString().toDoubleOrNull() ?: 0.0
        val bil2 = inputBil2.text.toString().toDoubleOrNull() ?: 0.0
        val hasil = when (operasi) {
            "+" -> bil1 + bil2
            "-" -> bil1 - bil2
            "*" -> bil1 * bil2
            "/" -> if (bil2 != 0.0) bil1 / bil2 else "Tidak bisa bagi nol"
            "^" -> bil1.pow(bil2)
            else -> "Error"
        }
        txtHasil.text = "Hasil: $hasil"
    }

    private fun akarPangkat() {
        val bil1 = inputBil1.text.toString().toDoubleOrNull() ?: 0.0
        txtHasil.text = "Hasil: ${sqrt(bil1)}"
    }
}
