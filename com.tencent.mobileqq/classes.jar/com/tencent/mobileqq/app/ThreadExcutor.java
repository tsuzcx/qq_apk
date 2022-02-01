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
  public static boolean sLooperMonitorSwitch = false;
  public static int sThreshTime = 1000;
  private ThreadSmartPool mAIODownloadThreadPool;
  private ThreadSmartPool mDBPool;
  private ThreadSmartPool mFilePool;
  private ThreadSmartPool mHeavyThreadPool;
  private ThreadSmartPool mLightThreadPool;
  private ThreadSmartPool mNetPool;
  private ThreadSmartPool mNormalPool;
  
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
    try
    {
      localObject2 = ((Class)localObject1).getDeclaredField("this$0");
      ((Field)localObject2).setAccessible(true);
      localObject1 = ((Field)localObject2).get(paramRunnable);
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      Object localObject2;
      break label125;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      break label98;
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      label50:
      label57:
      break label71;
    }
    try
    {
      ((Field)localObject2).set(paramRunnable, null);
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      break label64;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      break label57;
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      break label50;
    }
    localObject2 = localObject1;
    break label74;
    localObject2 = localObject1;
    break label101;
    label64:
    localObject2 = localObject1;
    break label128;
    label71:
    localObject2 = null;
    label74:
    localObject1 = localObject2;
    if (ThreadSetting.logcatBgTaskMonitor)
    {
      ThreadLog.printQLog("ThreadManager", "buildJob IllegalAccessException");
      localObject1 = localObject2;
      break label149;
      label98:
      localObject2 = null;
      label101:
      localObject1 = localObject2;
      if (ThreadSetting.logcatBgTaskMonitor)
      {
        ThreadLog.printQLog("ThreadManager", "buildJob IllegalArgumentException");
        localObject1 = localObject2;
        break label149;
        label125:
        localObject2 = null;
        label128:
        localObject1 = localObject2;
        if (ThreadSetting.logcatBgTaskMonitor)
        {
          ThreadLog.printQLog("ThreadManager", "buildJob NoSuchFieldException");
          localObject1 = localObject2;
        }
      }
    }
    label149:
    break label155;
    localObject1 = null;
    try
    {
      label155:
      paramRunnable = new Job(localObject1, str, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
      return paramRunnable;
    }
    catch (OutOfMemoryError paramRunnable)
    {
      ThreadLog.printQLog("ThreadManager", "buildJob IllegalAccessException", paramRunnable);
      return null;
    }
  }
  
  public static void doRdmReport(String paramString1, String paramString2)
  {
    if (ThreadSetting.isPublicVersion)
    {
      if (ThreadManagerV2.sThreadWrapContext != null) {
        ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPInvalidArgsCatchedException(paramString1), paramString1, paramString2);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    throw new TSPInvalidArgsCatchedException(localStringBuilder.toString());
  }
  
  private StringBuilder getAllPoolRunningJob(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\ngetAllPoolRunningJob from: ");
    localStringBuilder.append(paramString);
    ThreadLog.printQLog("ThreadManager", localStringBuilder.toString());
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
  
  public static ThreadExcutor getInstance()
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\nRunning_Job: ");
        localStringBuilder.append(str);
        paramStringBuilder.append(localStringBuilder.toString());
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
    if (paramRunnable != null)
    {
      paramRunnable = new ThreadExcutor.2(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
      DISPATCHER_HANDLER.postAtFrontOfQueue(paramRunnable);
      return;
    }
    throw new IllegalArgumentException();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newFreeThreadPool ");
    localStringBuilder.append(localThreadPoolParams.poolThreadName);
    ThreadLog.printQLog("ThreadManager", localStringBuilder.toString());
    return paramThreadPoolParams;
  }
  
  void post(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable != null)
    {
      paramRunnable = new ThreadExcutor.1(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
      DISPATCHER_HANDLER.postAtFrontOfQueue(paramRunnable);
      return;
    }
    throw new IllegalArgumentException("ThreadManager job == null");
  }
  
  void postDownLoadTask(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable != null)
    {
      paramRunnable = new ThreadExcutor.3(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
      DISPATCHER_HANDLER.postAtFrontOfQueue(paramRunnable);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  void postImmediately(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    post(10, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  String printCurrentState()
  {
    StringBuilder localStringBuilder = getAllPoolRunningJob("CRASH");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.mHeavyThreadPool.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append(this.mLightThreadPool.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append(this.mAIODownloadThreadPool.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append(this.mNormalPool.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append(this.mDBPool.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append(this.mFilePool.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append(this.mNetPool.toString());
    return localStringBuilder.toString();
  }
  
  boolean removeJobFromThreadPool(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable == null) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("job_NONE_type");
      ((StringBuilder)localObject).append(paramInt);
      doRdmReport("removeJobFromThreadPool_Err", ((StringBuilder)localObject).toString());
      return false;
    }
    catch (Exception localException)
    {
      Object localObject;
      Job localJob;
      break label185;
    }
    localJob = buildJob(paramInt, paramRunnable, null, false);
    if (localJob == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("work_NONE_type");
      ((StringBuilder)localObject).append(paramInt);
      doRdmReport("removeJobFromThreadPool_Err", ((StringBuilder)localObject).toString());
      return false;
    }
    if ((paramInt & 0x80) != 0)
    {
      localObject = this.mNetPool;
    }
    else if ((paramInt & 0x40) != 0)
    {
      localObject = this.mFilePool;
    }
    else if ((paramInt & 0x20) != 0)
    {
      localObject = this.mDBPool;
    }
    else
    {
      if ((paramInt & 0x10) == 0) {
        break label151;
      }
      localObject = this.mNormalPool;
    }
    return ((ThreadSmartPool)localObject).remove(localJob);
    label151:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("type_NONE_");
    ((StringBuilder)localObject).append(paramRunnable);
    doRdmReport("removeJobFromThreadPool_Err", ((StringBuilder)localObject).toString());
    return false;
    label185:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("name_");
    ((StringBuilder)localObject).append(paramRunnable);
    ((StringBuilder)localObject).append("_Type_");
    ((StringBuilder)localObject).append(paramInt);
    doRdmReport("removeJobFromThreadPool_Err", ((StringBuilder)localObject).toString());
    return false;
  }
  
  public void shrinkMaxPoolSize(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localThreadSmartPool = this.mHeavyThreadPool;
      localThreadSmartPool.setMaximumPoolSize(Math.max(localThreadSmartPool.getActiveCount(), this.mHeavyThreadPool.getCorePoolSize()));
      localThreadSmartPool = this.mAIODownloadThreadPool;
      localThreadSmartPool.setMaximumPoolSize(Math.max(localThreadSmartPool.getActiveCount(), this.mAIODownloadThreadPool.getCorePoolSize()));
      return;
    }
    ThreadSmartPool localThreadSmartPool = this.mHeavyThreadPool;
    localThreadSmartPool.setMaximumPoolSize(localThreadSmartPool.getInitMaxPoolSize());
    localThreadSmartPool = this.mAIODownloadThreadPool;
    localThreadSmartPool.setMaximumPoolSize(localThreadSmartPool.getInitMaxPoolSize());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor
 * JD-Core Version:    0.7.0.1
 */