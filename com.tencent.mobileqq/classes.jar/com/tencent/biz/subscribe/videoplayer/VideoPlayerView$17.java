package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.framework.BaseVideoViewListenerSets;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.immersive.ImmersiveUtils;

class VideoPlayerView$17
  implements Runnable
{
  VideoPlayerView$17(VideoPlayerView paramVideoPlayerView, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    VSReporter.a("subscribe_account_video_play", VSReporter.a(VSReporter.a(0L, 0L, VideoPlayerView.a(this.this$0), 0L)));
    VSReporter.a("subscribe_account_video_play_first_buffer", VSReporter.a(VSReporter.a(0L, System.currentTimeMillis() - VideoPlayerView.a(this.this$0), VideoPlayerView.a(this.this$0), 0L)));
    VideoPlayerView.a(this.this$0, 10);
    VideoPlayerView.a(this.this$0, false);
    VideoPlayerView.h(this.this$0);
    VideoPlayerView.i(this.this$0);
    Object localObject;
    int i;
    if (VideoPlayerView.d(this.this$0) != null)
    {
      localObject = (FrameLayout.LayoutParams)VideoPlayerView.d(this.this$0).getLayoutParams();
      if (VideoPlayerView.c(this.this$0)) {
        i = 21;
      } else {
        i = 85;
      }
      ((FrameLayout.LayoutParams)localObject).gravity = i;
      int j = ImmersiveUtils.dpToPx(25.0F);
      if (VideoPlayerView.c(this.this$0)) {
        i = 0;
      } else {
        i = ImmersiveUtils.dpToPx(82.0F);
      }
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, j, i);
      VideoPlayerView.d(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((VideoPlayerView.a(this.this$0) != null) && (this.this$0.d()) && (this.this$0.a() != null))
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
    if (this.this$0.a != null)
    {
      localObject = this.this$0.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      i = (int)l;
      localStringBuilder.append(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    if (((VideoPlayerView.g(this.this$0)) && (NetworkUtils.isWifiConnected(this.this$0.getContext()))) || (VideoPlayerView.i()))
    {
      if (!VideoPlayerView.h(this.this$0))
      {
        this.this$0.f();
        VideoPlayerView.a(this.this$0, System.currentTimeMillis());
      }
    }
    else if (VideoPlayerView.i(this.this$0)) {
      VideoPlayerView.a(this.this$0).setVisibility(0);
    } else if (VideoPlayerView.e(this.this$0) != null) {
      VideoPlayerView.e(this.this$0).setVisibility(0);
    }
    if (VideoPlayerView.a(this.this$0) != null) {
      VideoPlayerView.b(this.this$0).a(this.a);
    }
    VideoPlayerView.j(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.17
 * JD-Core Version:    0.7.0.1
 */