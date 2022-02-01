package com.tencent.luggage.wxa.rp;

import com.tencent.luggage.wxa.rn.a;

public class c
  extends d
{
  public c()
  {
    a.b("Vending.NoLooperScheduler", "This is not a handler thread! %s", new Object[] { Thread.currentThread() });
  }
  
  public void a() {}
  
  public void a(Runnable paramRunnable)
  {
    a.b("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    a.b("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rp.c
 * JD-Core Version:    0.7.0.1
 */