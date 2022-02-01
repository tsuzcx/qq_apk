package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView.OnCounterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.superplayer.api.ISuperPlayer;

class VideoPlayerView$15
  implements VideoNextFeedsView.OnCounterListener
{
  VideoPlayerView$15(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean)
  {
    VideoPlayerView.d(this.a, paramBoolean);
    if (VideoPlayerView.d(this.a)) {
      this.a.a().post(new VideoPlayerView.15.1(this));
    }
    do
    {
      do
      {
        return;
        if (VideoPlayerView.b(this.a))
        {
          this.a.a().post(new VideoPlayerView.15.2(this));
          return;
        }
      } while (!VideoPlayerView.e(this.a));
      if (this.a.a() != null) {
        this.a.a().setLoopback(true);
      }
      this.a.i();
    } while (VideoPlayerView.a(this.a) == null);
    VideoPlayerView.a(this.a).onVideoStart((int)this.a.a().getDurationMs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15
 * JD-Core Version:    0.7.0.1
 */