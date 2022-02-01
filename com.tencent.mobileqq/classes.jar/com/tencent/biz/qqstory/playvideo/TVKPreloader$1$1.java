package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xbu;
import xbv;
import xca;
import xcb;

public class TVKPreloader$1$1
  implements Runnable
{
  public TVKPreloader$1$1(xbv paramxbv, xca paramxca) {}
  
  public void run()
  {
    Iterator localIterator = xbu.a().iterator();
    while (localIterator.hasNext()) {
      ((xcb)localIterator.next()).b(this.a);
    }
    xbu.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1
 * JD-Core Version:    0.7.0.1
 */