package com.tencent.luggage.wxa.lv;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class c
  extends a<h>
{
  public static final int CTRL_INDEX = 146;
  public static final String NAME = "showShareMenu";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramh.v();
    if (paramJSONObject != null) {
      paramJSONObject.a(b.d.ordinal(), false);
    }
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lv.c
 * JD-Core Version:    0.7.0.1
 */