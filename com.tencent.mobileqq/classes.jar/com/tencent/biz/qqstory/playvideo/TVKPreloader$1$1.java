package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import vjz;
import vka;
import vkf;
import vkg;

public class TVKPreloader$1$1
  implements Runnable
{
  public TVKPreloader$1$1(vka paramvka, vkf paramvkf) {}
  
  public void run()
  {
    Iterator localIterator = vjz.a().iterator();
    while (localIterator.hasNext()) {
      ((vkg)localIterator.next()).b(this.a);
    }
    vjz.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1
 * JD-Core Version:    0.7.0.1
 */