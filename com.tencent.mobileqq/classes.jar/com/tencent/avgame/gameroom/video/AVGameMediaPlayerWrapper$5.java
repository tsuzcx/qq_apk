package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nct;

public class AVGameMediaPlayerWrapper$5
  implements Runnable
{
  public AVGameMediaPlayerWrapper$5(nct paramnct) {}
  
  public void run()
  {
    if ((nct.a(this.this$0) != null) && (nct.a(this.this$0).isPlaying())) {
      nct.a(this.this$0).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.5
 * JD-Core Version:    0.7.0.1
 */