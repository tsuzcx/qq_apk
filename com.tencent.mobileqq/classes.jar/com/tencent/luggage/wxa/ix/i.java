package com.tencent.luggage.wxa.ix;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;

abstract class i<R>
{
  private R a;
  private final Object b = new Object();
  private final long c;
  private long d;
  private long e;
  private boolean f = false;
  private final Runnable g = new i.1(this);
  private volatile s h;
  
  public i()
  {
    this(0L, null);
  }
  
  public i(long paramLong, R paramR)
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
    this.h = params;
    o.d("MicroMsg.SDK.SyncTask", "sync task exec...");
    if (Thread.currentThread().getId() == params.a().getThread().getId())
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
  
  public void c()
  {
    s locals = this.h;
    if (locals == null) {
      return;
    }
    this.h.b(this.g);
    if (Looper.myLooper() == locals.a())
    {
      this.g.run();
      return;
    }
    a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.i
 * JD-Core Version:    0.7.0.1
 */