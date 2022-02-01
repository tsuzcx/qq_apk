package com.tencent.aelight.camera.aioeditor.setting;

public class CaptureEntranceParams
{
  public int a;
  public int b;
  public int c;
  private CapturePicParams d;
  private CaptureVideoParams e;
  
  public CaptureEntranceParams(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(CapturePicParams paramCapturePicParams)
  {
    this.d = paramCapturePicParams;
    if (this.d.a() != null) {
      this.b = this.d.d();
    }
  }
  
  public void a(CaptureVideoParams paramCaptureVideoParams)
  {
    this.e = paramCaptureVideoParams;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public CapturePicParams c()
  {
    return this.d;
  }
  
  public CaptureVideoParams d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams
 * JD-Core Version:    0.7.0.1
 */