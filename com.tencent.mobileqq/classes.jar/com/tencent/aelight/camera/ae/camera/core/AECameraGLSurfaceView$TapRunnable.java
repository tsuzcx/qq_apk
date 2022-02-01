package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

class AECameraGLSurfaceView$TapRunnable
  implements Runnable
{
  int touchEvent;
  float x;
  float y;
  
  public AECameraGLSurfaceView$TapRunnable(AECameraGLSurfaceView paramAECameraGLSurfaceView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.touchEvent = paramInt;
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public void run()
  {
    ((AEFilterProcessTex)AECameraGLSurfaceView.access$000(this.this$0)).h().setTouchTriggerEvent(this.touchEvent, this.x, this.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.TapRunnable
 * JD-Core Version:    0.7.0.1
 */