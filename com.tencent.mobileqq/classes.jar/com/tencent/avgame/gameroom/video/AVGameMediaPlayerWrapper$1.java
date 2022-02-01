package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class AVGameMediaPlayerWrapper$1
  implements Runnable
{
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call pausePlay");
    if ((AVGameMediaPlayerWrapper.a(this.this$0) != null) && (AVGameMediaPlayerWrapper.a(this.this$0).isPlaying())) {
      AVGameMediaPlayerWrapper.a(this.this$0).pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */