package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class bj
{
  private static int d = 20;
  protected AtomicInteger a = new AtomicInteger(0);
  public AtomicInteger b = new AtomicInteger(0);
  public int c;
  private Handler e;
  private bp f;
  private AtomicInteger g = new AtomicInteger(0);
  private List<String> h = new ArrayList();
  private volatile boolean i = false;
  private volatile boolean j = false;
  private int k = 0;
  private long l = 0L;
  private AtomicInteger m = new AtomicInteger(0);
  private volatile boolean n = false;
  private bp.a o = new bm(this);
  private final Runnable p = new bn(this);
  private final Runnable q = new bo(this);
  
  public bj()
  {
    bq.a(ac.a());
    HandlerThread localHandlerThread = new HandlerThread("halley_" + ac.c() + "_" + "ReportAction", 10);
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
    this.f = new bk();
    b(true, false);
    this.c = a();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (;;)
    {
      try
      {
        b(false, true);
        if (!this.i) {
          break label49;
        }
        if (paramBoolean1) {
          this.j = true;
        }
        return;
      }
      finally {}
      b(false, false);
      continue;
      label49:
      if (!paramBoolean1) {
        this.g.set(0);
      }
      if ((this.l != 0L) && (SystemClock.elapsedRealtime() - this.l < this.k * 60 * 1000))
      {
        this.h.clear();
      }
      else
      {
        this.i = true;
        try
        {
          new bj.d(this, paramBoolean1, paramBoolean2).a(true);
        }
        catch (Throwable localThrowable)
        {
          this.i = false;
        }
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      if (this.m.get() > 3) {
        this.m.set(0);
      }
    }
    do
    {
      return;
      ay.a().a(this.p, false, as.a("report_real_timer_interval", 1, 60, 5) * 1000);
      return;
      if (paramBoolean1)
      {
        ay.a().a(this.q, false, 10000L);
        return;
      }
    } while (this.n);
    ay.a().a(this.q, false, as.a("report_timer_interval", 30000, 600000, 300000));
  }
  
  public abstract int a();
  
  public abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.bj
 * JD-Core Version:    0.7.0.1
 */