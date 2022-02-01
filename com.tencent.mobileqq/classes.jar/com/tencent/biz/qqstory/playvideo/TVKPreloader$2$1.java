package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xbu;
import xbw;
import xca;
import xcb;

public class TVKPreloader$2$1
  implements Runnable
{
  public TVKPreloader$2$1(xbw paramxbw, xca paramxca) {}
  
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.1
 * JD-Core Version:    0.7.0.1
 */