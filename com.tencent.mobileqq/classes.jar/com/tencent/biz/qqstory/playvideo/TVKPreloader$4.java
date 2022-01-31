package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import voi;
import voo;
import vop;

public final class TVKPreloader$4
  implements Runnable
{
  public TVKPreloader$4(voo paramvoo) {}
  
  public void run()
  {
    Iterator localIterator = voi.a().iterator();
    while (localIterator.hasNext()) {
      ((vop)localIterator.next()).c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.4
 * JD-Core Version:    0.7.0.1
 */