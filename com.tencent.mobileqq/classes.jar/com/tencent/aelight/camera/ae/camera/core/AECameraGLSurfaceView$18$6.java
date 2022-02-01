package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.log.AEQLog;

class AECameraGLSurfaceView$18$6
  implements Runnable
{
  AECameraGLSurfaceView$18$6(AECameraGLSurfaceView.18 param18, AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void run()
  {
    String str = AEARCakeMaterialManager.a().i();
    this.val$aeFilterProcessTex.b(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apply ar cake watermark text: ");
    localStringBuilder.append(str);
    AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.18.6
 * JD-Core Version:    0.7.0.1
 */