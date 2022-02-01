package com.Vas.ColorFont;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.util.SparseIntArray;
import java.util.HashMap;

public class FastColorFontCache
{
  private static HashMap<String, BitmapShader> a = new HashMap();
  private static HashMap<String, BitmapShader> b = new HashMap();
  private static HashMap<String, Bitmap> c = new HashMap();
  private static HashMap<String, Bitmap> d = new HashMap();
  private static SparseIntArray e = new SparseIntArray();
  private static SparseIntArray f = new SparseIntArray();
  private static SparseIntArray g = new SparseIntArray();
  private static SparseIntArray h = new SparseIntArray();
  private static SparseIntArray i = new SparseIntArray();
  private static SparseIntArray j = new SparseIntArray();
  private static SparseIntArray k = new SparseIntArray();
  
  public static int a(int paramInt)
  {
    return g.get(paramInt);
  }
  
  public static BitmapShader a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = a;
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
  
  public static void a(int paramInt1, int paramInt2)
  {
    g.put(paramInt1, paramInt2);
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
    if ((!c.containsKey(localObject)) && (paramBitmap != null)) {
      c.put(localObject, paramBitmap);
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
    if ((!a.containsKey(localObject)) && (paramBitmapShader != null)) {
      a.put(localObject, paramBitmapShader);
    }
  }
  
  public static int b(int paramInt)
  {
    return e.get(paramInt, 0);
  }
  
  public static Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = c;
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
    e.put(paramInt1, paramInt2);
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
    if ((!d.containsKey(localObject)) && (paramBitmap != null)) {
      d.put(localObject, paramBitmap);
    }
  }
  
  public static int c(int paramInt)
  {
    return f.get(paramInt, 0);
  }
  
  public static Bitmap c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = d;
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
  
  public static void c(int paramInt1, int paramInt2)
  {
    f.put(paramInt1, paramInt2);
  }
  
  public static int d(int paramInt)
  {
    return i.get(paramInt, 256);
  }
  
  public static void d(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      i.put(paramInt1, paramInt2);
    }
  }
  
  public static int e(int paramInt)
  {
    return h.get(paramInt, 256);
  }
  
  public static void e(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      h.put(paramInt1, paramInt2);
    }
  }
  
  public static int f(int paramInt)
  {
    return j.get(paramInt, 0);
  }
  
  public static void f(int paramInt1, int paramInt2)
  {
    j.put(paramInt1, paramInt2);
  }
  
  public static int g(int paramInt)
  {
    return k.get(paramInt, 0);
  }
  
  public static void g(int paramInt1, int paramInt2)
  {
    k.put(paramInt1, paramInt2);
  }
  
  public static void h(int paramInt)
  {
    int m = e.indexOfKey(paramInt);
    if (m >= 0) {
      e.removeAt(m);
    }
    m = f.indexOfKey(paramInt);
    if (m >= 0) {
      f.removeAt(m);
    }
    m = g.indexOfKey(paramInt);
    if (m >= 0) {
      g.removeAt(m);
    }
    m = h.indexOfKey(paramInt);
    if (m >= 0) {
      h.removeAt(m);
    }
    m = i.indexOfKey(paramInt);
    if (m >= 0) {
      i.removeAt(m);
    }
    m = j.indexOfKey(paramInt);
    if (m >= 0) {
      j.removeAt(m);
    }
    paramInt = k.indexOfKey(paramInt);
    if (paramInt >= 0) {
      k.removeAt(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontCache
 * JD-Core Version:    0.7.0.1
 */