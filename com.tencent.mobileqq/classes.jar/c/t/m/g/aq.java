package c.t.m.g;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class aq
{
  private static int e = 20;
  protected AtomicInteger a = new AtomicInteger(0);
  public AtomicInteger b = new AtomicInteger(0);
  public int c;
  private long d;
  private Handler f;
  private ax g;
  private AtomicInteger h = new AtomicInteger(0);
  private List<String> i = new ArrayList();
  private volatile boolean j = false;
  private volatile boolean k = false;
  private int l = 0;
  private long m = 0L;
  private AtomicInteger n = new AtomicInteger(0);
  private volatile boolean o = false;
  private ax.a p = new at(this);
  private final Runnable q = new av(this);
  private final Runnable r = new aw(this);
  
  public aq()
  {
    ay.a(m.a());
    this.f = x.a.a("ReportAction");
    this.g = new ar();
    a(true);
    b(true, false);
    this.c = a();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f.postDelayed(new au(this), 5000L);
    }
    while ((this.d == 0L) || (SystemClock.elapsedRealtime() - this.d <= 1800000L)) {
      return;
    }
    e();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        a(false);
        if ((paramBoolean1) && (paramBoolean2))
        {
          b(false, true);
          if (this.j) {
            if (paramBoolean1) {
              this.k = true;
            }
          }
        }
        else
        {
          b(false, false);
          continue;
        }
        if (paramBoolean1) {
          break label66;
        }
      }
      finally {}
      this.h.set(0);
      label66:
      if ((this.m == 0L) || (SystemClock.elapsedRealtime() - this.m >= this.l * 60 * 1000))
      {
        this.j = true;
        try
        {
          new aq.d(this, paramBoolean1, paramBoolean2).a(true);
        }
        catch (Throwable localThrowable)
        {
          this.j = false;
        }
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      if (this.n.get() > 3) {
        this.n.set(0);
      }
    }
    do
    {
      return;
      af.a().a(this.q, false, x.a.a("report_real_timer_interval", 1, 60, 5) * 1000);
      return;
      if (paramBoolean1)
      {
        af.a().a(this.r, false, 10000L);
        return;
      }
    } while (this.o);
    af.a().a(this.r, false, x.a.a("report_timer_interval", 30000, 600000, 300000));
  }
  
  private void e()
  {
    this.d = SystemClock.elapsedRealtime();
    int i1 = ck.c("report_missing_event");
    int i2 = ck.c("report_using_traffic");
    int i3 = x.a.a("report_using_traffic_limit", 1, 10240, 32);
    if ((i1 == 0) && (i2 < i3 << 10)) {
      return;
    }
    long l1 = ck.b("report_traffic_last_time");
    if (l1 == 0L)
    {
      ck.a("report_traffic_last_time", System.currentTimeMillis());
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("B110", String.valueOf(i2));
    String str;
    if (l1 < 0L)
    {
      str = "0";
      localHashMap.put("B112", str);
      if (i1 != 0) {
        break label157;
      }
      q.b("HLReportEvent", m.c(), 0, "", localHashMap, null, false);
    }
    for (;;)
    {
      ck.a("report_using_traffic", 0);
      return;
      str = String.valueOf(l1);
      break;
      label157:
      localHashMap.put("B111", String.valueOf(i1));
      q.b("HLReportEvent", m.c(), -500, "", localHashMap, null, false);
      ck.a("report_missing_event", 0);
    }
  }
  
  public abstract int a();
  
  public abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.aq
 * JD-Core Version:    0.7.0.1
 */