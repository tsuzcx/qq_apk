package com.tencent.liteav.basic.util;

import java.util.concurrent.CountDownLatch;

class e$1
  implements Runnable
{
  e$1(e parame, Runnable paramRunnable, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    this.a.run();
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.e.1
 * JD-Core Version:    0.7.0.1
 */