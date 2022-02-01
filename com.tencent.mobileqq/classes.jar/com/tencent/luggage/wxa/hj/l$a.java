package com.tencent.luggage.wxa.hj;

import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

class l$a
  implements com.tencent.luggage.wxa.hk.b
{
  HandlerThread a = b();
  private int b = 3;
  
  private HandlerThread b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IPCThreadPool#InnerWorkerThread-");
    ((StringBuilder)localObject).append(hashCode());
    localObject = new HandlerThread(((StringBuilder)localObject).toString());
    ((HandlerThread)localObject).start();
    com.tencent.luggage.wxa.hs.b.a("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", new Object[] { Integer.valueOf(localObject.hashCode()) });
    return localObject;
  }
  
  public ExecutorService a()
  {
    l.a.2 local2 = new l.a.2(this, this.b, new l.a.1(this));
    double d = this.b;
    Double.isNaN(d);
    local2.setMaximumPoolSize((int)(d * 1.5D));
    local2.setRejectedExecutionHandler(new l.a.3(this));
    return local2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l.a
 * JD-Core Version:    0.7.0.1
 */