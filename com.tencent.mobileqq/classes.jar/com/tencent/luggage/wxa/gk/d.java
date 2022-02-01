package com.tencent.luggage.wxa.gk;

import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.magicbrush.handler.a;

public abstract class d<R>
{
  private R a;
  private Object b = new Object();
  private final long c;
  private long d;
  private long e;
  private boolean f = false;
  private Runnable g = new d.1(this);
  
  public d(long paramLong, R paramR, boolean paramBoolean)
  {
    this.c = paramLong;
    this.a = paramR;
    this.f = paramBoolean;
  }
  
  public R a(a parama)
  {
    if (parama == null)
    {
      c.c.a("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now", new Object[0]);
      return b();
    }
    c.c.b("MicroMsg.SDK.SyncTask", "sync task exec...", new Object[0]);
    this.d = h.a();
    try
    {
      synchronized (this.b)
      {
        c.c.b("MicroMsg.SDK.SyncTask", "sync task exec at synchronized", new Object[0]);
        parama.a(this.g, false);
        this.b.wait(this.c);
      }
      long l;
      return this.a;
    }
    catch (InterruptedException parama)
    {
      c.c.a("MicroMsg.SDK.SyncTask", parama, "", new Object[0]);
      l = h.a(this.d);
      parama = new StringBuilder();
      parama.append("");
      parama.append(this.a);
      c.c.b("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new Object[] { parama.toString(), Long.valueOf(l), Long.valueOf(this.e), Long.valueOf(l - this.e) });
    }
  }
  
  public void a(R arg1)
  {
    c.c.b("MicroMsg.SDK.SyncTask", "setResultFinish ", new Object[0]);
    this.a = ???;
    synchronized (this.b)
    {
      c.c.b("MicroMsg.SDK.SyncTask", "setResultFinish synchronized", new Object[0]);
      this.b.notify();
      return;
    }
  }
  
  protected abstract R b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.d
 * JD-Core Version:    0.7.0.1
 */