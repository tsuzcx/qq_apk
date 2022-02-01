package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class AdLiveExpandCardProteusItem$1
  extends Handler
{
  AdLiveExpandCardProteusItem$1(AdLiveExpandCardProteusItem paramAdLiveExpandCardProteusItem, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    AdLiveExpandCardProteusItem.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdLiveExpandCardProteusItem.1
 * JD-Core Version:    0.7.0.1
 */