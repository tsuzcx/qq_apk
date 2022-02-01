package com.tencent.featuretoggle.hltxkg.common.a;

import java.util.concurrent.CountDownLatch;

final class m
  implements Runnable
{
  m(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      this.a[0] = l.b();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.m
 * JD-Core Version:    0.7.0.1
 */