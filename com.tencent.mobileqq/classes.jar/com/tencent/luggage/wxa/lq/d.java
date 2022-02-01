package com.tencent.luggage.wxa.lq;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public final class d
  extends a<h>
{
  private static final int CTRL_INDEX = 105;
  private static final String NAME = "showToast";
  private v a;
  
  private static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(8);
    if (!ViewGroup.class.isInstance(paramView.getParent())) {
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    u localu = paramh.v();
    if (localu == null)
    {
      o.c("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
      paramh.a(paramInt, b("fail"));
      return;
    }
    o.d("MicroMsg.JsApiShowToast", "showToast:%s, callbackId:%d", new Object[] { paramJSONObject, Integer.valueOf(paramInt) });
    int i = paramJSONObject.optInt("duration", 1500);
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("icon", "success");
    String str3 = paramJSONObject.optString("image");
    boolean bool2 = paramJSONObject.optBoolean("mask");
    boolean bool1;
    if ((af.c(str2)) && (af.c(str3))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramJSONObject = new d.1(this);
    c.a(paramh.getAppId(), paramJSONObject);
    localu.a(new d.2(this, paramh, bool1, localu, i, paramInt, bool2, str2, str3, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.d
 * JD-Core Version:    0.7.0.1
 */