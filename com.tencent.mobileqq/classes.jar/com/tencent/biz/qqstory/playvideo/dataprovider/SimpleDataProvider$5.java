package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import xda;
import xdu;

public class SimpleDataProvider$5
  implements Runnable
{
  public SimpleDataProvider$5(xdu paramxdu) {}
  
  public void run()
  {
    Iterator localIterator = xdu.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((xda)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5
 * JD-Core Version:    0.7.0.1
 */