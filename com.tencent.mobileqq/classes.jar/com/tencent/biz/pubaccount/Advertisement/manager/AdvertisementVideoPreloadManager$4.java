package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import ofd;

public class AdvertisementVideoPreloadManager$4
  implements Runnable
{
  public AdvertisementVideoPreloadManager$4(ofd paramofd, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ofd.b(((PAAdPreloadTask)localIterator.next()).mVideoVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.4
 * JD-Core Version:    0.7.0.1
 */