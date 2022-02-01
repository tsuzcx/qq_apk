package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$22
  implements Runnable
{
  AECameraGLSurfaceView$22(AECameraGLSurfaceView paramAECameraGLSurfaceView, VideoMaterial paramVideoMaterial, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setVideoMaterial] update material: ");
    localStringBuilder.append(this.val$videoMaterial.getId());
    AEQLog.d("AECameraGLSurfaceView", localStringBuilder.toString());
    if ((AECameraGLSurfaceView.access$000(this.this$0) instanceof AEFilterProcessTex)) {
      ((AEFilterProcessTex)AECameraGLSurfaceView.access$000(this.this$0)).a(this.val$videoMaterial, this.val$force);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.22
 * JD-Core Version:    0.7.0.1
 */