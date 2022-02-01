package com.b.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class c
  extends Thread
{
  private static final boolean a = u.a;
  private final BlockingQueue<m<?>> b;
  private final BlockingQueue<m<?>> c;
  private final b d;
  private final p e;
  private volatile boolean f = false;
  private final c.a g;
  
  public c(BlockingQueue<m<?>> paramBlockingQueue1, BlockingQueue<m<?>> paramBlockingQueue2, b paramb, p paramp)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramb;
    this.e = paramp;
    this.g = new c.a(this);
  }
  
  public final void a()
  {
    this.f = true;
    interrupt();
  }
  
  public final void run()
  {
    if (a) {
      u.a("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.d.a();
    label152:
    do
    {
      try
      {
        do
        {
          for (;;)
          {
            localm = (m)this.b.take();
            localm.a("cache-queue-take");
            if (!localm.f()) {
              break;
            }
            localm.b("cache-discard-canceled");
          }
          localObject = this.d.a(localm.d());
          if (localObject != null) {
            break;
          }
          localm.a("cache-miss");
        } while (c.a.a(this.g, localm));
        for (localObject = this.c;; localObject = this.c)
        {
          ((BlockingQueue)localObject).put(localm);
          break;
          if (!((b.a)localObject).a()) {
            break label152;
          }
          localm.a("cache-hit-expired");
          localm.a((b.a)localObject);
          if (c.a.a(this.g, localm)) {
            break;
          }
        }
        localm.a("cache-hit");
        localo = localm.a(new j(((b.a)localObject).a, ((b.a)localObject).g));
        localm.a("cache-hit-parsed");
        if (((b.a)localObject).f >= System.currentTimeMillis()) {
          break;
        }
        i = 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          m localm;
          Object localObject;
          o localo;
          continue;
          int i = 0;
        }
      }
      if (i == 0) {}
      for (localObject = this.e;; localObject = this.e)
      {
        ((p)localObject).a(localm, localo);
        break;
        localm.a("cache-hit-refresh-needed");
        localm.a((b.a)localObject);
        localo.d = true;
        if (!c.a.a(this.g, localm))
        {
          this.e.a(localm, localo, new c.1(this, localm));
          break;
        }
      }
    } while (!this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.c
 * JD-Core Version:    0.7.0.1
 */