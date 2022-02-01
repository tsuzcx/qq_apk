package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nej;
import nek;

public class AVGameMediaPlayerWrapper$8
  implements Runnable
{
  public AVGameMediaPlayerWrapper$8(nej paramnej) {}
  
  public void run()
  {
    if (nej.a(this.this$0) == null) {}
    do
    {
      return;
      nej.a(this.this$0).start();
      nej.b(this.this$0, true);
    } while (nej.a(this.this$0) == null);
    if (nej.b(this.this$0))
    {
      nej.a(this.this$0).c(nej.a(this.this$0));
      return;
    }
    nej.a(this.this$0).x = nej.a(this.this$0).getVideoWidth();
    nej.a(this.this$0).y = nej.a(this.this$0).getVideoHeight();
    nej.c(this.this$0, true);
    nej.a(this.this$0).a(nej.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */