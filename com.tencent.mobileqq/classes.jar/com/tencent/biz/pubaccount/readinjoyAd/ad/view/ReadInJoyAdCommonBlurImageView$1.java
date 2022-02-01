package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ReadInJoyAdCommonBlurImageView$1
  extends Handler
{
  ReadInJoyAdCommonBlurImageView$1(ReadInJoyAdCommonBlurImageView paramReadInJoyAdCommonBlurImageView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    ReadInJoyAdCommonBlurImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView.1
 * JD-Core Version:    0.7.0.1
 */