package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import java.util.ArrayList;
import java.util.Iterator;

class AdvertisementVideoPreloadManager$5
  implements Runnable
{
  AdvertisementVideoPreloadManager$5(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void run()
  {
    PublicAccountEntityHelper localPublicAccountEntityHelper = AdvertisementVideoPreloadManager.a(this.this$0);
    if (localPublicAccountEntityHelper != null)
    {
      localPublicAccountEntityHelper.a(PAAdPreloadTask.class.getSimpleName());
      Iterator localIterator = AdvertisementVideoPreloadManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        localPublicAccountEntityHelper.a((PAAdPreloadTask)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.5
 * JD-Core Version:    0.7.0.1
 */