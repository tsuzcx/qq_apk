package com.tencent.luggage.wxa.lx;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class h
  extends a
{
  public static final int CTRL_INDEX = 232;
  public static final String NAME = "getScreenBrightness";
  
  private float a(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    try
    {
      float f = Settings.System.getInt(paramContext, "screen_brightness");
      int i = c();
      return f / i;
    }
    catch (Exception paramContext)
    {
      o.b("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[] { paramContext.getMessage() });
    }
    catch (IllegalArgumentException paramContext)
    {
      o.b("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent IllegalArgumentException: %s", new Object[] { paramContext.getMessage() });
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      o.b("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[] { paramContext.getMessage() });
    }
    return 0.0F;
  }
  
  private int c()
  {
    try
    {
      Resources localResources = Resources.getSystem();
      int i = localResources.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
      if (i == 0) {
        break label34;
      }
      i = localResources.getInteger(i);
      return i;
    }
    catch (Exception localException)
    {
      label27:
      label34:
      break label27;
    }
    o.d("MicroMsg.JsApiGetScreenBrightness", "get max brightness fail, fallback to 255");
    return 255;
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.e("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail"));
      o.b("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      paramc.a(paramInt, b("fail"));
      o.b("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
      return;
    }
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramJSONObject).getWindow().getAttributes();
    float f2 = localLayoutParams.screenBrightness;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = a(paramJSONObject);
    }
    o.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", new Object[] { Float.valueOf(f1), Float.valueOf(localLayoutParams.screenBrightness) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("value", Float.valueOf(f1));
    paramc.a(paramInt, a("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.h
 * JD-Core Version:    0.7.0.1
 */