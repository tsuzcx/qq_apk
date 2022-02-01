package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class f<TResult>
  implements ExecuteResult<TResult>
{
  private OnFailureListener a;
  private Executor b;
  private final Object c = new Object();
  
  f(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    this.a = paramOnFailureListener;
    this.b = paramExecutor;
  }
  
  public final void cancel()
  {
    synchronized (this.c)
    {
      this.a = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    if ((!paramTask.isSuccessful()) && (!paramTask.isCanceled())) {
      this.b.execute(new f.1(this, paramTask));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.f
 * JD-Core Version:    0.7.0.1
 */