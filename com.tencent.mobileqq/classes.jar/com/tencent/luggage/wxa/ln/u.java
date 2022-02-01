package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class u
  extends a<b>
{
  public static final int CTRL_INDEX = 198;
  public static final String NAME = "setNavigationBarColor";
  
  public void a(b paramb, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      int j = g.b(paramJSONObject.getString("frontColor"));
      int k = g.b(paramJSONObject.getString("backgroundColor"));
      double d = paramJSONObject.optDouble("alpha", 1.0D);
      paramJSONObject = paramJSONObject.optJSONObject("animation");
      int i;
      if (paramJSONObject != null)
      {
        i = paramJSONObject.optInt("duration");
        paramJSONObject = paramJSONObject.optString("timingFunc");
      }
      else
      {
        paramJSONObject = "";
        i = 0;
      }
      paramJSONObject = new u.1(this, paramb, paramInt, paramJSONObject, k, i, j, d);
      if ((!(paramb instanceof com.tencent.mm.plugin.appbrand.page.u)) && (paramb.q().F())) {
        paramb.q().c(paramJSONObject);
      } else {
        paramb.a(paramJSONObject);
      }
      paramb.a(paramInt, b("ok"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      label134:
      break label134;
    }
    o.b("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
    paramb.a(paramInt, b("fail:invalid color"));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.u
 * JD-Core Version:    0.7.0.1
 */