package com.tencent.liteav.basic.util;

import java.util.concurrent.CountDownLatch;

class f$1
  implements Runnable
{
  f$1(f paramf, Runnable paramRunnable, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    this.a.run();
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.f.1
 * JD-Core Version:    0.7.0.1
 */