package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$14
  implements Runnable
{
  VideoView$14(VideoView paramVideoView) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        QLog.d("gifvideo.VideoView", 1, "startPlay");
        VideoView.a(this.this$0, System.currentTimeMillis());
        if (this.this$0.a() == 6)
        {
          if ((!TextUtils.isEmpty(VideoView.b(this.this$0))) && (VideoView.b(this.this$0).equals(VideoView.a(this.this$0))))
          {
            QLog.d("gifvideo.VideoView", 1, "has opened");
            VideoView.e(this.this$0);
            return;
          }
          QLog.d("gifvideo.VideoView", 1, "not current url");
          if (VideoView.a(this.this$0) == null) {
            continue;
          }
          VideoView.f(this.this$0);
          this.this$0.E_();
          continue;
        }
        if (this.this$0.a() != 4) {
          break label153;
        }
      }
      finally {}
      QLog.d("gifvideo.VideoView", 1, "has inited, just start");
      VideoView.h(this.this$0);
      continue;
      label153:
      if (this.this$0.a() == 9)
      {
        QLog.d("gifvideo.VideoView", 1, "now is stop, so start again");
        VideoView.h(this.this$0);
      }
      else if (this.this$0.a() == 8)
      {
        this.this$0.a();
      }
      else
      {
        QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.a() + ", do nothing");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.14
 * JD-Core Version:    0.7.0.1
 */