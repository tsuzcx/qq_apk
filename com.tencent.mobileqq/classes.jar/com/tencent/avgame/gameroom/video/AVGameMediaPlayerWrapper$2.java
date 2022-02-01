package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class AVGameMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call resumePlay");
    if (AVGameMediaPlayerWrapper.a(this.this$0) != null) {
      AVGameMediaPlayerWrapper.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */