package com.tencent.luggage.wxa.pp;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.kw.h.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class j$3
  implements ag
{
  j$3(j paramj, WeakReference paramWeakReference, c paramc, int paramInt, String paramString) {}
  
  public void a(String paramString, int paramInt, ag.a parama)
  {
    for (;;)
    {
      try
      {
        u localu = (u)this.a.get();
        if (localu == null) {
          return;
        }
        JSONObject localJSONObject = new JSONObject().put("value", paramString).put("keyCode", ((ac)this.b.b()).getLastKeyPressed()).put("inputId", this.c).put("cursor", paramInt);
        if (ag.a.c.equals(parama))
        {
          paramString = new h.a();
          paramString.a(localu.q().ae(), localu.getComponentId()).a();
          paramString.a(localJSONObject.put("data", this.d).toString());
          paramString.a();
          return;
        }
        paramInt = j.5.a[parama.ordinal()];
        if (paramInt == 1) {
          break label182;
        }
        if (paramInt != 2)
        {
          paramString = null;
          if (af.c(paramString)) {
            return;
          }
          localu.a(paramString, localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      paramString = "onKeyboardConfirm";
      continue;
      label182:
      paramString = "onKeyboardComplete";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.j.3
 * JD-Core Version:    0.7.0.1
 */