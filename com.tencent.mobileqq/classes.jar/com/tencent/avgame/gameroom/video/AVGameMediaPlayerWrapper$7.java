package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import nfq;

public class AVGameMediaPlayerWrapper$7
  implements Runnable
{
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call seekTo expectPositionMs:=" + this.a);
    if ((nfq.a(this.this$0) != null) && (nfq.a(this.this$0).isPlaying()))
    {
      nfq.a(this.this$0).pause();
      nfq.a(this.this$0).seekTo((int)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.7
 * JD-Core Version:    0.7.0.1
 */