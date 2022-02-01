package com.tencent.av;

import com.tencent.qphone.base.util.QLog;

class VideoController$40
  implements Runnable
{
  VideoController$40(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoController.a, 2, "quitDoubleVideoMeeting, time out task run.");
    }
    if (this.this$0.J != null) {
      this.this$0.J.onCompletion(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.40
 * JD-Core Version:    0.7.0.1
 */