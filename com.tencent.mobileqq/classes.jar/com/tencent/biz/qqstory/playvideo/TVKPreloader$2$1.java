package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import wmz;
import wnb;
import wnf;
import wng;

public class TVKPreloader$2$1
  implements Runnable
{
  public TVKPreloader$2$1(wnb paramwnb, wnf paramwnf) {}
  
  public void run()
  {
    Iterator localIterator = wmz.a().iterator();
    while (localIterator.hasNext()) {
      ((wng)localIterator.next()).b(this.a);
    }
    wmz.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.1
 * JD-Core Version:    0.7.0.1
 */