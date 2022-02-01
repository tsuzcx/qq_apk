package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class TVKPreloader$1$1
  implements Runnable
{
  TVKPreloader$1$1(TVKPreloader.1 param1, TVKPreloader.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.a().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).b(this.a);
    }
    TVKPreloader.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1
 * JD-Core Version:    0.7.0.1
 */