package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$11
  implements Runnable
{
  VideoView$11(VideoView paramVideoView) {}
  
  public void run()
  {
    QLog.d("gifvideo.VideoView", 1, "startPlay");
    VideoView.a(this.this$0, System.currentTimeMillis());
    if (this.this$0.a() == 6)
    {
      if ((!TextUtils.isEmpty(VideoView.b(this.this$0))) && (VideoView.b(this.this$0).equals(VideoView.a(this.this$0))))
      {
        QLog.d("gifvideo.VideoView", 1, "has opened");
        VideoView.b(this.this$0);
      }
      do
      {
        return;
        QLog.d("gifvideo.VideoView", 1, "not current url");
      } while (VideoView.a(this.this$0) == null);
      VideoView.e(this.this$0);
      this.this$0.E_();
      return;
    }
    if (this.this$0.a() == 4)
    {
      QLog.d("gifvideo.VideoView", 1, "has inited, just start");
      VideoView.c(this.this$0);
      return;
    }
    if (this.this$0.a() == 9)
    {
      QLog.d("gifvideo.VideoView", 1, "now is stop, so start again");
      VideoView.c(this.this$0);
      return;
    }
    if (this.this$0.a() == 8)
    {
      this.this$0.a();
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.a() + ", do nothing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.11
 * JD-Core Version:    0.7.0.1
 */