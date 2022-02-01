package com.tencent.luggage.wxa.ln;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qa.d;
import com.tencent.luggage.wxa.qa.i;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class v
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.h>
{
  private static final int CTRL_INDEX = 238;
  private static final String NAME = "setNavigationBarRightButton";
  
  public v()
  {
    com.tencent.luggage.wxa.on.a.a("setNavigationBarRightButton");
  }
  
  protected u a(c paramc)
  {
    if ((paramc instanceof u)) {
      return (u)paramc;
    }
    return ((com.tencent.luggage.wxa.iu.h)paramc).v();
  }
  
  public void a(com.tencent.luggage.wxa.jx.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    u localu = a(paramh);
    com.tencent.luggage.wxa.iu.h localh = bd.b(paramh);
    boolean bool = paramJSONObject.optBoolean("hide", false);
    if (localu == null)
    {
      paramh.a(paramInt, b("fail:page don't exist"));
      return;
    }
    if (localh == null)
    {
      paramh.a(paramInt, b("fail:internal error invalid js component"));
      return;
    }
    localu.b(bool ^ true);
    if ((bool) && (c()))
    {
      paramJSONObject = paramJSONObject.optString("iconPath");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = new i(paramJSONObject, new d(), localh);
        paramJSONObject.a(new v.1(this, localu));
        paramJSONObject.a();
      }
    }
    paramh.a(paramInt, b("ok"));
  }
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.v
 * JD-Core Version:    0.7.0.1
 */