package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class AdvertisementVideoPreloadManager$2$1
  implements TVK_SDKMgr.InstallListener
{
  AdvertisementVideoPreloadManager$2$1(AdvertisementVideoPreloadManager.2 param2) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("installSDK onInstalledFailed arg0=");
    localStringBuilder.append(paramInt);
    AdvertisementVideoPreloadManager.f(localStringBuilder.toString());
  }
  
  public void onInstalledSuccessed()
  {
    AdvertisementVideoPreloadManager.f("installSDK onInstalledSuccessed");
    AdvertisementVideoPreloadManager.b(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2.1
 * JD-Core Version:    0.7.0.1
 */