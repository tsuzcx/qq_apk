package com.tencent.luggage.wxa.nz;

import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.sj.b;
import com.tencent.mars.cdn.CronetLogic;

class d$2
  extends b
{
  d$2(d paramd, e parame, d.a parama) {}
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandNetworkRequest@");
    localStringBuilder.append(this.a.i());
    return localStringBuilder.toString();
  }
  
  public void run()
  {
    o.b("MicroMsg.AppBrandNetworkRequest", "call cronet time out taskid:%s,timeout:%d,url:%s", new Object[] { this.a.i(), Integer.valueOf(this.a.d()), this.a.a() });
    if (!this.a.q())
    {
      this.a.a(true);
      d.a(this.c, this.b, "fail", "timeout", this.a.i(), null);
    }
    else
    {
      o.b("MicroMsg.AppBrandNetworkRequest", "call cronet time out already callback");
    }
    ((c)com.tencent.luggage.wxa.ba.e.b(c.class)).a(1095L, 6L, 1L, false);
    if (!af.c(this.a.j())) {
      CronetLogic.cancelCronetTask(this.a.j());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.d.2
 * JD-Core Version:    0.7.0.1
 */