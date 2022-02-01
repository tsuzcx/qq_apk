package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;

class AdvertisementVideoPreloadManager$4
  implements Runnable
{
  AdvertisementVideoPreloadManager$4(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      AdvertisementVideoPreloadManager.c(((PAAdPreloadTask)localIterator.next()).mVideoVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.4
 * JD-Core Version:    0.7.0.1
 */