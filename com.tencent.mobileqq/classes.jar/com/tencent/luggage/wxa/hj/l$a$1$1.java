package com.tencent.luggage.wxa.hj;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.luggage.wxa.hr.a;
import com.tencent.luggage.wxa.hs.b;

class l$a$1$1
  implements Runnable
{
  l$a$1$1(l.a.1 param1, Runnable paramRunnable) {}
  
  public void run()
  {
    ThreadLocal localThreadLocal = (ThreadLocal)new a(Looper.class, "sThreadLocal").a();
    if ((localThreadLocal != null) && (localThreadLocal.get() == null))
    {
      b.d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
      localThreadLocal.set(this.b.b.a.getLooper());
    }
    else
    {
      b.d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", new Object[] { localThreadLocal });
    }
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l.a.1.1
 * JD-Core Version:    0.7.0.1
 */