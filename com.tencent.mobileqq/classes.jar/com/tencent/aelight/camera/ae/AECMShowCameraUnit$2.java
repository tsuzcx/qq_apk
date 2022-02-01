package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule;
import com.tencent.aelight.camera.ae.cmshow.config.AECMShowConfig;

class AECMShowCameraUnit$2
  implements Runnable
{
  AECMShowCameraUnit$2(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    AECMShowQipcModule.a(AECMShowConfig.ESSENTIAL_RESOURCE_ID_LIST, new AECMShowCameraUnit.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */