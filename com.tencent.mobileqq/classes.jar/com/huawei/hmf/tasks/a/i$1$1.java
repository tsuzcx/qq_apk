package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;

final class i$1$1
  implements OnCompleteListener<TContinuationResult>
{
  i$1$1(i.1 param1) {}
  
  public final void onComplete(Task<TContinuationResult> paramTask)
  {
    if (paramTask.isSuccessful())
    {
      this.a.b.a(paramTask.getResult());
      return;
    }
    if (paramTask.isCanceled())
    {
      this.a.b.a();
      return;
    }
    this.a.b.a(paramTask.getException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.i.1.1
 * JD-Core Version:    0.7.0.1
 */