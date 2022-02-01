package com.huawei.hiar;

public class ARWorldBodyTrackingConfig
  extends ARConfigBase
{
  ARWorldBodyTrackingConfig() {}
  
  public ARWorldBodyTrackingConfig(ARSession paramARSession)
  {
    super(paramARSession);
    setARType(3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARWorldBodyTrackingConfig
 * JD-Core Version:    0.7.0.1
 */