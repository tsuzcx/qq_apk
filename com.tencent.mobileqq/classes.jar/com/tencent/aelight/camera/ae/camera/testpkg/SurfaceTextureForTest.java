package com.tencent.aelight.camera.ae.camera.testpkg;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

public class SurfaceTextureForTest
  extends SurfaceTexture
{
  private SurfaceTexture.OnFrameAvailableListener a;
  private SurfaceTextureForTest.ITestListener b;
  private SurfaceTextureForTest.IUpdateFrameListener c;
  
  public void a()
  {
    SurfaceTextureForTest.ITestListener localITestListener = this.b;
    if (localITestListener != null) {
      localITestListener.startRecord();
    }
  }
  
  public void a(SurfaceTextureForTest.ITestListener paramITestListener)
  {
    this.b = paramITestListener;
  }
  
  public void a(SurfaceTextureForTest.IUpdateFrameListener paramIUpdateFrameListener)
  {
    this.c = paramIUpdateFrameListener;
  }
  
  public void b()
  {
    SurfaceTextureForTest.ITestListener localITestListener = this.b;
    if (localITestListener != null) {
      localITestListener.endRecord();
    }
  }
  
  public void setOnFrameAvailableListener(@androidx.annotation.Nullable @org.jetbrains.annotations.Nullable SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    super.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.a = paramOnFrameAvailableListener;
  }
  
  public void updateTexImage()
  {
    super.updateTexImage();
    SurfaceTextureForTest.IUpdateFrameListener localIUpdateFrameListener = this.c;
    if (localIUpdateFrameListener != null) {
      localIUpdateFrameListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.testpkg.SurfaceTextureForTest
 * JD-Core Version:    0.7.0.1
 */