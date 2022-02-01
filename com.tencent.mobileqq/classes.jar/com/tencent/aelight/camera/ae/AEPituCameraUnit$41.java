package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;

class AEPituCameraUnit$41
  implements AECameraManager.CameraOpenCallback
{
  AEPituCameraUnit$41(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.a()) {
        CameraHelper.a(paramInt);
      }
      if (this.a.a)
      {
        this.a.l();
        return;
      }
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.41
 * JD-Core Version:    0.7.0.1
 */