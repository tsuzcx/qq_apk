package com.tencent.av.app;

import com.tencent.qphone.base.util.QLog;
import lfq;

class VideoAppInterface$1
  implements Runnable
{
  VideoAppInterface$1(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoAppInterface.c(), 2, "Async load mediaCodecChipConfig.");
    }
    lfq.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.1
 * JD-Core Version:    0.7.0.1
 */