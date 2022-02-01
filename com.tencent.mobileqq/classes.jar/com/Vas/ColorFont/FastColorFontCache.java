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
    HashMap localHashMap = jdField_c_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    return (Bitmap)localHashMap.get(localStringBuilder.toString());
  }
  
  public static BitmapShader a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    return (BitmapShader)localHashMap.get(localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt4);
    localObject = ((StringBuilder)localObject).toString();
    if ((!jdField_c_of_type_JavaUtilHashMap.containsKey(localObject)) && (paramBitmap != null)) {
      jdField_c_of_type_JavaUtilHashMap.put(localObject, paramBitmap);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapShader paramBitmapShader)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt4);
    localObject = ((StringBuilder)localObject).toString();
    if ((!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) && (paramBitmapShader != null)) {
      jdField_a_of_type_JavaUtilHashMap.put(localObject, paramBitmapShader);
    }
  }
  
  public static int b(int paramInt)
  {
    return jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, 0);
  }
  
  public static Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = jdField_d_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    return (Bitmap)localHashMap.get(localStringBuilder.toString());
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt4);
    localObject = ((StringBuilder)localObject).toString();
    if ((!jdField_d_of_type_JavaUtilHashMap.containsKey(localObject)) && (paramBitmap != null)) {
      jdField_d_of_type_JavaUtilHashMap.put(localObject, paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontCache
 * JD-Core Version:    0.7.0.1
 */