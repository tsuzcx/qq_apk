package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class d<TResult>
  implements ExecuteResult<TResult>
{
  Executor a;
  private OnCompleteListener<TResult> b;
  private final Object c = new Object();
  
  d(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.b = paramOnCompleteListener;
    this.a = paramExecutor;
  }
  
  public final void cancel()
  {
    synchronized (this.c)
    {
      this.b = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    this.a.execute(new d.1(this, paramTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.d
 * JD-Core Version:    0.7.0.1
 */