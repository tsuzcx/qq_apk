package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class e
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 779;
  public static final String NAME = "showShareTimelineMenu";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiShowShareTimelineMenu", "invoke showShareTimelineMenu");
    if (paramh == null) {
      return;
    }
    if (paramh.v() == null)
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    if (paramh.v().d(b.e.ordinal()) == null)
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    paramh.v().d(b.e.ordinal()).a(false);
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.e
 * JD-Core Version:    0.7.0.1
 */