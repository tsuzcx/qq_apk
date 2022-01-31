package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import java.util.TimerTask;
import trk;

class VideoPlayerView$14
  extends TimerTask
{
  VideoPlayerView$14(VideoPlayerView paramVideoPlayerView) {}
  
  public void run()
  {
    double d;
    float f;
    if (this.this$0.a() != null)
    {
      d = this.this$0.a().a();
      f = (float)this.this$0.a().b();
      if (f != 0.0F) {
        break label177;
      }
      this.this$0.a.setProgress(0);
    }
    for (;;)
    {
      if ((!VideoPlayerView.d(this.this$0)) && (d != 0.0D))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = ((int)d);
        localMessage.arg2 = ((int)f);
        localMessage.obj = Boolean.valueOf(true);
        this.this$0.a().sendMessage(localMessage);
      }
      if ((VideoPlayerView.e(this.this$0)) || (VideoPlayerView.f(this.this$0)))
      {
        VideoPlayerView.a(this.this$0, 0);
        VideoPlayerView.e(this.this$0, false);
      }
      if (VideoPlayerView.a(this.this$0) <= 120) {
        break;
      }
      this.this$0.a().sendEmptyMessage(2);
      return;
      label177:
      if ((!VideoPlayerView.d(this.this$0)) && (d != 0.0D)) {
        this.this$0.a.setProgress((int)(this.this$0.a.getMax() * (d / f)));
      }
    }
    VideoPlayerView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.14
 * JD-Core Version:    0.7.0.1
 */