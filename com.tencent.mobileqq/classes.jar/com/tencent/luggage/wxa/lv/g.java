package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class g
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 210;
  public static final String NAME = "updateShareMenuShareTicket";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiUpdateShareMenuShareTicket", "invoke");
    Object localObject = paramh.v();
    if (localObject != null)
    {
      localObject = ((u)localObject).d(b.d.ordinal());
      if (localObject == null)
      {
        paramh.a(paramInt, b("fail:menu item do not exist"));
        return;
      }
      boolean bool = paramJSONObject.optBoolean("withShareTicket", false);
      ((com.tencent.luggage.wxa.nu.a)localObject).f().a("enable_share_with_share_ticket", Boolean.valueOf(bool));
      paramh.a(paramInt, b("ok"));
      o.d("MicroMsg.JsApiUpdateShareMenuShareTicket", "update share menu withShareTicket(%s)", new Object[] { Boolean.valueOf(bool) });
      return;
    }
    paramh.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.g
 * JD-Core Version:    0.7.0.1
 */