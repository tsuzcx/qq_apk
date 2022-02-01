package com.tencent.av.camera;

import android.annotation.TargetApi;

class CameraUtils$SwitchCameraRunnable
  implements Runnable
{
  long a = 0L;
  
  CameraUtils$SwitchCameraRunnable(CameraUtils paramCameraUtils) {}
  
  @TargetApi(14)
  public void run()
  {
    CameraUtils.b(this.this$0, this.a);
  }
  
  public String toString()
  {
    return this.a + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils.SwitchCameraRunnable
 * JD-Core Version:    0.7.0.1
 */