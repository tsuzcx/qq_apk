package com.b.a;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class h
  extends Thread
{
  private final BlockingQueue<m<?>> a;
  private final g b;
  private final b c;
  private final p d;
  private volatile boolean e = false;
  
  public h(BlockingQueue<m<?>> paramBlockingQueue, g paramg, b paramb, p paramp)
  {
    this.a = paramBlockingQueue;
    this.b = paramg;
    this.c = paramb;
    this.d = paramp;
  }
  
  public final void a()
  {
    this.e = true;
    interrupt();
  }
  
  public final void run()
  {
    Process.setThreadPriority(10);
    label107:
    do
    {
      try
      {
        for (;;)
        {
          m localm = (m)this.a.take();
          SystemClock.elapsedRealtime();
          try
          {
            localm.a("network-queue-take");
            if (localm.f()) {
              localm.b("network-discard-cancelled");
            }
            for (;;)
            {
              localm.r();
              break;
              if (Build.VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(localm.b());
              }
              b.a.a(localm);
              localObject = this.b.a(localm);
              localm.a("network-http-complete");
              if ((!((j)localObject).c) || (!localm.q())) {
                break label107;
              }
              localm.b("not-modified");
            }
            Object localObject = localm.a((j)localObject);
            localm.a("network-parse-complete");
            if ((localm.l()) && (((o)localObject).b != null))
            {
              this.c.a(localm.d(), ((o)localObject).b);
              localm.a("network-cache-written");
            }
            localm.p();
            this.d.a(localm, (o)localObject);
            localm.a((o)localObject);
            b.a.a(localm, (o)localObject);
          }
          catch (Exception localException)
          {
            u.a(localException, "Unhandled exception %s", new Object[] { localException.toString() });
            t localt1 = new t(localException);
            SystemClock.elapsedRealtime();
            this.d.a(localm, localt1);
            localm.r();
            b.a.a(localm, localt1);
          }
          catch (t localt2)
          {
            SystemClock.elapsedRealtime();
            t localt3 = m.a(localt2);
            this.d.a(localm, localt3);
            localm.r();
            b.a.a(localm, localt2);
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label265;
      }
    } while (!this.e);
    label265:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.h
 * JD-Core Version:    0.7.0.1
 */