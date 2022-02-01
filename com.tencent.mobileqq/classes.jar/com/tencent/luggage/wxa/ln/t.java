package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class t
  extends a<h>
{
  public static final int CTRL_INDEX = 388;
  public static final String NAME = "setMenuStyle";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiSetMenuStyle", "JsApiSetMenuStyle!");
    if (paramJSONObject == null)
    {
      paramh.a(paramInt, b("fail:data is null"));
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetMenuStyle", "data is null");
      return;
    }
    paramJSONObject = paramJSONObject.optString("style");
    Object localObject = paramh.q().C().getPageView();
    if (localObject == null)
    {
      paramh.a(paramInt, b("fail view is null"));
      return;
    }
    if (paramJSONObject.equalsIgnoreCase("dark"))
    {
      ((u)localObject).i("dark");
    }
    else
    {
      if (!paramJSONObject.equalsIgnoreCase("light")) {
        break label113;
      }
      ((u)localObject).i("light");
    }
    paramh.a(paramInt, b("ok"));
    return;
    label113:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail invalid style ");
    ((StringBuilder)localObject).append(paramJSONObject);
    paramh.a(paramInt, b(((StringBuilder)localObject).toString()));
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetMenuStyle", "fail invalid style %s", new Object[] { paramJSONObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.t
 * JD-Core Version:    0.7.0.1
 */