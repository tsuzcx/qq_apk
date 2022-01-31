package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import vpo;
import vqi;

public class SimpleDataProvider$5
  implements Runnable
{
  public SimpleDataProvider$5(vqi paramvqi) {}
  
  public void run()
  {
    Iterator localIterator = vqi.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((vpo)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5
 * JD-Core Version:    0.7.0.1
 */