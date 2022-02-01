package com.tencent.luggage.wxa.cj;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public abstract class a<CONTEXT extends h>
  extends com.tencent.luggage.wxa.jx.a<CONTEXT>
{
  protected abstract void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt);
  
  protected abstract boolean a(JSONObject paramJSONObject);
  
  public void b(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    if (i.a.g())
    {
      a(paramCONTEXT, paramJSONObject, paramInt);
      return;
    }
    c localc = ((d)e.a(d.class)).a(paramCONTEXT, paramJSONObject);
    if (localc == null)
    {
      o.b("Luggage.BaseLoginJsApi", "%s.invoke: loginLogic is null, return", new Object[] { d() });
      paramCONTEXT.a(paramInt, b("fail:not supported"));
      return;
    }
    int i;
    if ((localc.a(d(), paramCONTEXT, paramJSONObject)) && (a(paramJSONObject))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      o.b("Luggage.BaseLoginJsApi", "%s.invoke: canLogin:false return", new Object[] { d() });
      paramCONTEXT.a(paramInt, b("fail:not login"));
      return;
    }
    o.d("Luggage.BaseLoginJsApi", "invoke loginLogic, api=%s, callbackId=%s", new Object[] { d(), Integer.valueOf(paramInt) });
    localc.a(paramCONTEXT, new a.1(this, paramCONTEXT, paramJSONObject, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cj.a
 * JD-Core Version:    0.7.0.1
 */