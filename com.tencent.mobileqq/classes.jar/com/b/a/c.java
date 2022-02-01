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
    label73:
    b.a locala;
    for (;;)
    {
      try
      {
        m localm = (m)this.b.take();
        localm.a("cache-queue-take");
        if (!localm.f()) {
          break label73;
        }
        localm.b("cache-discard-canceled");
        continue;
        if (!this.f) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      locala = this.d.a(localInterruptedException.d());
      if (locala == null)
      {
        localInterruptedException.a("cache-miss");
        if (!c.a.a(this.g, localInterruptedException)) {
          this.c.put(localInterruptedException);
        }
      }
      else
      {
        if (!locala.a()) {
          break;
        }
        localInterruptedException.a("cache-hit-expired");
        localInterruptedException.a(locala);
        if (!c.a.a(this.g, localInterruptedException)) {
          this.c.put(localInterruptedException);
        }
      }
    }
    localInterruptedException.a("cache-hit");
    o localo = localInterruptedException.a(new j(locala.a, locala.g));
    localInterruptedException.a("cache-hit-parsed");
    if (locala.f < System.currentTimeMillis()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.e.a(localInterruptedException, localo);
        break;
      }
      localInterruptedException.a("cache-hit-refresh-needed");
      localInterruptedException.a(locala);
      localo.d = true;
      if (!c.a.a(this.g, localInterruptedException))
      {
        this.e.a(localInterruptedException, localo, new c.1(this, localInterruptedException));
        break;
      }
      this.e.a(localInterruptedException, localo);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.c
 * JD-Core Version:    0.7.0.1
 */