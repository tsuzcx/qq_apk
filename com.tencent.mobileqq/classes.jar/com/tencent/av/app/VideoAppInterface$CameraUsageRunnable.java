package com.tencent.av.app;

import com.tencent.qphone.base.util.QLog;
import lmm;

class VideoAppInterface$CameraUsageRunnable
  implements Runnable
{
  VideoAppInterface$CameraUsageRunnable(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    QLog.w(VideoAppInterface.c(), 1, "CameraUsageRunnable");
    lmm.b(this.this$0.getApplication(), "CameraUsageRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.CameraUsageRunnable
 * JD-Core Version:    0.7.0.1
 */