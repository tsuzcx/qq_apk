package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager.IWatermarkDictCallback;
import java.util.Map;

class AECameraGLSurfaceView$24
  implements WatermarkDataManager.IWatermarkDictCallback
{
  AECameraGLSurfaceView$24(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void onGetWatermarkDict(Map<String, String> paramMap)
  {
    this.this$0.queueEvent(new AECameraGLSurfaceView.24.1(this, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.24
 * JD-Core Version:    0.7.0.1
 */