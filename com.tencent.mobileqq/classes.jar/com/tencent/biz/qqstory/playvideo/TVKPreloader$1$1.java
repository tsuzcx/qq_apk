package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import voi;
import voj;
import voo;
import vop;

public class TVKPreloader$1$1
  implements Runnable
{
  public TVKPreloader$1$1(voj paramvoj, voo paramvoo) {}
  
  public void run()
  {
    Iterator localIterator = voi.a().iterator();
    while (localIterator.hasNext()) {
      ((vop)localIterator.next()).b(this.a);
    }
    voi.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1
 * JD-Core Version:    0.7.0.1
 */