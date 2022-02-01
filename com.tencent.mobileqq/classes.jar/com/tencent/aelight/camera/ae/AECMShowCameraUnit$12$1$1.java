package com.tencent.aelight.camera.ae;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qphone.base.util.QLog;
import org.light.CameraController.CmShowCallback;
import org.light.CameraController.MorphType;

class AECMShowCameraUnit$12$1$1
  implements CameraController.CmShowCallback
{
  AECMShowCameraUnit$12$1$1(AECMShowCameraUnit.12.1 param1) {}
  
  public void callback()
  {
    QLog.i(this.a.b.this$0.a, 1, "aeFilterManager.cmShowSetKapuModel callback");
    this.a.b.this$0.R();
    this.a.b.this$0.I.cmShowUpdateKapuMorph(CameraController.MorphType.MIDDLE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.12.1.1
 * JD-Core Version:    0.7.0.1
 */