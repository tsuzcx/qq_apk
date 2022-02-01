package com.tencent.aelight.camera.aebase.view;

import android.opengl.GLSurfaceView;
import android.view.View;

public abstract interface IAECaptureButton
{
  public abstract View a();
  
  public abstract void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView);
  
  public abstract void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate);
  
  public abstract boolean a();
  
  public abstract void d();
  
  public abstract void n();
  
  public abstract void setFunctionFlag(int paramInt);
  
  public abstract void setMaxDuration(float paramFloat);
  
  public abstract void setTouchEnable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.IAECaptureButton
 * JD-Core Version:    0.7.0.1
 */