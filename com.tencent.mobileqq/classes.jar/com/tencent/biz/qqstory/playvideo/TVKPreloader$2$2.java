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
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem, new Throwable(this.jdField_a_of_type_JavaLangString + "|" + String.valueOf(this.jdField_a_of_type_Int) + "|" + this.b));
    }
    TVKPreloader.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.2
 * JD-Core Version:    0.7.0.1
 */