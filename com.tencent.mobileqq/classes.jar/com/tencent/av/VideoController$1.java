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
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "networkBrokenRunnable");
    }
    VideoController localVideoController;
    if ((this.this$0.a().f > 0) && (this.this$0.a().f <= 4))
    {
      localVideoController = this.this$0;
      localVideoController.a(localVideoController.a().c, 215);
      this.this$0.b(215);
      localVideoController = this.this$0;
      localVideoController.b(localVideoController.a().c, 9);
    }
    else
    {
      localVideoController = this.this$0;
      localVideoController.onGAudioSDKError(localVideoController.b, this.this$0.jdField_a_of_type_Long, 15, 0);
    }
    VideoController.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.1
 * JD-Core Version:    0.7.0.1
 */