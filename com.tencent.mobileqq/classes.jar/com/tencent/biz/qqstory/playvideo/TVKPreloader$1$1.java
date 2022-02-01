package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xht;
import xhu;
import xhz;
import xia;

public class TVKPreloader$1$1
  implements Runnable
{
  public TVKPreloader$1$1(xhu paramxhu, xhz paramxhz) {}
  
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1
 * JD-Core Version:    0.7.0.1
 */