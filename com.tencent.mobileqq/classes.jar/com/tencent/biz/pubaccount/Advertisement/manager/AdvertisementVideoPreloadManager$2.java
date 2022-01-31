package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import myh;
import myj;

public class AdvertisementVideoPreloadManager$2
  implements Runnable
{
  public AdvertisementVideoPreloadManager$2(myh parammyh) {}
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(myh.a(this.this$0), new myj(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      myh.c("installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */