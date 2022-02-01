package com.tencent.luggage.wxa.du;

import com.tencent.luggage.wxa.pd.m;
import com.tencent.luggage.wxa.pd.m.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.v;

class b$3
  implements Runnable
{
  b$3(b paramb, String paramString) {}
  
  public void run()
  {
    if (this.b.d()) {}
    try
    {
      localObject1 = new f(this.a);
      localObject2 = this.b.y();
      localObject2.getClass();
      ((f)localObject1).a((com.tencent.luggage.wxa.iu.h)localObject2);
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      label44:
      String str;
      break label44;
    }
    o.b("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
    return;
    if ("__APP__".equals(this.a))
    {
      b.a(this.b);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a);
    str = this.a;
    localObject1 = "/";
    if (str.endsWith("/")) {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("app-service.js");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = ad.b(((c)this.b.y()).i()).a((String)localObject1).b();
    m.a(((c)this.b.y()).i(), ((c)this.b.y()).getJsRuntime(), (String)localObject2, (String)localObject1, "", "", m.a.b, new b.e((String)localObject1, (c)this.b.y(), null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.b.3
 * JD-Core Version:    0.7.0.1
 */