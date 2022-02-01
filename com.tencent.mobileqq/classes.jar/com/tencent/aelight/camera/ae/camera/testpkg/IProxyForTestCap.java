package com.tencent.aelight.camera.ae.camera.testpkg;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.common.Observer;

public abstract interface IProxyForTestCap
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack);
  
  public abstract void a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3, int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract void a(CameraSize paramCameraSize, boolean paramBoolean, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback);
  
  public abstract void a(Observer paramObserver);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract Object b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(Observer paramObserver);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void c(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.testpkg.IProxyForTestCap
 * JD-Core Version:    0.7.0.1
 */