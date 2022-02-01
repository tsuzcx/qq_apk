package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 203;
  public static final String NAME = "hideShareMenu";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiHideShareMenu", "invoke");
    paramJSONObject = paramh.v();
    if (paramJSONObject != null) {
      paramJSONObject.a(b.d.ordinal(), true);
    }
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.a
 * JD-Core Version:    0.7.0.1
 */