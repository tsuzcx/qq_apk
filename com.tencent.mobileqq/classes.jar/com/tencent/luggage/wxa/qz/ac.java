package com.tencent.luggage.wxa.qz;

import android.os.Looper;
import com.tencent.luggage.wxa.sk.a;

public abstract class ac<R>
{
  private R a;
  private Object b = new Object();
  private final long c;
  private long d;
  private long e;
  private boolean f = false;
  private Runnable g = new ac.1(this);
  
  public ac()
  {
    this(0L, null);
  }
  
  public ac(long paramLong, R paramR)
  {
    this.c = paramLong;
    this.a = paramR;
  }
  
  public R a(s params)
  {
    if (params == null)
    {
      o.e("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
      return b();
    }
    o.d("MicroMsg.SDK.SyncTask", "sync task exec...");
    boolean bool;
    if (params.a() != null)
    {
      if (Thread.currentThread().getId() == params.a().getThread().getId()) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = params.b().equals(a.c());
    }
    if (bool)
    {
      o.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
      return b();
    }
    this.d = af.b();
    try
    {
      synchronized (this.b)
      {
        o.d("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
        params.a(this.g);
        this.b.wait(this.c);
      }
      long l;
      return this.a;
    }
    catch (InterruptedException params)
    {
      o.a("MicroMsg.SDK.SyncTask", params, "", new Object[0]);
      l = af.c(this.d);
      params = new StringBuilder();
      params.append("");
      params.append(this.a);
      o.d("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new Object[] { params.toString(), Long.valueOf(l), Long.valueOf(this.e), Long.valueOf(l - this.e) });
    }
  }
  
  public void a(R arg1)
  {
    o.d("MicroMsg.SDK.SyncTask", "setResultFinish ");
    this.a = ???;
    synchronized (this.b)
    {
      o.d("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
      this.b.notify();
      return;
    }
  }
  
  protected abstract R b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.ac
 * JD-Core Version:    0.7.0.1
 */