package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xbu;
import xca;
import xcb;

public final class TVKPreloader$5
  implements Runnable
{
  public TVKPreloader$5(xca paramxca) {}
  
  public void run()
  {
    Iterator localIterator = xbu.a().iterator();
    while (localIterator.hasNext()) {
      ((xcb)localIterator.next()).c(this.a);
    }
    xbu.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.5
 * JD-Core Version:    0.7.0.1
 */