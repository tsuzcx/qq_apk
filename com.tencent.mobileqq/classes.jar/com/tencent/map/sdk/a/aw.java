package com.tencent.map.sdk.a;

import java.util.concurrent.CountDownLatch;

final class aw
  implements Runnable
{
  aw(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      this.a[0] = av.b();
      this.b.countDown();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.aw
 * JD-Core Version:    0.7.0.1
 */