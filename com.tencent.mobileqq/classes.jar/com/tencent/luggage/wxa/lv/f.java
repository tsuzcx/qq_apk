package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class f
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 211;
  public static final String NAME = "updateShareMenuDynamic";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = paramh.v();
    if (localObject != null)
    {
      localObject = ((u)localObject).d(b.d.ordinal());
      if (localObject == null)
      {
        paramh.a(paramInt, b("fail:menu item do not exist"));
        return;
      }
      boolean bool = paramJSONObject.optBoolean("isDynamic", false);
      ((com.tencent.luggage.wxa.nu.a)localObject).f().a("enable_share_dynamic", Boolean.valueOf(bool));
      paramh.a(paramInt, b("ok"));
      o.d("MicroMsg.JsApiUpdateShareMenuDynamic", "update share menu dynamic(%s)", new Object[] { Boolean.valueOf(bool) });
      return;
    }
    paramh.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.f
 * JD-Core Version:    0.7.0.1
 */