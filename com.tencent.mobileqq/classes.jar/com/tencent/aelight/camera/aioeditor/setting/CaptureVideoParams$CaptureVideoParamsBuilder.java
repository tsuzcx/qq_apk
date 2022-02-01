package com.tencent.aelight.camera.aioeditor.setting;

public class CaptureVideoParams$CaptureVideoParamsBuilder
{
  public boolean a = true;
  public int b = 0;
  private boolean c = true;
  private boolean d = true;
  private int e = 0;
  private int f = 1;
  private boolean g = false;
  
  public CaptureVideoParamsBuilder a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public CaptureVideoParamsBuilder a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public CaptureVideoParams a()
  {
    return new CaptureVideoParams(this, null);
  }
  
  public CaptureVideoParamsBuilder b(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public CaptureVideoParamsBuilder b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public CaptureVideoParamsBuilder c(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public CaptureVideoParamsBuilder c(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams.CaptureVideoParamsBuilder
 * JD-Core Version:    0.7.0.1
 */