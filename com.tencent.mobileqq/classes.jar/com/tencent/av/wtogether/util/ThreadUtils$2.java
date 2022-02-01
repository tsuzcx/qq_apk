package com.tencent.av.wtogether.util;

import java.util.concurrent.CountDownLatch;

final class ThreadUtils$2
  implements ThreadUtils.BlockingOperation
{
  ThreadUtils$2(CountDownLatch paramCountDownLatch) {}
  
  public void a()
  {
    this.a.await();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.ThreadUtils.2
 * JD-Core Version:    0.7.0.1
 */