package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.superplayer.api.ISuperPlayer;

class AVGameMediaPlayerWrapper$8
  implements Runnable
{
  AVGameMediaPlayerWrapper$8(AVGameMediaPlayerWrapper paramAVGameMediaPlayerWrapper) {}
  
  public void run()
  {
    if (AVGameMediaPlayerWrapper.a(this.this$0) == null) {
      return;
    }
    AVGameMediaPlayerWrapper.a(this.this$0).start();
    AVGameMediaPlayerWrapper.b(this.this$0, true);
    if (AVGameMediaPlayerWrapper.a(this.this$0) != null)
    {
      if (!AVGameMediaPlayerWrapper.b(this.this$0)) {
        break label83;
      }
      AVGameMediaPlayerWrapper.a(this.this$0).c(AVGameMediaPlayerWrapper.a(this.this$0));
    }
    for (;;)
    {
      CJSurvivalFestivalReporter.a(1, AVGameMediaPlayerWrapper.a(this.this$0));
      return;
      label83:
      AVGameMediaPlayerWrapper.a(this.this$0).x = AVGameMediaPlayerWrapper.a(this.this$0).getVideoWidth();
      AVGameMediaPlayerWrapper.a(this.this$0).y = AVGameMediaPlayerWrapper.a(this.this$0).getVideoHeight();
      AVGameMediaPlayerWrapper.c(this.this$0, true);
      AVGameMediaPlayerWrapper.a(this.this$0).a(AVGameMediaPlayerWrapper.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */