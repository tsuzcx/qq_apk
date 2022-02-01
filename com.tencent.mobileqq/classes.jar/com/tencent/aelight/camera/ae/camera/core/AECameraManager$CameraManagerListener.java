package com.tencent.aelight.camera.ae.camera.core;

public abstract interface AECameraManager$CameraManagerListener
{
  public abstract void onCameraPreviewSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onCameraPreviewStarted();
  
  public abstract void onCameraStarted(boolean paramBoolean, String paramString);
  
  public abstract void onRetryOpenCamera();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener
 * JD-Core Version:    0.7.0.1
 */