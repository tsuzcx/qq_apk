package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import nws;
import ogo;

public class AdvertisementVideoPreloadManager$5
  implements Runnable
{
  public AdvertisementVideoPreloadManager$5(nws paramnws) {}
  
  public void run()
  {
    ogo localogo = nws.a(this.this$0);
    if (localogo != null)
    {
      localogo.a(PAAdPreloadTask.class.getSimpleName());
      Iterator localIterator = nws.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        localogo.a((PAAdPreloadTask)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.5
 * JD-Core Version:    0.7.0.1
 */