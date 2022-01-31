package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tvh;
import tvj;
import tvn;
import tvo;

public class TVKPreloader$2$2
  implements Runnable
{
  public TVKPreloader$2$2(tvj paramtvj, tvn paramtvn, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = tvh.a().iterator();
    while (localIterator.hasNext()) {
      ((tvo)localIterator.next()).a(this.jdField_a_of_type_Tvn, new Throwable(this.jdField_a_of_type_JavaLangString + "|" + String.valueOf(this.jdField_a_of_type_Int) + "|" + this.b));
    }
    tvh.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.2
 * JD-Core Version:    0.7.0.1
 */