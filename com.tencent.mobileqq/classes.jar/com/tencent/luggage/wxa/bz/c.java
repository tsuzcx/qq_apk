package com.tencent.luggage.wxa.bz;

import android.app.Activity;
import com.tencent.luggage.setting.ui.WxaSettingActivity;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class c
  extends a<h>
{
  public static final int CTRL_INDEX = 192;
  public static final String NAME = "openSetting";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = paramh.q().A();
    if (localObject == null)
    {
      o.b("Luggage.JsApiOpenSetting", "config is null!");
      paramh.a(paramInt, b("fail:config is null"));
      return;
    }
    Activity localActivity = paramh.G();
    if (localActivity == null)
    {
      paramh.a(paramInt, b("fail"));
      o.b("Luggage.JsApiOpenSetting", "mmActivity is null, invoke fail!");
      return;
    }
    boolean bool = paramJSONObject.optBoolean("withSubscriptions", false);
    paramJSONObject = paramh.getAppId();
    localObject = ((l)localObject).I;
    WxaSettingActivity.a(localActivity, paramJSONObject, ((com.tencent.luggage.wxa.do.c)paramh.q().B()).b, (String)localObject, WxaSettingActivity.a(paramh.y()), new c.1(this, paramh, paramInt, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bz.c
 * JD-Core Version:    0.7.0.1
 */