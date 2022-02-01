package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;
import nfq;

public class AVGameMediaPlayerWrapper$5
  implements Runnable
{
  public AVGameMediaPlayerWrapper$5(nfq paramnfq) {}
  
  public void run()
  {
    if ((nfq.a(this.this$0) != null) && (nfq.a(this.this$0).isPlaying())) {
      nfq.a(this.this$0).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.5
 * JD-Core Version:    0.7.0.1
 */