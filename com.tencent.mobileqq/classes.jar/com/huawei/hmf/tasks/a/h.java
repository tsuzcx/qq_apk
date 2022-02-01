package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class h<TResult>
  implements ExecuteResult<TResult>
{
  private OnSuccessListener<TResult> a;
  private Executor b;
  private final Object c = new Object();
  
  h(Executor paramExecutor, OnSuccessListener<TResult> paramOnSuccessListener)
  {
    this.a = paramOnSuccessListener;
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
    if ((paramTask.isSuccessful()) && (!paramTask.isCanceled())) {
      this.b.execute(new h.1(this, paramTask));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.h
 * JD-Core Version:    0.7.0.1
 */