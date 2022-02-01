package com.hiar.sdk.utils;

import java.nio.FloatBuffer;

public class Drawable2d
{
  public static float[] a = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] b = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static final FloatBuffer c = GlUtil.a(a);
  private static final FloatBuffer d = GlUtil.a(b);
  private FloatBuffer e = c;
  private FloatBuffer f = d;
  private int g;
  private int h = 2;
  private int i;
  private int j;
  
  public Drawable2d()
  {
    int k = this.h;
    this.i = (k * 4);
    this.g = (a.length / k);
    this.j = 8;
  }
  
  public FloatBuffer a()
  {
    return this.e;
  }
  
  public FloatBuffer b()
  {
    return this.f;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.i;
  }
  
  public int e()
  {
    return this.j;
  }
  
  public int f()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.hiar.sdk.utils.Drawable2d
 * JD-Core Version:    0.7.0.1
 */