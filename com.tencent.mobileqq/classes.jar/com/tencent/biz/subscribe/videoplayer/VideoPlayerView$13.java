package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoPlayerView$13
  implements View.OnClickListener
{
  VideoPlayerView$13(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    VideoPlayerView.f(this.a);
    this.a.i();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.13
 * JD-Core Version:    0.7.0.1
 */