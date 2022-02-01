package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

final class j$1
  implements Runnable
{
  j$1(j paramj, TaskCompletionSource paramTaskCompletionSource, Callable paramCallable) {}
  
  public final void run()
  {
    try
    {
      this.a.setResult(this.b.call());
      return;
    }
    catch (Exception localException)
    {
      this.a.setException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.j.1
 * JD-Core Version:    0.7.0.1
 */