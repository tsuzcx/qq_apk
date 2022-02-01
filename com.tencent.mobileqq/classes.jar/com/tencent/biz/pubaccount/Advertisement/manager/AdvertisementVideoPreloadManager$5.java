package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import nyd;
import oib;

public class AdvertisementVideoPreloadManager$5
  implements Runnable
{
  public AdvertisementVideoPreloadManager$5(nyd paramnyd) {}
  
  public void run()
  {
    oib localoib = nyd.a(this.this$0);
    if (localoib != null)
    {
      localoib.a(PAAdPreloadTask.class.getSimpleName());
      Iterator localIterator = nyd.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        localoib.a((PAAdPreloadTask)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.5
 * JD-Core Version:    0.7.0.1
 */