package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import nej;

public class AVGameMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call resumePlay");
    if (nej.a(this.this$0) != null) {
      nej.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */