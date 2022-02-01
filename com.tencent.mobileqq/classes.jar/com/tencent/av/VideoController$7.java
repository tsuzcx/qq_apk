package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.VcControllerImpl;

class VideoController$7
  implements Runnable
{
  VideoController$7(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.a();
    if ((localSessionInfo.e) && (localSessionInfo.n) && (localSessionInfo.d == 2))
    {
      localSessionInfo.b(this.a, false);
      this.this$0.a.pauseVideo(localSessionInfo.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.7
 * JD-Core Version:    0.7.0.1
 */