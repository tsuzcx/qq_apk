package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoPlayerView$2
  implements View.OnClickListener
{
  VideoPlayerView$2(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.b(this.a) != null) {
      VideoPlayerView.b(this.a).setVisibility(8);
    }
    VideoPlayerView.a(this.a, false);
    VideoPlayerView.c(true);
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.2
 * JD-Core Version:    0.7.0.1
 */