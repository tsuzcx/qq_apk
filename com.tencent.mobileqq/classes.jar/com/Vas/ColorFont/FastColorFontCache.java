package com.Vas.ColorFont;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.util.SparseIntArray;
import java.util.HashMap;

public class FastColorFontCache
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static HashMap<String, BitmapShader> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static SparseIntArray jdField_b_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static HashMap<String, BitmapShader> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static SparseIntArray jdField_c_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static HashMap<String, Bitmap> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private static SparseIntArray jdField_d_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private static HashMap<String, Bitmap> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private static SparseIntArray e = new SparseIntArray();
  private static SparseIntArray f = new SparseIntArray();
  private static SparseIntArray g = new SparseIntArray();
  
  public static int a(int paramInt)
  {
    return jdField_c_of_type_AndroidUtilSparseIntArray.get(paramInt);
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (Bitmap)jdField_c_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4);
  }
  
  public static BitmapShader a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (BitmapShader)jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4);
  }
  
  public static void a(int paramInt)
  {
    int i = jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(paramInt);
    if (i >= 0) {
      jdField_a_of_type_AndroidUtilSparseIntArray.removeAt(i);
    }
    i = jdField_b_of_type_AndroidUtilSparseIntArray.indexOfKey(paramInt);
    if (i >= 0) {
      jdField_b_of_type_AndroidUtilSparseIntArray.removeAt(i);
    }
    i = jdField_c_of_type_AndroidUtilSparseIntArray.indexOfKey(paramInt);
    if (i >= 0) {
      jdField_c_of_type_AndroidUtilSparseIntArray.removeAt(i);
    }
    i = jdField_d_of_type_AndroidUtilSparseIntArray.indexOfKey(paramInt);
    if (i >= 0) {
      jdField_d_of_type_AndroidUtilSparseIntArray.removeAt(i);
    }
    i = e.indexOfKey(paramInt);
    if (i >= 0) {
      e.removeAt(i);
    }
    i = f.indexOfKey(paramInt);
    if (i >= 0) {
      f.removeAt(i);
    }
    paramInt = g.indexOfKey(paramInt);
    if (paramInt >= 0) {
      g.removeAt(paramInt);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_c_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4;
    if ((!jdField_c_of_type_JavaUtilHashMap.containsKey(str)) && (paramBitmap != null)) {
      jdField_c_of_type_JavaUtilHashMap.put(str, paramBitmap);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapShader paramBitmapShader)
  {
    String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4;
    if ((!jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (paramBitmapShader != null)) {
      jdField_a_of_type_JavaUtilHashMap.put(str, paramBitmapShader);
    }
  }
  
  public static int b(int paramInt)
  {
    return jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, 0);
  }
  
  public static Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (Bitmap)jdField_d_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4;
    if ((!jdField_d_of_type_JavaUtilHashMap.containsKey(str)) && (paramBitmap != null)) {
      jdField_d_of_type_JavaUtilHashMap.put(str, paramBitmap);
    }
  }
  
  public static int c(int paramInt)
  {
    return jdField_b_of_type_AndroidUtilSparseIntArray.get(paramInt, 0);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    jdField_b_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
  }
  
  public static int d(int paramInt)
  {
    return e.get(paramInt, 256);
  }
  
  public static void d(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      e.put(paramInt1, paramInt2);
    }
  }
  
  public static int e(int paramInt)
  {
    return jdField_d_of_type_AndroidUtilSparseIntArray.get(paramInt, 256);
  }
  
  public static void e(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      jdField_d_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
    }
  }
  
  public static int f(int paramInt)
  {
    return f.get(paramInt, 0);
  }
  
  public static void f(int paramInt1, int paramInt2)
  {
    f.put(paramInt1, paramInt2);
  }
  
  public static int g(int paramInt)
  {
    return g.get(paramInt, 0);
  }
  
  public static void g(int paramInt1, int paramInt2)
  {
    g.put(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontCache
 * JD-Core Version:    0.7.0.1
 */