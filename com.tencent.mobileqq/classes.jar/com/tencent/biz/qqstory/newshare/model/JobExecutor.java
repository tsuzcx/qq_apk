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
  private JobExecutor.IOnJobExecuteResultCallback jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback;
  private List<Job> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  public volatile boolean a;
  
  private void a(@NonNull Job paramJob, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramJob.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramJob.a(paramConcurrentHashMap);
    if (!paramJob.a())
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback.b();
      }
      a();
      return;
    }
    if (paramJob.jdField_a_of_type_Boolean)
    {
      paramJob.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramJob));
  }
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (Job)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  public JobExecutor a(@NonNull Job paramJob)
  {
    paramJob.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJob$JobExecutorCallback = this;
    this.jdField_a_of_type_JavaUtilList.add(paramJob);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback = null;
  }
  
  public void a(@NonNull JobExecutor.IOnJobExecuteResultCallback paramIOnJobExecuteResultCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback = paramIOnJobExecuteResultCallback;
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
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback.c();
      }
      a();
      return;
    }
    Job localJob = (Job)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localJob.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localJob.a(localJob.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localJob));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localJob));
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback.b();
    }
    localJob.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback.c();
      }
      a();
    }
    Job localJob;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localJob = (Job)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localJob));
    return;
    label108:
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor$IOnJobExecuteResultCallback.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.JobExecutor
 * JD-Core Version:    0.7.0.1
 */