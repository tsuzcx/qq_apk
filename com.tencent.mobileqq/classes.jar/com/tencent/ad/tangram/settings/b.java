package com.tencent.ad.tangram.settings;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.statistics.a;
import java.nio.charset.Charset;
import org.json.JSONObject;

final class b
{
  private static final String TAG = "AdSettingsUtil";
  
  public static boolean isValid(gdt_settings.Settings paramSettings)
  {
    boolean bool = false;
    if (paramSettings == null) {
      return false;
    }
    try
    {
      long l1 = Long.valueOf(paramSettings.timeExpiredMillis).longValue();
      long l2 = System.currentTimeMillis();
      if (l2 < l1) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramSettings)
    {
      AdLog.e("AdSettingsUtil", "isValid", paramSettings);
    }
    return false;
  }
  
  public static gdt_settings.Settings load(Context paramContext, int paramInt, String paramString)
  {
    AdLog.i("AdSettingsUtil", String.format("load %s", new Object[] { paramString }));
    if (!TextUtils.isEmpty(paramString))
    {
      AdHttp.Params localParams = new AdHttp.Params();
      localParams.setUrl(paramString);
      localParams.method = "GET";
      localParams.contentType = "application/json";
      localParams.connectTimeoutMillis = 3000;
      localParams.readTimeoutMillis = 3000;
      if (localParams.canSend())
      {
        AdHttp.send(localParams);
        a.reportForSettingsStatisticsEnd(paramContext, null, localParams, paramInt);
        if ((localParams.isSuccess()) && (localParams.responseData != null)) {
          try
          {
            paramContext = Charset.forName("UTF-8");
            if (paramContext != null)
            {
              paramContext = toObject(new String(localParams.responseData, paramContext));
              return paramContext;
            }
          }
          catch (Throwable paramContext)
          {
            AdLog.e("AdSettingsUtil", "load", paramContext);
          }
        }
      }
    }
    AdLog.e("AdSettingsUtil", String.format("load error %s", new Object[] { paramString }));
    return null;
  }
  
  public static gdt_settings.Settings toObject(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (gdt_settings.Settings)gdt_settings.Settings.class.cast(AdJSON.toObject(new JSONObject(paramString), gdt_settings.Settings.class));
      return paramString;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdSettingsUtil", "toObject", paramString);
    }
    return null;
  }
  
  public static String toString(gdt_settings.Settings paramSettings)
  {
    if (paramSettings == null) {
      return null;
    }
    try
    {
      paramSettings = AdJSON.fromObject(paramSettings);
    }
    catch (Throwable paramSettings)
    {
      AdLog.e("AdSettingsUtil", "toString", paramSettings);
      paramSettings = null;
    }
    if (paramSettings != null)
    {
      if (JSONObject.NULL.equals(paramSettings)) {
        return null;
      }
      return paramSettings.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.b
 * JD-Core Version:    0.7.0.1
 */