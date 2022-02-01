package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xht;
import xhz;
import xia;

public final class TVKPreloader$10
  implements Runnable
{
  public TVKPreloader$10(xhz paramxhz) {}
  
  public void run()
  {
    Iterator localIterator = xht.a().iterator();
    while (localIterator.hasNext()) {
      ((xia)localIterator.next()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.10
 * JD-Core Version:    0.7.0.1
 */