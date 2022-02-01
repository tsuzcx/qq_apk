package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

class AECameraGLSurfaceView$2
  implements Runnable
{
  AECameraGLSurfaceView$2(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString1, String paramString2) {}
  
  public void run()
  {
    ((AEFilterProcessTex)AECameraGLSurfaceView.access$000(this.this$0)).h().setLightBundle(this.val$bundlePath, this.val$agentType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */