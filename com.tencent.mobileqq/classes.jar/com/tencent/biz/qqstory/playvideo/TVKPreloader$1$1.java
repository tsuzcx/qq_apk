package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tio;
import tip;
import tiu;
import tiv;

public class TVKPreloader$1$1
  implements Runnable
{
  public TVKPreloader$1$1(tip paramtip, tiu paramtiu) {}
  
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1
 * JD-Core Version:    0.7.0.1
 */