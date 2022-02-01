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
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.statistics.c;
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
  
  private void unObserve(String paramString)
  {
    this.data.remove(paramString);
  }
  
  protected AdClickUtil.Params getParams(String paramString)
  {
    if (this.data.containsKey(paramString)) {
      return (AdClickUtil.Params)this.data.get(paramString);
    }
    return null;
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
    if ((paramContext != null) && (paramIntent != null))
    {
      AdLog.i("AdAppReceiver", "onReceive");
      if (TextUtils.equals(paramIntent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
        onReceivePackageAdded(paramContext, paramIntent);
      }
      return;
    }
    AdLog.e("AdAppReceiver", "onReceive error");
  }
  
  protected void onReceivePackageAdded(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "android.intent.action.PACKAGE_ADDED")) && (paramIntent.getData() != null) && (!TextUtils.isEmpty(paramIntent.getData().getSchemeSpecificPart())))
    {
      paramContext = paramIntent.getData().getSchemeSpecificPart();
      AdLog.i("AdAppReceiver", String.format("onReceivePackageAdded %s", new Object[] { paramContext }));
      paramIntent = getParams(paramContext);
      if (paramIntent == null) {
        return;
      }
      unObserve(paramContext);
      if (AdClickUtil.isValidForApp(paramIntent))
      {
        c.reportAsync(new WeakReference(paramIntent.activity.get()), paramIntent.ad, 286);
        AdAnalysisHelperForUtil.reportForAppInstalled(paramIntent);
      }
      if (AdClickUtil.isValidForApp(paramIntent)) {
        AdThreadManager.INSTANCE.postDelayed(new AdAppReceiver.1(this, paramIntent), 0, 1000L);
      }
      return;
    }
    AdLog.e("AdAppReceiver", "onReceivePackageAdded error");
  }
  
  public void register(Context paramContext)
  {
    if (paramContext != null)
    {
      if (this.registered) {
        return;
      }
      try
      {
        if (this.registered) {
          return;
        }
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
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public void unregister(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!this.registered) {
        return;
      }
      try
      {
        if (!this.registered) {
          return;
        }
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
          return;
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppReceiver
 * JD-Core Version:    0.7.0.1
 */