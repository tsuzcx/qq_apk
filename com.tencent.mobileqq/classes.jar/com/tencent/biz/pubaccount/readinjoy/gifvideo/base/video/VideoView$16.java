package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$16
  implements Runnable
{
  VideoView$16(VideoView paramVideoView) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.this$0.a() != 4) && (this.this$0.a() != 9) && (this.this$0.a() != 10) && (VideoView.a(this.this$0) != VideoView.d))
        {
          QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.a() + ", return");
          return;
        }
        if (!TextUtils.isEmpty(VideoView.a(this.this$0)))
        {
          if (!VideoView.c(this.this$0).equals(VideoView.a(this.this$0)))
          {
            VideoView.b(this.this$0, VideoView.a(this.this$0));
            this.this$0.b(VideoView.a(this.this$0));
          }
          return;
        }
      }
      finally {}
      if (!TextUtils.isEmpty(VideoView.d(this.this$0))) {
        VideoView.k(this.this$0);
      } else {
        QLog.d("gifvideo.VideoView", 1, "both url and vid is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.16
 * JD-Core Version:    0.7.0.1
 */