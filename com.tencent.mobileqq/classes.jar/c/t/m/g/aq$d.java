package c.t.m.g;

import java.util.ArrayList;
import java.util.List;

final class aq$d
  extends aq.a
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d = false;
  public List<ba.a> e;
  int f;
  private int g;
  
  public aq$d(aq paramaq, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramaq, (byte)0);
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
      int m = aq.e(this.h).size();
      if (m == 0) {}
      for (;;)
      {
        this.e = ((List)localObject1);
        if ((this.e != null) && (this.e.size() != 0)) {
          break;
        }
        aq.g(this.h);
        return;
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        i = 0;
        int j = 0;
        while ((i < m) && (j < aq.d()))
        {
          String str = (String)aq.e(this.h).get(i);
          ((List)localObject1).add(new ba.a(0L, str));
          ((List)localObject2).add(str);
          j += 1;
          i += 1;
        }
        i = 0;
        while (i < ((List)localObject2).size())
        {
          aq.e(this.h).remove(((List)localObject2).get(i));
          i += 1;
        }
        if (aq.e(this.h).size() == 0) {
          this.a = true;
        }
      }
    }
    int i = x.a.a("report_clear_db_num", 1, 10000, 1000);
    if (ba.a(this.h.b()).a(i)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.e = ((List)localObject1);
      break;
      localObject1 = ba.a(this.h.b()).b(aq.d() + 1);
      if (((List)localObject1).size() <= aq.d())
      {
        this.a = true;
        aq.a(this.h, true);
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
    aq.i(this.h).a((byte[])localObject1, i, this.b, this, aq.h(this.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.aq.d
 * JD-Core Version:    0.7.0.1
 */