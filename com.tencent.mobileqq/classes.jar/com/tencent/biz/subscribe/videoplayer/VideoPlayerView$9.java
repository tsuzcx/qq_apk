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
    if (VideoPlayerView.l(this.a) != null)
    {
      VideoPlayerView.l(this.a).c();
      VideoPlayerView.a(this.a, null);
    }
    VideoPlayerView.a(this.a, null);
    this.a.g();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyVideoSeek seek ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("VideoPlayerView", 4, ((StringBuilder)localObject).toString());
    localObject = this.a;
    ((VideoPlayerView)localObject).a(paramInt * ((VideoPlayerView)localObject).getSuperPlayer().getDurationMs() / 100L);
  }
  
  public void notifyVideoStart()
  {
    if (this.a.getSuperPlayer().getCurrentPositionMs() < this.a.getSuperPlayer().getDurationMs())
    {
      this.a.e();
      return;
    }
    if (VideoPlayerView.o(this.a))
    {
      QLog.d("VideoPlayerView", 4, "has more , wait for auto play next");
      return;
    }
    this.a.getSuperPlayer().setLoopback(true);
    this.a.j();
    if (VideoPlayerView.m(this.a) != null) {
      VideoPlayerView.m(this.a).onVideoStart((int)this.a.getSuperPlayer().getDurationMs());
    }
    QLog.d("VideoPlayerView", 4, "no more, player repeat");
  }
  
  public void notifyVideoStop()
  {
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.9
 * JD-Core Version:    0.7.0.1
 */