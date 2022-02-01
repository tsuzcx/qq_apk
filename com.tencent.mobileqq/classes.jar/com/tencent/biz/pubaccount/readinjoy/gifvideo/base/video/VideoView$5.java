package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import sgx;

class VideoView$5
  implements Runnable
{
  VideoView$5(VideoView paramVideoView, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (VideoView.access$900(this.this$0) != null)
      {
        VideoView.access$900(this.this$0).a(VideoView.access$1200(this.this$0));
        if (this.a) {
          this.this$0.openVideo();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.5
 * JD-Core Version:    0.7.0.1
 */