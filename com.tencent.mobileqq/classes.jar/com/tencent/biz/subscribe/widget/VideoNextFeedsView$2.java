package com.tencent.biz.subscribe.widget;

import android.os.Handler;
import java.util.TimerTask;

class VideoNextFeedsView$2
  extends TimerTask
{
  VideoNextFeedsView$2(VideoNextFeedsView paramVideoNextFeedsView) {}
  
  public void run()
  {
    if (VideoNextFeedsView.b(this.this$0) <= 0)
    {
      VideoNextFeedsView.a(this.this$0);
      this.this$0.c();
      if (VideoNextFeedsView.c(this.this$0) != null) {
        VideoNextFeedsView.c(this.this$0).a(true);
      }
      return;
    }
    if (this.this$0.getHandler() != null) {
      this.this$0.getHandler().post(new VideoNextFeedsView.2.1(this));
    }
    VideoNextFeedsView.f(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.VideoNextFeedsView.2
 * JD-Core Version:    0.7.0.1
 */