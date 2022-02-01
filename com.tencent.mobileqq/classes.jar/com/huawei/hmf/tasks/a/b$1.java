package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    synchronized (b.a(this.a))
    {
      if (b.b(this.a) != null) {
        b.b(this.a).onCanceled();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.b.1
 * JD-Core Version:    0.7.0.1
 */