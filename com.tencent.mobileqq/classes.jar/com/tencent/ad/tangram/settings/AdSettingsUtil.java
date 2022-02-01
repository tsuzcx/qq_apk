package com.tencent.ad.tangram.settings;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Keep
public enum AdSettingsUtil
{
  INSTANCE;
  
  private static final String TAG = "AdSettingsUtil";
  private volatile gdt_settings.Settings currentSettings;
  private volatile boolean initialized = false;
  private volatile List<WeakReference<AdSettingsUtil.a>> listeners = new ArrayList();
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
  
  private void notifyUpdated(WeakReference<Context> paramWeakReference, boolean paramBoolean)
  {
    AdThreadManager.INSTANCE.post(new AdSettingsUtil.2(this, paramWeakReference, paramBoolean), 0);
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
  
  public void addListener(WeakReference<AdSettingsUtil.a> paramWeakReference)
  {
    if (paramWeakReference != null) {}
    try
    {
      if (paramWeakReference.get() != null) {
        this.listeners.add(paramWeakReference);
      }
      return;
    }
    finally {}
  }
  
  public gdt_settings.Settings getSettingsCache(Context paramContext)
  {
    if (isValid(this.currentSettings)) {
      return this.currentSettings;
    }
    return null;
  }
  
  public void init(Context paramContext)
  {
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    this.initialized = true;
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      if ((paramContext == null) || (paramContext.get() == null)) {
        break;
      }
      AdThreadManager.INSTANCE.post(new AdSettingsUtil.1(this, paramContext), 4);
      return;
    }
  }
  
  public void update(Context paramContext)
  {
    int i;
    if (paramContext != null)
    {
      paramContext = paramContext.getApplicationContext();
      if (this.currentSettings == null) {
        break label78;
      }
      i = this.currentSettings.intervalMillis;
      label24:
      if (this.currentSettings == null) {
        break label85;
      }
    }
    label78:
    label85:
    for (Object localObject = this.currentSettings.urlForSettings;; localObject = "https://i.gtimg.cn/ams-web/public/tangram-report/settings-android-qq-8-4-5.json")
    {
      localObject = AdUriUtil.replaceHttpsWithHttpForVivoY67OnAndroidM((String)localObject);
      if ((this.loadSettingsTimeMillis == -2147483648L) || (System.currentTimeMillis() - this.loadSettingsTimeMillis >= i)) {
        break label93;
      }
      return;
      paramContext = null;
      break;
      i = 1800000;
      break label24;
    }
    try
    {
      label93:
      if ((this.loadSettingsTimeMillis != -2147483648L) && (System.currentTimeMillis() - this.loadSettingsTimeMillis < i)) {
        return;
      }
    }
    finally {}
    this.loadSettingsTimeMillis = System.currentTimeMillis();
    localObject = load(paramContext, (String)localObject);
    boolean bool = isValid((gdt_settings.Settings)localObject);
    if (bool) {
      this.currentSettings = ((gdt_settings.Settings)localObject);
    }
    notifyUpdated(new WeakReference(paramContext), bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.AdSettingsUtil
 * JD-Core Version:    0.7.0.1
 */