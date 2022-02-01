package com.tencent.ad.tangram.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForDeferredDeeplink;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.statistics.b;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@Keep
public class AdAppReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AdAppReceiver";
  private Map<String, AdClickUtil.Params> data = new HashMap();
  private boolean registered = false;
  
  private void onReceivePackageAdded(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null) || (!TextUtils.equals(paramIntent.getAction(), "android.intent.action.PACKAGE_ADDED")) || (paramIntent.getData() == null) || (TextUtils.isEmpty(paramIntent.getData().getSchemeSpecificPart()))) {
      AdLog.e("AdAppReceiver", "onReceivePackageAdded error");
    }
    do
    {
      String str;
      do
      {
        return;
        str = paramIntent.getData().getSchemeSpecificPart();
        AdLog.i("AdAppReceiver", String.format("onReceivePackageAdded %s", new Object[] { str }));
      } while (!this.data.containsKey(str));
      paramIntent = (AdClickUtil.Params)this.data.get(str);
      this.data.remove(str);
      if (AdClickUtil.isValidForApp(paramIntent))
      {
        b.reportAsync(new WeakReference(paramIntent.activity.get()), paramIntent.ad, 286);
        AdReporterForAnalysis.reportForAppInstalled(paramIntent);
      }
    } while ((!AdClickUtil.isValidForApp(paramIntent)) || (TextUtils.isEmpty(paramIntent.ad.getAppDeeplink())));
    long l = 0L;
    if (paramIntent.ad.isHitWithoutInstallSuccessPage())
    {
      paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
      if (paramContext == null) {
        break label227;
      }
    }
    label227:
    for (l = paramContext.settingsForDeferredDeeplink.delayMillis;; l = 1000L)
    {
      AdThreadManager.INSTANCE.postDelayed(new AdAppReceiver.1(this, paramIntent), 0, l);
      return;
    }
  }
  
  public void observe(AdClickUtil.Params paramParams)
  {
    if (!AdClickUtil.isValidForApp(paramParams))
    {
      AdLog.e("AdAppReceiver", "observe error");
      return;
    }
    AdLog.i("AdAppReceiver", String.format("observe %s", new Object[] { paramParams.ad.getAppPackageName() }));
    this.data.put(paramParams.ad.getAppPackageName(), paramParams);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      AdLog.e("AdAppReceiver", "onReceive error");
    }
    do
    {
      return;
      AdLog.i("AdAppReceiver", "onReceive");
    } while (!TextUtils.equals(paramIntent.getAction(), "android.intent.action.PACKAGE_ADDED"));
    onReceivePackageAdded(paramContext, paramIntent);
  }
  
  public void register(Context paramContext)
  {
    if ((paramContext == null) || (this.registered)) {
      return;
    }
    try
    {
      if (this.registered) {
        return;
      }
    }
    finally {}
    this.registered = true;
    AdLog.i("AdAppReceiver", "register");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    try
    {
      paramContext.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdAppReceiver", "register", paramContext);
    }
  }
  
  public void unregister(Context paramContext)
  {
    if ((paramContext == null) || (!this.registered)) {
      return;
    }
    try
    {
      if (!this.registered) {
        return;
      }
    }
    finally {}
    this.registered = false;
    AdLog.i("AdAppReceiver", "unregister");
    try
    {
      paramContext.unregisterReceiver(this);
      return;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdAppReceiver", "unregisterReceiver", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppReceiver
 * JD-Core Version:    0.7.0.1
 */