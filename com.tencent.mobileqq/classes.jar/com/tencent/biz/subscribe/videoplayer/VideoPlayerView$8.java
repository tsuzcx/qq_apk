package com.tencent.biz.subscribe.videoplayer;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
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
    if ((this.this$0.a() == null) || (this.this$0.a().getRenderViewWidth() > this.this$0.a().getRenderViewHeight()))
    {
      bool = true;
      localObject = ((FloatingScreenParams.FloatingBuilder)localObject).setIsHorizontal(bool).setCanMove(true).setCanZoom(false).build();
      if (((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(BaseApplicationImpl.getContext(), (View)this.this$0.a(), (FloatingScreenParams)localObject, 28) != 1) {
        break label113;
      }
      FloatingScreenPermission.enterPermissionRequestDialog(this.this$0.getContext());
    }
    label113:
    do
    {
      return;
      bool = false;
      break;
      this.this$0.m();
      VideoPlayerView.b(this.this$0, true);
      if ((VideoPlayerView.a(this.this$0) != null) && (VideoPlayerView.a(this.this$0).getVisibility() == 0))
      {
        VideoPlayerView.a(this.this$0).b();
        VideoPlayerView.a(this.this$0).a();
      }
      if (this.this$0.a().getCurrentPositionMs() >= this.this$0.a().getDurationMs())
      {
        this.this$0.i();
        if (VideoPlayerView.a(this.this$0) != null) {
          VideoPlayerView.a(this.this$0).onVideoStart((int)this.this$0.a().getDurationMs());
        }
      }
      if (this.this$0.a() != null)
      {
        VideoPlayerView.a(this.this$0).onVideoSize(this.this$0.a().getRenderViewWidth(), this.this$0.a().getRenderViewHeight());
        this.this$0.f();
      }
    } while (VideoPlayerView.a(this.this$0) == null);
    VideoPlayerView.a(this.this$0).getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.8
 * JD-Core Version:    0.7.0.1
 */