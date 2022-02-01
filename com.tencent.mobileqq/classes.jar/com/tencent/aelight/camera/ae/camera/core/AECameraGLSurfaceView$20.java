package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$20
  implements AECameraManager.CameraOpenCallback
{
  AECameraGLSurfaceView$20(AECameraGLSurfaceView paramAECameraGLSurfaceView, VideoMaterial paramVideoMaterial) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    this.this$0.realQueueApplyMaterial(this.val$videoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20
 * JD-Core Version:    0.7.0.1
 */