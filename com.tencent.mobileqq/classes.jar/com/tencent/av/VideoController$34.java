package com.tencent.av;

import com.tencent.qphone.base.util.QLog;
import lcv;

class VideoController$34
  implements Runnable
{
  VideoController$34(VideoController paramVideoController) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.34
 * JD-Core Version:    0.7.0.1
 */