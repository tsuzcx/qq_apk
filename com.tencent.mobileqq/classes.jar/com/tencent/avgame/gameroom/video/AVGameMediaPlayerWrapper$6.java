package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import nej;

public class AVGameMediaPlayerWrapper$6
  implements Runnable
{
  public AVGameMediaPlayerWrapper$6(nej paramnej) {}
  
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call releaseMediaPlayer");
    if (nej.a(this.this$0) != null)
    {
      nej.a(this.this$0).stop();
      nej.a(this.this$0).release();
      nej.a(this.this$0, null);
      nej.b(this.this$0);
      nej.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.6
 * JD-Core Version:    0.7.0.1
 */