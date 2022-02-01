package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;

class ReadInJoyAdGestureView$1
  implements Runnable
{
  ReadInJoyAdGestureView$1(ReadInJoyAdGestureView paramReadInJoyAdGestureView) {}
  
  public void run()
  {
    if ((this.this$0.b) && (ReadInJoyAdGestureView.a(this.this$0)) && (ReadInJoyAdGestureView.a != null))
    {
      ReadInJoyAdGestureView.a.removeCallbacksAndMessages(null);
      return;
    }
    if (this.this$0.m >= 15.0F)
    {
      this.this$0.m -= 2.0F;
      this.this$0.e = false;
    }
    for (;;)
    {
      this.this$0.invalidate();
      if (ReadInJoyAdGestureView.a == null) {
        break;
      }
      ReadInJoyAdGestureView.a.postDelayed(this, 5L);
      return;
      if (this.this$0.m <= -15.0F)
      {
        this.this$0.m += 2.0F;
        this.this$0.e = true;
      }
      else if (this.this$0.m == 0.0F)
      {
        if (this.this$0.e) {
          this.this$0.m += 2.0F;
        } else {
          this.this$0.m -= 2.0F;
        }
      }
      else if ((this.this$0.m > -15.0F) && (this.this$0.m < 15.0F))
      {
        if (this.this$0.e) {
          this.this$0.m += 2.0F;
        } else {
          this.this$0.m -= 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView.1
 * JD-Core Version:    0.7.0.1
 */