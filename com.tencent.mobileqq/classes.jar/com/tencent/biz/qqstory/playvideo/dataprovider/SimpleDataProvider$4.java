package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.concurrent.atomic.AtomicInteger;
import txk;
import veg;

public class SimpleDataProvider$4
  implements Runnable
{
  public SimpleDataProvider$4(txk paramtxk) {}
  
  public void run()
  {
    int i = txk.a(this.this$0).getAndSet(1);
    if (i > 1)
    {
      veg.a("Q.qqstory.player.data.SimpleDataProvider", "post result combine count:%d", Integer.valueOf(i));
      txk.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4
 * JD-Core Version:    0.7.0.1
 */