package com.tencent.aelight.camera.ae;

import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AEPituCameraUnit$13
  implements CosFunHelper.CountDownListener
{
  AEPituCameraUnit$13(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onCountDownEnd()
  {
    this.a.av();
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    AEPituCameraUnit.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.13
 * JD-Core Version:    0.7.0.1
 */