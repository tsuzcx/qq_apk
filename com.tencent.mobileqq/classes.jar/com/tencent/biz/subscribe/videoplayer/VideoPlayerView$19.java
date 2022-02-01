package com.tencent.biz.subscribe.videoplayer;

import aanb;
import anvx;
import com.tencent.mobileqq.widget.QQToast;

class VideoPlayerView$19
  implements Runnable
{
  VideoPlayerView$19(VideoPlayerView paramVideoPlayerView, int paramInt) {}
  
  public void run()
  {
    VideoPlayerView.a(this.this$0, 9);
    VideoPlayerView.b(this.this$0, false);
    aanb.a("subscribe_account_video_play", aanb.a(aanb.a(this.a, 0L, VideoPlayerView.a(this.this$0), 0L)));
    if (!VideoPlayerView.j(this.this$0)) {
      QQToast.a(this.this$0.getContext(), 1, anvx.a(2131715707), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19
 * JD-Core Version:    0.7.0.1
 */