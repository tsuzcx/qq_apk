package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import bdlv;
import bmhv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import nwo;
import pvh;
import pvt;

public class MonitorTimeExecutor
  extends ThreadPoolExecutor
{
  private static long jdField_a_of_type_Long = 5000L;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static volatile ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private static boolean jdField_a_of_type_Boolean;
  private static long b = 30000L;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private MonitorTimeExecutor.TimeTrackedRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable;
  
  private MonitorTimeExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, new pvt(), new pvh());
  }
  
  private static String a(Thread paramThread)
  {
    if (paramThread == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|").append("pub").append("|").append(System.currentTimeMillis());
    localStringBuilder.append(Build.MODEL).append("|").append(Build.VERSION.RELEASE);
    localStringBuilder.append("|").append("monitorThread=").append(paramThread.getName()).append(",tid=").append(paramThread.getId()).append(",state=").append(paramThread.getState());
    localStringBuilder.append(bdlv.a());
    localStringBuilder.append(bdlv.b());
    return localStringBuilder.toString();
  }
  
  public static ExecutorService a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {}
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null)
      {
        MonitorTimeExecutor localMonitorTimeExecutor = new MonitorTimeExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        b(localMonitorTimeExecutor);
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = localMonitorTimeExecutor;
      }
      QLog.i("MonitorTimeExecutor", 1, "[newThreadExecutor]: " + jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor);
      return jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
    }
    finally {}
  }
  
  private static boolean a(StringBuilder paramStringBuilder, String paramString)
  {
    QLog.d("MonitorTimeExecutor", 2, "[dumpAllJavaStacks] ");
    for (;;)
    {
      int i;
      try
      {
        Thread[] arrayOfThread = new Thread[Thread.activeCount()];
        Thread.enumerate(arrayOfThread);
        i = 0;
        if (i < arrayOfThread.length)
        {
          Object localObject = arrayOfThread[i];
          if (localObject != null)
          {
            paramStringBuilder.append("Name:").append(((Thread)localObject).getName()).append("\n").append("State:").append(((Thread)localObject).getState()).append("\n").append("Tid:").append(((Thread)localObject).getId()).append("\n");
            if (((Thread)localObject).isAlive())
            {
              localObject = ((Thread)localObject).getStackTrace();
              int k = localObject.length;
              int j = 0;
              if (j < k)
              {
                paramStringBuilder.append(localObject[j].toString()).append("\n");
                j += 1;
                continue;
              }
              paramStringBuilder.append("\n");
            }
          }
        }
        else
        {
          paramStringBuilder.append("\n").append(paramString);
          return true;
        }
      }
      catch (Exception paramStringBuilder)
      {
        QLog.e("MonitorTimeExecutor", 1, "[dumpAllJavaStacks] failed ", paramStringBuilder);
        return false;
      }
      i += 1;
    }
  }
  
  private static void b(MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    QLog.i("MonitorTimeExecutor", 1, "[startWatching] for " + paramMonitorTimeExecutor);
    if (!((Boolean)bmhv.a("sp_key_kandian_thread_pool_monitor_enable", Boolean.valueOf(false))).booleanValue())
    {
      QLog.i("MonitorTimeExecutor", 1, "[startWatching] won't start since monitor disabled");
      return;
    }
    jdField_a_of_type_Long = ((Long)bmhv.a("sp_key_kandian_thread_pool_check_period", Long.valueOf(5000L))).longValue();
    b = ((Long)bmhv.a("sp_key_kandian_thread_pool_time_out_threshold", Long.valueOf(30000L))).longValue();
    QLog.i("MonitorTimeExecutor", 1, "[startWatching] CHECK_PERIOD=" + jdField_a_of_type_Long + " THRESHOLD=" + b);
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    }
    jdField_a_of_type_AndroidOsHandler.post(new MonitorTimeExecutor.WatchDogRunnable(paramMonitorTimeExecutor, null));
  }
  
  private static void c(MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    MonitorTimeExecutor.TimeTrackedRunnable localTimeTrackedRunnable = paramMonitorTimeExecutor.a();
    if ((localTimeTrackedRunnable != null) && (MonitorTimeExecutor.TimeTrackedRunnable.a(localTimeTrackedRunnable) > 0L))
    {
      long l = SystemClock.uptimeMillis() - MonitorTimeExecutor.TimeTrackedRunnable.a(localTimeTrackedRunnable);
      if (jdField_a_of_type_Boolean) {
        QLog.d("MonitorTimeExecutor", 2, "[run] currentTask=" + localTimeTrackedRunnable + " running for " + l + "ms");
      }
      if ((l > b) && (!Debug.isDebuggerConnected()))
      {
        QLog.e("MonitorTimeExecutor", 1, "[run] time limit exceed!, task=" + localTimeTrackedRunnable);
        if (!paramMonitorTimeExecutor.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(localTimeTrackedRunnable.a().hashCode(), false)) {
          break label149;
        }
        QLog.i("MonitorTimeExecutor", 1, "[checkBlockingState] skip task since already reported");
      }
    }
    return;
    label149:
    String str2 = a(localTimeTrackedRunnable.a());
    String str1 = str2;
    for (;;)
    {
      try
      {
        localObject = bdlv.a("kandian");
        str1 = str2;
        i = bdlv.a(BaseApplication.getContext(), (String)localObject, str2);
        if (i != 1) {
          continue;
        }
        str1 = str2;
        QLog.i("MonitorTimeExecutor", 1, "[checkBlockingState] trace dumped: " + (String)localObject);
        str1 = str2;
        str2 = nwo.a(new FileInputStream((String)localObject));
        str1 = str2;
        nwo.b((String)localObject);
        str1 = str2;
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        QLog.e("MonitorTimeExecutor", 1, "[checkBlockingState] ", localException);
        continue;
      }
      QQCatchedExceptionReporter.reportQQCatchedException(new MonitorTimeExecutor.KandianTaskRunningTooLongException(null), "", str1);
      paramMonitorTimeExecutor.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(localTimeTrackedRunnable.a().hashCode(), true);
      return;
      str1 = str2;
      QLog.e("MonitorTimeExecutor", 1, "[checkBlockingState] dump thread result: " + i);
      str1 = str2;
      localObject = new StringBuilder();
      str1 = str2;
      if (a((StringBuilder)localObject, str2))
      {
        str1 = str2;
        str2 = ((StringBuilder)localObject).toString();
        str1 = str2;
      }
      else
      {
        str1 = str2;
        QLog.d("MonitorTimeExecutor", 2, "[dumpAllJavaStacks] failed");
        str1 = str2;
      }
    }
  }
  
  public MonitorTimeExecutor.TimeTrackedRunnable a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable == paramRunnable) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable = null;
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    if ((paramRunnable instanceof MonitorTimeExecutor.TimeTrackedRunnable)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable = ((MonitorTimeExecutor.TimeTrackedRunnable)paramRunnable);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(new MonitorTimeExecutor.TimeTrackedRunnable(paramRunnable, null));
  }
  
  public void shutdown()
  {
    QLog.i("MonitorTimeExecutor", 1, "[shutdown]");
  }
  
  public List<Runnable> shutdownNow()
  {
    QLog.i("MonitorTimeExecutor", 1, "[shutdownNow]");
    return Collections.emptyList();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return super.submit(new MonitorTimeExecutor.TimeTrackedRunnable(paramRunnable, null));
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return super.submit(new MonitorTimeExecutor.TimeTrackedRunnable(paramRunnable, null), paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor
 * JD-Core Version:    0.7.0.1
 */