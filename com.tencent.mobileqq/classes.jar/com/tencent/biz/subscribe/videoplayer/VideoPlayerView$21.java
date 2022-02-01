package com.tencent.biz.subscribe.videoplayer;

import android.view.View;

class VideoPlayerView$21
  implements Runnable
{
  VideoPlayerView$21(VideoPlayerView paramVideoPlayerView) {}
  
  public void run()
  {
    if ((VideoPlayerView.a(this.this$0) != null) && (VideoPlayerView.a(this.this$0).getVisibility() == 8) && (!VideoPlayerView.i()))
    {
      this.this$0.g();
      VideoPlayerView.e(this.this$0);
      VideoPlayerView.a(this.this$0).setVisibility(0);
      VideoPlayerView.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.21
 * JD-Core Version:    0.7.0.1
 */