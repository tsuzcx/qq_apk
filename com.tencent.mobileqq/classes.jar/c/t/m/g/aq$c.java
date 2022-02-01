package c.t.m.g;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class aq$c
  extends aq.a
{
  private aq.d a;
  
  public aq$c(aq paramaq, aq.d paramd)
  {
    super(paramaq, (byte)0);
    this.a = paramd;
  }
  
  public final void run()
  {
    aq.g(this.b);
    aq.a(this.b, SystemClock.elapsedRealtime());
    boolean bool = this.a.d;
    int i = 0;
    int j = 0;
    if (bool)
    {
      if (aq.j(this.b) > 0) {
        aq.k(this.b);
      }
      this.b.a.addAndGet(this.a.f);
      if (!this.a.b)
      {
        int k = this.a.e.size();
        ArrayList localArrayList = new ArrayList();
        i = j;
        while (i < k)
        {
          localArrayList.add(Long.valueOf(((ba.a)this.a.e.get(i)).a));
          i += 1;
        }
        ba.a(this.b.b()).a(localArrayList);
        if (aq.l(this.b))
        {
          aq.m(this.b);
          aq.a(this.b, true, this.a.c);
          return;
        }
      }
      if (!this.a.a)
      {
        SystemClock.sleep(200L);
        aq.a(this.b, this.a.b, this.a.c);
        return;
      }
      aq.a(this.b, true);
      return;
    }
    if (x.h()) {
      if (aq.j(this.b) > 0)
      {
        j = x.a.a("report_interval_forbid_limit", 30, 1440, 60);
        if (aq.j(this.b) < j) {
          aq.n(this.b);
        }
      }
      else
      {
        aq.o(this.b);
      }
    }
    if ((this.a.c) && (this.a.b))
    {
      j = this.a.e.size();
      while (i < j)
      {
        ba.a(this.b.b()).b(((ba.a)this.a.e.get(i)).b);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.aq.c
 * JD-Core Version:    0.7.0.1
 */