package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xlo;
import xlu;
import xlv;

public final class TVKPreloader$4
  implements Runnable
{
  public TVKPreloader$4(xlu paramxlu) {}
  
  public void run()
  {
    Iterator localIterator = xlo.a().iterator();
    while (localIterator.hasNext()) {
      ((xlv)localIterator.next()).c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.4
 * JD-Core Version:    0.7.0.1
 */