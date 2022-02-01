package com.tencent.luggage.wxa.nf;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.gd.d;
import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.b.b;
import com.tencent.luggage.wxa.mi.b.f;
import com.tencent.luggage.wxa.mi.b.g;
import com.tencent.luggage.wxa.mi.c;
import com.tencent.luggage.wxa.qz.o;

class j$a
  implements com.tencent.luggage.wxa.lp.j
{
  private final String b;
  @Nullable
  private com.tencent.luggage.wxa.lp.j.a c;
  private volatile boolean d;
  private b.f e;
  private b.g f;
  private b.b g;
  
  private j$a(j paramj)
  {
    paramj = new StringBuilder();
    paramj.append("MicroMsg.AppBrand.XWebVideoVideoController#");
    paramj.append(hashCode());
    this.b = paramj.toString();
    this.c = null;
    this.d = false;
    this.e = new j.a.1(this);
    this.f = new j.a.2(this);
    this.g = new j.a.3(this);
    j.b(this.a).a(new j.a.4(this));
  }
  
  public String a()
  {
    return j.b(this.a).p();
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.lp.j.a parama)
  {
    if (parama != null) {
      if (!this.d)
      {
        o.d(this.b, "onLoading from mPrepared");
        parama.a(this);
      }
      else
      {
        o.d(this.b, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    this.c = parama;
  }
  
  @Nullable
  public Integer b()
  {
    Integer localInteger = j.b(this.a).q();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOriginPageViewId, originPageViewId: ");
    localStringBuilder.append(localInteger);
    o.e("MicroMsg.AppBrand.XWebVideoVideoController", localStringBuilder.toString());
    return localInteger;
  }
  
  public int c()
  {
    c localc = this.a.f();
    if (localc == null) {
      return 0;
    }
    return localc.i();
  }
  
  public int d()
  {
    c localc = this.a.f();
    if (localc == null) {
      return 0;
    }
    return localc.j();
  }
  
  public boolean e()
  {
    return j.b(this.a).y();
  }
  
  public void f()
  {
    o.e(this.b, "start");
    j.b(this.a).i();
  }
  
  public void g()
  {
    o.e(this.b, "pause");
    j.b(this.a).j();
  }
  
  public void h()
  {
    o.e(this.b, "release");
    j.b(this.a).k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.j.a
 * JD-Core Version:    0.7.0.1
 */