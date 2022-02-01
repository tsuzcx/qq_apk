package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.IEditableWatermarkMaterialRecover;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$6
  implements AEFilterProcessTex.IEditableWatermarkMaterialRecover
{
  AECameraGLSurfaceView$6(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void recover(VideoMaterial paramVideoMaterial)
  {
    AEQLog.b("AECameraGLSurfaceView", "EditableWatermarkMaterialRecover recover---");
    AECameraGLSurfaceView.access$502(this.this$0, null);
    this.this$0.setMaterial(paramVideoMaterial.getDataPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */