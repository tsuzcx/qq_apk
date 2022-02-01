package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nmi;
import nmj;

public class AVGameMediaPlayerWrapper$8
  implements Runnable
{
  public AVGameMediaPlayerWrapper$8(nmi paramnmi) {}
  
  public void run()
  {
    if (nmi.a(this.this$0) == null) {}
    do
    {
      return;
      nmi.a(this.this$0).start();
      nmi.b(this.this$0, true);
    } while (nmi.a(this.this$0) == null);
    if (nmi.b(this.this$0))
    {
      nmi.a(this.this$0).c(nmi.a(this.this$0));
      return;
    }
    nmi.a(this.this$0).x = nmi.a(this.this$0).getVideoWidth();
    nmi.a(this.this$0).y = nmi.a(this.this$0).getVideoHeight();
    nmi.c(this.this$0, true);
    nmi.a(this.this$0).a(nmi.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */