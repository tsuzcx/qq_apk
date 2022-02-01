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
    AdvertisementVideoPreloadManager.f("onNetMobile2None");
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = this.a;
    if (localAdvertisementVideoPreloadManager != null) {
      AdvertisementVideoPreloadManager.i(localAdvertisementVideoPreloadManager);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    AdvertisementVideoPreloadManager.f("onNetMobile2Wifi");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.i(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    AdvertisementVideoPreloadManager.f("onNetNone2Mobile");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.i(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    AdvertisementVideoPreloadManager.f("onNetNone2Wifi");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.i(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    AdvertisementVideoPreloadManager.f("onNetWifi2Mobile");
    paramString = this.a;
    if (paramString != null) {
      AdvertisementVideoPreloadManager.i(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    AdvertisementVideoPreloadManager.f("onNetWifi2None");
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = this.a;
    if (localAdvertisementVideoPreloadManager != null) {
      AdvertisementVideoPreloadManager.i(localAdvertisementVideoPreloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */