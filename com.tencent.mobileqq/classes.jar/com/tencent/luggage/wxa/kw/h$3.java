package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.pp.i;
import com.tencent.luggage.wxa.pp.z;
import com.tencent.luggage.wxa.pt.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;

class h$3
  implements c
{
  h$3(h paramh, i parami, String paramString, u paramu) {}
  
  public void a(String paramString, int paramInt)
  {
    int i = this.a.a();
    if (this.a.d() == null)
    {
      o.b("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", new Object[] { this.b });
      return;
    }
    h.a locala = new h.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", com.tencent.luggage.wxa.pd.d.a(paramString));
    localHashMap.put("data", this.d.a(i));
    localHashMap.put("cursor", Integer.valueOf(paramInt));
    localHashMap.put("inputId", Integer.valueOf(i));
    localHashMap.put("keyCode", Integer.valueOf(this.a.d().getLastKeyPressed()));
    locala.a(this.c.q().ae(), this.c.getComponentId()).a(localHashMap).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.h.3
 * JD-Core Version:    0.7.0.1
 */