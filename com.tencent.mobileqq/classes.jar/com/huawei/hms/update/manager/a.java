package com.huawei.hms.update.manager;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static boolean a = false;
  private CountDownLatch b;
  
  public boolean a(long paramLong, TimeUnit paramTimeUnit, String paramString)
  {
    if (a)
    {
      HMSLog.i("PingTask", "ping google return cache");
      return true;
    }
    HMSLog.i("PingTask", "start ping goole");
    this.b = new CountDownLatch(1);
    new a.a(this, paramString).execute(new Context[0]);
    try
    {
      if (!this.b.await(paramLong, paramTimeUnit))
      {
        HMSLog.i("PingTask", "await time out");
        return false;
      }
      HMSLog.i("PingTask", "await:isReachable:" + a);
      boolean bool = a;
      return bool;
    }
    catch (InterruptedException paramTimeUnit)
    {
      HMSLog.e("PingTask", "await:InterruptedException:");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.manager.a
 * JD-Core Version:    0.7.0.1
 */