package com.tencent.luggage.wxa.sc;

import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.f;
import java.util.concurrent.ConcurrentLinkedQueue;

final class a$2
  extends Thread
{
  a$2(Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void interrupt()
  {
    super.interrupt();
    a.a().remove(Long.valueOf(getId()));
    c.b.a(this, getName(), getId());
  }
  
  public void start()
  {
    try
    {
      super.start();
      if (!a.a().contains(Long.valueOf(getId()))) {
        a.a().add(Long.valueOf(getId()));
      }
      c.b.b(this, getName(), getId());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sc.a.2
 * JD-Core Version:    0.7.0.1
 */