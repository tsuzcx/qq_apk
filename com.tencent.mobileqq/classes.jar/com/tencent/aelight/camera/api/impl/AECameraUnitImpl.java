package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.api.IAECameraUnit;

public class AECameraUnitImpl
  implements IAECameraUnit
{
  public Class getAEPitUnitClass()
  {
    return AEPituCameraUnit.class;
  }
  
  public void setPublishStoryFlag(boolean paramBoolean)
  {
    AEPituCameraUnit.ad = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AECameraUnitImpl
 * JD-Core Version:    0.7.0.1
 */