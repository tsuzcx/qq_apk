package com.tencent.luggage.wxa.bz;

import android.content.Intent;
import com.tencent.luggage.setting.ui.WxaSettingActivity.d;
import com.tencent.luggage.wxa.ci.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c$1
  implements WxaSettingActivity.d
{
  c$1(c paramc, h paramh, int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2)
  {
    o.f("Luggage.JsApiOpenSetting", "settingInfo %s", new Object[] { paramIntent });
    a.a(this.a.q(), paramInt2);
    if (paramIntent == null)
    {
      o.b("Luggage.JsApiOpenSetting", "settingInfo is null, err");
      this.a.a(this.b, this.d.b("fail:authSetting is null, return"));
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("KEY_AUTHORIZE_STR");
    Object localObject2 = paramIntent.getStringExtra("KEY_APP_SUBSCRIPTIONS_SETTING");
    try
    {
      localObject1 = new JSONArray((String)localObject1);
    }
    catch (JSONException paramIntent)
    {
      label88:
      break label88;
    }
    localObject1 = new JSONArray();
    paramIntent = null;
    if (this.c) {}
    try
    {
      paramIntent = new JSONObject((String)localObject2);
    }
    catch (JSONException paramIntent)
    {
      label119:
      break label119;
    }
    paramIntent = new JSONObject();
    localObject2 = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.d());
      localStringBuilder.append(":ok");
      ((JSONObject)localObject2).put("errMsg", localStringBuilder.toString());
      ((JSONObject)localObject2).put("authSetting", localObject1);
      if (this.c) {
        ((JSONObject)localObject2).put("subscriptionsSetting", paramIntent);
      }
    }
    catch (JSONException paramIntent)
    {
      o.b("Luggage.JsApiOpenSetting", "set json error!");
      o.a("Luggage.JsApiOpenSetting", paramIntent, "", new Object[0]);
    }
    this.a.a(this.b, ((JSONObject)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bz.c.1
 * JD-Core Version:    0.7.0.1
 */