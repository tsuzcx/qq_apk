package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xlo;
import xlu;
import xlv;

public final class TVKPreloader$5
  implements Runnable
{
  public TVKPreloader$5(xlu paramxlu) {}
  
  public void run()
  {
    Iterator localIterator = xlo.a().iterator();
    while (localIterator.hasNext()) {
      ((xlv)localIterator.next()).c(this.a);
    }
    xlo.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.5
 * JD-Core Version:    0.7.0.1
 */