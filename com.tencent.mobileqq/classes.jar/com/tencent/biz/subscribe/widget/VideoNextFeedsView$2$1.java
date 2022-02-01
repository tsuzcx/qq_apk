package com.tencent.biz.subscribe.widget;

import android.widget.TextView;
import com.tencent.mobileqq.widget.CircleProgress;

class VideoNextFeedsView$2$1
  implements Runnable
{
  VideoNextFeedsView$2$1(VideoNextFeedsView.2 param2) {}
  
  public void run()
  {
    if ((VideoNextFeedsView.a(this.a.this$0) != null) && (VideoNextFeedsView.a(this.a.this$0) != null))
    {
      VideoNextFeedsView.a(this.a.this$0).setProgress(100.0F - VideoNextFeedsView.a(this.a.this$0) * 100.0F / 5.0F);
      VideoNextFeedsView.a(this.a.this$0).setText(String.valueOf(VideoNextFeedsView.a(this.a.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.VideoNextFeedsView.2.1
 * JD-Core Version:    0.7.0.1
 */