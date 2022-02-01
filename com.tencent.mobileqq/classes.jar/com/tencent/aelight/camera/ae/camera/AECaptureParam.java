package com.tencent.aelight.camera.ae.camera;

import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import java.io.File;

public class AECaptureParam
{
  public String a;
  private int b = 960;
  private int c = 720;
  private int d = 960;
  private int e = 720;
  private int f;
  private int g;
  private float h = 1.0F;
  private int i = 2000000;
  private int j = 1;
  private int k = 1;
  private int l = -1;
  private int m = -1;
  private long n = System.currentTimeMillis();
  
  public AECaptureParam()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.CAMERA.FILES.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.n);
    this.a = localStringBuilder.toString();
  }
  
  public int a()
  {
    return this.i;
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public void e(int paramInt)
  {
    this.i = paramInt;
  }
  
  public float f()
  {
    return this.h;
  }
  
  public void f(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int g()
  {
    return this.j;
  }
  
  public void g(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int h()
  {
    return this.k;
  }
  
  public void h(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public void i(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public void j(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.AECaptureParam
 * JD-Core Version:    0.7.0.1
 */