package com.tencent.luggage.wxa.si;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class c$a$1
  implements ThreadFactory
{
  AtomicInteger a = new AtomicInteger(0);
  
  c$a$1(c paramc) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.c());
    localStringBuilder.append("#");
    localStringBuilder.append(this.a.getAndIncrement());
    return com.tencent.luggage.wxa.sc.c.a(localStringBuilder.toString(), paramRunnable, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.c.a.1
 * JD-Core Version:    0.7.0.1
 */