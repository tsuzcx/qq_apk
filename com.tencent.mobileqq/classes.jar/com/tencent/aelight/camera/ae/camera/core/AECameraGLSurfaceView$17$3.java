package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$17$3
  implements Runnable
{
  AECameraGLSurfaceView$17$3(AECameraGLSurfaceView.17 param17, AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void run()
  {
    this.val$aeFilterProcessTex.a(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.17.3
 * JD-Core Version:    0.7.0.1
 */