package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class VideoController$17
  implements Runnable
{
  VideoController$17(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "mSwitchToMultiRunnable timeOut ");
    }
    VideoController localVideoController = this.this$0;
    localVideoController.b(localVideoController.a().c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.17
 * JD-Core Version:    0.7.0.1
 */