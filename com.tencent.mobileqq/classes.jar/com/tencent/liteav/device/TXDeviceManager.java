package com.tencent.liteav.device;

public abstract interface TXDeviceManager
{
  public abstract int enableCameraAutoFocus(boolean paramBoolean);
  
  public abstract boolean enableCameraTorch(boolean paramBoolean);
  
  public abstract float getCameraZoomMaxRatio();
  
  public abstract boolean isAutoFocusEnabled();
  
  public abstract boolean isFrontCamera();
  
  public abstract int setAudioRoute(TXDeviceManager.TXAudioRoute paramTXAudioRoute);
  
  public abstract int setCameraFocusPosition(int paramInt1, int paramInt2);
  
  public abstract int setCameraZoomRatio(float paramFloat);
  
  public abstract int setSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType);
  
  public abstract int switchCamera(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManager
 * JD-Core Version:    0.7.0.1
 */