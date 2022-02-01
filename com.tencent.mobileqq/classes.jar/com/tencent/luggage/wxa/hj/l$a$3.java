package com.tencent.luggage.wxa.hj;

import com.tencent.luggage.wxa.hs.b;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class l$a$3
  implements RejectedExecutionHandler
{
  l$a$3(l.a parama) {}
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    b.c("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", new Object[] { paramRunnable });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l.a.3
 * JD-Core Version:    0.7.0.1
 */