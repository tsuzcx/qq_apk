package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class h
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.iu.h>
{
  public static final int CTRL_INDEX = 464;
  public static final String NAME = "updateShareMenuUpdatable";
  
  public void a(com.tencent.luggage.wxa.iu.h paramh, JSONObject paramJSONObject, int paramInt)
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
      boolean bool1 = paramJSONObject.optBoolean("updatable", false);
      String str = paramJSONObject.optString("templateId", "");
      boolean bool2 = paramJSONObject.optBoolean("isPrivateMessage", false);
      ((com.tencent.luggage.wxa.nu.a)localObject).f().a("enable_share_with_updateable_msg", Boolean.valueOf(bool1));
      ((com.tencent.luggage.wxa.nu.a)localObject).f().a("enable_share_with_updateable_msg_template_id", str);
      ((com.tencent.luggage.wxa.nu.a)localObject).f().a("enable_share_with_private_msg", Boolean.valueOf(bool2));
      paramh.a(paramInt, b("ok"));
      o.d("MicroMsg.JsApiUpdateShareMenuUpdatable", "update share menu updatable(%s) isPrivateMessage(%s)", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      return;
    }
    paramh.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.h
 * JD-Core Version:    0.7.0.1
 */