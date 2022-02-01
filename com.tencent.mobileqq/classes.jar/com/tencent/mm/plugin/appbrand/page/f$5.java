package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.jj.a.g;
import com.tencent.luggage.wxa.jj.a.h;
import com.tencent.luggage.wxa.qa.a.b;
import java.util.ArrayList;
import java.util.HashMap;

class f$5
  implements a.b
{
  f$5(f paramf, a.g paramg) {}
  
  public void a(int paramInt, String paramString)
  {
    this.b.getContainer().f(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("pagePath", paramString);
    localHashMap.put("text", ((a.h)this.a.g.get(paramInt)).b);
    localHashMap.put("index", Integer.valueOf(paramInt));
    this.b.getCurrentPageView().a(new f.a().a(localHashMap), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f.5
 * JD-Core Version:    0.7.0.1
 */