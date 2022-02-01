package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nct;
import ncu;

public class AVGameMediaPlayerWrapper$8
  implements Runnable
{
  public AVGameMediaPlayerWrapper$8(nct paramnct) {}
  
  public void run()
  {
    if (nct.a(this.this$0) == null) {}
    do
    {
      return;
      nct.a(this.this$0).start();
      nct.b(this.this$0, true);
    } while (nct.a(this.this$0) == null);
    if (nct.b(this.this$0))
    {
      nct.a(this.this$0).c(nct.a(this.this$0));
      return;
    }
    nct.a(this.this$0).x = nct.a(this.this$0).getVideoWidth();
    nct.a(this.this$0).y = nct.a(this.this$0).getVideoHeight();
    nct.c(this.this$0, true);
    nct.a(this.this$0).a(nct.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */