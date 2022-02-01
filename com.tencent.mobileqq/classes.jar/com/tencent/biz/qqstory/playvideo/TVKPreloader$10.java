package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class TVKPreloader$10
  implements Runnable
{
  TVKPreloader$10(TVKPreloader.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.e().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.10
 * JD-Core Version:    0.7.0.1
 */