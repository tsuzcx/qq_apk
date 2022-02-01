package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$13
  implements Runnable
{
  VideoView$13(VideoView paramVideoView) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0)
      {
        if ((this.this$0.getCurrentState() != 4) && (this.this$0.getCurrentState() != 9) && (this.this$0.getCurrentState() != 10) && (VideoView.access$400(this.this$0) != VideoView.PLAYMODE_DISABLE))
        {
          QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.getCurrentState() + ", return");
          return;
        }
        if (!TextUtils.isEmpty(VideoView.access$1500(this.this$0)))
        {
          if (!VideoView.access$1600(this.this$0).equals(VideoView.access$1500(this.this$0)))
          {
            VideoView.access$1602(this.this$0, VideoView.access$1500(this.this$0));
            this.this$0.openVideoByUrl(VideoView.access$1500(this.this$0));
          }
          return;
        }
      }
      if (!TextUtils.isEmpty(VideoView.access$3200(this.this$0))) {
        VideoView.access$3300(this.this$0);
      } else {
        QLog.d("gifvideo.VideoView", 1, "both url and vid is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.13
 * JD-Core Version:    0.7.0.1
 */