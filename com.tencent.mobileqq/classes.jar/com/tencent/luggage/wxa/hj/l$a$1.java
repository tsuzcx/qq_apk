package com.tencent.luggage.wxa.hj;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hs.b;
import java.util.concurrent.ThreadFactory;

class l$a$1
  implements ThreadFactory
{
  int a = 0;
  
  l$a$1(l.a parama) {}
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IPCThreadPool#Thread-");
    int i = this.a;
    this.a = (i + 1);
    ((StringBuilder)localObject).append(i);
    localObject = ((StringBuilder)localObject).toString();
    paramRunnable = new Thread(new l.a.1.1(this, paramRunnable), (String)localObject);
    b.a("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", new Object[] { localObject });
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l.a.1
 * JD-Core Version:    0.7.0.1
 */