package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class VideoController$1
  implements Runnable
{
  VideoController$1(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "networkBrokenRunnable");
    }
    VideoController localVideoController;
    if ((this.this$0.k().i > 0) && (this.this$0.k().i <= 4))
    {
      localVideoController = this.this$0;
      localVideoController.a(localVideoController.k().s, 215);
      this.this$0.b(215);
      localVideoController = this.this$0;
      localVideoController.b(localVideoController.k().s, 9);
    }
    else
    {
      localVideoController = this.this$0;
      localVideoController.onGAudioSDKError(localVideoController.l, this.this$0.k, 15, 0);
    }
    VideoController.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.1
 * JD-Core Version:    0.7.0.1
 */