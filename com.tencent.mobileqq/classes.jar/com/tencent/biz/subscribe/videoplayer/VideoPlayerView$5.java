package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoPlayerView$5
  implements View.OnClickListener
{
  VideoPlayerView$5(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.f(this.a))
    {
      VideoPlayerView.g(this.a);
    }
    else
    {
      VideoPlayerView.h(this.a);
      if (VideoPlayerView.c(this.a) != null) {
        VSReporter.b(VideoPlayerView.c(this.a).poster.id.get(), "auth_video", "fullscreen", 0, 0, new String[] { "", "", VideoPlayerView.c(this.a).poster.nick.get(), VideoPlayerView.c(this.a).title.get() });
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.5
 * JD-Core Version:    0.7.0.1
 */