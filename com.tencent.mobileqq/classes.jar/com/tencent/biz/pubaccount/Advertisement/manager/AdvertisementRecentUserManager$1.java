package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import java.util.ArrayList;
import java.util.Iterator;

class AdvertisementRecentUserManager$1
  implements Runnable
{
  AdvertisementRecentUserManager$1(AdvertisementRecentUserManager paramAdvertisementRecentUserManager, AdvertisementItem paramAdvertisementItem) {}
  
  public void run()
  {
    Iterator localIterator = this.a.c.iterator();
    while (localIterator.hasNext()) {
      AdvertisementVideoPreloadManager.c(((VideoCoverItem)localIterator.next()).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */