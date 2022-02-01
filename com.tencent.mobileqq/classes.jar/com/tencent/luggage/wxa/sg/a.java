package com.tencent.luggage.wxa.sg;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class a
  extends e
{
  private ReentrantLock b = new ReentrantLock();
  private final Condition c = this.b.newCondition();
  
  public a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void a(g paramg)
  {
    super.a(paramg);
    try
    {
      this.b.lock();
      this.c.signal();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public void b(g paramg)
  {
    super.b(paramg);
    try
    {
      for (;;)
      {
        boolean bool = c(paramg);
        if (!bool) {}
        try
        {
          this.b.lock();
          this.c.await();
          this.b.unlock();
        }
        finally
        {
          this.b.unlock();
        }
      }
      return;
    }
    catch (InterruptedException paramg) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sg.a
 * JD-Core Version:    0.7.0.1
 */