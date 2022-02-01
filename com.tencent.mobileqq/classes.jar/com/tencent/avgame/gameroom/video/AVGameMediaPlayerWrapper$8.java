package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nfq;
import nfr;

public class AVGameMediaPlayerWrapper$8
  implements Runnable
{
  public AVGameMediaPlayerWrapper$8(nfq paramnfq) {}
  
  public void run()
  {
    if (nfq.a(this.this$0) == null) {}
    do
    {
      return;
      nfq.a(this.this$0).start();
      nfq.b(this.this$0, true);
    } while (nfq.a(this.this$0) == null);
    if (nfq.b(this.this$0))
    {
      nfq.a(this.this$0).c(nfq.a(this.this$0));
      return;
    }
    nfq.a(this.this$0).x = nfq.a(this.this$0).getVideoWidth();
    nfq.a(this.this$0).y = nfq.a(this.this$0).getVideoHeight();
    nfq.c(this.this$0, true);
    nfq.a(this.this$0).a(nfq.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */