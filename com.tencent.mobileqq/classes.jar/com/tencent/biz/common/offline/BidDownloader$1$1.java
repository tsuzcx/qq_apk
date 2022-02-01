package com.tencent.biz.common.offline;

import nuy;

public class BidDownloader$1$1
  extends Thread
{
  public BidDownloader$1$1(nuy paramnuy) {}
  
  public void run()
  {
    if (this.a.a.b == 1) {}
    for (;;)
    {
      try
      {
        Thread.sleep(5000L);
        this.a.a.b();
        return;
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
        continue;
      }
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.1.1
 * JD-Core Version:    0.7.0.1
 */