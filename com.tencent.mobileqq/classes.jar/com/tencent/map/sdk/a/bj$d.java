package com.tencent.map.sdk.a;

import java.util.ArrayList;
import java.util.List;

final class bj$d
  extends bj.a
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d = false;
  public List<bs.a> e;
  int f;
  private int g;
  
  public bj$d(bj parambj, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(parambj, (byte)0);
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.g = 0;
  }
  
  public final void run()
  {
    int k = 0;
    this.a = false;
    bj.a(as.a("report_max_report_count", 10, 100, 20));
    boolean bool = this.b;
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (bool)
    {
      int m = bj.e(this.h).size();
      if (m != 0)
      {
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        int j = 0;
        i = 0;
        while ((j < m) && (i < bj.d()))
        {
          String str = (String)bj.e(this.h).get(j);
          ((List)localObject1).add(new bs.a(0L, str));
          ((List)localObject2).add(str);
          j += 1;
          i += 1;
        }
        i = 0;
        while (i < ((List)localObject2).size())
        {
          bj.e(this.h).remove(((List)localObject2).get(i));
          i += 1;
        }
        if (bj.e(this.h).size() == 0) {
          this.a = true;
        }
      }
      this.e = ((List)localObject1);
    }
    else
    {
      i = as.a("report_clear_db_num", 1, 10000, 1000);
      if (bs.a(this.h.b()).a(i))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = bs.a(this.h.b()).b(bj.d() + 1);
        if (((List)localObject1).size() <= bj.d())
        {
          this.a = true;
          bj.a(this.h, true);
        }
        else
        {
          ((List)localObject1).remove(((List)localObject1).size() - 1);
        }
      }
      this.e = ((List)localObject1);
    }
    localObject1 = this.e;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = new StringBuilder();
      i = k;
      while (i < this.e.size())
      {
        ((StringBuilder)localObject1).append(((bs.a)this.e.get(i)).b);
        ((StringBuilder)localObject1).append("\n");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (this.b)
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("client_report_time")) {
          localObject1 = ((String)localObject2).replace("client_report_time", dg.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }
      }
      localObject1 = ((String)localObject1).getBytes();
      i = localObject1.length;
      this.f = i;
      localObject1 = as.a((byte[])localObject1);
      bj.b(localObject1.length);
      bj.i(this.h).a((byte[])localObject1, i, this.b, this, bj.h(this.h), this.g);
      return;
    }
    bj.g(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.bj.d
 * JD-Core Version:    0.7.0.1
 */