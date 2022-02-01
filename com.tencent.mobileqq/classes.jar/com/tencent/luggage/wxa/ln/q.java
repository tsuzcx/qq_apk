package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class q
  extends com.tencent.luggage.wxa.jx.u<b>
{
  private static final int CTRL_INDEX = 413;
  public static final String NAME = "scrollWebviewTo";
  
  public String a(b paramb, JSONObject paramJSONObject)
  {
    if ((paramb instanceof com.tencent.mm.plugin.appbrand.page.u)) {
      paramb = (com.tencent.mm.plugin.appbrand.page.u)paramb;
    } else if ((paramb instanceof h)) {
      paramb = ((h)paramb).v();
    } else {
      paramb = null;
    }
    if (paramb == null) {
      return b("fail:page don't exist");
    }
    long l = paramJSONObject.optLong("duration", 300L);
    if (!paramJSONObject.has("scrollTop")) {
      return b("fail:invalid data");
    }
    try
    {
      int i = Math.round(g.b(new BigDecimal(paramJSONObject.getString("scrollTop")).floatValue()));
      paramb.a(new q.1(this, paramb, i, l));
      return b("ok");
    }
    catch (Exception paramb)
    {
      o.b("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[] { paramb });
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("fail:invalid data ");
      paramJSONObject.append(af.b(paramb.getMessage()));
    }
    return b(paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.q
 * JD-Core Version:    0.7.0.1
 */