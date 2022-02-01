package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class AdvertisementVideoPreloadManager$NetInfoHandler
  implements INetInfoHandler
{
  AdvertisementVideoPreloadManager a;
  
  public AdvertisementVideoPreloadManager$NetInfoHandler(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager1, AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager2)
  {
    this.a = paramAdvertisementVideoPreloadManager2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    AdvertisementVideoPreloadManager.c("onNetMobile2None");
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = this.a;
    if (localAdvertisementVideoPreloadManager != null) {
      AdvertisementVideoPreloadManager.b(localAdvertisementVideoPreloadManager);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetMobile2Wifi");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.b(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetNone2Mobile");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.b(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetNone2Wifi");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.b(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetWifi2Mobile");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.b(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    AdvertisementVideoPreloadManager.c("onNetWifi2None");
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = this.a;
    if (localAdvertisementVideoPreloadManager != null) {
      AdvertisementVideoPreloadManager.b(localAdvertisementVideoPreloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */