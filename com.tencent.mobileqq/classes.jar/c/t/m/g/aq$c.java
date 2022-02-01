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
    int j;
    int i;
    if (this.a.d)
    {
      if (aq.j(this.b) > 0) {
        aq.k(this.b);
      }
      this.b.a.addAndGet(this.a.f);
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
        ba.a(this.b.b()).a(localArrayList);
        if (aq.l(this.b))
        {
          aq.m(this.b);
          aq.a(this.b, true, this.a.c);
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
        aq.a(this.b, this.a.b, this.a.c);
        return;
      }
      aq.a(this.b, true);
      return;
      if (x.h())
      {
        if (aq.j(this.b) <= 0) {
          break label363;
        }
        i = x.a.a("report_interval_forbid_limit", 30, 1440, 60);
        if (aq.j(this.b) < i) {
          aq.n(this.b);
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
          ba.a(this.b.b()).b(((ba.a)this.a.e.get(i)).b);
          i += 1;
        }
        break;
        aq.o(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.aq.c
 * JD-Core Version:    0.7.0.1
 */