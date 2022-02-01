package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class d
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 202;
  public static final String NAME = "showShareMenuWithShareTicket";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiShowShareMenuWithShareTicket", "invoke");
    paramJSONObject = paramh.v();
    if (paramJSONObject != null)
    {
      paramJSONObject.a(b.d.ordinal(), false);
      paramJSONObject = paramJSONObject.d(b.d.ordinal());
      if (paramJSONObject == null)
      {
        paramh.a(paramInt, b("fail:menu item do not exist"));
        return;
      }
      paramJSONObject.f().a("enable_share_with_share_ticket", Boolean.valueOf(true));
      paramh.a(paramInt, b("ok"));
      return;
    }
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.d
 * JD-Core Version:    0.7.0.1
 */