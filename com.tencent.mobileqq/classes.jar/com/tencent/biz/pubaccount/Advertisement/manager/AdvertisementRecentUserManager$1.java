package com.tencent.biz.pubaccount.Advertisement.manager;

import java.util.ArrayList;
import java.util.Iterator;
import mxu;
import mxv;
import myd;
import myh;

public class AdvertisementRecentUserManager$1
  implements Runnable
{
  public AdvertisementRecentUserManager$1(myd parammyd, mxu parammxu) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      myh.b(((mxv)localIterator.next()).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */