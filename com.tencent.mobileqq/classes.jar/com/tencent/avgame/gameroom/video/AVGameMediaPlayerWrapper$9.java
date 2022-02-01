package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nmi;

public class AVGameMediaPlayerWrapper$9
  implements Runnable
{
  public AVGameMediaPlayerWrapper$9(nmi paramnmi) {}
  
  public void run()
  {
    if ((nmi.a(this.this$0) == null) || (!nmi.c(this.this$0))) {
      return;
    }
    nmi.a(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.9
 * JD-Core Version:    0.7.0.1
 */