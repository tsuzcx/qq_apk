package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.concurrent.atomic.AtomicInteger;
import xjt;
import yqp;

public class SimpleDataProvider$4
  implements Runnable
{
  public SimpleDataProvider$4(xjt paramxjt) {}
  
  public void run()
  {
    int i = xjt.a(this.this$0).getAndSet(1);
    if (i > 1)
    {
      yqp.a("Q.qqstory.player.data.SimpleDataProvider", "post result combine count:%d", Integer.valueOf(i));
      xjt.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4
 * JD-Core Version:    0.7.0.1
 */