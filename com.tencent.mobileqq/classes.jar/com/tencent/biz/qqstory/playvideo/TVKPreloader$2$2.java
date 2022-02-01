package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xlo;
import xlq;
import xlu;
import xlv;

public class TVKPreloader$2$2
  implements Runnable
{
  public TVKPreloader$2$2(xlq paramxlq, xlu paramxlu, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = xlo.a().iterator();
    while (localIterator.hasNext()) {
      ((xlv)localIterator.next()).a(this.jdField_a_of_type_Xlu, new Throwable(this.jdField_a_of_type_JavaLangString + "|" + String.valueOf(this.jdField_a_of_type_Int) + "|" + this.b));
    }
    xlo.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.2
 * JD-Core Version:    0.7.0.1
 */