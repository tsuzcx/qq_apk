package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManagerV2
{
  public static final String AUTO_MONITOR_TAG = "AutoMonitor";
  protected static HandlerThread FILE_THREAD;
  protected static volatile Handler FILE_THREAD_HANDLER;
  public static volatile boolean IsRunTimeShutDown = false;
  public static final boolean OLD_BUSINESS_AUTO_RETRIEVE = false;
  public static boolean OPEN_RDM_REPORT = true;
  protected static HandlerThread RECENT_THREAD;
  protected static Handler RECENT_THREAD_HANDLER;
  private static final String REPORT_AP_REJECTION_EXCEPTION = "ap_reject_exception_report";
  protected static final String REPORT_SP_REJECTION_EXCEPTION = "sp_reject_exception_report";
  protected static HandlerThread SUB_THREAD;
  protected static volatile Handler SUB_THREAD_HANDLER;
  public static final String TAG = "ThreadManager";
  private static Timer TIMER;
  protected static volatile Handler UI_HANDLER;
  private static Executor mNetExcutorPool = new ThreadPoolExecutor(5, 9, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new ThreadManagerV2.3());
  public static ThreadWrapContext sThreadWrapContext;
  
  static
  {
    initRuntimShutDownHook();
    reflectAsyncTaskPool();
  }
  
  public static void excute(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if ((paramInt & 0xF0) == 0) {
      if (!ThreadSetting.isPublicVersion)
      {
        ThreadLog.trackException("ThreadManager", "ThreadManager.excute type is not valid");
      }
      else
      {
        paramIThreadListener = sThreadWrapContext;
        if (paramIThreadListener != null) {
          paramIThreadListener.reportRDMException(new TSPInvalidArgsCatchedException("ThreadManager_excute_Type_NONE"), "ThreadManager_excute_Type_NONE", paramRunnable.getClass().getName());
        }
        return;
      }
    }
    ThreadExcutor.getInstance().excute(paramRunnable, paramInt, paramIThreadListener, paramBoolean);
  }
  
  public static void executeOnFileThread(Runnable paramRunnable)
  {
    getFileThreadHandlerV2().post(paramRunnable);
  }
  
  public static void executeOnNetWorkThread(Runnable paramRunnable)
  {
    excute(paramRunnable, 128, null, false);
  }
  
  public static void executeOnSubThread(Runnable paramRunnable)
  {
    getSubThreadHandlerV2().post(paramRunnable);
  }
  
  public static void executeOnSubThread(Runnable paramRunnable, boolean paramBoolean)
  {
    getSubThreadHandlerV2().post(paramRunnable);
  }
  
  public static Thread getFileThread()
  {
    if (FILE_THREAD == null) {
      getFileThreadHandlerV2();
    }
    return FILE_THREAD;
  }
  
  private static Handler getFileThreadHandlerV2()
  {
    if (FILE_THREAD_HANDLER == null) {
      try
      {
        if (FILE_THREAD_HANDLER == null)
        {
          FILE_THREAD = newFreeHandlerThread("QQ_FILE_RW", 0);
          FILE_THREAD.start();
          FILE_THREAD_HANDLER = new Handler(FILE_THREAD.getLooper());
        }
      }
      finally {}
    }
    return FILE_THREAD_HANDLER;
  }
  
  public static Looper getFileThreadLooper()
  {
    return getFileThreadHandlerV2().getLooper();
  }
  
  public static Executor getNetExcutor()
  {
    return mNetExcutorPool;
  }
  
  public static Thread getRecentThread()
  {
    if (RECENT_THREAD == null) {
      getRecentThreadLooper();
    }
    return RECENT_THREAD;
  }
  
  public static Looper getRecentThreadLooper()
  {
    if (RECENT_THREAD_HANDLER == null) {
      try
      {
        if (RECENT_THREAD_HANDLER == null)
        {
          RECENT_THREAD = newFreeHandlerThread("Recent_Handler", 0);
          RECENT_THREAD.start();
          RECENT_THREAD_HANDLER = new Handler(RECENT_THREAD.getLooper());
        }
      }
      finally {}
    }
    return RECENT_THREAD_HANDLER.getLooper();
  }
  
  public static Thread getSubThread()
  {
    if (SUB_THREAD == null) {
      getSubThreadHandlerV2();
    }
    return SUB_THREAD;
  }
  
  private static Handler getSubThreadHandlerV2()
  {
    if (SUB_THREAD_HANDLER == null) {
      try
      {
        if (SUB_THREAD_HANDLER == null)
        {
          SUB_THREAD = newFreeHandlerThread("QQ_SUB", 0);
          SUB_THREAD.start();
          SUB_THREAD_HANDLER = new Handler(SUB_THREAD.getLooper());
        }
      }
      finally {}
    }
    return SUB_THREAD_HANDLER;
  }
  
  public static Looper getSubThreadLooper()
  {
    return getSubThreadHandlerV2().getLooper();
  }
  
  public static Timer getTimer()
  {
    if (TIMER == null) {
      try
      {
        TIMER = new ThreadManagerV2.4("QQ_Timer");
      }
      finally {}
    }
    return TIMER;
  }
  
  public static Handler getUIHandlerV2()
  {
    if (UI_HANDLER == null) {
      try
      {
        if (UI_HANDLER == null) {
          UI_HANDLER = new Handler(Looper.getMainLooper());
        }
      }
      finally {}
    }
    return UI_HANDLER;
  }
  
  public static void init()
  {
    ThreadLog.printQLog("ThreadManager", "ThreadManager init");
    ThreadExcutor.getInstance();
  }
  
  private static void initRuntimShutDownHook()
  {
    Runtime.getRuntime().addShutdownHook(new ThreadManagerV2.1());
  }
  
  public static HandlerThread newFreeHandlerThread(String paramString, int paramInt)
  {
    HandlerThread localHandlerThread = ThreadExcutor.getInstance().newFreeHandlerThread(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localHandlerThread.getId());
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    ThreadLog.printQLog("ThreadManager", localStringBuilder.toString());
    return localHandlerThread;
  }
  
  public static Thread newFreeThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    paramRunnable = ThreadExcutor.getInstance().newFreeThread(paramRunnable, paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRunnable.getId());
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    ThreadLog.printQLog("ThreadManager", localStringBuilder.toString());
    return paramRunnable;
  }
  
  public static Executor newFreeThreadPool(ThreadPoolParams paramThreadPoolParams)
  {
    if ((!ThreadSetting.isPublicVersion) && ((paramThreadPoolParams == null) || (TextUtils.isEmpty(paramThreadPoolParams.poolThreadName)) || ("default_name".equals(paramThreadPoolParams.poolThreadName)))) {
      throw new RuntimeException("newFreeThreadPool exception");
    }
    return ThreadExcutor.getInstance().newFreeThreadPool(paramThreadPoolParams);
  }
  
  public static Executor newSerialExecutor()
  {
    return Executors.newSingleThreadExecutor(new ThreadManagerV2.2());
  }
  
  @Deprecated
  public static void post(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.getInstance().post(paramInt, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  @Deprecated
  public static void postDownLoadTask(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.getInstance().postDownLoadTask(paramInt, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  @Deprecated
  public static void postImmediately(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.getInstance().postImmediately(paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  @TargetApi(11)
  private static void reflectAsyncTaskPool()
  {
    try
    {
      Object localObject1 = ThreadAsyncTaskPool.createThreadPool();
      ((ThreadSmartPool)localObject1).allowCoreThreadTimeOut(true);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reflectAsyncTaskPool before:");
      ((StringBuilder)localObject2).append(AsyncTask.THREAD_POOL_EXECUTOR);
      ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject2).toString());
      localObject2 = AsyncTask.class.getDeclaredField("THREAD_POOL_EXECUTOR");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(null, localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reflectAsyncTaskPool after:");
      ((StringBuilder)localObject1).append(AsyncTask.THREAD_POOL_EXECUTOR);
      ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject1).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      ThreadLog.printQLog("ThreadManager", "reflectAsyncTaskPool", localThrowable);
    }
  }
  
  @Deprecated
  public static boolean remove(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Remove_Use_Deprecated_Method ");
    localStringBuilder.append(paramRunnable.getClass().getName());
    ThreadLog.printQLog("ThreadManager", localStringBuilder.toString());
    return false;
  }
  
  public static boolean removeJobFromThreadPool(Runnable paramRunnable, int paramInt)
  {
    return ThreadExcutor.getInstance().removeJobFromThreadPool(paramRunnable, paramInt);
  }
  
  public static String reportCurrentState()
  {
    return ThreadExcutor.getInstance().printCurrentState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerV2
 * JD-Core Version:    0.7.0.1
 */