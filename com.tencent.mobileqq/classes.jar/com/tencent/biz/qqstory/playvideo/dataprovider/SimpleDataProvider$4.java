package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.concurrent.atomic.AtomicInteger;
import xno;
import yuk;

public class SimpleDataProvider$4
  implements Runnable
{
  public SimpleDataProvider$4(xno paramxno) {}
  
  public void run()
  {
    int i = xno.a(this.this$0).getAndSet(1);
    if (i > 1)
    {
      yuk.a("Q.qqstory.player.data.SimpleDataProvider", "post result combine count:%d", Integer.valueOf(i));
      xno.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4
 * JD-Core Version:    0.7.0.1
 */