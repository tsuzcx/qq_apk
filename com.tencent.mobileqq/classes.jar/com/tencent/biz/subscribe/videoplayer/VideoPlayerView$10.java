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
    if ((this.a.getSuperPlayer() != null) && (VideoPlayerView.m(this.a) != null))
    {
      VideoPlayerView.c(this.a, false);
      VideoPlayerView.m(this.a).onOrientationChange(VideoPlayerView.p(this.a));
      VideoPlayerView.m(this.a).onVideoSize(this.a.getPlayerVideoView().getRenderViewWidth(), this.a.getPlayerVideoView().getRenderViewHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.10
 * JD-Core Version:    0.7.0.1
 */