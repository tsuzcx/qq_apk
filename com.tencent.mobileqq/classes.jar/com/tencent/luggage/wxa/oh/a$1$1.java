package com.tencent.luggage.wxa.oh;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, com.tencent.luggage.wxa.iu.d paramd) {}
  
  public void run()
  {
    if (this.a.au()) {
      return;
    }
    o.d("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.d(this.b.a).getAppId() });
    HashMap localHashMap = new HashMap();
    a.a(this.b.a, localHashMap, ((com.tencent.luggage.wxa.ed.d)this.a).a());
    localHashMap.put("state", com.tencent.luggage.wxa.ix.b.a);
    localHashMap.put("wxaData", com.tencent.luggage.wxa.of.b.a(this.a));
    this.b.a.a(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oh.a.1.1
 * JD-Core Version:    0.7.0.1
 */