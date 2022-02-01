package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import nfq;

public class AVGameMediaPlayerWrapper$6
  implements Runnable
{
  public AVGameMediaPlayerWrapper$6(nfq paramnfq) {}
  
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call releaseMediaPlayer");
    if (nfq.a(this.this$0) != null)
    {
      nfq.a(this.this$0).stop();
      nfq.a(this.this$0).release();
      nfq.a(this.this$0, null);
      nfq.b(this.this$0);
      nfq.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.6
 * JD-Core Version:    0.7.0.1
 */