package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import nmb;
import nvl;

public class AdvertisementVideoPreloadManager$5
  implements Runnable
{
  public AdvertisementVideoPreloadManager$5(nmb paramnmb) {}
  
  public void run()
  {
    nvl localnvl = nmb.a(this.this$0);
    if (localnvl != null)
    {
      localnvl.a(PAAdPreloadTask.class.getSimpleName());
      Iterator localIterator = nmb.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        localnvl.a((PAAdPreloadTask)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.5
 * JD-Core Version:    0.7.0.1
 */