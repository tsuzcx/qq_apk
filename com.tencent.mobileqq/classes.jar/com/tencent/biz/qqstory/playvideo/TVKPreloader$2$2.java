package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class TVKPreloader$2$2
  implements Runnable
{
  TVKPreloader$2$2(TVKPreloader.2 param2, TVKPreloader.PreloadItem paramPreloadItem, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.a().iterator();
    while (localIterator.hasNext())
    {
      TVKPreloader.PreloadListener localPreloadListener = (TVKPreloader.PreloadListener)localIterator.next();
      TVKPreloader.PreloadItem localPreloadItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("|");
      localStringBuilder.append(String.valueOf(this.jdField_a_of_type_Int));
      localStringBuilder.append("|");
      localStringBuilder.append(this.b);
      localPreloadListener.a(localPreloadItem, new Throwable(localStringBuilder.toString()));
    }
    TVKPreloader.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.2
 * JD-Core Version:    0.7.0.1
 */