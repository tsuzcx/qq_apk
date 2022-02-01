package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nej;

public class AVGameMediaPlayerWrapper$5
  implements Runnable
{
  public AVGameMediaPlayerWrapper$5(nej paramnej) {}
  
  public void run()
  {
    if ((nej.a(this.this$0) != null) && (nej.a(this.this$0).isPlaying())) {
      nej.a(this.this$0).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.5
 * JD-Core Version:    0.7.0.1
 */