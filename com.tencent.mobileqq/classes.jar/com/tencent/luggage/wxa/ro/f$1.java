package com.tencent.luggage.wxa.ro;

import com.tencent.luggage.wxa.rn.a;
import com.tencent.luggage.wxa.rp.f.a;

class f$1
  implements f.a
{
  f$1(f paramf) {}
  
  public void a()
  {
    g.a().a(this.a);
  }
  
  public void a(Object paramObject)
  {
    g.a().c();
    synchronized (this.a)
    {
      f.a(this.a, f.a(this.a));
      f.b(this.a, null);
      if (!f.b(this.a)) {
        f.a(this.a, paramObject);
      }
      if (f.c(this.a)) {
        a.c("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
      }
      if (f.d(this.a) == f.d.e)
      {
        a.c("Vending.Pipeline", "interrupted, just return", new Object[0]);
        return;
      }
      if (f.d(this.a) == f.d.d)
      {
        a.c("Vending.Pipeline", "pausing, just return.", new Object[0]);
        return;
      }
      a.c("Vending.Pipeline", "last one resolved, dequeue next.", new Object[0]);
      f.a(this.a, f.d.b);
      f.e(this.a);
      f.f(this.a);
      return;
    }
  }
  
  public void b()
  {
    f.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.f.1
 * JD-Core Version:    0.7.0.1
 */