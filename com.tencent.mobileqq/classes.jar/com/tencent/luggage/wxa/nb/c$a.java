package com.tencent.luggage.wxa.nb;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.s;
import com.tencent.luggage.wxa.ga.a;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.lp.j.a;
import com.tencent.luggage.wxa.qz.o;

class c$a
  implements j
{
  @Nullable
  private j.a b = null;
  private int c = -1;
  private s d = new c.a.1(this);
  
  private c$a(c paramc)
  {
    c.a(this.a).a(this.d);
  }
  
  public String a()
  {
    String str = c.a(this.a).f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getKey, key: ");
    localStringBuilder.append(str);
    o.e("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", localStringBuilder.toString());
    return str;
  }
  
  public void a(@Nullable j.a parama)
  {
    this.b = parama;
    if (parama != null)
    {
      switch (this.c)
      {
      default: 
        return;
      case 7: 
        parama.g(this);
        return;
      case 6: 
        parama.e(this);
        return;
      case 5: 
        parama.d(this);
        return;
      case 4: 
        parama.c(this);
        return;
      case 3: 
        parama.b(this);
        parama.a(this, false);
        return;
      case 2: 
        parama.b(this);
        parama.a(this, true);
        return;
      case 1: 
        parama.b(this);
        return;
      }
      parama.a(this);
    }
  }
  
  @Nullable
  public Integer b()
  {
    Integer localInteger = c.a(this.a).g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOriginPageViewId, originPageViewId: ");
    localStringBuilder.append(localInteger);
    o.e("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", localStringBuilder.toString());
    return localInteger;
  }
  
  public int c()
  {
    return -1;
  }
  
  public int d()
  {
    return -1;
  }
  
  public boolean e()
  {
    return c.a(this.a).r();
  }
  
  public void f()
  {
    c.a(this.a).h();
  }
  
  public void g()
  {
    c.a(this.a).i();
  }
  
  public void h()
  {
    c.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nb.c.a
 * JD-Core Version:    0.7.0.1
 */