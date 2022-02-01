package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$11
  implements Runnable
{
  VideoView$11(VideoView paramVideoView) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0)
      {
        QLog.d("gifvideo.VideoView", 1, "startPlay");
        VideoView.access$2902(this.this$0, System.currentTimeMillis());
        if (this.this$0.getCurrentState() == 6)
        {
          if ((!TextUtils.isEmpty(VideoView.access$1400(this.this$0))) && (VideoView.access$1400(this.this$0).equals(VideoView.access$1500(this.this$0))))
          {
            QLog.d("gifvideo.VideoView", 1, "has opened");
            VideoView.access$1700(this.this$0);
            return;
          }
          QLog.d("gifvideo.VideoView", 1, "not current url");
          if (VideoView.access$900(this.this$0) == null) {
            continue;
          }
          VideoView.access$1900(this.this$0);
          this.this$0.openVideo();
        }
      }
      if (this.this$0.getCurrentState() == 4)
      {
        QLog.d("gifvideo.VideoView", 1, "has inited, just start");
        VideoView.access$3000(this.this$0);
      }
      else if (this.this$0.getCurrentState() == 9)
      {
        QLog.d("gifvideo.VideoView", 1, "now is stop, so start again");
        VideoView.access$3000(this.this$0);
      }
      else if (this.this$0.getCurrentState() == 8)
      {
        this.this$0.resume();
      }
      else
      {
        QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.getCurrentState() + ", do nothing");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.11
 * JD-Core Version:    0.7.0.1
 */