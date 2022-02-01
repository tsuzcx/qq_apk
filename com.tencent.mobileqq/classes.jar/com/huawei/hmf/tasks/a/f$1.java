package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;

final class f$1
  implements Runnable
{
  f$1(f paramf, Task paramTask) {}
  
  public final void run()
  {
    synchronized (f.a(this.b))
    {
      if (f.b(this.b) != null) {
        f.b(this.b).onFailure(this.a.getException());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.f.1
 * JD-Core Version:    0.7.0.1
 */