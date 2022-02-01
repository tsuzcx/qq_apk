package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;

final class d$1
  implements Runnable
{
  d$1(d paramd, Task paramTask) {}
  
  public final void run()
  {
    synchronized (d.a(this.b))
    {
      if (d.b(this.b) != null) {
        d.b(this.b).onComplete(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.d.1
 * JD-Core Version:    0.7.0.1
 */