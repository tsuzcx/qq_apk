package com.huawei.hiar;

public class ARWorldTrackingConfig
  extends ARConfigBase
{
  ARWorldTrackingConfig() {}
  
  public ARWorldTrackingConfig(ARSession paramARSession)
  {
    super(paramARSession);
    super.setARType(1);
    super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
    super.setFocusMode(ARConfigBase.FocusMode.FIXED_FOCUS);
  }
  
  public ARAugmentedImageDatabase getAugmentedImageDatabase()
  {
    return super.getAugmentedImageDatabase();
  }
  
  public ARConfigBase.PlaneFindingMode getPlaneFindingMode()
  {
    return super.getPlaneFindingMode();
  }
  
  public void setAugmentedImageDatabase(ARAugmentedImageDatabase paramARAugmentedImageDatabase)
  {
    super.setAugmentedImageDatabase(paramARAugmentedImageDatabase);
  }
  
  public void setPlaneFindingMode(ARConfigBase.PlaneFindingMode paramPlaneFindingMode)
  {
    super.setPlaneFindingMode(paramPlaneFindingMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARWorldTrackingConfig
 * JD-Core Version:    0.7.0.1
 */