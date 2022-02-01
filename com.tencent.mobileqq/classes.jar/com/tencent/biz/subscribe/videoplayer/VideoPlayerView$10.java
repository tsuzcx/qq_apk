package com.tencent.biz.subscribe.videoplayer;

import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.superplayer.view.ISPlayerVideoView;

class VideoPlayerView$10
  implements IFullScreenViewClickListener
{
  VideoPlayerView$10(VideoPlayerView paramVideoPlayerView) {}
  
  public void a()
  {
    if ((this.a.a() != null) && (VideoPlayerView.a(this.a) != null))
    {
      VideoPlayerView.c(this.a, false);
      VideoPlayerView.a(this.a).onOrientationChange(VideoPlayerView.c(this.a));
      VideoPlayerView.a(this.a).onVideoSize(this.a.a().getRenderViewWidth(), this.a.a().getRenderViewHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.10
 * JD-Core Version:    0.7.0.1
 */