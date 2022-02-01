package com.tencent.luggage.wxa.du;

import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.pd.l.b;
import com.tencent.mm.appbrand.v8.n.c;
import java.util.concurrent.atomic.AtomicInteger;

class b$e
  implements l.b
{
  private final String a;
  private final c b;
  private int c = 0;
  private boolean d = false;
  private n.c e = null;
  private final AtomicInteger f = new AtomicInteger(2);
  private final long g;
  
  private b$e(String paramString, c paramc)
  {
    this.a = paramString;
    this.b = paramc;
    this.g = System.currentTimeMillis();
  }
  
  private void a()
  {
    if (this.f.decrementAndGet() == 0)
    {
      Object localObject = this.e;
      long l1;
      if (localObject == null) {
        l1 = this.g;
      } else {
        l1 = ((n.c)localObject).a;
      }
      localObject = this.e;
      long l2;
      if (localObject == null) {
        l2 = System.currentTimeMillis();
      } else {
        l2 = ((n.c)localObject).b;
      }
      localObject = new d.a();
      ((d.a)localObject).a = this.a;
      ((d.a)localObject).c = this.c;
      this.b.a((d.a)localObject, this.d, l1, l2, this.e);
    }
  }
  
  public void a(n.c paramc)
  {
    this.e = paramc;
    this.c = paramc.sourceLength;
    a();
  }
  
  public void a(String paramString)
  {
    this.d = true;
    a();
  }
  
  public void b(String paramString)
  {
    this.d = false;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.b.e
 * JD-Core Version:    0.7.0.1
 */