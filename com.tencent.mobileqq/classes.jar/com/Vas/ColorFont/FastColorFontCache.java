package com.Vas.ColorFont;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.util.SparseIntArray;
import java.util.HashMap;

public class FastColorFontCache
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static SparseIntArray jdField_b_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static SparseIntArray jdField_c_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private static SparseIntArray d = new SparseIntArray();
  
  static int a(int paramInt)
  {
    return jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt);
  }
  
  static Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (Bitmap)jdField_b_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3);
  }
  
  static BitmapShader a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (BitmapShader)jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3);
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      jdField_b_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramInt3, paramBitmap);
    }
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, BitmapShader paramBitmapShader)
  {
    if (paramBitmapShader != null) {
      jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramInt3, paramBitmapShader);
    }
  }
  
  static int b(int paramInt)
  {
    return d.get(paramInt, 0);
  }
  
  static Bitmap b(int paramInt1, int paramInt2, int paramInt3)
  {
    return (Bitmap)jdField_c_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3);
  }
  
  static void b(int paramInt1, int paramInt2)
  {
    d.put(paramInt1, paramInt2);
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      jdField_c_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramInt3, paramBitmap);
    }
  }
  
  static int c(int paramInt)
  {
    return jdField_c_of_type_AndroidUtilSparseIntArray.get(paramInt, 256);
  }
  
  static void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      jdField_c_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
    }
  }
  
  static int d(int paramInt)
  {
    return jdField_b_of_type_AndroidUtilSparseIntArray.get(paramInt, 256);
  }
  
  static void d(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      jdField_b_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontCache
 * JD-Core Version:    0.7.0.1
 */