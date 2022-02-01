package com.tencent.aelight.camera.ae;

import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AEPituCameraUnit$12
  implements CosFunHelper.CountDownListener
{
  AEPituCameraUnit$12(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onCountDownEnd()
  {
    this.a.S();
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    AEPituCameraUnit.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.12
 * JD-Core Version:    0.7.0.1
 */