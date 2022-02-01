package com.tencent.biz.subscribe.videoplayer;

import android.view.View;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;

class VideoPlayerView$8
  implements Runnable
{
  VideoPlayerView$8(VideoPlayerView paramVideoPlayerView) {}
  
  public void run()
  {
    Object localObject = new FloatingScreenParams.FloatingBuilder();
    boolean bool;
    if ((this.this$0.getPlayerVideoView() != null) && (this.this$0.getPlayerVideoView().getRenderViewWidth() <= this.this$0.getPlayerVideoView().getRenderViewHeight())) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = ((FloatingScreenParams.FloatingBuilder)localObject).setIsHorizontal(bool).setCanMove(true).setCanZoom(false).build();
    if (((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(BaseApplicationImpl.getContext(), (View)this.this$0.getPlayerVideoView(), (FloatingScreenParams)localObject, 28) == 1)
    {
      ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(this.this$0.getContext());
      return;
    }
    this.this$0.r();
    VideoPlayerView.b(this.this$0, true);
    if ((VideoPlayerView.l(this.this$0) != null) && (VideoPlayerView.l(this.this$0).getVisibility() == 0))
    {
      VideoPlayerView.l(this.this$0).c();
      VideoPlayerView.l(this.this$0).b();
    }
    if (this.this$0.getSuperPlayer().getCurrentPositionMs() >= this.this$0.getSuperPlayer().getDurationMs())
    {
      this.this$0.j();
      if (VideoPlayerView.m(this.this$0) != null) {
        VideoPlayerView.m(this.this$0).onVideoStart((int)this.this$0.getSuperPlayer().getDurationMs());
      }
    }
    if (this.this$0.getPlayerVideoView() != null)
    {
      VideoPlayerView.m(this.this$0).onVideoSize(this.this$0.getPlayerVideoView().getRenderViewWidth(), this.this$0.getPlayerVideoView().getRenderViewHeight());
      this.this$0.e();
    }
    if (VideoPlayerView.n(this.this$0) != null) {
      VideoPlayerView.n(this.this$0).getBaseActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.8
 * JD-Core Version:    0.7.0.1
 */