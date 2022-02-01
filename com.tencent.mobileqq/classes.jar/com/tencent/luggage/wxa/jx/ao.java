package com.tencent.luggage.wxa.jx;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class ao
  extends a<h>
{
  public static final int CTRL_INDEX = 102;
  public static final String NAME = "makePhoneCall";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("phoneNumber");
    if (af.c(paramJSONObject))
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    Activity localActivity = paramh.G();
    if (localActivity == null)
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.DIAL");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tel:");
      localStringBuilder.append(Uri.encode(paramJSONObject));
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      LuggageActivityHelper.FOR(localActivity).startActivityForResult(localIntent, new ao.1(this, paramh, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      label122:
      break label122;
    }
    o.b("MicroMsg.JsApiMakePhoneCall", "startActivity failed");
    paramh.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ao
 * JD-Core Version:    0.7.0.1
 */