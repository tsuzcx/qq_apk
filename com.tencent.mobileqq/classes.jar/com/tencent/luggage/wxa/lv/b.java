package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 795;
  public static final String NAME = "hideShareTimelineMenu";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiHideShareTimelineMenu", "invoke hideShareTimelineMenu");
    if (paramh == null) {
      return;
    }
    if (paramh.v() == null)
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    if (paramh.v().d(com.tencent.luggage.wxa.nu.b.e.ordinal()) == null)
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    paramh.v().d(com.tencent.luggage.wxa.nu.b.e.ordinal()).a(true);
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.b
 * JD-Core Version:    0.7.0.1
 */