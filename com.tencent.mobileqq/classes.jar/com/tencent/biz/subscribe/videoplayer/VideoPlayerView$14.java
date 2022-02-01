package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoPlayerView$14
  implements View.OnClickListener
{
  VideoPlayerView$14(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.a(this.a) != null)
    {
      VideoPlayerView.a(this.a).b();
      VideoPlayerView.g(this.a);
      VideoPlayerView.a(this.a, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.14
 * JD-Core Version:    0.7.0.1
 */