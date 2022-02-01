package com.tencent.avgame.gameroom.video;

import com.tencent.superplayer.api.ISuperPlayer;

class AVGameMediaPlayerWrapper$9
  implements Runnable
{
  AVGameMediaPlayerWrapper$9(AVGameMediaPlayerWrapper paramAVGameMediaPlayerWrapper) {}
  
  public void run()
  {
    if (AVGameMediaPlayerWrapper.a(this.this$0) != null)
    {
      if (!AVGameMediaPlayerWrapper.i(this.this$0)) {
        return;
      }
      AVGameMediaPlayerWrapper.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.9
 * JD-Core Version:    0.7.0.1
 */