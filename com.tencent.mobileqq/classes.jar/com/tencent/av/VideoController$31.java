package com.tencent.av;

import com.tencent.qphone.base.util.QLog;
import lfv;

class VideoController$31
  implements Runnable
{
  VideoController$31(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoController.a, 2, "quitDoubleVideoMeeting, time out task run.");
    }
    if (this.this$0.c != null) {
      this.this$0.c.onCompletion(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.31
 * JD-Core Version:    0.7.0.1
 */