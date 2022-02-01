package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicInteger;

class SimpleDataProvider$4
  implements Runnable
{
  SimpleDataProvider$4(SimpleDataProvider paramSimpleDataProvider) {}
  
  public void run()
  {
    int i = SimpleDataProvider.a(this.this$0).getAndSet(1);
    if (i > 1)
    {
      SLog.a("Q.qqstory.player.data.SimpleDataProvider", "post result combine count:%d", Integer.valueOf(i));
      SimpleDataProvider.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4
 * JD-Core Version:    0.7.0.1
 */