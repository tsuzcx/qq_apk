package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import rzt;
import rzv;
import sac;
import sad;

class VideoView$4
  implements Runnable
{
  VideoView$4(VideoView paramVideoView, Runnable paramRunnable) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      VideoView.access$602(this.this$0, sac.a.a());
      if (VideoView.access$600(this.this$0) != null)
      {
        VideoView.access$702(this.this$0, VideoView.access$800(this.this$0));
        VideoView.access$902(this.this$0, VideoView.access$600(this.this$0).a(VideoView.access$700(this.this$0)));
        if (VideoView.access$900(this.this$0) != null)
        {
          VideoView.access$900(this.this$0).a(VideoView.access$700(this.this$0));
          VideoView.access$1000(this.this$0, false);
          VideoView.access$1100(this.this$0);
          this.a.run();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.4
 * JD-Core Version:    0.7.0.1
 */