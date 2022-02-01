package com.tencent.av;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;

class VideoController$28
  implements Runnable
{
  VideoController$28(VideoController paramVideoController, int paramInt) {}
  
  public void run()
  {
    QLog.d(VideoController.a, 1, "GAudioCtrl.quitRoom start.");
    ??? = this.this$0;
    VideoController.b((VideoController)???, ((VideoController)???).U.quitRoom(this.a));
    ??? = VideoController.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GAudioCtrl.quitRoom end. mQuitResult = ");
    localStringBuilder.append(VideoController.b(this.this$0));
    QLog.d((String)???, 1, localStringBuilder.toString());
    synchronized (VideoController.c(this.this$0))
    {
      VideoController.c(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.28
 * JD-Core Version:    0.7.0.1
 */