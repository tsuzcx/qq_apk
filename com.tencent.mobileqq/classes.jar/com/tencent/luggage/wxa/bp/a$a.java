package com.tencent.luggage.wxa.bp;

import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.pd.l.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.n.c;
import java.util.concurrent.atomic.AtomicInteger;

class a$a
  implements l.b
{
  private final String e;
  private final String f;
  private final long g = this.a;
  private boolean h = false;
  private n.c i = null;
  private final AtomicInteger j = new AtomicInteger(2);
  
  a$a(String paramString1, String paramString2)
  {
    this.e = paramString2;
    Object localObject1;
    this.f = localObject1;
  }
  
  private void a()
  {
    if (this.j.decrementAndGet() == 0)
    {
      Object localObject = this.i;
      long l1;
      if (localObject == null) {
        l1 = this.g;
      } else {
        l1 = ((n.c)localObject).a;
      }
      localObject = this.i;
      long l2;
      if (localObject == null) {
        l2 = System.currentTimeMillis();
      } else {
        l2 = ((n.c)localObject).b;
      }
      localObject = new d.a();
      ((d.a)localObject).a = this.e;
      String str = this.f;
      ((d.a)localObject).b = str;
      ((d.a)localObject).c = af.b(str).length();
      ((c)this.d.y()).a((d.a)localObject, this.h, l1, l2, this.i);
    }
  }
  
  public void a(n.c paramc)
  {
    this.i = paramc;
    a();
  }
  
  public void a(String paramString)
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(this.b) });
    a.a(this.d, this.c, this.a, this.b);
    this.h = true;
    a();
  }
  
  public void b(String paramString)
  {
    o.b("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
    a.c(this.d);
    this.h = false;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.a
 * JD-Core Version:    0.7.0.1
 */