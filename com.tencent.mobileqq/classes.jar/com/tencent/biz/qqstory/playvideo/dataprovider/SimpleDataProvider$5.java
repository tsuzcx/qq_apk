package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import twn;
import txh;

public class SimpleDataProvider$5
  implements Runnable
{
  public SimpleDataProvider$5(txh paramtxh) {}
  
  public void run()
  {
    Iterator localIterator = txh.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((twn)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5
 * JD-Core Version:    0.7.0.1
 */