package com.tencent.ilinkservice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

final class v
{
  private ArrayBlockingQueue<v.c> a = new ArrayBlockingQueue(80);
  private volatile boolean b = false;
  private v.a c = null;
  private volatile boolean d = false;
  private final Boolean e = new Boolean(true);
  
  private v()
  {
    af.a().a("IlinkServiceApiTask", "Create IlinkApiTaskManager", new Object[0]);
  }
  
  static v a()
  {
    return v.b.a();
  }
  
  void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Integer.TYPE;
      boolean bool = this.a.offer(new v.c(this, IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "writeLogToService", new Class[] { localClass, String.class, String.class }, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }), 200L, TimeUnit.MILLISECONDS);
      if (!bool)
      {
        af.a().d("IlinkServiceApiTask", "task queue is full!", new Object[0]);
        return;
      }
      af.a().a("IlinkServiceApiTask", "add task to queue!", new Object[0]);
      return;
    }
    catch (InterruptedException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  void a(Object paramObject, Class paramClass, String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      boolean bool = this.a.offer(new v.c(this, paramObject, paramClass, paramString, paramArrayOfClass, paramVarArgs), 200L, TimeUnit.MILLISECONDS);
      if (!bool)
      {
        af.a().d("IlinkServiceApiTask", "task queue is full!", new Object[0]);
        return;
      }
      af.a().a("IlinkServiceApiTask", "add task to queue!", new Object[0]);
      return;
    }
    catch (InterruptedException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  void a(boolean paramBoolean)
  {
    synchronized (this.e)
    {
      this.d = paramBoolean;
      this.e.notify();
      return;
    }
  }
  
  void b()
  {
    this.b = false;
    if (this.c == null)
    {
      this.c = new v.a(this, null);
      this.c.start();
    }
  }
  
  void c()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.v
 * JD-Core Version:    0.7.0.1
 */