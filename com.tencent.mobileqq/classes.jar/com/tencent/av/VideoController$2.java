package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class VideoController$2
  implements Runnable
{
  VideoController$2(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "connectingRunnable");
    }
    if (!this.this$0.k().j())
    {
      VideoController localVideoController = this.this$0;
      localVideoController.a(localVideoController.k().s, 216);
      this.this$0.b(216);
      localVideoController = this.this$0;
      localVideoController.b(localVideoController.k().s, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.2
 * JD-Core Version:    0.7.0.1
 */