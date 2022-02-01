package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class SimpleDataProvider$5
  implements Runnable
{
  SimpleDataProvider$5(SimpleDataProvider paramSimpleDataProvider) {}
  
  public void run()
  {
    Iterator localIterator = SimpleDataProvider.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IDataProvider.ICallBack)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5
 * JD-Core Version:    0.7.0.1
 */