package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nmi;

public class AVGameMediaPlayerWrapper$5
  implements Runnable
{
  public AVGameMediaPlayerWrapper$5(nmi paramnmi) {}
  
  public void run()
  {
    if ((nmi.a(this.this$0) != null) && (nmi.a(this.this$0).isPlaying())) {
      nmi.a(this.this$0).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.5
 * JD-Core Version:    0.7.0.1
 */