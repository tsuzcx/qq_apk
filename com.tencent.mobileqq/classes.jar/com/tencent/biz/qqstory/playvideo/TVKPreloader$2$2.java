package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class TVKPreloader$2$2
  implements Runnable
{
  TVKPreloader$2$2(TVKPreloader.2 param2, TVKPreloader.PreloadItem paramPreloadItem, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.e().iterator();
    while (localIterator.hasNext())
    {
      TVKPreloader.PreloadListener localPreloadListener = (TVKPreloader.PreloadListener)localIterator.next();
      TVKPreloader.PreloadItem localPreloadItem = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("|");
      localStringBuilder.append(String.valueOf(this.c));
      localStringBuilder.append("|");
      localStringBuilder.append(this.d);
      localPreloadListener.a(localPreloadItem, new Throwable(localStringBuilder.toString()));
    }
    TVKPreloader.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.2
 * JD-Core Version:    0.7.0.1
 */