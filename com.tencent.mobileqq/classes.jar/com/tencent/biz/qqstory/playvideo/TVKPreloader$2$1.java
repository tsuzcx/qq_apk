package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tvh;
import tvj;
import tvn;
import tvo;

public class TVKPreloader$2$1
  implements Runnable
{
  public TVKPreloader$2$1(tvj paramtvj, tvn paramtvn) {}
  
  public void run()
  {
    Iterator localIterator = tvh.a().iterator();
    while (localIterator.hasNext()) {
      ((tvo)localIterator.next()).b(this.a);
    }
    tvh.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2.1
 * JD-Core Version:    0.7.0.1
 */