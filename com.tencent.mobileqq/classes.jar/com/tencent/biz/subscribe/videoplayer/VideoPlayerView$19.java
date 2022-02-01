package com.tencent.biz.subscribe.videoplayer;

import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class VideoPlayerView$19
  implements Runnable
{
  VideoPlayerView$19(VideoPlayerView paramVideoPlayerView, int paramInt) {}
  
  public void run()
  {
    VideoPlayerView.a(this.this$0, 9);
    VideoPlayerView.f(this.this$0, false);
    VSReporter.a("subscribe_account_video_play", VSReporter.a(VSReporter.a(this.a, 0L, VideoPlayerView.u(this.this$0), 0L)));
    if (!VideoPlayerView.J(this.this$0)) {
      QQToast.makeText(this.this$0.getContext(), 1, HardCodeUtil.a(2131913545), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19
 * JD-Core Version:    0.7.0.1
 */