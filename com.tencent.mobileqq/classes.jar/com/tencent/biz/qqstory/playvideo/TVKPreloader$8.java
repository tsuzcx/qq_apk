package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tio;
import tiu;
import tiv;

public final class TVKPreloader$8
  implements Runnable
{
  public TVKPreloader$8(tiu paramtiu) {}
  
  public void run()
  {
    Iterator localIterator = tio.a().iterator();
    while (localIterator.hasNext()) {
      ((tiv)localIterator.next()).a(this.a, new Throwable("TVK_ICacheMgr create failed !"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.8
 * JD-Core Version:    0.7.0.1
 */