package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.concurrent.atomic.AtomicInteger;
import vlz;
import wsv;

public class SimpleDataProvider$4
  implements Runnable
{
  public SimpleDataProvider$4(vlz paramvlz) {}
  
  public void run()
  {
    int i = vlz.a(this.this$0).getAndSet(1);
    if (i > 1)
    {
      wsv.a("Q.qqstory.player.data.SimpleDataProvider", "post result combine count:%d", Integer.valueOf(i));
      vlz.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4
 * JD-Core Version:    0.7.0.1
 */