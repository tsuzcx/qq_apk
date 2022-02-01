package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class ap
  extends a<u>
{
  public static final int CTRL_INDEX = 0;
  public static final String NAME = "openLink";
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (af.c(paramJSONObject))
    {
      paramu.a(paramInt, b("fail"));
      return;
    }
    ((z)paramu.a(z.class)).a(paramu.getContext(), paramJSONObject, null);
    paramu.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ap
 * JD-Core Version:    0.7.0.1
 */