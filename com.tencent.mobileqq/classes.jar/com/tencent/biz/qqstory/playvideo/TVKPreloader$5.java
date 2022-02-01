package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class TVKPreloader$5
  implements Runnable
{
  TVKPreloader$5(TVKPreloader.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.a().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).c(this.a);
    }
    TVKPreloader.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.5
 * JD-Core Version:    0.7.0.1
 */