package com.tencent.gamecenter.wadl.api.impl;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class WadlProxyServiceMonitor
  extends Thread
  implements IWadlProxyServiceMonitor
{
  private final long a = 30000L;
  private long b = 30000L;
  private final long c = 60000L;
  private final long d = 120000L;
  private final int e = 3;
  private WadlProxyServiceManager f;
  private long g = 0L;
  private long h = 0L;
  private int i = 0;
  private volatile AtomicBoolean j = new AtomicBoolean(false);
  
  public WadlProxyServiceMonitor(WadlProxyServiceManager paramWadlProxyServiceManager)
  {
    this.f = paramWadlProxyServiceManager;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    long l = (30000.0F * paramFloat);
    try
    {
      this.b = l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCheckRate rate=");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(",checkInterval=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",isServiceDied=");
      localStringBuilder.append(paramBoolean);
      QLog.i("WadlProxyServiceMonitor", 1, localStringBuilder.toString());
      if (paramBoolean) {
        this.i = 0;
      }
      return;
    }
    finally {}
  }
  
  public void a(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    this.g = l;
    if (this.h == 0L) {
      this.h = l;
    }
    if (l - this.h > 120000L)
    {
      this.h = l;
      if (this.i >= 3) {
        this.f.a();
      }
      this.i = 0;
    }
    else
    {
      this.i += 1;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onRecvHeart lastRecvReportTime=");
    paramBundle.append(this.g);
    paramBundle.append(",lastCheckTime=");
    paramBundle.append(this.h);
    paramBundle.append(",lastReportCount=");
    paramBundle.append(this.i);
    QLog.i("WadlProxyServiceMonitor", 1, paramBundle.toString());
  }
  
  public boolean a()
  {
    return this.j.get();
  }
  
  public void b()
  {
    try
    {
      QLog.i("WadlProxyServiceMonitor", 1, "stopMonitoring");
      this.j.set(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceMonitor:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: invokevirtual 127	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   10: ifne +24 -> 34
    //   13: ldc 83
    //   15: iconst_1
    //   16: ldc 129
    //   18: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: ldc 131
    //   24: invokevirtual 135	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceMonitor:setName	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokevirtual 138	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceMonitor:start	()V
    //   31: goto +28 -> 59
    //   34: ldc 83
    //   36: iconst_1
    //   37: ldc 140
    //   39: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: goto +17 -> 59
    //   45: astore_1
    //   46: goto +16 -> 62
    //   49: astore_1
    //   50: ldc 83
    //   52: iconst_1
    //   53: ldc 145
    //   55: aload_1
    //   56: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WadlProxyServiceMonitor
    //   45	1	1	localObject	Object
    //   49	16	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	31	45	finally
    //   34	42	45	finally
    //   50	59	45	finally
    //   2	31	49	java/lang/Throwable
    //   34	42	49	java/lang/Throwable
  }
  
  public void run()
  {
    try
    {
      while (this.j.get())
      {
        Thread.sleep(this.b);
        boolean bool = this.j.get();
        if (bool)
        {
          long l = SystemClock.elapsedRealtime();
          if ((this.g != 0L) && (l - this.g <= 60000L))
          {
            QLog.i("WadlProxyServiceMonitor", 1, "MonitorWorkingThread is running");
          }
          else
          {
            QLog.i("WadlProxyServiceMonitor", 1, "MonitorWorkingThread startWadlService");
            this.f.a(1);
          }
        }
        else
        {
          QLog.i("WadlProxyServiceMonitor", 1, "MonitorWorkingThread not running");
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */