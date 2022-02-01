package com.tencent.aelight.camera.aebase.view;

import android.opengl.GLSurfaceView;
import android.view.View;

public abstract interface IAECaptureButton
{
  public abstract void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView);
  
  public abstract void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate);
  
  public abstract boolean g();
  
  public abstract View getCaptureBtn();
  
  public abstract void h();
  
  public abstract void k();
  
  public abstract void setFunctionFlag(int paramInt);
  
  public abstract void setMaxDuration(float paramFloat);
  
  public abstract void setTouchEnable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.IAECaptureButton
 * JD-Core Version:    0.7.0.1
 */