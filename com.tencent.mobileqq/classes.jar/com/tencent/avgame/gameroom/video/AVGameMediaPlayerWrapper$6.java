package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class AVGameMediaPlayerWrapper$6
  implements Runnable
{
  AVGameMediaPlayerWrapper$6(AVGameMediaPlayerWrapper paramAVGameMediaPlayerWrapper) {}
  
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call releaseMediaPlayer");
    if (AVGameMediaPlayerWrapper.a(this.this$0) != null)
    {
      AVGameMediaPlayerWrapper.a(this.this$0).stop();
      AVGameMediaPlayerWrapper.a(this.this$0).release();
      AVGameMediaPlayerWrapper.a(this.this$0, null);
      AVGameMediaPlayerWrapper.b(this.this$0);
      AVGameMediaPlayerWrapper.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.6
 * JD-Core Version:    0.7.0.1
 */