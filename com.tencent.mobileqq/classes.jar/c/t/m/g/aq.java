package c.t.m.g;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
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
          new d(paramBoolean1, paramBoolean2).a(true);
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
  
  public abstract class a
    implements Runnable
  {
    private a() {}
    
    public final void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (!aq.a(aq.this).postAtFrontOfQueue(this)) {
          aq.a(aq.this).post(this);
        }
        return;
      }
      aq.a(aq.this).post(this);
    }
  }
  
  public final class b
    extends aq.a
  {
    private String a;
    private boolean b;
    private boolean c;
    
    public b(String paramString)
    {
      super((byte)0);
      this.a = paramString;
      this.b = false;
      this.c = true;
    }
    
    public final void run()
    {
      aq.b(aq.this).decrementAndGet();
      if (TextUtils.isEmpty(this.a)) {}
      int i;
      do
      {
        return;
        i = x.a.a("report_new_record_num", 1, 50, 10);
        if (ba.a(aq.this.b()).b(this.a) == -1L) {
          break;
        }
        if (aq.c(aq.this))
        {
          aq.a(aq.this, false);
          aq.b(aq.this, false);
        }
      } while (aq.d(aq.this).incrementAndGet() < i);
      aq.a(aq.this, false, this.c);
      return;
      aq.c();
    }
  }
  
  final class c
    extends aq.a
  {
    private aq.d a;
    
    public c(aq.d paramd)
    {
      super((byte)0);
      this.a = paramd;
    }
    
    public final void run()
    {
      aq.g(aq.this);
      aq.a(aq.this, SystemClock.elapsedRealtime());
      int j;
      int i;
      if (this.a.d)
      {
        if (aq.j(aq.this) > 0) {
          aq.k(aq.this);
        }
        aq.this.a.addAndGet(this.a.f);
        if (!this.a.b)
        {
          j = this.a.e.size();
          ArrayList localArrayList = new ArrayList();
          i = 0;
          while (i < j)
          {
            localArrayList.add(Long.valueOf(((ba.a)this.a.e.get(i)).a));
            i += 1;
          }
          ba.a(aq.this.b()).a(localArrayList);
          if (aq.l(aq.this))
          {
            aq.m(aq.this);
            aq.a(aq.this, true, this.a.c);
          }
        }
      }
      label363:
      label372:
      for (;;)
      {
        return;
        if (!this.a.a)
        {
          SystemClock.sleep(200L);
          aq.a(aq.this, this.a.b, this.a.c);
          return;
        }
        aq.a(aq.this, true);
        return;
        if (x.h())
        {
          if (aq.j(aq.this) <= 0) {
            break label363;
          }
          i = x.a.a("report_interval_forbid_limit", 30, 1440, 60);
          if (aq.j(aq.this) < i) {
            aq.n(aq.this);
          }
        }
        for (;;)
        {
          if ((!this.a.c) || (!this.a.b)) {
            break label372;
          }
          j = this.a.e.size();
          i = 0;
          while (i < j)
          {
            ba.a(aq.this.b()).b(((ba.a)this.a.e.get(i)).b);
            i += 1;
          }
          break;
          aq.o(aq.this);
        }
      }
    }
  }
  
  final class d
    extends aq.a
  {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d = false;
    public List<ba.a> e;
    int f;
    private int g;
    
    public d(boolean paramBoolean1, boolean paramBoolean2)
    {
      super((byte)0);
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.g = 0;
    }
    
    public final void run()
    {
      Object localObject2 = null;
      Object localObject1 = null;
      int k = 0;
      this.a = false;
      aq.a(x.a.a("report_max_report_count", 10, 100, 20));
      if (this.b)
      {
        int m = aq.e(aq.this).size();
        if (m == 0) {}
        for (;;)
        {
          this.e = ((List)localObject1);
          if ((this.e != null) && (this.e.size() != 0)) {
            break;
          }
          aq.g(aq.this);
          return;
          localObject2 = new ArrayList();
          localObject1 = new ArrayList();
          i = 0;
          int j = 0;
          while ((i < m) && (j < aq.d()))
          {
            String str = (String)aq.e(aq.this).get(i);
            ((List)localObject1).add(new ba.a(0L, str));
            ((List)localObject2).add(str);
            j += 1;
            i += 1;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            aq.e(aq.this).remove(((List)localObject2).get(i));
            i += 1;
          }
          if (aq.e(aq.this).size() == 0) {
            this.a = true;
          }
        }
      }
      int i = x.a.a("report_clear_db_num", 1, 10000, 1000);
      if (ba.a(aq.this.b()).a(i)) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        this.e = ((List)localObject1);
        break;
        localObject1 = ba.a(aq.this.b()).b(aq.d() + 1);
        if (((List)localObject1).size() <= aq.d())
        {
          this.a = true;
          aq.a(aq.this, true);
        }
        else
        {
          ((List)localObject1).remove(((List)localObject1).size() - 1);
        }
      }
      localObject1 = new StringBuilder();
      i = k;
      while (i < this.e.size())
      {
        ((StringBuilder)localObject1).append(((ba.a)this.e.get(i)).b).append("\n");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (this.b)
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("client_report_time")) {
          localObject1 = ((String)localObject2).replace("client_report_time", cn.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }
      }
      localObject1 = ((String)localObject1).getBytes();
      i = localObject1.length;
      this.f = i;
      localObject1 = x.a.a((byte[])localObject1);
      aq.b(localObject1.length);
      aq.i(aq.this).a((byte[])localObject1, i, this.b, this, aq.h(aq.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.aq
 * JD-Core Version:    0.7.0.1
 */