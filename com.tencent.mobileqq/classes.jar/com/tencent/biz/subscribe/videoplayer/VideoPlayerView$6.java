package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;

class VideoPlayerView$6
  implements View.OnClickListener
{
  VideoPlayerView$6(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (FastClickUtils.a("mLLSkipBackWrapper", 500L))
    {
      VideoPlayerView.e(this.a);
      VideoPlayerView localVideoPlayerView = this.a;
      VideoPlayerView.a(localVideoPlayerView, VideoPlayerView.b(localVideoPlayerView), 0, 1, true);
      if (this.a.a() != null)
      {
        localVideoPlayerView = this.a;
        localVideoPlayerView.a(localVideoPlayerView.a().getCurrentPositionMs() - 10000L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.6
 * JD-Core Version:    0.7.0.1
 */