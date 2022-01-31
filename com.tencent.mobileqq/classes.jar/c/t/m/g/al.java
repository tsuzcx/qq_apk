package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class al
{
  Handler a;
  ar b;
  AtomicInteger c = new AtomicInteger(0);
  List<String> d = new ArrayList();
  volatile boolean e = false;
  volatile boolean f = false;
  protected AtomicInteger g = new AtomicInteger(0);
  AtomicInteger h = new AtomicInteger(0);
  int i;
  AtomicInteger j = new AtomicInteger(0);
  volatile boolean k = false;
  ar.a l = new ar.a(this);
  private final String m = a();
  private long n;
  private final Runnable o = new ap(this);
  private final Runnable p = new aq(this);
  
  public al()
  {
    as.a(l.a());
    HandlerThread localHandlerThread = new HandlerThread(this.m, 10);
    localHandlerThread.start();
    this.a = new Handler(localHandlerThread.getLooper());
    this.b = new am();
    a(true);
    b(true, false);
    this.i = b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.postDelayed(new ao(this), 5000L);
    }
    while ((this.n == 0L) || (SystemClock.elapsedRealtime() - this.n <= 1800000L)) {
      return;
    }
    d();
  }
  
  public abstract String a();
  
  final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        a(false);
        if ((paramBoolean1) && (paramBoolean2))
        {
          b(false, true);
          if (this.e) {
            if (paramBoolean1) {
              this.f = true;
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
      this.c.set(0);
      label66:
      this.e = true;
      try
      {
        new d(paramBoolean1, paramBoolean2).a(true);
      }
      catch (Throwable localThrowable)
      {
        this.e = false;
      }
    }
  }
  
  public abstract int b();
  
  final void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      if (this.j.get() > 3) {
        this.j.set(0);
      }
    }
    do
    {
      return;
      ab.a().a(this.o, v.a("report_real_timer_interval", 1, 60, 5) * 1000);
      return;
      if (paramBoolean1)
      {
        ab.a().a(this.p, 10000L);
        return;
      }
    } while (this.k);
    ab.a().a(this.p, v.a("report_timer_interval", 30000, 600000, 300000));
  }
  
  public abstract String c();
  
  final void d()
  {
    this.n = SystemClock.elapsedRealtime();
    int i1 = cc.c("report_missing_event");
    int i2 = cc.c("report_using_traffic");
    int i3 = v.a("report_using_traffic_limit", 1, 10240, 32);
    if ((i1 == 0) && (i2 < i3 << 10)) {
      return;
    }
    long l1 = cc.b("report_traffic_last_time");
    if (l1 == 0L)
    {
      cc.a("report_traffic_last_time", System.currentTimeMillis());
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("B110", i2);
    String str;
    if (l1 < 0L)
    {
      str = "0";
      localHashMap.put("B112", str);
      if (i1 != 0) {
        break label177;
      }
      cd.b("HLReportEvent", l.c(), 0, "", localHashMap, null, false);
    }
    for (;;)
    {
      cc.a("report_using_traffic", 0);
      return;
      str = l1;
      break;
      label177:
      localHashMap.put("B111", i1);
      cd.b("HLReportEvent", l.c(), -500, "", localHashMap, null, false);
      cc.a("report_missing_event", 0);
    }
  }
  
  abstract class a
    implements Runnable
  {
    private a() {}
    
    public final void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (!al.this.a.postAtFrontOfQueue(this)) {
          al.this.a.post(this);
        }
        return;
      }
      al.this.a.post(this);
    }
  }
  
  final class b
    extends al.a
  {
    private String a;
    private boolean b;
    
    public b(String paramString)
    {
      super((byte)0);
      this.a = paramString;
      this.b = true;
    }
    
    public final void run()
    {
      al.this.h.decrementAndGet();
      if (TextUtils.isEmpty(this.a)) {}
      int i;
      do
      {
        return;
        i = v.a("report_new_record_num", 1, 50, 10);
        if (au.a(al.this.c()).b(this.a) == -1L) {
          break;
        }
        if (al.this.k)
        {
          al.this.k = false;
          al.this.b(false, false);
        }
      } while (al.this.c.incrementAndGet() < i);
      al.this.a(false, this.b);
      return;
      al localal = al.this;
      cc.a("report_missing_event", cc.c("report_missing_event") + 1);
    }
  }
  
  final class c
    extends al.a
  {
    private al.d a;
    
    public c(al.d paramd)
    {
      super((byte)0);
      this.a = paramd;
    }
    
    public final void run()
    {
      int i = 0;
      al.this.e = false;
      int j;
      if (this.a.d)
      {
        al.this.g.addAndGet(this.a.f);
        if (!this.a.b)
        {
          j = this.a.e.size();
          ArrayList localArrayList = new ArrayList();
          i = 0;
          while (i < j)
          {
            localArrayList.add(Long.valueOf(((au.a)this.a.e.get(i)).a));
            i += 1;
          }
          au.a(al.this.c()).a(localArrayList);
          if (al.this.f)
          {
            al.this.f = false;
            al.this.a(true, this.a.c);
          }
        }
      }
      for (;;)
      {
        return;
        if (!this.a.a)
        {
          SystemClock.sleep(200L);
          al.this.a(this.a.b, this.a.c);
          return;
        }
        al.this.k = true;
        return;
        if ((this.a.c) && (this.a.b))
        {
          j = this.a.e.size();
          while (i < j)
          {
            au.a(al.this.c()).b(((au.a)this.a.e.get(i)).b);
            i += 1;
          }
        }
      }
    }
  }
  
  final class d
    extends al.a
  {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d = false;
    public List<au.a> e;
    int f;
    
    public d(boolean paramBoolean1, boolean paramBoolean2)
    {
      super((byte)0);
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    public final void run()
    {
      Object localObject2 = null;
      Object localObject1 = null;
      int k = 0;
      this.a = false;
      if (this.b)
      {
        int m = al.this.d.size();
        if (m == 0) {}
        for (;;)
        {
          this.e = ((List)localObject1);
          if ((this.e != null) && (this.e.size() != 0)) {
            break;
          }
          al.this.e = false;
          return;
          localObject2 = new ArrayList();
          localObject1 = new ArrayList();
          i = 0;
          j = 0;
          while ((i < m) && (j < 10))
          {
            String str = (String)al.this.d.get(i);
            ((List)localObject1).add(new au.a(0L, str));
            ((List)localObject2).add(str);
            j += 1;
            i += 1;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            al.this.d.remove(((List)localObject2).get(i));
            i += 1;
          }
          if (al.this.d.size() == 0) {
            this.a = true;
          }
        }
      }
      int i = v.a("report_clear_db_num", 1, 10000, 1000);
      if (au.a(al.this.c()).a(i)) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        this.e = ((List)localObject1);
        break;
        localObject1 = au.a(al.this.c()).a();
        if (((List)localObject1).size() <= 10)
        {
          this.a = true;
          al.this.k = true;
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
        ((StringBuilder)localObject1).append(((au.a)this.e.get(i)).b).append("\n");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (this.b)
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("client_report_time")) {
          localObject1 = ((String)localObject2).replace("client_report_time", ch.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }
      }
      localObject1 = ((String)localObject1).getBytes();
      i = localObject1.length;
      this.f = i;
      localObject1 = v.a((byte[])localObject1);
      localObject2 = al.this;
      int j = localObject1.length;
      k = cc.c("report_using_traffic");
      if (k == 0) {
        cc.a("report_traffic_last_time", System.currentTimeMillis());
      }
      cc.a("report_using_traffic", j + k);
      al.this.b.a((byte[])localObject1, i, this.b, this, al.this.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.al
 * JD-Core Version:    0.7.0.1
 */