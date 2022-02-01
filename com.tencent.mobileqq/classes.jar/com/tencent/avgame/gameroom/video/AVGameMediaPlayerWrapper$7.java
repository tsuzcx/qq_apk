package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import nct;

public class AVGameMediaPlayerWrapper$7
  implements Runnable
{
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call seekTo expectPositionMs:=" + this.a);
    if ((nct.a(this.this$0) != null) && (nct.a(this.this$0).isPlaying()))
    {
      nct.a(this.this$0).pause();
      nct.a(this.this$0).seekTo((int)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.7
 * JD-Core Version:    0.7.0.1
 */