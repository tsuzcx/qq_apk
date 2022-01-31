package com.tencent.biz.qqstory.playvideo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tvh;
import tvn;
import tvo;

public final class TVKPreloader$5
  implements Runnable
{
  public TVKPreloader$5(tvn paramtvn) {}
  
  public void run()
  {
    Iterator localIterator = tvh.a().iterator();
    while (localIterator.hasNext()) {
      ((tvo)localIterator.next()).c(this.a);
    }
    tvh.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.5
 * JD-Core Version:    0.7.0.1
 */