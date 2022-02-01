package com.tencent.luggage.wxa.lq;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public final class c
  extends a<h>
{
  private static final int CTRL_INDEX = 104;
  private static final String NAME = "showModal";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    u localu = paramh.v();
    if (localu == null)
    {
      if ((paramh.q() != null) && (!paramh.q().au()) && (!paramh.q().aw()))
      {
        o.c("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { paramh.getAppId(), Integer.valueOf(paramInt) });
        paramh.q().c(new c.1(this, paramh, paramInt, paramJSONObject));
        return;
      }
      o.c("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", new Object[] { paramh.getAppId(), Integer.valueOf(paramInt) });
      paramh.a(paramInt, b("fail:page don't exist"));
      return;
    }
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("confirmText", paramh.getContext().getString(2131891475));
    String str3 = paramJSONObject.optString("cancelText", paramh.getContext().getString(2131891473));
    boolean bool = paramJSONObject.optBoolean("showCancel", true);
    int j;
    int i;
    if (k.a.a())
    {
      j = g.a(paramJSONObject.optString("confirmColorDark", ""), r.a().getResources().getColor(2131165616));
      i = g.a(paramJSONObject.optString("cancelColorDark", ""), r.a().getResources().getColor(2131165569));
    }
    else
    {
      j = g.a(paramJSONObject.optString("confirmColor", ""), r.a().getResources().getColor(2131165616));
      i = g.a(paramJSONObject.optString("cancelColor", ""), r.a().getResources().getColor(2131165569));
    }
    paramJSONObject = paramJSONObject.optString("content");
    o.d("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { paramh.getAppId(), str1, paramJSONObject });
    paramh.a(new c.2(this, paramh, localu, str1, paramJSONObject, str2, paramInt, bool, str3, j, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.c
 * JD-Core Version:    0.7.0.1
 */