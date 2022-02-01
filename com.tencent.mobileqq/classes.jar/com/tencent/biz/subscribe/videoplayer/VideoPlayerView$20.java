package com.tencent.biz.subscribe.videoplayer;

class VideoPlayerView$20
  implements Runnable
{
  VideoPlayerView$20(VideoPlayerView paramVideoPlayerView, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i != 112)
    {
      if (i != 113) {
        return;
      }
      VideoPlayerView.a(this.this$0, 5);
      VideoPlayerView.a(this.this$0, false);
      VideoPlayerView.b(this.this$0, false);
      VideoPlayerView.j(this.this$0);
      return;
    }
    VideoPlayerView.a(this.this$0, 4);
    VideoPlayerView.a(this.this$0, true);
    VideoPlayerView.b(this.this$0, true);
    VideoPlayerView.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.20
 * JD-Core Version:    0.7.0.1
 */