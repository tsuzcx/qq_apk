package com.tencent.mobileqq.app;

import android.os.SystemClock;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Job
  extends WeakReference
  implements Comparable, Runnable
{
  public static ConcurrentLinkedQueue a;
  public static ConcurrentLinkedQueue b;
  public static ConcurrentLinkedQueue c;
  public int a;
  public long a;
  public ThreadExcutor.IThreadListener a;
  public Runnable a;
  public String a;
  private boolean a;
  public int b;
  public long b;
  private boolean b;
  private int c;
  public long c;
  public long d = -1L;
  public long e = -1L;
  public long f = -1L;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    jdField_c_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  }
  
  public Job(Object paramObject, Runnable paramRunnable, boolean paramBoolean)
  {
    super(paramObject);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    if (paramObject != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  Job(Object paramObject, String paramString, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    super(paramObject);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    if (paramObject != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = paramIThreadListener;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a()
  {
    this.d = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
    JobReporter.reportJobTime(this.d);
    if (this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener.a();
    }
  }
  
  private void b()
  {
    this.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener.b();
    }
    if (this.jdField_c_of_type_Long >= 30000L) {
      c();
    }
  }
  
  private boolean b()
  {
    return (ThreadExcutor.jdField_b_of_type_Boolean) && (UnifiedMonitor.a().whetherReportThisTime(6));
  }
  
  private void c()
  {
    if ((b()) || (ThreadManager.logcatBgTaskMonitor))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("priority", "" + this.jdField_a_of_type_Int);
      UnifiedMonitor.a().addEvent(6, this.jdField_a_of_type_JavaLangString, (int)this.jdField_c_of_type_Long, this.jdField_c_of_type_Int, localHashMap);
      this.jdField_c_of_type_Int = 0;
      return;
    }
    this.jdField_c_of_type_Int += 1;
  }
  
  public int a(Job paramJob)
  {
    if (this.jdField_a_of_type_Int == paramJob.jdField_a_of_type_Int) {
      return 0;
    }
    if (this.jdField_a_of_type_Int > paramJob.jdField_a_of_type_Int) {
      return -1;
    }
    return 1;
  }
  
  public boolean a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      localObject = get();
      if (localObject == null) {}
    }
    else
    {
      try
      {
        Field localField = this.jdField_a_of_type_JavaLangRunnable.getClass().getDeclaredField("this$0");
        localField.setAccessible(true);
        localField.set(this.jdField_a_of_type_JavaLangRunnable, localObject);
        return true;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + localNoSuchFieldException + "shouldRun is false");
        }
        return false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + localIllegalArgumentException + "shouldRun is false");
        }
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + localIllegalAccessException + "shouldRun is false");
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + " never run, becuse outer object is retrieve already");
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Job)paramObject;
        if (this.jdField_a_of_type_JavaLangRunnable != null) {
          break;
        }
      } while (paramObject.jdField_a_of_type_JavaLangRunnable == null);
      return false;
    } while (this.jdField_a_of_type_JavaLangRunnable.equals(paramObject.jdField_a_of_type_JavaLangRunnable));
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaLangRunnable.hashCode()) {
      return i + 31;
    }
  }
  
  public void run()
  {
    if (a())
    {
      a();
      this.jdField_a_of_type_JavaLangRunnable.run();
      b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + " is recycled");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(" cost=").append(this.jdField_c_of_type_Long).append(", ").append(this.jdField_a_of_type_JavaLangString).append("|pool-").append(this.jdField_b_of_type_Int).append("|t-id=").append(this.jdField_a_of_type_Long).append("|priority=").append(this.jdField_a_of_type_Int).append("|wait=").append(this.d).append("|postCost=").append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.Job
 * JD-Core Version:    0.7.0.1
 */