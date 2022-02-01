package com.tencent.luggage.wxa.si;

import com.tencent.luggage.wxa.sc.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class b$a$1
  implements ThreadFactory
{
  AtomicInteger a = new AtomicInteger(0);
  
  b$a$1(b paramb) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.c());
    localStringBuilder.append("#");
    localStringBuilder.append(this.a.getAndIncrement());
    return c.a(localStringBuilder.toString(), paramRunnable, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.b.a.1
 * JD-Core Version:    0.7.0.1
 */