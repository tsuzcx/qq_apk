package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager.IWatermarkDictCallback;
import java.util.Map;

class AECameraGLSurfaceView$21
  implements WatermarkDataManager.IWatermarkDictCallback
{
  AECameraGLSurfaceView$21(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void onGetWatermarkDict(Map<String, String> paramMap)
  {
    this.this$0.queueEvent(new AECameraGLSurfaceView.21.1(this, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.21
 * JD-Core Version:    0.7.0.1
 */