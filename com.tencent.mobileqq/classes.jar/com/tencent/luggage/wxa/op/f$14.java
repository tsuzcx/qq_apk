package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.lp.j;

class f$14
  extends c.c
{
  f$14(f paramf) {}
  
  public void a(c.d paramd)
  {
    String str = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause, type: ");
    localStringBuilder.append(paramd);
    com.tencent.luggage.wxa.qz.o.d(str, localStringBuilder.toString());
    f.b(this.a, true);
    if (f.n(this.a))
    {
      com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "pipVideo has stopped, skip");
      return;
    }
    if (f.d(this.a) == null) {
      return;
    }
    paramd = f.d(this.a).g;
    if (paramd != null)
    {
      if (paramd.e())
      {
        com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "background play enabled, skip");
        return;
      }
      com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "onPause, pause");
      paramd.g();
      f.c(this.a, true);
    }
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "onResume");
    f.b(this.a, false);
    if (f.n(this.a))
    {
      com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "pipVideo has stopped, skip");
      return;
    }
    if (f.d(this.a) == null) {
      return;
    }
    j localj = f.d(this.a).g;
    if (localj != null)
    {
      if (localj.e())
      {
        com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "background play enabled, skip");
        return;
      }
      com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "onResume, start");
      localj.f();
      f.c(this.a, false);
    }
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "onDestroy");
    if (f.d(this.a) != null)
    {
      j localj = f.d(this.a).g;
      if (localj != null) {
        localj.h();
      }
    }
    f.i(this.a).setPipPageLifeCycleListener(null);
    c.b(f.o(this.a).aa(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.14
 * JD-Core Version:    0.7.0.1
 */