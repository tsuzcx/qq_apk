package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class VideoController$18
  implements Runnable
{
  VideoController$18(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "mDoubleVideoMeetingSwitchMulti timeOut ");
    }
    this.this$0.e.a(new Object[] { Integer.valueOf(28), String.valueOf(this.this$0.k().aN), Boolean.valueOf(true) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.18
 * JD-Core Version:    0.7.0.1
 */