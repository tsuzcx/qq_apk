package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class AVGameMediaPlayerWrapper$7
  implements Runnable
{
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call seekTo expectPositionMs:=");
    localStringBuilder.append(this.a);
    QLog.d("AVGameMediaPlayerWrapper", 1, localStringBuilder.toString());
    if ((AVGameMediaPlayerWrapper.a(this.this$0) != null) && (AVGameMediaPlayerWrapper.a(this.this$0).isPlaying()))
    {
      AVGameMediaPlayerWrapper.a(this.this$0).pause();
      AVGameMediaPlayerWrapper.a(this.this$0).seekTo((int)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.7
 * JD-Core Version:    0.7.0.1
 */