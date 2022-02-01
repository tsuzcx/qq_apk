package com.tencent.biz.pubaccount.Advertisement.manager;

import java.util.ArrayList;
import java.util.Iterator;
import nwf;
import nwg;
import nwo;
import nws;

public class AdvertisementRecentUserManager$1
  implements Runnable
{
  public AdvertisementRecentUserManager$1(nwo paramnwo, nwf paramnwf) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      nws.b(((nwg)localIterator.next()).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */