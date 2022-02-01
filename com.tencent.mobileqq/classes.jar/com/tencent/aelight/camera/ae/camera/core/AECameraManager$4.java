package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.log.AEQLog;

class AECameraManager$4
  implements Runnable
{
  AECameraManager$4(AECameraManager paramAECameraManager, int paramInt, AECameraManager.CameraOpenCallback paramCameraOpenCallback) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[cameraManagerHandler] changeCamera ");
    localStringBuilder.append(this.val$whichCamera);
    AEQLog.b("AECameraManager", localStringBuilder.toString());
    int i = this.val$whichCamera;
    if ((i != 2) && (i != 1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cameraManagerHandler] changeCamera invalid camera: ");
      localStringBuilder.append(this.val$whichCamera);
      AEQLog.d("AECameraManager", localStringBuilder.toString());
      this.val$cameraOpenCallback.onOpenResult(AECameraManager.access$200(this.this$0), AECameraManager.access$400(this.this$0));
      return;
    }
    if ((AECameraManager.access$200(this.this$0) != this.val$whichCamera) && (AECameraManager.access$400(this.this$0)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cameraManagerHandler] changeCamera, firstly close last camera: ");
      localStringBuilder.append(AECameraManager.access$200(this.this$0));
      AEQLog.b("AECameraManager", localStringBuilder.toString());
      AECameraManager.access$100(this.this$0, false);
    }
    AECameraManager.access$202(this.this$0, this.val$whichCamera);
    AECameraManager.access$000(this.this$0, this.val$cameraOpenCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */