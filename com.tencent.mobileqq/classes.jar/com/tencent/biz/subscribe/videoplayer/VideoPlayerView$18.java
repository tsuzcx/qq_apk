package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

class VideoPlayerView$18
  implements Runnable
{
  VideoPlayerView$18(VideoPlayerView paramVideoPlayerView) {}
  
  public void run()
  {
    VideoPlayerView.a(this.this$0, 10);
    if (this.this$0.getSuperPlayer() != null)
    {
      VideoPlayerView.I(this.this$0);
      VideoPlayerView.i(this.this$0);
      VideoPlayerView.a(this.this$0, true);
    }
    if (!VideoPlayerView.s(this.this$0))
    {
      if (VideoPlayerView.l(this.this$0) != null) {
        if (this.this$0.q())
        {
          VideoPlayerView.l(this.this$0).b();
        }
        else if ((VideoPlayerView.l(this.this$0).a()) && (this.this$0.s != null))
        {
          this.this$0.s.setBackgroundResource(2131165578);
          this.this$0.s.setImageDrawable(null);
          this.this$0.s.setVisibility(0);
          if (VideoPlayerView.c(this.this$0) != null) {
            VSReporter.b(VideoPlayerView.c(this.this$0).poster.id.get(), "auth_video", "finish_exp", 0, 0, new String[] { "", "", VideoPlayerView.c(this.this$0).poster.nick.get(), VideoPlayerView.c(this.this$0).title.get() });
          }
        }
      }
    }
    else
    {
      VideoPlayerView.q(this.this$0);
      this.this$0.j();
    }
    if (VideoPlayerView.A(this.this$0) != null) {
      VideoPlayerView.A(this.this$0).setVisibility(8);
    }
    if (VideoPlayerView.m(this.this$0) != null) {
      VideoPlayerView.m(this.this$0).onVideoComplete(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.18
 * JD-Core Version:    0.7.0.1
 */