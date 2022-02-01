package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;

final class i$4
  implements OnCompleteListener<TResult>
{
  i$4(i parami1, Continuation paramContinuation, i parami2) {}
  
  public final void onComplete(Task<TResult> paramTask)
  {
    try
    {
      paramTask = (Task)this.a.then(paramTask);
      if (paramTask == null)
      {
        this.b.a(new NullPointerException("Continuation returned null"));
        return;
      }
      paramTask.addOnCompleteListener(new i.4.1(this));
      return;
    }
    catch (Exception paramTask)
    {
      this.b.a(paramTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.i.4
 * JD-Core Version:    0.7.0.1
 */