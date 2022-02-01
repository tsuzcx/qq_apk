package com.huawei.hiar;

public class ARHandTrackingConfig
  extends ARConfigBase
{
  ARHandTrackingConfig() {}
  
  public ARHandTrackingConfig(ARSession paramARSession)
  {
    super(paramARSession);
    setARType(4);
    super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
    super.setFocusMode(ARConfigBase.FocusMode.AUTO_FOCUS);
  }
  
  public ARConfigBase.CameraLensFacing getCameraLensFacing()
  {
    return super.getCameraLensFacing();
  }
  
  public void setCameraLensFacing(ARConfigBase.CameraLensFacing paramCameraLensFacing)
  {
    super.setCameraLensFacing(paramCameraLensFacing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARHandTrackingConfig
 * JD-Core Version:    0.7.0.1
 */