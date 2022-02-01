package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class SimpleDataProvider$6
  implements Runnable
{
  SimpleDataProvider$6(SimpleDataProvider paramSimpleDataProvider, IDataProvider.GroupInfo paramGroupInfo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = SimpleDataProvider.c(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IDataProvider.ICallBack)localIterator.next()).a(this.a.b, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.6
 * JD-Core Version:    0.7.0.1
 */