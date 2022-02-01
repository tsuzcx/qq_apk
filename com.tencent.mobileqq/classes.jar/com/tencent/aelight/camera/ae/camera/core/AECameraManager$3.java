package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.mobileqq.qmcf.QmcfManager;

class AECameraManager$3
  implements Runnable
{
  AECameraManager$3(AECameraManager paramAECameraManager, AECameraManager.CameraOpenCallback paramCameraOpenCallback) {}
  
  public void run()
  {
    AECameraManager.access$100(this.this$0, false);
    if (AECameraManager.access$200(this.this$0) == 1) {
      AECameraManager.access$202(this.this$0, 2);
    } else {
      AECameraManager.access$202(this.this$0, 1);
    }
    com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.b = AECameraManager.access$200(this.this$0);
    AECameraManager.access$302(this.this$0, false);
    QmcfManager.getInstance().setCameraMode(AECameraManager.access$200(this.this$0));
    AECameraManager.access$000(this.this$0, this.val$cameraOpenCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */