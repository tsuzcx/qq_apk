package com.tencent.luggage.wxa.cj;

import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class e
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "logout";
  
  public static boolean l_()
  {
    if (i.a.g())
    {
      i.a.b();
      com.tencent.luggage.wxa.oo.a.a();
      return true;
    }
    return false;
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    if (l_())
    {
      o.d("Luggage.JsApiLogout", "logout data:%s success", new Object[] { paramJSONObject });
      paramh.a(paramInt, b("ok"));
      return;
    }
    o.b("Luggage.JsApiLogout", "logout data:%s fail", new Object[] { paramJSONObject });
    paramh.a(paramInt, b("fail: not login"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cj.e
 * JD-Core Version:    0.7.0.1
 */