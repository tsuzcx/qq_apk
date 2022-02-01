package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 70;
  public static final String NAME = "hideKeyboard";
  
  private u a(com.tencent.luggage.wxa.jx.c paramc)
  {
    if ((paramc instanceof u)) {
      return (u)paramc;
    }
    if ((paramc instanceof h)) {
      return ((h)paramc).q().C().getCurrentPage().getCurrentPageView();
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
    return null;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      paramJSONObject = Integer.valueOf(paramJSONObject.getInt("inputId"));
    }
    catch (JSONException paramJSONObject)
    {
      label13:
      break label13;
    }
    paramJSONObject = null;
    l.a(new c.1(this, paramc, paramJSONObject, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.c
 * JD-Core Version:    0.7.0.1
 */