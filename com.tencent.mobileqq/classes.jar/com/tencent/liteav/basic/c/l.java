package com.tencent.liteav.basic.c;

public class l
{
  public static final float[] a = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] b = { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  public static final float[] c = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] d = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final float[] e = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  
  private static float a(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 1.0F;
    }
    return 0.0F;
  }
  
  public static float[] a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = l.1.a[paramk.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          paramk = (float[])a.clone();
        } else {
          paramk = (float[])d.clone();
        }
      }
      else {
        paramk = (float[])c.clone();
      }
    }
    else {
      paramk = (float[])b.clone();
    }
    Object localObject = paramk;
    if (paramBoolean1) {
      localObject = new float[] { a(paramk[0]), paramk[1], a(paramk[2]), paramk[3], a(paramk[4]), paramk[5], a(paramk[6]), paramk[7] };
    }
    paramk = (k)localObject;
    if (paramBoolean2) {
      paramk = new float[] { localObject[0], a(localObject[1]), localObject[2], a(localObject[3]), localObject[4], a(localObject[5]), localObject[6], a(localObject[7]) };
    }
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.l
 * JD-Core Version:    0.7.0.1
 */