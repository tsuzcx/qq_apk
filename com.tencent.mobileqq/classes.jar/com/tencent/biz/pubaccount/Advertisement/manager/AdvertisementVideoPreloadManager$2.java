package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

class AdvertisementVideoPreloadManager$2
  implements Runnable
{
  AdvertisementVideoPreloadManager$2(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(AdvertisementVideoPreloadManager.a(this.this$0), new AdvertisementVideoPreloadManager.2.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installSDK t==");
      localStringBuilder.append(localThrowable.toString());
      AdvertisementVideoPreloadManager.f(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */