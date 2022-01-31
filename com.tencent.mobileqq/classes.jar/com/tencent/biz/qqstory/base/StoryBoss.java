package com.tencent.biz.qqstory.base;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tribe.async.async.Boss;
import com.tribe.async.async.ExecutorConfig;
import com.tribe.async.async.ExecutorConfig.CpuExecutorConfig;
import com.tribe.async.async.ExecutorConfig.NetworkExecutorConfig;
import com.tribe.async.async.FutureListener;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobControlHandler;
import com.tribe.async.async.JobController;
import com.tribe.async.async.JobController.CancelCommand;
import com.tribe.async.async.LightWeightExecutor;
import com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import myh;

public class StoryBoss
  implements Boss, MonitorThreadPoolExecutor.ThreadPoolMonitorListener
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final JobController jdField_a_of_type_ComTribeAsyncAsyncJobController;
  private final LightWeightExecutor jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor;
  private final Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private final Executor[] jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor = new Executor[2];
  private long jdField_b_of_type_Long;
  private final Executor jdField_b_of_type_JavaUtilConcurrentExecutor;
  
  public StoryBoss(Context paramContext)
  {
    Object localObject = new ExecutorConfig.CpuExecutorConfig();
    ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
    localThreadPoolParams.a = "story_cpu";
    localThreadPoolParams.b = ((ExecutorConfig)localObject).getCore();
    localThreadPoolParams.c = ((ExecutorConfig)localObject).getMaximum();
    localThreadPoolParams.d = ((ExecutorConfig)localObject).getAliveTime();
    this.jdField_b_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
    paramContext = new ExecutorConfig.NetworkExecutorConfig(paramContext);
    localObject = new ThreadPoolParams();
    ((ThreadPoolParams)localObject).a = "story_network";
    ((ThreadPoolParams)localObject).b = paramContext.getCore();
    ((ThreadPoolParams)localObject).c = paramContext.getMaximum();
    ((ThreadPoolParams)localObject).d = paramContext.getAliveTime();
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool((ThreadPoolParams)localObject);
    this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor[0] = this.jdField_a_of_type_JavaUtilConcurrentExecutor;
    this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor[1] = this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor = new LightWeightExecutor(100);
    this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor.setMonitorListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Dispatchers.get().getDefaultLooper());
    this.jdField_a_of_type_ComTribeAsyncAsyncJobController = new JobController(this);
    Dispatchers.get().registerSubscriber("root_group", this.jdField_a_of_type_ComTribeAsyncAsyncJobController);
  }
  
  @NonNull
  private Future a(Job paramJob, int paramInt1, int paramInt2, @Nullable FutureListener paramFutureListener, @Nullable Object paramObject)
  {
    paramJob = prepareWorker(paramJob, paramInt2, paramFutureListener, paramObject);
    paramJob.addFutureListener(new myh(this, paramJob));
    if (paramInt1 == 0)
    {
      Dispatchers.get().dispatch(paramJob);
      return paramJob;
    }
    Dispatchers.get().dispatchDelayed(paramJob, paramInt1);
    return paramJob;
  }
  
  public Future a(Job paramJob, @Nullable FutureListener paramFutureListener, @Nullable Object paramObject)
  {
    paramJob = prepareWorker(paramJob, paramJob.getJobType(), paramFutureListener, paramObject);
    this.jdField_a_of_type_ComTribeAsyncAsyncJobController.getDefaultHandler().handleExecute(this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor, paramJob);
    return paramJob;
  }
  
  public void cancelJob(Future paramFuture, boolean paramBoolean)
  {
    if ((paramFuture instanceof Worker)) {
      Dispatchers.get().cancelDispatch("", (Worker)paramFuture);
    }
    Dispatchers.get().dispatch(new JobController.CancelCommand(paramFuture, paramBoolean));
  }
  
  @NonNull
  public Executor getExecutor(int paramInt)
  {
    Executor localExecutor = this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    switch (paramInt)
    {
    default: 
      return localExecutor;
    case 2: 
      return this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    case 4: 
      return this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    case 8: 
      return this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentExecutor;
  }
  
  @NonNull
  public Executor[] getExecutors()
  {
    return this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor;
  }
  
  @NonNull
  public JobController getJobController()
  {
    return this.jdField_a_of_type_ComTribeAsyncAsyncJobController;
  }
  
  @NonNull
  public Executor getLightWeightExecutor()
  {
    return this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor;
  }
  
  public void onQueueExceedLimit(String paramString, int paramInt)
  {
    SLog.e("StoryBoss", paramString + " onQueueExceedLimit, size = " + paramInt);
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long > 7200000L) {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public void onWorkerExceedTime(String paramString, List paramList, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      paramList = localRunnable.getClass().getSimpleName();
      if (!(localRunnable instanceof Worker)) {
        break label116;
      }
      paramList = ((Worker)localRunnable).getJob().getClass().getSimpleName();
    }
    label116:
    for (;;)
    {
      SLog.e("StoryBoss", paramString + " onWorkerExceedTime, runnable = " + paramList);
      if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long <= 7200000L) {
        break;
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      break;
      return;
    }
  }
  
  @NonNull
  public Future postJob(Job paramJob)
  {
    return a(paramJob, null, null);
  }
  
  @NonNull
  public Future postJob(Job paramJob, @Nullable FutureListener paramFutureListener, @Nullable Object paramObject)
  {
    return a(paramJob, paramFutureListener, paramObject);
  }
  
  @NonNull
  public Future postJob(Job paramJob, @Nullable Object paramObject)
  {
    return a(paramJob, null, paramObject);
  }
  
  public void postLightWeightJob(Runnable paramRunnable, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor.execute(paramRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramInt);
  }
  
  @NonNull
  public Worker prepareWorker(Job paramJob, int paramInt, @Nullable FutureListener paramFutureListener, @Nullable Object paramObject)
  {
    AssertUtils.a(paramJob);
    paramJob.setJobType(paramInt);
    paramJob.setParams(paramObject);
    paramObject = new Worker(paramJob);
    if (paramFutureListener != null) {
      paramObject.addFutureListener(paramFutureListener);
    }
    paramJob.onPost();
    return paramObject;
  }
  
  @NonNull
  public Future scheduleJob(Job paramJob)
  {
    return a(paramJob, 0, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public Future scheduleJob(Job paramJob, @Nullable FutureListener paramFutureListener, @Nullable Object paramObject)
  {
    return a(paramJob, 0, paramJob.getJobType(), paramFutureListener, paramObject);
  }
  
  @NonNull
  public Future scheduleJob(Job paramJob, @Nullable Object paramObject)
  {
    return a(paramJob, 0, paramJob.getJobType(), null, paramObject);
  }
  
  @NonNull
  public Future scheduleJobDelayed(Job paramJob, int paramInt)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public Future scheduleJobDelayed(Job paramJob, int paramInt, @Nullable FutureListener paramFutureListener, @Nullable Object paramObject)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), paramFutureListener, paramObject);
  }
  
  @NonNull
  public Future scheduleJobDelayed(Job paramJob, int paramInt, @Nullable Object paramObject)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), null, paramObject);
  }
  
  public void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss
 * JD-Core Version:    0.7.0.1
 */