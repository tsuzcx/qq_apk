package com.tencent.mm.plugin.sight.base;

import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.hg.f;

public class SightVideoJNI
{
  private static final Object a = new Object();
  
  static
  {
    f.a("wmpfcommonjni", SightVideoJNI.class.getClassLoader());
    if (com.tencent.luggage.wxa.ey.a.a() >> 12 >= 4)
    {
      b.a = 3;
      b.c = 3;
      b.d = 544000;
      return;
    }
    b.a = 1;
    b.c = 1;
    b.d = 640000;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4)
  {
    return shouldRemuxing(i.a(paramString, false), paramInt1, paramInt2, paramInt3, paramDouble, paramInt4);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, byte[] paramArrayOfByte, int paramInt7, boolean paramBoolean, int paramInt8, int paramInt9)
  {
    return remuxing(i.a(paramString1, false), i.a(paramString2, true), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloat1, paramFloat2, paramArrayOfByte, paramInt7, paramBoolean, paramInt8, paramInt9, com.tencent.luggage.wxa.qs.a.a(), true);
  }
  
  private static native int remuxing(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, byte[] paramArrayOfByte, int paramInt7, boolean paramBoolean1, int paramInt8, int paramInt9, String paramString3, boolean paramBoolean2);
  
  private static native int shouldRemuxing(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.SightVideoJNI
 * JD-Core Version:    0.7.0.1
 */