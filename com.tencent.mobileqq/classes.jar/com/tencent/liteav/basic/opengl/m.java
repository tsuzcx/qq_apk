package com.tencent.liteav.basic.opengl;

public class m
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
  
  public static float[] a(l paraml, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = m.1.a[paraml.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          paraml = (float[])a.clone();
        } else {
          paraml = (float[])d.clone();
        }
      }
      else {
        paraml = (float[])c.clone();
      }
    }
    else {
      paraml = (float[])b.clone();
    }
    Object localObject = paraml;
    if (paramBoolean1) {
      localObject = new float[] { a(paraml[0]), paraml[1], a(paraml[2]), paraml[3], a(paraml[4]), paraml[5], a(paraml[6]), paraml[7] };
    }
    paraml = (l)localObject;
    if (paramBoolean2) {
      paraml = new float[] { localObject[0], a(localObject[1]), localObject[2], a(localObject[3]), localObject[4], a(localObject[5]), localObject[6], a(localObject[7]) };
    }
    return paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.m
 * JD-Core Version:    0.7.0.1
 */