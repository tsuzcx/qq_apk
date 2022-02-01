package com.tencent.mobileqq.app.automator;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.widget.TraceUtils;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AsyncStep
  implements Runnable
{
  protected volatile int a;
  private long jdField_a_of_type_Long = 0L;
  public Automator a;
  public IResultListener a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public Object[] a;
  public int b;
  protected long b;
  protected int c = 0;
  
  public AsyncStep()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Long = 30000L;
    this.jdField_b_of_type_Int = -1;
  }
  
  private boolean a()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = this.jdField_a_of_type_Int;
        if (i != 2) {}
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(this.jdField_b_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + " waitResult " + this.jdField_a_of_type_Int + " " + this.c);
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          this.jdField_a_of_type_Int = 2;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          localInterruptedException2.printStackTrace();
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_Int = 5;
          Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
          localAutomator.jdField_b_of_type_Int += 1;
        }
        if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 5))
        {
          i = this.c;
          this.c = (i - 1);
          if (i > 0)
          {
            this.jdField_a_of_type_Int = 1;
            return true;
          }
        }
        if ((DeviceOptSwitch.d) && (!DeviceOptSwitch.b.contains(Integer.valueOf(this.jdField_b_of_type_Int))))
        {
          long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, new Object[] { "asyncstep runtime = ", Long.valueOf(l) });
          }
          if (l < 1500L) {
            try
            {
              Thread.sleep(1500L - l);
              return false;
            }
            catch (InterruptedException localInterruptedException1) {}
          }
        }
      }
    }
    return false;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + " AsyncStep.doStep()");
    }
    return 7;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + " setResult " + paramInt + ", when " + this.jdField_a_of_type_Int);
    }
    if (paramInt == 6)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
      ((Automator)???).jdField_b_of_type_Int += 1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramInt > this.jdField_a_of_type_Int) && (paramInt != 4)) {
        this.jdField_a_of_type_Int = paramInt;
      }
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(64);
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)???).append(" updateTimeout ");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append(", when ");
      ((StringBuilder)???).append(this.jdField_a_of_type_Int);
      QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_Int = 3;
      }
      this.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public final void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      TraceUtils.asyncTraceBegin(4096L, this.jdField_a_of_type_JavaLangString, Process.myTid());
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 1, this.jdField_a_of_type_JavaLangString + " begin with " + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    try
    {
      b();
      do
      {
        a(a());
      } while (a());
      c();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 1, this.jdField_a_of_type_JavaLangString + " cost: " + (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long));
      }
    }
    catch (Throwable localThrowable1)
    {
      label250:
      QLog.e("QQInitHandler", 1, "", localThrowable1);
      a(8);
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 1, this.jdField_a_of_type_JavaLangString + " cost: " + (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long));
      }
      try
      {
        if (((this instanceof ActiveAccount)) || ((this instanceof LoginWelcomeRequest)) || ((this instanceof UpdateFriend)) || ((this instanceof UpdateTroop)) || ((this instanceof UpdateDiscuss)) || ((this instanceof CheckPublicAccount)) || ((this instanceof GetSubAccount)) || ((this instanceof InitBeforeSyncMsg)) || ((this instanceof RegisterPush)) || ("{4,3,5,6}".equals(this.jdField_a_of_type_JavaLangString)) || ("[11,12,14]".equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long));
        }
      }
      catch (Throwable localThrowable4)
      {
        break label653;
      }
      TraceUtils.asyncTraceEnd(4096L, this.jdField_a_of_type_JavaLangString, Process.myTid());
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener.a(this, this.jdField_a_of_type_Int);
      }
    }
    try
    {
      if (((this instanceof ActiveAccount)) || ((this instanceof LoginWelcomeRequest)) || ((this instanceof UpdateFriend)) || ((this instanceof UpdateTroop)) || ((this instanceof UpdateDiscuss)) || ((this instanceof CheckPublicAccount)) || ((this instanceof GetSubAccount)) || ((this instanceof InitBeforeSyncMsg)) || ((this instanceof RegisterPush)) || ("{4,3,5,6}".equals(this.jdField_a_of_type_JavaLangString)) || ("[11,12,14]".equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long));
      }
    }
    catch (Throwable localThrowable3)
    {
      break label250;
    }
    TraceUtils.asyncTraceEnd(4096L, this.jdField_a_of_type_JavaLangString, Process.myTid());
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener.a(this, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.AsyncStep
 * JD-Core Version:    0.7.0.1
 */