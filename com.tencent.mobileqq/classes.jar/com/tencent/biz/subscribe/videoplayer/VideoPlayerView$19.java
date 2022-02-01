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
    VideoPlayerView.b(this.this$0, false);
    VSReporter.a("subscribe_account_video_play", VSReporter.a(VSReporter.a(this.a, 0L, VideoPlayerView.a(this.this$0), 0L)));
    if (!VideoPlayerView.j(this.this$0)) {
      QQToast.a(this.this$0.getContext(), 1, HardCodeUtil.a(2131716096), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19
 * JD-Core Version:    0.7.0.1
 */