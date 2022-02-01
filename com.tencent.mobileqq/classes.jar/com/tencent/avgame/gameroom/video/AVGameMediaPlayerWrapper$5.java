package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;

class AVGameMediaPlayerWrapper$5
  implements Runnable
{
  AVGameMediaPlayerWrapper$5(AVGameMediaPlayerWrapper paramAVGameMediaPlayerWrapper) {}
  
  public void run()
  {
    if ((AVGameMediaPlayerWrapper.a(this.this$0) != null) && (AVGameMediaPlayerWrapper.a(this.this$0).isPlaying())) {
      AVGameMediaPlayerWrapper.a(this.this$0).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.5
 * JD-Core Version:    0.7.0.1
 */