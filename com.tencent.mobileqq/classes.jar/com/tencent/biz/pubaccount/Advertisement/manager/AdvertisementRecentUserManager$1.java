package com.tencent.biz.pubaccount.Advertisement.manager;

import java.util.ArrayList;
import java.util.Iterator;
import oeq;
import oer;
import oez;
import ofd;

public class AdvertisementRecentUserManager$1
  implements Runnable
{
  public AdvertisementRecentUserManager$1(oez paramoez, oeq paramoeq) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ofd.b(((oer)localIterator.next()).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */