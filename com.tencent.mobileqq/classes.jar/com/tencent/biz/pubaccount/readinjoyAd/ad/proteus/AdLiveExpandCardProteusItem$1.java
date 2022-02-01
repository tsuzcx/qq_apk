package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;

class AdLiveExpandCardProteusItem$1
  extends Handler
{
  AdLiveExpandCardProteusItem$1(AdLiveExpandCardProteusItem paramAdLiveExpandCardProteusItem, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramMessage = CommonImageCacheHelper.a(AdLiveExpandCardProteusItem.a(this.a));
      ReadInJoyLogicEngineEventDispatcher.a().a(paramMessage);
      return;
    }
    AdLiveExpandCardProteusItem.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdLiveExpandCardProteusItem.1
 * JD-Core Version:    0.7.0.1
 */