package com.tencent.biz.qqstory.base;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.FutureListener;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobControlHandler;
import com.tribe.async.async.JobController;
import com.tribe.async.async.JobController.CancelCommand;
import com.tribe.async.async.LightWeightExecutor;
import com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class StoryBoss
  implements Boss, MonitorThreadPoolExecutor.ThreadPoolMonitorListener
{
  private static final int j = Runtime.getRuntime().availableProcessors();
  private static final int k = Runtime.getRuntime().availableProcessors();
  private static final int l = Runtime.getRuntime().availableProcessors();
  private final Executor a = new StoryBoss.StoryQueueExecutor("StoryBoss.NetworkExecutor", 128, l, null);
  private final Executor b = new StoryBoss.StoryQueueExecutor("StoryBoss.CpuExecutor", 16, j, null);
  private final Executor c = new StoryBoss.StoryQueueExecutor("StoryBoss.FileExecutor", 64, k, null);
  private final Executor[] d = new Executor[3];
  private final JobController e;
  private final LightWeightExecutor f;
  private Handler g;
  private long h = 0L;
  private long i = 0L;
  
  public StoryBoss(Context paramContext)
  {
    paramContext = this.d;
    paramContext[0] = this.a;
    paramContext[1] = this.b;
    paramContext[2] = this.c;
    this.f = new LightWeightExecutor(StoryDispatcher.a().getDefaultLooper(), 100);
    this.f.setMonitorListener(this);
    this.g = new Handler(StoryDispatcher.a().getDefaultLooper());
    this.e = new JobController(this);
    StoryDispatcher.a().registerSubscriber("root_group", this.e);
  }
  
  @NonNull
  private <Params, Progress, Result> Future<Result> a(Job<Params, Progress, Result> paramJob, int paramInt1, int paramInt2, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramInt2, paramFutureListener, paramParams);
    paramJob.addFutureListener(new StoryBoss.1(this, paramJob));
    if (paramInt1 == 0)
    {
      StoryDispatcher.a().dispatch(paramJob);
      return paramJob;
    }
    StoryDispatcher.a().dispatchDelayed(paramJob, paramInt1);
    return paramJob;
  }
  
  public <Params, Progress, Result> Future<Result> a(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramJob.getJobType(), paramFutureListener, paramParams);
    this.e.getDefaultHandler().handleExecute(this.d, paramJob);
    if (paramJob != null)
    {
      paramFutureListener = new StringBuilder();
      paramFutureListener.append("work hash code:");
      paramFutureListener.append(paramJob.hashCode());
      SLog.b("StoryBoss", paramFutureListener.toString());
    }
    return paramJob;
  }
  
  public <Result> void cancelJob(Future<Result> paramFuture, boolean paramBoolean)
  {
    if ((paramFuture instanceof Worker)) {
      StoryDispatcher.a().cancelDispatch("", (Worker)paramFuture);
    }
    StoryDispatcher.a().dispatch(new JobController.CancelCommand(paramFuture, paramBoolean));
  }
  
  @NonNull
  public Executor getExecutor(int paramInt)
  {
    Executor localExecutor2 = this.b;
    Executor localExecutor1 = localExecutor2;
    if (paramInt != 2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 8)
        {
          if (paramInt != 16) {
            return localExecutor2;
          }
          return this.a;
        }
        return this.c;
      }
      localExecutor1 = this.c;
    }
    return localExecutor1;
  }
  
  @NonNull
  public Executor[] getExecutors()
  {
    return this.d;
  }
  
  @NonNull
  public JobController getJobController()
  {
    return this.e;
  }
  
  @NonNull
  public Executor getLightWeightExecutor()
  {
    return this.f;
  }
  
  public void onQueueExceedLimit(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" onQueueExceedLimit, size = ");
    localStringBuilder.append(paramInt);
    SLog.e("StoryBoss", localStringBuilder.toString());
    if (SystemClock.uptimeMillis() - this.i > 7200000L) {
      this.i = SystemClock.uptimeMillis();
    }
  }
  
  public void onWorkerExceedTime(String paramString, List<Runnable> paramList, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Runnable)localIterator.next();
      paramList = localObject.getClass().getSimpleName();
      if ((localObject instanceof Worker)) {
        paramList = ((Worker)localObject).getJob().getClass().getSimpleName();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" onWorkerExceedTime, runnable = ");
      ((StringBuilder)localObject).append(paramList);
      SLog.e("StoryBoss", ((StringBuilder)localObject).toString());
      if (SystemClock.uptimeMillis() - this.h > 7200000L) {
        this.h = SystemClock.uptimeMillis();
      }
    }
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob)
  {
    return a(paramJob, null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return a(paramJob, paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return a(paramJob, null, paramParams);
  }
  
  public void postLightWeightJob(Runnable paramRunnable, int paramInt)
  {
    if (paramInt == 0)
    {
      this.f.execute(paramRunnable);
      return;
    }
    this.g.postDelayed(paramRunnable, paramInt);
  }
  
  @NonNull
  public <Params, Progress, Result> Worker<Progress, Result> prepareWorker(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    AssertUtils.checkNotNull(paramJob);
    paramJob.setJobType(paramInt);
    paramJob.setParams(paramParams);
    paramParams = new Worker(paramJob);
    if (paramFutureListener != null) {
      paramParams.addFutureListener(paramFutureListener);
    }
    paramJob.onPost();
    return paramParams;
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob)
  {
    return a(paramJob, 0, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return a(paramJob, 0, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return a(paramJob, 0, paramJob.getJobType(), null, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable Params paramParams)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), null, paramParams);
  }
  
  public void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss
 * JD-Core Version:    0.7.0.1
 */