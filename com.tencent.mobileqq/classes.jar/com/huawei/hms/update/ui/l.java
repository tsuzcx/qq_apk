package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends a
{
  private BroadcastReceiver k;
  private Handler l = new Handler();
  private int m = 0;
  private Handler n = new l.1(this);
  
  private void a(Bundle paramBundle)
  {
    String str = null;
    if (paramBundle.containsKey("UpgradePkgName")) {
      str = paramBundle.getString("UpgradePkgName");
    }
    if ((str == null) || (!str.equals(this.g))) {}
    while (!paramBundle.containsKey("downloadtask.status")) {
      return;
    }
    int i = paramBundle.getInt("downloadtask.status");
    HMSLog.i("SilentUpdateWizard", "handleDownloadStatus-status is " + i);
    if ((i == 3) || (i == 5) || (i == 6) || (i == 8))
    {
      c(i);
      return;
    }
    if (i == 4)
    {
      b(60000);
      return;
    }
    b(20000);
  }
  
  private boolean a(Activity paramActivity)
  {
    if (TextUtils.isEmpty(this.g)) {
      return false;
    }
    Intent localIntent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
    localIntent.setPackage("com.huawei.appmarket");
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pkgName", this.g);
      localJSONObject.put("versioncode", this.i);
      localJSONArray.put(localJSONObject);
      localIntent.putExtra("params", localJSONArray.toString());
      localIntent.putExtra("isHmsOrApkUpgrade", this.c.a());
      localIntent.putExtra("buttonDlgY", ResourceLoaderUtil.getString("hms_install"));
      localIntent.putExtra("buttonDlgN", ResourceLoaderUtil.getString("hms_cancel"));
      localIntent.putExtra("upgradeDlgContent", ResourceLoaderUtil.getString("hms_update_message_new", new Object[] { "%P" }));
      return false;
    }
    catch (JSONException paramActivity)
    {
      try
      {
        HMSLog.i("SilentUpdateWizard", "start silent activity of AppMarket");
        paramActivity.startActivityForResult(localIntent, getRequestCode());
        HMSLog.i("SilentUpdateWizard", "start silent activity finished");
        return true;
      }
      catch (ActivityNotFoundException paramActivity)
      {
        HMSLog.e("SilentUpdateWizard", "ActivityNotFoundException");
      }
      paramActivity = paramActivity;
      HMSLog.e("SilentUpdateWizard", "create hmsJsonObject fail" + paramActivity.getMessage());
      return false;
    }
  }
  
  private void b(int paramInt)
  {
    this.l.removeCallbacksAndMessages(null);
    this.l.postDelayed(new l.a(this, null), paramInt);
  }
  
  private void b(Bundle paramBundle)
  {
    String str = null;
    if (paramBundle.containsKey("UpgradePkgName")) {
      str = paramBundle.getString("UpgradePkgName");
    }
    if ((str == null) || (!str.equals(this.g))) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!paramBundle.containsKey("UpgradeDownloadProgress")) || (!paramBundle.containsKey("UpgradeAppName")));
      int j = paramBundle.getInt("UpgradeDownloadProgress");
      HMSLog.i("SilentUpdateWizard", "handlerDownloadProgress-progress is " + j);
      b(20000);
      i = j;
      if (j >= 99) {
        i = 99;
      }
      this.m = i;
      if (this.d == null) {
        a(f.class);
      }
    } while (this.d == null);
    ((f)this.d).b(i);
  }
  
  private void c(int paramInt)
  {
    this.l.removeCallbacksAndMessages(null);
    e();
    c();
    if (!a(false))
    {
      b(paramInt, this.f);
      return;
    }
    a(paramInt, this.f);
  }
  
  private void c(Bundle paramBundle)
  {
    int i;
    if ((paramBundle.containsKey("packagename")) && (paramBundle.containsKey("status")))
    {
      String str = paramBundle.getString("packagename");
      i = paramBundle.getInt("status");
      HMSLog.i("SilentUpdateWizard", "handlerInstallStatus-status is " + i);
      if ((str != null) && (str.equals(this.g))) {}
    }
    else
    {
      return;
    }
    if (i == 2)
    {
      this.l.removeCallbacksAndMessages(null);
      if (this.d != null) {
        ((f)this.d).b(100);
      }
      b(0, this.f);
      return;
    }
    if ((i == -1) || (i == -2))
    {
      c(i);
      return;
    }
    b(60000);
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.huawei.appmarket.service.downloadservice.Receiver");
    localIntentFilter.addAction("com.huawei.appmarket.service.downloadservice.progress.Receiver");
    localIntentFilter.addAction("com.huawei.appmarket.service.installerservice.Receiver");
    this.k = new com.huawei.hms.update.c.a(this.n);
    Activity localActivity = b();
    if (localActivity != null) {
      localActivity.registerReceiver(this.k, localIntentFilter);
    }
  }
  
  private void e()
  {
    Activity localActivity = b();
    if ((localActivity != null) && (this.k != null))
    {
      localActivity.unregisterReceiver(this.k);
      this.k = null;
    }
  }
  
  void a()
  {
    b(13, this.f);
  }
  
  void a(Class<? extends b> paramClass)
  {
    try
    {
      paramClass = (b)paramClass.newInstance();
      if ((this.m > 0) && ((paramClass instanceof f))) {
        ((f)paramClass).a(this.m);
      }
      paramClass.a(this);
      this.d = paramClass;
      return;
    }
    catch (InstantiationException paramClass)
    {
      HMSLog.e("SilentUpdateWizard", "In showDialog, Failed to show the dialog." + paramClass.getMessage());
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      break label45;
    }
    catch (IllegalStateException paramClass)
    {
      label45:
      break label45;
    }
  }
  
  public int getRequestCode()
  {
    return 2000;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {}
    do
    {
      return;
      this.f = 0;
    } while (a(paramActivity));
    if (!a(true))
    {
      b(8, this.f);
      return;
    }
    a(8, this.f);
  }
  
  public void onBridgeActivityDestroy()
  {
    this.l.removeCallbacksAndMessages(null);
    e();
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.e) && (this.b != null)) {
      return this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent);
    }
    HMSLog.i("SilentUpdateWizard", "onBridgeActivityResult requestCode is " + paramInt1 + "resultCode is " + paramInt2);
    if (paramInt1 == getRequestCode())
    {
      if (paramInt2 == 0)
      {
        d();
        b(20000);
        return true;
      }
      if (paramInt2 == 4)
      {
        a();
        return true;
      }
      if (!a(true))
      {
        b(paramInt2, this.f);
        return true;
      }
      a(paramInt2, this.f);
      return true;
    }
    return false;
  }
  
  public void onBridgeConfigurationChanged()
  {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.l
 * JD-Core Version:    0.7.0.1
 */