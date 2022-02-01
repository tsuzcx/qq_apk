package com.tencent.gamecenter.wadl.api.impl;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.gamecenter.wadl.util.WLog;
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
      if (QLog.isColorLevel()) {
        WLog.c("WadlProxyServiceMonitor", "stopMonitoring");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    finally {}
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    long l = (30000.0F * paramFloat);
    try
    {
      this.jdField_b_of_type_Long = l;
      if (QLog.isColorLevel()) {
        WLog.c("WadlProxyServiceMonitor", "setCheckRate rate=" + paramFloat + ",checkInterval=" + this.jdField_b_of_type_Long + ",isServiceDied=" + paramBoolean);
      }
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
    }
    for (this.jdField_b_of_type_Int = 0;; this.jdField_b_of_type_Int += 1)
    {
      if (QLog.isColorLevel()) {
        WLog.c("WadlProxyServiceMonitor", "onRecvHeart lastRecvReportTime=" + this.e + ",lastCheckTime=" + this.f + ",lastReportCount=" + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          WLog.c("WadlProxyServiceMonitor", "startMonitoring...");
        }
        setName("WadlProxyService.Monitor.Thread");
        start();
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        WLog.a("WadlProxyServiceMonitor", "startMonitoring exception", localThrowable);
        continue;
      }
      finally {}
      return;
      if (QLog.isColorLevel()) {
        WLog.b("WadlProxyServiceMonitor", "startMonitoring,but is running");
      }
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          Thread.sleep(this.jdField_b_of_type_Long);
          if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            break label99;
          }
          long l = SystemClock.elapsedRealtime();
          if ((this.e == 0L) || (l - this.e > 60000L))
          {
            if (QLog.isColorLevel()) {
              WLog.c("WadlProxyServiceMonitor", "MonitorWorkingThread startWadlService");
            }
            this.jdField_a_of_type_ComTencentGamecenterWadlApiImplWadlProxyServiceManager.a(1);
          }
        }
        else
        {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        WLog.c("WadlProxyServiceMonitor", "MonitorWorkingThread is running");
        continue;
        label99:
        if (QLog.isColorLevel()) {
          WLog.c("WadlProxyServiceMonitor", "MonitorWorkingThread not running");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */