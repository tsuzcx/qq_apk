package com.tencent.biz.common.offline;

class BidDownloader$1$1
  extends Thread
{
  BidDownloader$1$1(BidDownloader.1 param1) {}
  
  public void run()
  {
    if (this.a.a.b == 1) {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
      }
    } else {
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
    this.a.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.1.1
 * JD-Core Version:    0.7.0.1
 */