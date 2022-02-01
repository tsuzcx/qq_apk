package com.huawei.hiar;

public class ARFaceTrackingConfig
  extends ARConfigBase
{
  ARFaceTrackingConfig() {}
  
  public ARFaceTrackingConfig(ARSession paramARSession)
  {
    super(paramARSession);
    super.setARType(16);
    super.setCameraLensFacing(ARConfigBase.CameraLensFacing.FRONT);
    super.setFocusMode(ARConfigBase.FocusMode.AUTO_FOCUS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARFaceTrackingConfig
 * JD-Core Version:    0.7.0.1
 */