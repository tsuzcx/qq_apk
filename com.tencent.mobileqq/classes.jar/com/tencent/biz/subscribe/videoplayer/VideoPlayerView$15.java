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
    VideoPlayerView.e(this.a, paramBoolean);
    if (VideoPlayerView.s(this.a))
    {
      this.a.getMainHandler().post(new VideoPlayerView.15.1(this));
      return;
    }
    if (VideoPlayerView.o(this.a))
    {
      this.a.getMainHandler().post(new VideoPlayerView.15.2(this));
      return;
    }
    if (VideoPlayerView.t(this.a))
    {
      if (this.a.getSuperPlayer() != null) {
        this.a.getSuperPlayer().setLoopback(true);
      }
      this.a.j();
      if (VideoPlayerView.m(this.a) != null) {
        VideoPlayerView.m(this.a).onVideoStart((int)this.a.getSuperPlayer().getDurationMs());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15
 * JD-Core Version:    0.7.0.1
 */