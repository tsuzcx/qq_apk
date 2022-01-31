package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.qphone.base.util.QLog;

class VideoView$12
  implements Runnable
{
  VideoView$12(VideoView paramVideoView) {}
  
  public void run()
  {
    QLog.d("gifvideo.VideoView", 1, this.this$0.getTag() + " stopPlay");
    VideoView.a(this.this$0, "");
    VideoView.b(this.this$0, "");
    this.this$0.g();
    VideoView.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.12
 * JD-Core Version:    0.7.0.1
 */