package com.tencent.aelight.camera.ae;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import org.light.CameraController.DisplayType;

class AECMShowCameraUnit$12$1
  implements Runnable
{
  AECMShowCameraUnit$12$1(AECMShowCameraUnit.12 param12, CmShowAssetsData paramCmShowAssetsData) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((CmShowAssetsData)localObject).b != null))
    {
      localObject = this.b.this$0.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onComplete] kapuModel = ");
      localStringBuilder.append(this.a.b.toString());
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
    this.b.this$0.I.cmShowSetKapuModel(this.a.b, this.a.c, new AECMShowCameraUnit.12.1.1(this));
    this.b.this$0.I.cmShowSetKapuDisplayType(CameraController.DisplayType.HEAD);
    this.b.this$0.a("triggerState2", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.12.1
 * JD-Core Version:    0.7.0.1
 */