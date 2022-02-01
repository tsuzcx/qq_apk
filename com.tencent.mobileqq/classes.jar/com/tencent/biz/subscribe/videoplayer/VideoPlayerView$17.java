package com.tencent.biz.subscribe.videoplayer;

import aaxb;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.immersive.ImmersiveUtils;
import vuq;

class VideoPlayerView$17
  implements Runnable
{
  VideoPlayerView$17(VideoPlayerView paramVideoPlayerView, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    aaxb.a("subscribe_account_video_play", aaxb.a(aaxb.a(0L, 0L, VideoPlayerView.a(this.this$0), 0L)));
    aaxb.a("subscribe_account_video_play_first_buffer", aaxb.a(aaxb.a(0L, System.currentTimeMillis() - VideoPlayerView.a(this.this$0), VideoPlayerView.a(this.this$0), 0L)));
    VideoPlayerView.a(this.this$0, 10);
    VideoPlayerView.a(this.this$0, false);
    VideoPlayerView.h(this.this$0);
    VideoPlayerView.i(this.this$0);
    int i;
    if (VideoPlayerView.d(this.this$0) != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)VideoPlayerView.d(this.this$0).getLayoutParams();
      if (VideoPlayerView.c(this.this$0))
      {
        i = 21;
        localLayoutParams.gravity = i;
        int j = ImmersiveUtils.a(25.0F);
        if (!VideoPlayerView.c(this.this$0)) {
          break label490;
        }
        i = 0;
        label146:
        localLayoutParams.setMargins(0, 0, j, i);
        VideoPlayerView.d(this.this$0).setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if ((VideoPlayerView.a(this.this$0) != null) && (this.this$0.c()) && (this.this$0.a() != null))
      {
        if (!VideoPlayerView.f(this.this$0)) {
          VideoPlayerView.a(this.this$0).onOrientationChange(VideoPlayerView.c(this.this$0));
        }
        VideoPlayerView.a(this.this$0).onVideoSize(this.this$0.a().getRenderViewWidth(), this.this$0.a().getRenderViewHeight());
      }
      if (VideoPlayerView.e(this.this$0) != null)
      {
        VideoPlayerView.e(this.this$0).setVisibility(0);
        VideoPlayerView.b(this.this$0, false);
      }
      if (VideoPlayerView.f(this.this$0) != null) {
        VideoPlayerView.f(this.this$0).setVisibility(0);
      }
      long l = this.a.getDurationMs() / 1000L;
      if (this.this$0.a != null) {
        this.this$0.a.setText("/" + String.format("%02d:%02d", new Object[] { Integer.valueOf((int)l / 60), Integer.valueOf((int)l % 60) }));
      }
      if (((!VideoPlayerView.g(this.this$0)) || (!NetworkUtils.isWifiConnected(this.this$0.getContext()))) && (!VideoPlayerView.m())) {
        break label499;
      }
      if (!VideoPlayerView.h(this.this$0))
      {
        this.this$0.d();
        VideoPlayerView.a(this.this$0, System.currentTimeMillis());
      }
    }
    for (;;)
    {
      if (VideoPlayerView.a(this.this$0) != null) {
        VideoPlayerView.b(this.this$0).a(this.a);
      }
      VideoPlayerView.j(this.this$0);
      return;
      i = 85;
      break;
      label490:
      i = ImmersiveUtils.a(82.0F);
      break label146;
      label499:
      if (VideoPlayerView.i(this.this$0)) {
        VideoPlayerView.a(this.this$0).setVisibility(0);
      } else if (VideoPlayerView.e(this.this$0) != null) {
        VideoPlayerView.e(this.this$0).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.17
 * JD-Core Version:    0.7.0.1
 */