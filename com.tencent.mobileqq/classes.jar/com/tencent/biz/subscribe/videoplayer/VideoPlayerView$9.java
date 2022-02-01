package com.tencent.biz.subscribe.videoplayer;

import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class VideoPlayerView$9
  implements IVideoInnerStatusListener
{
  VideoPlayerView$9(VideoPlayerView paramVideoPlayerView) {}
  
  public void notifyVideoClose(int paramInt)
  {
    VideoPlayerView.b(this.a, false);
    if (VideoPlayerView.a(this.a) != null)
    {
      VideoPlayerView.a(this.a).b();
      VideoPlayerView.a(this.a, null);
    }
    VideoPlayerView.a(this.a, null);
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    QLog.d("VideoPlayerView", 4, "notifyVideoSeek seek " + paramInt);
    this.a.a(paramInt * this.a.a().getDurationMs() / 100L);
  }
  
  public void notifyVideoStart()
  {
    if (this.a.a().getCurrentPositionMs() < this.a.a().getDurationMs())
    {
      this.a.f();
      return;
    }
    if (VideoPlayerView.b(this.a))
    {
      QLog.d("VideoPlayerView", 4, "has more , wait for auto play next");
      return;
    }
    this.a.a().setLoopback(true);
    this.a.i();
    if (VideoPlayerView.a(this.a) != null) {
      VideoPlayerView.a(this.a).onVideoStart((int)this.a.a().getDurationMs());
    }
    QLog.d("VideoPlayerView", 4, "no more, player repeat");
  }
  
  public void notifyVideoStop()
  {
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.9
 * JD-Core Version:    0.7.0.1
 */