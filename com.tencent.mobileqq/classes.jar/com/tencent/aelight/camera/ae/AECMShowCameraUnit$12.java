package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import java.util.HashMap;

class AECMShowCameraUnit$12
  implements Runnable
{
  AECMShowCameraUnit$12(AECMShowCameraUnit paramAECMShowCameraUnit, CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.b.putAll(this.a.namePathMap);
    localCmShowAssetsData.a = this.a.rolePath;
    localCmShowAssetsData.c = this.a.cmJsonString;
    localCmShowAssetsData.b.put("role", localCmShowAssetsData.a);
    this.this$0.h.queueEvent(new AECMShowCameraUnit.12.1(this, localCmShowAssetsData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.12
 * JD-Core Version:    0.7.0.1
 */