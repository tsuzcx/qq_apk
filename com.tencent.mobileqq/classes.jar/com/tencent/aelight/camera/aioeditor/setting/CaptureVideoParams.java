package com.tencent.aelight.camera.aioeditor.setting;

public class CaptureVideoParams
{
  public boolean a;
  public boolean b;
  public int c;
  private boolean d;
  private boolean e;
  private int f;
  private int g;
  
  private CaptureVideoParams(CaptureVideoParams.CaptureVideoParamsBuilder paramCaptureVideoParamsBuilder)
  {
    this.d = CaptureVideoParams.CaptureVideoParamsBuilder.a(paramCaptureVideoParamsBuilder);
    this.e = CaptureVideoParams.CaptureVideoParamsBuilder.b(paramCaptureVideoParamsBuilder);
    this.f = CaptureVideoParams.CaptureVideoParamsBuilder.c(paramCaptureVideoParamsBuilder);
    this.g = CaptureVideoParams.CaptureVideoParamsBuilder.d(paramCaptureVideoParamsBuilder);
    this.a = CaptureVideoParams.CaptureVideoParamsBuilder.e(paramCaptureVideoParamsBuilder);
    this.b = paramCaptureVideoParamsBuilder.a;
    this.c = paramCaptureVideoParamsBuilder.b;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams
 * JD-Core Version:    0.7.0.1
 */