package com.tencent.mobileqq.activity.home.impl;

public class FrameInfoBean
{
  private Class a;
  private boolean b;
  private int c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public FrameInfoBean(Class paramClass, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this(paramClass, false, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public FrameInfoBean(Class paramClass, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramClass;
    this.b = paramBoolean;
    this.c = paramInt1;
    this.d = paramString;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
    this.i = paramInt6;
  }
  
  public Class a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public int i()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.FrameInfoBean
 * JD-Core Version:    0.7.0.1
 */