package com.tencent.ilinkservice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;

class v$a
  extends Thread
{
  private v$a(v paramv) {}
  
  public void run()
  {
    super.run();
    Thread.currentThread().setName("ApiTaskThread");
    for (;;)
    {
      if (v.a(this.a)) {
        return;
      }
      try
      {
        synchronized (v.b(this.a))
        {
          if (!v.c(this.a))
          {
            af.a().a("IlinkServiceApiTask", "Thread stop running wait service available 20s", new Object[0]);
            v.b(this.a).wait(20000L);
            af.a().a("IlinkServiceApiTask", "wake up from wait signal", new Object[0]);
          }
        }
        if (!v.c(this.a)) {}
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
    for (;;)
    {
      try
      {
        ??? = (v.c)v.d(this.a).take();
        if (!v.c(this.a))
        {
          v.d(this.a).offer(???);
          break;
        }
        af.a().a("IlinkServiceApiTask", "get task from queue", new Object[0]);
        ((v.c)???).b.getMethod(((v.c)???).c, ((v.c)???).d).invoke(((v.c)???).a, ((v.c)???).e);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        af.a().a("IlinkServiceApiTask", "could not found function", new Object[0]);
        localNoSuchMethodException.printStackTrace();
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
      }
    }
    throw localInterruptedException2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.v.a
 * JD-Core Version:    0.7.0.1
 */