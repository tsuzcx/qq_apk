package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import vjz;
import vkf;
import vkg;

public final class TVKPreloader$7
  implements Runnable
{
  public TVKPreloader$7(vkf paramvkf) {}
  
  public void run()
  {
    Iterator localIterator = vjz.a().iterator();
    while (localIterator.hasNext()) {
      ((vkg)localIterator.next()).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.7
 * JD-Core Version:    0.7.0.1
 */