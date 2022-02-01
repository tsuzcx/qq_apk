package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xlo;
import xlq;
import xlu;
import xlv;

public class TVKPreloader$2$1
  implements Runnable
{
  public TVKPreloader$2$1(xlq paramxlq, xlu paramxlu) {}
  
  public void run()
  {
    Iterator localIterator = xlo.a().iterator();
    while (localIterator.hasNext()) {
      ((xlv)localIterator.next()).b(this.a);
    }
    xlo.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.1
 * JD-Core Version:    0.7.0.1
 */