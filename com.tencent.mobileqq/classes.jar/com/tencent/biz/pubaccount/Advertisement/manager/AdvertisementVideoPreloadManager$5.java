package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import myh;
import ngr;

public class AdvertisementVideoPreloadManager$5
  implements Runnable
{
  public AdvertisementVideoPreloadManager$5(myh parammyh) {}
  
  public void run()
  {
    ngr localngr = myh.a(this.this$0);
    if (localngr != null)
    {
      localngr.a(PAAdPreloadTask.class.getSimpleName());
      Iterator localIterator = myh.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        localngr.a((PAAdPreloadTask)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.5
 * JD-Core Version:    0.7.0.1
 */