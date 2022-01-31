package com.tencent.biz.subscribe.videoplayer;

import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import vxe;

class VideoPlayerView$9
  implements Runnable
{
  VideoPlayerView$9(VideoPlayerView paramVideoPlayerView) {}
  
  public void run()
  {
    Object localObject = new FloatingScreenParams.FloatingBuilder();
    boolean bool;
    if ((this.this$0.a() == null) || (this.this$0.a().getViewWidth() > this.this$0.a().getViewHeight()))
    {
      bool = true;
      localObject = ((FloatingScreenParams.FloatingBuilder)localObject).setIsHorizontal(bool).setCanMove(true).build();
      if (FloatingScreenManager.getInstance().enterFloatingScreen(BaseApplicationImpl.getContext(), VideoPlayerView.a(this.this$0).a(), (FloatingScreenParams)localObject, 28) != 1) {
        break label102;
      }
      FloatingScreenPermission.enterPermissionRequestDialog(this.this$0.getContext());
    }
    label102:
    do
    {
      return;
      bool = false;
      break;
      this.this$0.b();
      VideoPlayerView.c(this.this$0, true);
      if ((VideoPlayerView.a(this.this$0) != null) && (VideoPlayerView.a(this.this$0).getVisibility() == 0))
      {
        VideoPlayerView.a(this.this$0).b();
        VideoPlayerView.a(this.this$0).a();
      }
      if (this.this$0.a().a() >= this.this$0.a().b())
      {
        this.this$0.f();
        if (VideoPlayerView.a(this.this$0) != null) {
          VideoPlayerView.a(this.this$0).onVideoStart((int)VideoPlayerView.a(this.this$0).b());
        }
      }
      if (this.this$0.a() != null)
      {
        VideoPlayerView.a(this.this$0).onVideoSize(this.this$0.a().getViewWidth(), this.this$0.a().getViewHeight());
        this.this$0.d();
      }
    } while (VideoPlayerView.a(this.this$0) == null);
    VideoPlayerView.a(this.this$0).getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.9
 * JD-Core Version:    0.7.0.1
 */