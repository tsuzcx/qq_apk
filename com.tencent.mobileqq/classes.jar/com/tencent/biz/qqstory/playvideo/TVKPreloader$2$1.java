package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xht;
import xhv;
import xhz;
import xia;

public class TVKPreloader$2$1
  implements Runnable
{
  public TVKPreloader$2$1(xhv paramxhv, xhz paramxhz) {}
  
  public void run()
  {
    Iterator localIterator = xht.a().iterator();
    while (localIterator.hasNext()) {
      ((xia)localIterator.next()).b(this.a);
    }
    xht.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.1
 * JD-Core Version:    0.7.0.1
 */