package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import voi;
import vok;
import voo;
import vop;

public class TVKPreloader$2$2
  implements Runnable
{
  public TVKPreloader$2$2(vok paramvok, voo paramvoo, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = voi.a().iterator();
    while (localIterator.hasNext()) {
      ((vop)localIterator.next()).a(this.jdField_a_of_type_Voo, new Throwable(this.jdField_a_of_type_JavaLangString + "|" + String.valueOf(this.jdField_a_of_type_Int) + "|" + this.b));
    }
    voi.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.2
 * JD-Core Version:    0.7.0.1
 */