package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$17$6
  implements Runnable
{
  AECameraGLSurfaceView$17$6(AECameraGLSurfaceView.17 param17, VideoMaterial paramVideoMaterial, AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setVideoMaterial] update material");
    localStringBuilder.append(this.val$videoMaterial.getId());
    AEQLog.d("AECameraGLSurfaceView", localStringBuilder.toString());
    this.val$aeFilterProcessTex.a(this.val$videoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.17.6
 * JD-Core Version:    0.7.0.1
 */