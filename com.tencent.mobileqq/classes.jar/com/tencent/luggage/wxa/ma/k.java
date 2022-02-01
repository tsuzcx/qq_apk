package com.tencent.luggage.wxa.ma;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.wxa.mi.d;
import com.tencent.luggage.wxa.mk.c;
import com.tencent.luggage.wxa.qz.o;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class k
{
  public static float a(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    float f1 = 0.0F;
    try
    {
      float f2 = Settings.System.getInt(paramContext, "screen_brightness");
      f1 = f2;
      int i = a();
      return f2 / i;
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      o.a("MicroMsg.VideoPlayerUtils", paramContext, "", new Object[0]);
    }
    return f1;
  }
  
  private static int a()
  {
    int k = 255;
    int j = k;
    try
    {
      Resources localResources = Resources.getSystem();
      j = k;
      int m = localResources.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
      int i = k;
      if (m != 0)
      {
        j = k;
        i = localResources.getInteger(m);
      }
      j = i;
      o.e("MicroMsg.VideoPlayerUtils", "getMaxBrightness %d", new Object[] { Integer.valueOf(i) });
      return i;
    }
    catch (Exception localException)
    {
      label62:
      break label62;
    }
    o.d("MicroMsg.VideoPlayerUtils", "get max brightness fail, fallback to 255");
    return j;
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 3600000L) {
      localObject = "mm:ss";
    } else {
      localObject = "HH:mm:ss";
    }
    Object localObject = new SimpleDateFormat((String)localObject);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
    return ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
  }
  
  public static void a(Context paramContext, float paramFloat)
  {
    if (!(paramContext instanceof Activity)) {
      return;
    }
    float f;
    if (paramFloat < 0.01F)
    {
      f = 0.01F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
    paramContext = (Activity)paramContext;
    WindowManager.LayoutParams localLayoutParams = paramContext.getWindow().getAttributes();
    localLayoutParams.screenBrightness = f;
    paramContext.getWindow().setAttributes(localLayoutParams);
  }
  
  public static boolean a(com.tencent.luggage.wxa.mi.b paramb)
  {
    return paramb instanceof d;
  }
  
  public static boolean a(String paramString)
  {
    return com.tencent.luggage.wxa.mf.b.b(paramString);
  }
  
  public static float b(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      return 1.0F;
    }
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F) {
      return a(paramContext);
    }
    return localLayoutParams.screenBrightness;
  }
  
  public static boolean b(com.tencent.luggage.wxa.mi.b paramb)
  {
    return paramb instanceof c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.k
 * JD-Core Version:    0.7.0.1
 */