package com.tencent.ad.tangram.settings;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import java.nio.charset.Charset;
import org.json.JSONObject;

@Keep
public enum AdSettingsUtil
{
  INSTANCE;
  
  private static final String TAG = "AdSettingsUtil";
  private volatile gdt_settings.Settings currentSettings;
  private volatile long loadSettingsTimeMillis = -2147483648L;
  
  private AdSettingsUtil() {}
  
  private static boolean isValid(gdt_settings.Settings paramSettings)
  {
    if (paramSettings == null) {}
    for (;;)
    {
      return false;
      try
      {
        long l1 = Long.valueOf(paramSettings.timeExpiredMillis).longValue();
        long l2 = System.currentTimeMillis();
        if (l2 < l1) {
          return true;
        }
      }
      catch (Throwable paramSettings)
      {
        AdLog.e("AdSettingsUtil", "isValid", paramSettings);
      }
    }
    return false;
  }
  
  private static gdt_settings.Settings load(Context paramContext, String paramString)
  {
    AdLog.i("AdSettingsUtil", String.format("load %s", new Object[] { paramString }));
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      AdLog.e("AdSettingsUtil", String.format("load error %s", new Object[] { paramString }));
      return null;
      paramContext = new AdHttp.Params();
      paramContext.setUrl(paramString);
      paramContext.method = "GET";
      paramContext.contentType = "application/json";
      paramContext.connectTimeoutMillis = 3000;
      paramContext.readTimeoutMillis = 3000;
      if (paramContext.canSend())
      {
        AdHttp.send(paramContext);
        if ((paramContext.isSuccess()) && (paramContext.responseData != null)) {
          try
          {
            Charset localCharset = Charset.forName("UTF-8");
            if (localCharset != null)
            {
              paramContext = toObject(new String(paramContext.responseData, localCharset));
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
  }
  
  private static gdt_settings.Settings toObject(String paramString)
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
  
  public gdt_settings.Settings getSettingsCache(Context paramContext)
  {
    if (isValid(this.currentSettings)) {
      return this.currentSettings;
    }
    return null;
  }
  
  public void update(Context paramContext)
  {
    int i;
    String str;
    if (this.currentSettings != null)
    {
      i = this.currentSettings.intervalMillis;
      if (this.currentSettings == null) {
        break label62;
      }
      str = this.currentSettings.urlForSettings;
      label30:
      if ((this.loadSettingsTimeMillis == -2147483648L) || (System.currentTimeMillis() - this.loadSettingsTimeMillis >= i)) {
        break label68;
      }
    }
    label62:
    label68:
    do
    {
      return;
      i = 1800000;
      break;
      str = "https://i.gtimg.cn/ams-web/public/tangram-report/settings-android-qq-8-2-8.json";
      break label30;
      try
      {
        if ((this.loadSettingsTimeMillis != -2147483648L) && (System.currentTimeMillis() - this.loadSettingsTimeMillis < i)) {
          return;
        }
      }
      finally {}
      this.loadSettingsTimeMillis = System.currentTimeMillis();
      paramContext = load(paramContext, str);
    } while (!isValid(paramContext));
    this.currentSettings = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.AdSettingsUtil
 * JD-Core Version:    0.7.0.1
 */