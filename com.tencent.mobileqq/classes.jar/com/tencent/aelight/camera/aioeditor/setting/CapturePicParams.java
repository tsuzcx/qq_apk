package com.tencent.aelight.camera.aioeditor.setting;

import dov.com.qq.im.ae.current.SessionWrap;

public class CapturePicParams
{
  public boolean a;
  public int b;
  private SessionWrap c;
  private String d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private int i;
  private String j;
  private int k;
  
  private CapturePicParams(CapturePicParams.CapturePicParamsBuilder paramCapturePicParamsBuilder)
  {
    this.c = CapturePicParams.CapturePicParamsBuilder.a(paramCapturePicParamsBuilder);
    this.d = CapturePicParams.CapturePicParamsBuilder.b(paramCapturePicParamsBuilder);
    this.e = CapturePicParams.CapturePicParamsBuilder.c(paramCapturePicParamsBuilder);
    this.f = CapturePicParams.CapturePicParamsBuilder.d(paramCapturePicParamsBuilder);
    this.g = CapturePicParams.CapturePicParamsBuilder.e(paramCapturePicParamsBuilder);
    this.h = CapturePicParams.CapturePicParamsBuilder.f(paramCapturePicParamsBuilder);
    this.i = CapturePicParams.CapturePicParamsBuilder.g(paramCapturePicParamsBuilder);
    this.j = CapturePicParams.CapturePicParamsBuilder.h(paramCapturePicParamsBuilder);
    this.k = CapturePicParams.CapturePicParamsBuilder.i(paramCapturePicParamsBuilder);
    this.a = paramCapturePicParamsBuilder.a;
    this.b = paramCapturePicParamsBuilder.b;
  }
  
  public SessionWrap a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public String g()
  {
    return this.j;
  }
  
  public int h()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CapturePicParams
 * JD-Core Version:    0.7.0.1
 */