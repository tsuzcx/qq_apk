package com.tencent.biz.qqstory.newshare.model;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import mqq.os.MqqHandler;

public class JobExecutor
  implements Job.JobExecutorCallback
{
  Executor a = Executors.newSingleThreadExecutor();
  public volatile boolean b;
  private List<Job> c = Collections.synchronizedList(new ArrayList());
  private JobExecutor.IOnJobExecuteResultCallback d;
  
  private void a(@NonNull Job paramJob, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramJob.h = paramConcurrentHashMap;
    paramJob.a(paramConcurrentHashMap);
    if (!paramJob.b())
    {
      paramJob = this.d;
      if (paramJob != null) {
        paramJob.b();
      }
      a();
      return;
    }
    if (paramJob.f)
    {
      paramJob.a();
      return;
    }
    this.a.execute(new JobExecutor.2(this, paramJob));
  }
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.c.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (Job)this.c.get(0), paramConcurrentHashMap));
  }
  
  public JobExecutor a(@NonNull Job paramJob)
  {
    paramJob.i = this;
    this.c.add(paramJob);
    return this;
  }
  
  protected void a()
  {
    List localList = this.c;
    if ((localList != null) && (!localList.isEmpty())) {
      this.c.clear();
    }
    this.d = null;
  }
  
  public void a(@NonNull JobExecutor.IOnJobExecuteResultCallback paramIOnJobExecuteResultCallback)
  {
    this.d = paramIOnJobExecuteResultCallback;
    a(new ConcurrentHashMap());
  }
  
  public void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b)
    {
      localObject = this.d;
      if (localObject != null) {
        ((JobExecutor.IOnJobExecuteResultCallback)localObject).c();
      }
      a();
      return;
    }
    Object localObject = (Job)this.c.get(0);
    if (paramBoolean)
    {
      if (((Job)localObject).g)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ((Job)localObject).a(((Job)localObject).c());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, (Job)localObject));
        return;
      }
      this.a.execute(new JobExecutor.4(this, (Job)localObject));
      return;
    }
    JobExecutor.IOnJobExecuteResultCallback localIOnJobExecuteResultCallback = this.d;
    if (localIOnJobExecuteResultCallback != null) {
      localIOnJobExecuteResultCallback.b();
    }
    ((Job)localObject).a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (this.b)
    {
      localObject = this.d;
      if (localObject != null) {
        ((JobExecutor.IOnJobExecuteResultCallback)localObject).c();
      }
      a();
      return;
    }
    if (paramBoolean)
    {
      localObject = (Job)this.c.remove(0);
      if (this.c.isEmpty())
      {
        localObject = this.d;
        if (localObject != null) {
          ((JobExecutor.IOnJobExecuteResultCallback)localObject).a();
        }
        if (this.c.isEmpty()) {
          a();
        }
      }
      else
      {
        ThreadManager.getUIHandler().post(new JobExecutor.5(this, (Job)localObject));
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null) {
        ((JobExecutor.IOnJobExecuteResultCallback)localObject).b();
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.JobExecutor
 * JD-Core Version:    0.7.0.1
 */