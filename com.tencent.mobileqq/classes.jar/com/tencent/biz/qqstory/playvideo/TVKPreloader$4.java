package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tvk;
import tvq;
import tvr;

public final class TVKPreloader$4
  implements Runnable
{
  public TVKPreloader$4(tvq paramtvq) {}
  
  public void run()
  {
    Iterator localIterator = tvk.a().iterator();
    while (localIterator.hasNext()) {
      ((tvr)localIterator.next()).c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.4
 * JD-Core Version:    0.7.0.1
 */