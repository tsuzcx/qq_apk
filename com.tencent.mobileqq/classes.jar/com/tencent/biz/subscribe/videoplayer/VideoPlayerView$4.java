package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoPlayerView$4
  implements View.OnClickListener
{
  VideoPlayerView$4(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    VideoPlayerView.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.4
 * JD-Core Version:    0.7.0.1
 */