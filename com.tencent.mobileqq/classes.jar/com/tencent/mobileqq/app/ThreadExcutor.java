package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import mqq.os.MqqHandler;
import zgp;
import zkf;
import zkg;
import zkh;
import zki;
import zkj;
import zkk;
import zkt;

public class ThreadExcutor
{
  public static int a;
  private static final ThreadExcutor jdField_a_of_type_ComTencentMobileqqAppThreadExcutor = new ThreadExcutor();
  private static volatile MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public static boolean a;
  public static boolean b;
  private zgp jdField_a_of_type_Zgp = new zgp("GlobalPool-Light", 5);
  private zkt jdField_a_of_type_Zkt;
  private zgp jdField_b_of_type_Zgp = new zgp("GlobalPool-Heavy", 2);
  private zkt jdField_b_of_type_Zkt;
  private zgp jdField_c_of_type_Zgp = new zgp("GlobalPool-Download", 2);
  private zkt jdField_c_of_type_Zkt;
  
  static
  {
    jdField_a_of_type_Int = 1000;
  }
  
  private ThreadExcutor()
  {
    ThreadManager.IsRunTimeShutDown = false;
    if (QLog.isColorLevel()) {
      QLog.i("ThreadManager", 2, "ThreadExcutor singleton construct");
    }
    b();
    a();
  }
  
  private Job a(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    localObject1 = paramRunnable.getClass();
    String str = ((Class)localObject1).getName();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject2 = ((Class)localObject1).getDeclaredField("this$0");
        ((Field)localObject2).setAccessible(true);
        localObject1 = ((Field)localObject2).get(paramRunnable);
        localObject1 = localObject2;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        for (;;)
        {
          try
          {
            ((Field)localObject2).set(paramRunnable, null);
          }
          catch (IllegalAccessException localIllegalAccessException2)
          {
            localObject2 = localObject1;
            continue;
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            localObject2 = localObject1;
            continue;
          }
          catch (NoSuchFieldException localNoSuchFieldException2)
          {
            Object localObject2 = localObject1;
            continue;
          }
          try
          {
            paramIThreadListener = new Job(localObject1, str, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
            return paramIThreadListener;
          }
          catch (OutOfMemoryError paramIThreadListener)
          {
            QLog.e("ThreadManager", 1, "buildJob " + paramRunnable, paramIThreadListener);
            return null;
          }
        }
        localNoSuchFieldException1 = localNoSuchFieldException1;
        localObject2 = null;
        localObject1 = localObject2;
        if (!ThreadManager.logcatBgTaskMonitor) {
          continue;
        }
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ThreadManager", 2, "NoSuchFieldException", localNoSuchFieldException1);
        localObject1 = localObject2;
        continue;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (!ThreadManager.logcatBgTaskMonitor) {
          continue;
        }
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ThreadManager", 2, "IllegalArgumentException", localIllegalArgumentException1);
        localObject1 = localObject2;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        localObject2 = null;
      }
      if (ThreadManager.logcatBgTaskMonitor)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("ThreadManager", 2, "IllegalAccessException", localIllegalAccessException1);
          localObject1 = localObject2;
          continue;
          localObject1 = null;
        }
      }
    }
  }
  
  private Job a(Runnable paramRunnable)
  {
    return a(0, paramRunnable, null, false);
  }
  
  public static ThreadExcutor a()
  {
    try
    {
      ThreadExcutor localThreadExcutor = jdField_a_of_type_ComTencentMobileqqAppThreadExcutor;
      return localThreadExcutor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private StringBuilder a(String paramString)
  {
    QLog.e("ThreadManager", 1, "\ngetAllPoolRunningJob from: " + paramString);
    paramString = new StringBuilder();
    paramString.append("\n----RunningJobInHeavy------");
    a(paramString, Job.a);
    paramString.append("\n----RunningJobInDownload------");
    a(paramString, Job.b);
    paramString.append("\n----RunningJobInLight------");
    a(paramString, Job.c);
    return paramString;
  }
  
  private StringBuilder a(StringBuilder paramStringBuilder, ConcurrentLinkedQueue paramConcurrentLinkedQueue)
  {
    if (paramConcurrentLinkedQueue != null)
    {
      paramConcurrentLinkedQueue = paramConcurrentLinkedQueue.iterator();
      while (paramConcurrentLinkedQueue.hasNext())
      {
        String str = (String)paramConcurrentLinkedQueue.next();
        paramStringBuilder.append("\nRunning_Job: " + str);
      }
    }
    return paramStringBuilder;
  }
  
  private MqqHandler a()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null)
    {
      HandlerThread localHandlerThread = a("QQ_DISPATCHER", 0);
      localHandlerThread.start();
      jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      if ((QLog.isColorLevel()) && (ThreadManager.logcatBgTaskMonitor)) {
        jdField_a_of_type_MqqOsMqqHandler.getLooper().setMessageLogging(new zkk(4, "QQ_DISPATCHER"));
      }
    }
    return jdField_a_of_type_MqqOsMqqHandler;
  }
  
  @TargetApi(9)
  private void b()
  {
    if (this.jdField_a_of_type_Zkt == null) {
      this.jdField_a_of_type_Zkt = new zkj(new SynchronousQueue(true), this.jdField_a_of_type_Zgp);
    }
    if (this.jdField_b_of_type_Zkt == null)
    {
      this.jdField_b_of_type_Zkt = new zki(new LinkedBlockingQueue(15), this.jdField_b_of_type_Zgp);
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_b_of_type_Zkt.allowCoreThreadTimeOut(true);
      }
    }
    if (this.jdField_c_of_type_Zkt == null)
    {
      this.jdField_c_of_type_Zkt = new zkf(new LinkedBlockingQueue(128), this.jdField_c_of_type_Zgp);
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_c_of_type_Zkt.allowCoreThreadTimeOut(true);
      }
    }
  }
  
  public HandlerThread a(String paramString, int paramInt)
  {
    return new HandlerThread(paramString, paramInt);
  }
  
  String a()
  {
    StringBuilder localStringBuilder = a("DebugActivity");
    localStringBuilder.append("\n").append(this.jdField_a_of_type_Zkt.toString());
    localStringBuilder.append("\n").append(this.jdField_b_of_type_Zkt.toString());
    localStringBuilder.append("\n").append(this.jdField_c_of_type_Zkt.toString());
    return localStringBuilder.toString();
  }
  
  Thread a(Runnable paramRunnable, String paramString, int paramInt)
  {
    paramRunnable = new Thread(paramRunnable, paramString);
    paramRunnable.setPriority(paramInt);
    return paramRunnable;
  }
  
  @TargetApi(9)
  Executor a(ThreadPoolParams paramThreadPoolParams)
  {
    ThreadPoolParams localThreadPoolParams = paramThreadPoolParams;
    if (paramThreadPoolParams == null) {
      localThreadPoolParams = new ThreadPoolParams();
    }
    paramThreadPoolParams = new zgp(localThreadPoolParams.jdField_a_of_type_JavaLangString, localThreadPoolParams.jdField_a_of_type_Int);
    paramThreadPoolParams = new zkt(localThreadPoolParams.b, localThreadPoolParams.c, localThreadPoolParams.d, localThreadPoolParams.jdField_a_of_type_JavaUtilConcurrentBlockingQueue, paramThreadPoolParams);
    if (Build.VERSION.SDK_INT > 8) {
      paramThreadPoolParams.allowCoreThreadTimeOut(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager", 2, "newFreeThreadPool " + localThreadPoolParams.jdField_a_of_type_JavaLangString);
    }
    return paramThreadPoolParams;
  }
  
  void a() {}
  
  void a(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException();
    }
    paramRunnable = new zkg(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
    jdField_a_of_type_MqqOsMqqHandler.postAtFrontOfQueue(paramRunnable);
  }
  
  void a(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    a(10, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Zkt.setMaximumPoolSize(Math.max(this.jdField_b_of_type_Zkt.getActiveCount(), this.jdField_b_of_type_Zkt.getCorePoolSize()));
      this.jdField_c_of_type_Zkt.setMaximumPoolSize(Math.max(this.jdField_c_of_type_Zkt.getActiveCount(), this.jdField_c_of_type_Zkt.getCorePoolSize()));
      return;
    }
    this.jdField_b_of_type_Zkt.setMaximumPoolSize(this.jdField_b_of_type_Zkt.a());
    this.jdField_c_of_type_Zkt.setMaximumPoolSize(this.jdField_c_of_type_Zkt.a());
  }
  
  boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException();
    }
    try
    {
      Job localJob = a(paramRunnable);
      if (localJob == null)
      {
        QLog.e("ThreadManager", 1, "remove 3:w == null" + paramRunnable);
        return false;
      }
      boolean bool = this.jdField_b_of_type_Zkt.remove(localJob);
      return bool;
    }
    catch (Exception paramRunnable)
    {
      QLog.d("ThreadManager", 2, "remove task error happen!");
    }
    return false;
  }
  
  void b(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException();
    }
    paramRunnable = new zkh(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
    jdField_a_of_type_MqqOsMqqHandler.postAtFrontOfQueue(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor
 * JD-Core Version:    0.7.0.1
 */