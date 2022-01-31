package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tio;
import tiq;
import tiu;
import tiv;

public class TVKPreloader$2$1
  implements Runnable
{
  public TVKPreloader$2$1(tiq paramtiq, tiu paramtiu) {}
  
  public void run()
  {
    Iterator localIterator = tio.a().iterator();
    while (localIterator.hasNext()) {
      ((tiv)localIterator.next()).b(this.a);
    }
    tio.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.1
 * JD-Core Version:    0.7.0.1
 */