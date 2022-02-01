package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;

class VideoPlayerView$7
  implements View.OnClickListener
{
  VideoPlayerView$7(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (FastClickUtils.a("mLLSkipForwardWrapper", 500L))
    {
      VideoPlayerView.i(this.a);
      VideoPlayerView localVideoPlayerView = this.a;
      VideoPlayerView.a(localVideoPlayerView, VideoPlayerView.k(localVideoPlayerView), 0, 1, true);
      if (this.a.getSuperPlayer() != null)
      {
        localVideoPlayerView = this.a;
        localVideoPlayerView.a(localVideoPlayerView.getSuperPlayer().getCurrentPositionMs() + 10000L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.7
 * JD-Core Version:    0.7.0.1
 */