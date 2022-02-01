package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

class AEARCakeMaterialAdapter$2
  implements Runnable
{
  AEARCakeMaterialAdapter$2(AEARCakeMaterialAdapter paramAEARCakeMaterialAdapter) {}
  
  public void run()
  {
    QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "use material failed because of so load failed");
    if (AEKitForQQ.a()) {
      FeatureManager.loadBasicFeatures();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */