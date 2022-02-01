package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import java.util.concurrent.ConcurrentLinkedDeque;

class d$1
  extends ConcurrentLinkedDeque<j>
{
  d$1(d paramd) {}
  
  public boolean a(j paramj)
  {
    boolean bool = super.add(paramj);
    if ((paramj instanceof l))
    {
      o.d("MicroMsg.AppBrandRuntime", "mConfigs.add(AppBrandSysConfig[%s]) appId[%s], ret[%b]", new Object[] { paramj.getClass().getName(), this.a.aa(), Boolean.valueOf(bool) });
      ad.a(this.a, true);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.1
 * JD-Core Version:    0.7.0.1
 */