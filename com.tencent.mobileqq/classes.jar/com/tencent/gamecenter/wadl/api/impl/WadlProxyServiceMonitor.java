package com.tencent.gamecenter.wadl.api.impl;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class WadlProxyServiceMonitor
  extends Thread
  implements IWadlProxyServiceMonitor
{
  private final int jdField_a_of_type_Int = 3;
  private final long jdField_a_of_type_Long = 30000L;
  private WadlProxyServiceManager jdField_a_of_type_ComTencentGamecenterWadlApiImplWadlProxyServiceManager;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 30000L;
  private final long c = 60000L;
  private final long d = 120000L;
  private long e = 0L;
  private long f = 0L;
  
  public WadlProxyServiceMonitor(WadlProxyServiceManager paramWadlProxyServiceManager)
  {
    this.jdField_a_of_type_ComTencentGamecenterWadlApiImplWadlProxyServiceManager = paramWadlProxyServiceManager;
  }
  
  public void a()
  {
    try
    {
      QLog.i("WadlProxyServiceMonitor", 1, "stopMonitoring");
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    long l = (30000.0F * paramFloat);
    try
    {
      this.jdField_b_of_type_Long = l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCheckRate rate=");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(",checkInterval=");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append(",isServiceDied=");
      localStringBuilder.append(paramBoolean);
      QLog.i("WadlProxyServiceMonitor", 1, localStringBuilder.toString());
      if (paramBoolean) {
        this.jdField_b_of_type_Int = 0;
      }
      return;
    }
    finally {}
  }
  
  public void a(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    this.e = l;
    if (this.f == 0L) {
      this.f = l;
    }
    if (l - this.f > 120000L)
    {
      this.f = l;
      if (this.jdField_b_of_type_Int >= 3) {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiImplWadlProxyServiceManager.a();
      }
      this.jdField_b_of_type_Int = 0;
    }
    else
    {
      this.jdField_b_of_type_Int += 1;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onRecvHeart lastRecvReportTime=");
    paramBundle.append(this.e);
    paramBundle.append(",lastCheckTime=");
    paramBundle.append(this.f);
    paramBundle.append(",lastReportCount=");
    paramBundle.append(this.jdField_b_of_type_Int);
    QLog.i("WadlProxyServiceMonitor", 1, paramBundle.toString());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceMonitor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: invokevirtual 124	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   10: ifne +24 -> 34
    //   13: ldc 55
    //   15: iconst_1
    //   16: ldc 126
    //   18: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: ldc 128
    //   24: invokevirtual 132	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceMonitor:setName	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokevirtual 135	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceMonitor:start	()V
    //   31: goto +28 -> 59
    //   34: ldc 55
    //   36: iconst_1
    //   37: ldc 137
    //   39: invokestatic 140	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: goto +17 -> 59
    //   45: astore_1
    //   46: goto +16 -> 62
    //   49: astore_1
    //   50: ldc 55
    //   52: iconst_1
    //   53: ldc 142
    //   55: aload_1
    //   56: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
      while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        Thread.sleep(this.jdField_b_of_type_Long);
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
        if (bool)
        {
          long l = SystemClock.elapsedRealtime();
          if ((this.e != 0L) && (l - this.e <= 60000L))
          {
            QLog.i("WadlProxyServiceMonitor", 1, "MonitorWorkingThread is running");
          }
          else
          {
            QLog.i("WadlProxyServiceMonitor", 1, "MonitorWorkingThread startWadlService");
            this.jdField_a_of_type_ComTencentGamecenterWadlApiImplWadlProxyServiceManager.a(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */