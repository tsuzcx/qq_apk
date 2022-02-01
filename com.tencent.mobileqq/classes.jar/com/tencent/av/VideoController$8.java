package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.VcControllerImpl;

class VideoController$8
  implements Runnable
{
  VideoController$8(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.k();
    if ((localSessionInfo.B) && (localSessionInfo.M) && (localSessionInfo.g == 2))
    {
      localSessionInfo.b(this.a, false);
      this.this$0.d.pauseVideo(localSessionInfo.s);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.8
 * JD-Core Version:    0.7.0.1
 */