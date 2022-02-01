package com.tencent.avgame.gameroom.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import nct;

public class AVGameMediaPlayerWrapper$6
  implements Runnable
{
  public AVGameMediaPlayerWrapper$6(nct paramnct) {}
  
  public void run()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "call releaseMediaPlayer");
    if (nct.a(this.this$0) != null)
    {
      nct.a(this.this$0).stop();
      nct.a(this.this$0).release();
      nct.a(this.this$0, null);
      nct.b(this.this$0);
      nct.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.6
 * JD-Core Version:    0.7.0.1
 */