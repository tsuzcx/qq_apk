package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tvk;
import tvl;
import tvq;
import tvr;

public class TVKPreloader$1$1
  implements Runnable
{
  public TVKPreloader$1$1(tvl paramtvl, tvq paramtvq) {}
  
  public void run()
  {
    Iterator localIterator = tvk.a().iterator();
    while (localIterator.hasNext()) {
      ((tvr)localIterator.next()).b(this.a);
    }
    tvk.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1
 * JD-Core Version:    0.7.0.1
 */