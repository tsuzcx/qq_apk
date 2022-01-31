package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;
import znr;
import zns;
import znt;
import znu;
import znv;
import znw;

public class ThreadManager
{
  public static final String AUTO_MONITOR_TAG = "AutoMonitor";
  private static HandlerThread FILE_THREAD;
  private static volatile MqqHandler FILE_THREAD_HANDLER;
  public static volatile boolean IsRunTimeShutDown = false;
  public static final boolean OLD_BUSINESS_AUTO_RETRIEVE = false;
  public static boolean OPEN_RDM_REPORT = false;
  private static HandlerThread RECENT_THREAD;
  private static Handler RECENT_THREAD_HANDLER;
  private static final String REPORT_AP_REJECTION_EXCEPTION = "ap_reject_exception_report";
  protected static final String REPORT_SP_REJECTION_EXCEPTION = "sp_reject_exception_report";
  private static HandlerThread SUB_THREAD;
  private static volatile MqqHandler SUB_THREAD_HANDLER;
  public static final String TAG = "ThreadManager";
  private static Timer TIMER;
  private static volatile MqqHandler UI_HANDLER;
  public static boolean logcatBgTaskMonitor;
  private static Executor mNetExcutorPool = new ThreadPoolExecutor(5, 9, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new znv());
  
  static
  {
    initRuntimShutDownHook();
    reflectAsyncTaskPool();
  }
  
  public static void executeOnFileThread(Runnable paramRunnable)
  {
    getFileThreadHandler().post(paramRunnable);
  }
  
  public static void executeOnNetWorkThread(Runnable paramRunnable)
  {
    post(paramRunnable, 5, null, false);
  }
  
  public static void executeOnSubThread(Runnable paramRunnable)
  {
    getSubThreadHandler().post(paramRunnable);
  }
  
  public static void executeOnSubThread(Runnable paramRunnable, boolean paramBoolean)
  {
    getSubThreadHandler().post(paramRunnable);
  }
  
  public static Thread getFileThread()
  {
    if (FILE_THREAD == null) {
      getFileThreadHandler();
    }
    return FILE_THREAD;
  }
  
  public static MqqHandler getFileThreadHandler()
  {
    if (FILE_THREAD_HANDLER == null) {}
    try
    {
      if (FILE_THREAD_HANDLER == null)
      {
        FILE_THREAD = newFreeHandlerThread("QQ_FILE_RW", 0);
        FILE_THREAD.start();
        FILE_THREAD_HANDLER = new zns(FILE_THREAD.getLooper());
      }
      return FILE_THREAD_HANDLER;
    }
    finally {}
  }
  
  public static Looper getFileThreadLooper()
  {
    return getFileThreadHandler().getLooper();
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
    if (RECENT_THREAD_HANDLER == null) {}
    try
    {
      RECENT_THREAD = newFreeHandlerThread("Recent_Handler", 0);
      RECENT_THREAD.start();
      RECENT_THREAD_HANDLER = new Handler(RECENT_THREAD.getLooper());
      return RECENT_THREAD_HANDLER.getLooper();
    }
    finally {}
  }
  
  public static Thread getSubThread()
  {
    if (SUB_THREAD == null) {
      getSubThreadHandler();
    }
    return SUB_THREAD;
  }
  
  public static MqqHandler getSubThreadHandler()
  {
    if (SUB_THREAD_HANDLER == null) {}
    try
    {
      if (SUB_THREAD_HANDLER == null)
      {
        SUB_THREAD = newFreeHandlerThread("QQ_SUB", 0);
        SUB_THREAD.start();
        SUB_THREAD_HANDLER = new znt(SUB_THREAD.getLooper());
      }
      return SUB_THREAD_HANDLER;
    }
    finally {}
  }
  
  public static Looper getSubThreadLooper()
  {
    return getSubThreadHandler().getLooper();
  }
  
  public static Timer getTimer()
  {
    if (TIMER == null) {}
    try
    {
      TIMER = new znw("QQ_Timer");
      return TIMER;
    }
    finally {}
  }
  
  public static MqqHandler getUIHandler()
  {
    if (UI_HANDLER == null) {}
    try
    {
      if (UI_HANDLER == null) {
        UI_HANDLER = new MqqHandler(Looper.getMainLooper(), null, true);
      }
      return UI_HANDLER;
    }
    finally {}
  }
  
  public static void init()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThreadManager", 2, "ThreadManager init");
    }
    ThreadExcutor.a();
  }
  
  public static void initDPC()
  {
    ThreadExcutor.a().a();
  }
  
  private static void initRuntimShutDownHook()
  {
    Runtime.getRuntime().addShutdownHook(new znr());
  }
  
  public static HandlerThread newFreeHandlerThread(String paramString, int paramInt)
  {
    if (ThreadOptimizer.a().c()) {
      paramInt = 19;
    }
    HandlerThread localHandlerThread = ThreadExcutor.a().a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager", 2, localHandlerThread.getId() + "-" + paramString);
    }
    return localHandlerThread;
  }
  
  public static Thread newFreeThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    paramRunnable = ThreadExcutor.a().a(paramRunnable, paramString, paramInt);
    if (ThreadOptimizer.a().c()) {
      paramRunnable.setPriority(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager", 2, paramRunnable.getId() + "|" + paramString);
    }
    return paramRunnable;
  }
  
  public static Executor newFreeThreadPool(ThreadPoolParams paramThreadPoolParams)
  {
    return ThreadExcutor.a().a(paramThreadPoolParams);
  }
  
  public static Executor newSerialExecutor()
  {
    return Executors.newSingleThreadExecutor(new znu());
  }
  
  public static void post(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.a().a(paramInt, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  public static void postDownLoadTask(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.a().b(paramInt, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  public static void postImmediately(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.a().a(paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  @TargetApi(11)
  private static void reflectAsyncTaskPool()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11) {
      localObject = AsyncTask.THREAD_POOL_EXECUTOR;
    }
    for (;;)
    {
      if ((localObject instanceof ThreadPoolExecutor)) {
        ((ThreadPoolExecutor)localObject).setRejectedExecutionHandler(new ThreadManager.ShowQueueAbortPolicy());
      }
      return;
      try
      {
        localObject = AsyncTask.class.getDeclaredField("sExecutor");
        ((Field)localObject).setAccessible(true);
        localObject = (Executor)((Field)localObject).get(null);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThreadManager", 2, localException.getMessage(), localException);
        }
        ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      }
    }
  }
  
  public static boolean remove(Runnable paramRunnable)
  {
    return ThreadExcutor.a().a(paramRunnable);
  }
  
  public static String reportCurrentState()
  {
    return ThreadExcutor.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager
 * JD-Core Version:    0.7.0.1
 */