package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import ofd;
import off;

public class AdvertisementVideoPreloadManager$2
  implements Runnable
{
  public AdvertisementVideoPreloadManager$2(ofd paramofd) {}
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(ofd.a(this.this$0), new off(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      ofd.c("installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */