package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.report.exception.AVGameExceptionReporter;
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
    if (AVGameMediaPlayerWrapper.f(this.this$0) != null) {
      if (AVGameMediaPlayerWrapper.g(this.this$0))
      {
        AVGameMediaPlayerWrapper.f(this.this$0).c(AVGameMediaPlayerWrapper.c(this.this$0));
      }
      else
      {
        AVGameMediaPlayerWrapper.h(this.this$0).x = AVGameMediaPlayerWrapper.a(this.this$0).getVideoWidth();
        AVGameMediaPlayerWrapper.h(this.this$0).y = AVGameMediaPlayerWrapper.a(this.this$0).getVideoHeight();
        AVGameMediaPlayerWrapper.c(this.this$0, true);
        AVGameMediaPlayerWrapper.f(this.this$0).a(AVGameMediaPlayerWrapper.c(this.this$0));
      }
    }
    AVGameExceptionReporter.a().a(1, AVGameMediaPlayerWrapper.c(this.this$0), 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */