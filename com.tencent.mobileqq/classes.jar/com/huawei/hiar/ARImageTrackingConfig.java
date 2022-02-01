package com.huawei.hiar;

public class ARImageTrackingConfig
  extends ARConfigBase
{
  ARImageTrackingConfig() {}
  
  public ARImageTrackingConfig(ARSession paramARSession)
  {
    super(paramARSession);
    super.setARType(128);
    super.setFocusMode(ARConfigBase.FocusMode.AUTO_FOCUS);
    super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
  }
  
  public ARAugmentedImageDatabase getAugmentedImageDatabase()
  {
    return super.getAugmentedImageDatabase();
  }
  
  public void setAugmentedImageDatabase(ARAugmentedImageDatabase paramARAugmentedImageDatabase)
  {
    super.setAugmentedImageDatabase(paramARAugmentedImageDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARImageTrackingConfig
 * JD-Core Version:    0.7.0.1
 */