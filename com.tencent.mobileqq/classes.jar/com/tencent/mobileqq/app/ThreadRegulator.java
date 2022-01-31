package com.tencent.mobileqq.app;

import amdr;
import amds;
import amdt;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.os.MqqRegulatorCallback;

public class ThreadRegulator
  implements MqqRegulatorCallback
{
  private static ThreadRegulator jdField_a_of_type_ComTencentMobileqqAppThreadRegulator;
  private volatile amdt jdField_a_of_type_Amdt;
  private final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(amdt.class, 2);
  Runnable jdField_a_of_type_JavaLangRunnable = new ThreadRegulator.2(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new amds(this, ThreadManager.getSubThreadLooper());
  
  public static ThreadRegulator a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppThreadRegulator == null) {
        jdField_a_of_type_ComTencentMobileqqAppThreadRegulator = new ThreadRegulator();
      }
      ThreadRegulator localThreadRegulator = jdField_a_of_type_ComTencentMobileqqAppThreadRegulator;
      return localThreadRegulator;
    }
    finally {}
  }
  
  public void a()
  {
    MqqHandler.sRegulatorCallback = this;
    mqq.app.MainService.sRegulatorCallback = this;
  }
  
  public void a(int paramInt)
  {
    if (!amdr.a().a()) {}
    while (this.jdField_a_of_type_Amdt != null) {
      return;
    }
    this.jdField_a_of_type_Amdt = ((amdt)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(amdt.class));
    this.jdField_a_of_type_Amdt.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Amdt.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    try
    {
      ThreadExcutor.getInstance().shrinkMaxPoolSize(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ThreadManager.Regulaotr", 1, "markBusyState: invoked. ", localThrowable);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      return;
    }
    BaseApplicationImpl.sUiHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amdt == null) {
      return;
    }
    while (this.jdField_a_of_type_Amdt != null) {
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  public void checkInRegulatorMsg()
  {
    b();
  }
  
  public boolean regulatorThread(Thread paramThread)
  {
    if ((paramThread == ThreadManager.getFileThread()) || (paramThread == ThreadManager.getSubThread())) {}
    do
    {
      do
      {
        return true;
        if (!"MSF-Receiver".equals(paramThread.getName())) {
          break;
        }
      } while (!amdr.a().b());
      paramThread.setPriority(1);
      return true;
    } while ("Rejected_Handler".equals(paramThread.getName()));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadRegulator
 * JD-Core Version:    0.7.0.1
 */