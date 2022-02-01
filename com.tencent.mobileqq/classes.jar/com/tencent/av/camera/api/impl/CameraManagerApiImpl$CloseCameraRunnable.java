package com.tencent.av.camera.api.impl;

class CameraManagerApiImpl$CloseCameraRunnable
  implements Runnable
{
  public long a = 0L;
  private boolean b = true;
  
  CameraManagerApiImpl$CloseCameraRunnable(CameraManagerApiImpl paramCameraManagerApiImpl) {}
  
  public void run()
  {
    CameraManagerApiImpl.access$100(this.this$0, this.a, this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.CloseCameraRunnable
 * JD-Core Version:    0.7.0.1
 */