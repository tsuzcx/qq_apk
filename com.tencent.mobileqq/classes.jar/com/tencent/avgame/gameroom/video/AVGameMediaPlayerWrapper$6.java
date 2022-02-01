package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import nmi;

public class AVGameMediaPlayerWrapper$6
  implements Runnable
{
  public AVGameMediaPlayerWrapper$6(nmi paramnmi) {}
  
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call releaseMediaPlayer");
    if (nmi.a(this.this$0) != null)
    {
      nmi.a(this.this$0).stop();
      nmi.a(this.this$0).release();
      nmi.a(this.this$0, null);
      nmi.b(this.this$0);
      nmi.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.6
 * JD-Core Version:    0.7.0.1
 */