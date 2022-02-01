package com.tencent.av.camera.api.impl;

import android.annotation.TargetApi;

class CameraManagerApiImpl$SwitchCameraRunnable
  implements Runnable
{
  long a = 0L;
  
  CameraManagerApiImpl$SwitchCameraRunnable(CameraManagerApiImpl paramCameraManagerApiImpl) {}
  
  @TargetApi(14)
  public void run()
  {
    CameraManagerApiImpl.access$300(this.this$0, this.a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.SwitchCameraRunnable
 * JD-Core Version:    0.7.0.1
 */