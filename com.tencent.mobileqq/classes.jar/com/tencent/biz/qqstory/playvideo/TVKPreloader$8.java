package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class TVKPreloader$8
  implements Runnable
{
  TVKPreloader$8(TVKPreloader.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.e().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).a(this.a, new Throwable("TVK_ICacheMgr create failed !"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.8
 * JD-Core Version:    0.7.0.1
 */