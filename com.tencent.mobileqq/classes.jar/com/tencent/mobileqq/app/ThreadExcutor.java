package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class ThreadExcutor
{
  private static volatile Handler DISPATCHER_HANDLER;
  public static final int IS_ASYNC_POOL = 10;
  public static final int IS_DB_POOL = 7;
  public static final int IS_DOWNLOAD_POOL = 5;
  public static final int IS_FILE_POOL = 8;
  public static final int IS_HEAVY_POOL = 2;
  public static final int IS_LIGHT_POOL = 1;
  public static final int IS_NET_POOL = 9;
  public static final int IS_NOMAL_POOL = 6;
  public static final int IS_OTHER_POOL = 11;
  private static final ThreadExcutor sExcutors = new ThreadExcutor();
  public static boolean sLooperMonitorSwitch;
  public static int sThreshTime = 1000;
  private ThreadSmartPool mAIODownloadThreadPool;
  private ThreadSmartPool mDBPool;
  private ThreadSmartPool mFilePool;
  private ThreadSmartPool mHeavyThreadPool;
  private ThreadSmartPool mLightThreadPool;
  private ThreadSmartPool mNetPool;
  private ThreadSmartPool mNormalPool;
  
  static
  {
    sLooperMonitorSwitch = false;
  }
  
  private ThreadExcutor()
  {
    ThreadManagerV2.IsRunTimeShutDown = false;
    ThreadLog.printQLog("ThreadManager", "ThreadExcutor singleton construct");
    initThreadPools();
    initDispatcherHandler();
  }
  
  public static Job buildJob(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    Object localObject1 = paramRunnable.getClass();
    String str = ((Class)localObject1).getName();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localField = ((Class)localObject1).getDeclaredField("this$0");
        localField.setAccessible(true);
        localObject1 = localField.get(paramRunnable);
        Object localObject2;
        Object localObject3;
        localObject4 = localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        for (;;)
        {
          try
          {
            localField.set(paramRunnable, null);
          }
          catch (IllegalAccessException localIllegalAccessException2)
          {
            Field localField;
            Object localObject5 = localObject4;
            continue;
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            Object localObject6 = localObject4;
            continue;
          }
          catch (NoSuchFieldException localNoSuchFieldException2)
          {
            Object localObject4;
            Object localObject7 = localObject4;
            continue;
          }
          try
          {
            paramRunnable = new Job(localObject1, str, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
            return paramRunnable;
          }
          catch (OutOfMemoryError paramRunnable)
          {
            ThreadLog.printQLog("ThreadManager", "buildJob IllegalAccessException", paramRunnable);
            return null;
          }
        }
        localNoSuchFieldException1 = localNoSuchFieldException1;
        localField = null;
        localObject2 = localField;
        if (!ThreadSetting.logcatBgTaskMonitor) {
          continue;
        }
        ThreadLog.printQLog("ThreadManager", "buildJob NoSuchFieldException");
        localObject2 = localField;
        continue;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        localField = null;
        localObject3 = localField;
        if (!ThreadSetting.logcatBgTaskMonitor) {
          continue;
        }
        ThreadLog.printQLog("ThreadManager", "buildJob IllegalArgumentException");
        localObject3 = localField;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        localField = null;
      }
      if (ThreadSetting.logcatBgTaskMonitor)
      {
        ThreadLog.printQLog("ThreadManager", "buildJob IllegalAccessException");
        localObject4 = localField;
        continue;
        localObject4 = null;
      }
    }
  }
  
  public static void doRdmReport(String paramString1, String paramString2)
  {
    if (!ThreadSetting.isPublicVersion) {
      throw new TSPInvalidArgsCatchedException(paramString1 + "|" + paramString2);
    }
    if (ThreadManagerV2.sThreadWrapContext != null) {
      ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPInvalidArgsCatchedException(paramString1), paramString1, paramString2);
    }
  }
  
  private StringBuilder getAllPoolRunningJob(String paramString)
  {
    ThreadLog.printQLog("ThreadManager", "\ngetAllPoolRunningJob from: " + paramString);
    paramString = new StringBuilder();
    paramString.append("\nInLight");
    getPoolRunningJob(paramString, Job.runningJmapInLight);
    paramString.append("\nInHeavy");
    getPoolRunningJob(paramString, Job.runningJmapInHeavy);
    paramString.append("\nInDownload");
    getPoolRunningJob(paramString, Job.runningJmapInDownload);
    paramString.append("\nInNormal");
    getPoolRunningJob(paramString, Job.runningJmapInNormal);
    paramString.append("\nInDB");
    getPoolRunningJob(paramString, Job.runningJmapInDB);
    paramString.append("\nInFile");
    getPoolRunningJob(paramString, Job.runningJmapInFile);
    paramString.append("\nInNet");
    getPoolRunningJob(paramString, Job.runningJmapInNet);
    paramString.append("\nInAync");
    getPoolRunningJob(paramString, Job.runningJmapInAync);
    paramString.append("\nInOther");
    getPoolRunningJob(paramString, Job.runningJmapInOther);
    return paramString;
  }
  
  static ThreadExcutor getInstance()
  {
    try
    {
      ThreadExcutor localThreadExcutor = sExcutors;
      return localThreadExcutor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private StringBuilder getPoolRunningJob(StringBuilder paramStringBuilder, ConcurrentLinkedQueue<String> paramConcurrentLinkedQueue)
  {
    if ((paramConcurrentLinkedQueue != null) && (paramStringBuilder != null))
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
  
  private Handler initDispatcherHandler()
  {
    if (DISPATCHER_HANDLER == null)
    {
      HandlerThread localHandlerThread = newFreeHandlerThread("QQ_DISPATCHER", 0);
      localHandlerThread.start();
      DISPATCHER_HANDLER = new Handler(localHandlerThread.getLooper());
      if (ThreadSetting.logcatBgTaskMonitor) {
        DISPATCHER_HANDLER.getLooper().setMessageLogging(new ThreadLooperPrinter2(1, "QQ_DISPATCHER"));
      }
    }
    return DISPATCHER_HANDLER;
  }
  
  @TargetApi(9)
  private void initThreadPools()
  {
    if (this.mLightThreadPool == null)
    {
      this.mLightThreadPool = ThreadLightPool.createThreadPool();
      this.mLightThreadPool.allowCoreThreadTimeOut(true);
    }
    if (this.mHeavyThreadPool == null)
    {
      this.mHeavyThreadPool = ThreadHeavyPool.createThreadPool();
      this.mHeavyThreadPool.allowCoreThreadTimeOut(true);
    }
    if (this.mNormalPool == null)
    {
      this.mNormalPool = ThreadNormalPool.createThreadPool();
      this.mNormalPool.allowCoreThreadTimeOut(true);
    }
    if (this.mDBPool == null)
    {
      this.mDBPool = ThreadDBPool.createThreadPool();
      this.mDBPool.allowCoreThreadTimeOut(true);
    }
    if (this.mFilePool == null)
    {
      this.mFilePool = ThreadFilePool.createThreadPool();
      this.mFilePool.allowCoreThreadTimeOut(true);
    }
    if (this.mNetPool == null)
    {
      this.mNetPool = ThreadNetWorkPool.createThreadPool();
      this.mNetPool.allowCoreThreadTimeOut(true);
    }
    if (this.mAIODownloadThreadPool == null)
    {
      this.mAIODownloadThreadPool = ThreadAioDownloadPool.createThreadPool();
      this.mAIODownloadThreadPool.allowCoreThreadTimeOut(true);
    }
  }
  
  void excute(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException();
    }
    paramRunnable = new ThreadExcutor.2(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
    DISPATCHER_HANDLER.postAtFrontOfQueue(paramRunnable);
  }
  
  HandlerThread newFreeHandlerThread(String paramString, int paramInt)
  {
    return new ThreadExcutor.4(this, paramString, paramInt);
  }
  
  Thread newFreeThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    paramRunnable = new Thread(paramRunnable, paramString);
    paramRunnable.setPriority(paramInt);
    return paramRunnable;
  }
  
  @TargetApi(9)
  Executor newFreeThreadPool(ThreadPoolParams paramThreadPoolParams)
  {
    ThreadPoolParams localThreadPoolParams = paramThreadPoolParams;
    if (paramThreadPoolParams == null) {
      localThreadPoolParams = new ThreadPoolParams();
    }
    paramThreadPoolParams = new PriorityThreadFactory(localThreadPoolParams.poolThreadName, localThreadPoolParams.priority);
    paramThreadPoolParams = new ThreadSmartPool(localThreadPoolParams.corePoolsize, localThreadPoolParams.maxPooolSize, localThreadPoolParams.keepAliveTime, localThreadPoolParams.queue, paramThreadPoolParams);
    if (Build.VERSION.SDK_INT > 8) {
      paramThreadPoolParams.allowCoreThreadTimeOut(true);
    }
    ThreadLog.printQLog("ThreadManager", "newFreeThreadPool " + localThreadPoolParams.poolThreadName);
    return paramThreadPoolParams;
  }
  
  void post(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("ThreadManager job == null");
    }
    paramRunnable = new ThreadExcutor.1(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
    DISPATCHER_HANDLER.postAtFrontOfQueue(paramRunnable);
  }
  
  void postDownLoadTask(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException();
    }
    paramRunnable = new ThreadExcutor.3(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
    DISPATCHER_HANDLER.postAtFrontOfQueue(paramRunnable);
  }
  
  void postImmediately(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    post(10, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  String printCurrentState()
  {
    StringBuilder localStringBuilder = getAllPoolRunningJob("CRASH");
    localStringBuilder.append("\n").append(this.mHeavyThreadPool.toString());
    localStringBuilder.append("\n").append(this.mLightThreadPool.toString());
    localStringBuilder.append("\n").append(this.mAIODownloadThreadPool.toString());
    localStringBuilder.append("\n").append(this.mNormalPool.toString());
    localStringBuilder.append("\n").append(this.mDBPool.toString());
    localStringBuilder.append("\n").append(this.mFilePool.toString());
    localStringBuilder.append("\n").append(this.mNetPool.toString());
    return localStringBuilder.toString();
  }
  
  boolean removeJobFromThreadPool(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable == null) {}
    try
    {
      doRdmReport("removeJobFromThreadPool_Err", "job_NONE_type" + paramInt);
      return false;
    }
    catch (Exception localException)
    {
      doRdmReport("removeJobFromThreadPool_Err", "name_" + paramRunnable + "_Type_" + paramInt);
      return false;
    }
    Job localJob = buildJob(paramInt, paramRunnable, null, false);
    if (localJob == null)
    {
      doRdmReport("removeJobFromThreadPool_Err", "work_NONE_type" + paramInt);
      return false;
    }
    ThreadSmartPool localThreadSmartPool;
    if ((paramInt & 0x80) != 0) {
      localThreadSmartPool = this.mNetPool;
    }
    for (;;)
    {
      return localThreadSmartPool.remove(localJob);
      if ((paramInt & 0x40) != 0)
      {
        localThreadSmartPool = this.mFilePool;
      }
      else if ((paramInt & 0x20) != 0)
      {
        localThreadSmartPool = this.mDBPool;
      }
      else
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        localThreadSmartPool = this.mNormalPool;
      }
    }
    doRdmReport("removeJobFromThreadPool_Err", "type_NONE_" + paramRunnable);
    return false;
  }
  
  void shrinkMaxPoolSize(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mHeavyThreadPool.setMaximumPoolSize(Math.max(this.mHeavyThreadPool.getActiveCount(), this.mHeavyThreadPool.getCorePoolSize()));
      this.mAIODownloadThreadPool.setMaximumPoolSize(Math.max(this.mAIODownloadThreadPool.getActiveCount(), this.mAIODownloadThreadPool.getCorePoolSize()));
      return;
    }
    this.mHeavyThreadPool.setMaximumPoolSize(this.mHeavyThreadPool.getInitMaxPoolSize());
    this.mAIODownloadThreadPool.setMaximumPoolSize(this.mAIODownloadThreadPool.getInitMaxPoolSize());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor
 * JD-Core Version:    0.7.0.1
 */