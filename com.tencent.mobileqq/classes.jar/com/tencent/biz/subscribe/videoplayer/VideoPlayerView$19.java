package com.tencent.biz.subscribe.videoplayer;

import amtj;
import com.tencent.mobileqq.widget.QQToast;
import zxp;

class VideoPlayerView$19
  implements Runnable
{
  VideoPlayerView$19(VideoPlayerView paramVideoPlayerView, int paramInt) {}
  
  public void run()
  {
    VideoPlayerView.a(this.this$0, 9);
    VideoPlayerView.b(this.this$0, false);
    zxp.a("subscribe_account_video_play", zxp.a(zxp.a(this.a, 0L, VideoPlayerView.a(this.this$0), 0L)));
    if (!VideoPlayerView.j(this.this$0)) {
      QQToast.a(this.this$0.getContext(), 1, amtj.a(2131715359), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19
 * JD-Core Version:    0.7.0.1
 */