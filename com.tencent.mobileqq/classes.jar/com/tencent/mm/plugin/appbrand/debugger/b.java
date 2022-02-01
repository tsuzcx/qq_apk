package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.wxa.jx.bd;
import com.tencent.luggage.wxa.jx.u;
import org.json.JSONObject;

public class b
  extends u<com.tencent.luggage.wxa.iu.b>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "remoteDebugInfo";
  
  public String a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject)
  {
    paramb = bd.b(paramb);
    if ((paramb instanceof com.tencent.luggage.wxa.du.c)) {
      paramb = (c)((com.tencent.luggage.wxa.du.c)paramb).d(c.class);
    } else {
      paramb = null;
    }
    if (paramb == null) {
      return b("fail:not debug");
    }
    paramb.a(paramJSONObject.toString());
    return b("ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.b
 * JD-Core Version:    0.7.0.1
 */