package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$13
  implements Runnable
{
  VideoView$13(VideoView paramVideoView) {}
  
  public void run()
  {
    if ((this.this$0.a() != 4) && (this.this$0.a() != 9) && (this.this$0.a() != 10) && (VideoView.b(this.this$0) != VideoView.d)) {
      QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.a() + ", return");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(VideoView.a(this.this$0))) {
        break;
      }
    } while (VideoView.c(this.this$0).equals(VideoView.a(this.this$0)));
    VideoView.b(this.this$0, VideoView.a(this.this$0));
    this.this$0.b(VideoView.a(this.this$0));
    return;
    if (!TextUtils.isEmpty(VideoView.d(this.this$0)))
    {
      VideoView.f(this.this$0);
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "both url and vid is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.13
 * JD-Core Version:    0.7.0.1
 */