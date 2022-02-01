package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadSmartPool
  extends ThreadPoolExecutor
{
  private static int BLOCKING_TIME_OUT = 9990000;
  private static int CHECK_PERIOD = 9990000;
  protected static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int MAX_Report_Size = 1;
  protected static final int maximumPoolSize = CPU_COUNT * 2 + 1;
  private Handler REJECTED_THREAD_HANDLER;
  private int blockingReportCount = 0;
  private int initMaxPoolSize;
  protected long poolcheckTime = -1L;
  private boolean sAlreadyOutOfPool = false;
  private ThreadSmartPool.SmartRejectedExecutionHandler smartRejectedExecutionHandler = new ThreadSmartPool.SmartRejectedExecutionHandler(this);
  
  ThreadSmartPool(int paramInt1, int paramInt2, long paramLong, BlockingQueue<Runnable> paramBlockingQueue, PriorityThreadFactory paramPriorityThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, TimeUnit.SECONDS, paramBlockingQueue, paramPriorityThreadFactory);
    setRejectedExecutionHandler(this.smartRejectedExecutionHandler);
    this.initMaxPoolSize = paramInt2;
  }
  
  private void checkBlockingState()
  {
    if (this.sAlreadyOutOfPool) {
      return;
    }
    if (ThreadLog.needReportRunOrBlocking())
    {
      long l = SystemClock.uptimeMillis();
      if (l - this.poolcheckTime > get_CHECK_PERIOD())
      {
        this.poolcheckTime = l;
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getName());
        ((StringBuilder)localObject1).append("_checkBlockingState");
        ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject1).toString());
        Object localObject2 = getQueue().iterator();
        l = SystemClock.uptimeMillis();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Job)((Iterator)localObject2).next();
          ((Job)localObject1).blcokingCost = (l - ((Job)localObject1).addPoint);
          if (((Job)localObject1).blcokingCost >= get_BLOCKING_TIME_OUT())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(getName());
            ((StringBuilder)localObject2).append("_BlockingException");
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder1 = new StringBuilder();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("\n revision:");
            localStringBuilder2.append(ThreadSetting.revision);
            localStringBuilder1.append(localStringBuilder2.toString());
            getRunningJob((String)localObject2, localStringBuilder1);
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("\nblocking JOB: ");
            localStringBuilder2.append(((Job)localObject1).toString());
            localStringBuilder1.append(localStringBuilder2.toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("\nblocking Executor:");
            ((StringBuilder)localObject1).append(toString());
            localStringBuilder1.append(((StringBuilder)localObject1).toString());
            ThreadLog.printQLog("ThreadManager", localStringBuilder1.toString());
            if ((ThreadManagerV2.OPEN_RDM_REPORT) && (ThreadManagerV2.sThreadWrapContext != null) && (this.blockingReportCount < 1))
            {
              ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPBlockingCatchedException((String)localObject2), (String)localObject2, localStringBuilder1.toString());
              this.blockingReportCount += 1;
            }
          }
        }
      }
    }
  }
  
  private void doJobOneByOne(Runnable paramRunnable)
  {
    this.REJECTED_THREAD_HANDLER = getRejectedHandler();
    Handler localHandler = this.REJECTED_THREAD_HANDLER;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private Handler getRejectedHandler()
  {
    if (this.REJECTED_THREAD_HANDLER == null) {
      try
      {
        Object localObject = ThreadExcutor.getInstance();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getName());
        localStringBuilder.append("_Rejected_Handler");
        localObject = ((ThreadExcutor)localObject).newFreeHandlerThread(localStringBuilder.toString(), 10);
        ((HandlerThread)localObject).start();
        this.REJECTED_THREAD_HANDLER = new Handler(((HandlerThread)localObject).getLooper());
        localObject = this.REJECTED_THREAD_HANDLER;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getName());
        localStringBuilder.append("_getRejectedHandler:");
        ThreadLog.printQLog("ThreadManager", localStringBuilder.toString(), localOutOfMemoryError);
      }
    }
    return this.REJECTED_THREAD_HANDLER;
  }
  
  private StringBuilder getRunningJob(String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\ngetRunningJob from: ");
    ((StringBuilder)localObject).append(paramString);
    ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject).toString());
    paramString = getRunningJobCache();
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\n");
        localStringBuilder.append((String)localObject);
        paramStringBuilder.append(localStringBuilder.toString());
      }
    }
    return paramStringBuilder;
  }
  
  private static long get_BLOCKING_TIME_OUT()
  {
    if (!ThreadSetting.isPublicVersion) {
      BLOCKING_TIME_OUT = 30000;
    }
    return BLOCKING_TIME_OUT;
  }
  
  private static long get_CHECK_PERIOD()
  {
    if (!ThreadSetting.isPublicVersion) {
      CHECK_PERIOD = 30000;
    }
    return CHECK_PERIOD;
  }
  
  public void execute(Runnable paramRunnable)
  {
    Object localObject1;
    if (ThreadManagerV2.IsRunTimeShutDown)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pool has shutdown:");
      ((StringBuilder)localObject1).append(paramRunnable.toString());
      ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2;
    if (!(paramRunnable instanceof Job))
    {
      if (ThreadSetting.logcatBgTaskMonitor)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("command is not instanceof Job ");
        ((StringBuilder)localObject1).append(paramRunnable.toString());
        ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject1).toString());
      }
      if ((this instanceof ThreadAsyncTaskPool))
      {
        localObject1 = ThreadExcutor.buildJob(256, paramRunnable, null, false);
        ((Job)localObject1).poolNum = 10;
      }
      else
      {
        localObject1 = ThreadExcutor.buildJob(512, paramRunnable, null, false);
        ((Job)localObject1).poolNum = 11;
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        ThreadLog.printQLog("ThreadManager", "sp execute job == null ");
        doJobOneByOne(paramRunnable);
      }
    }
    else
    {
      localObject2 = (Job)paramRunnable;
    }
    try
    {
      if (ThreadSetting.logcatBgTaskMonitor)
      {
        paramRunnable = new StringBuilder();
        paramRunnable.append("tsp execute:");
        paramRunnable.append(((Job)localObject2).toString());
        ThreadLog.printQLog("ThreadManager", paramRunnable.toString());
      }
      checkBlockingState();
      super.execute((Runnable)localObject2);
      return;
    }
    catch (InternalError paramRunnable)
    {
      ThreadLog.printQLog("ThreadManager", "java.lang.InternalError: Thread starting during runtime shutdown", paramRunnable);
      return;
    }
    catch (OutOfMemoryError paramRunnable)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("execute job OutOfMemoryError:");
      ((StringBuilder)localObject1).append(((Job)localObject2).toString());
      ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject1).toString(), paramRunnable);
      doJobOneByOne((Runnable)localObject2);
    }
  }
  
  int getInitMaxPoolSize()
  {
    return this.initMaxPoolSize;
  }
  
  protected String getName()
  {
    return "ThreadOtherPool";
  }
  
  protected ConcurrentLinkedQueue<String> getRunningJobCache()
  {
    return Job.runningJmapInOther;
  }
  
  protected void terminated()
  {
    super.terminated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadSmartPool
 * JD-Core Version:    0.7.0.1
 */