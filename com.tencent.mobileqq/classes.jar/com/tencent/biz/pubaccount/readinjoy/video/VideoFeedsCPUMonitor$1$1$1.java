package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import qmv;

class VideoFeedsCPUMonitor$1$1$1
  implements Runnable
{
  VideoFeedsCPUMonitor$1$1$1(VideoFeedsCPUMonitor.1.1 param1) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(30000L);
      qmv.a().set(2);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(qmv.a(), 2, "clockThread InterruptedException");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1.1
 * JD-Core Version:    0.7.0.1
 */