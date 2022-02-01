package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import xiz;
import xjt;

public class SimpleDataProvider$5
  implements Runnable
{
  public SimpleDataProvider$5(xjt paramxjt) {}
  
  public void run()
  {
    Iterator localIterator = xjt.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((xiz)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5
 * JD-Core Version:    0.7.0.1
 */