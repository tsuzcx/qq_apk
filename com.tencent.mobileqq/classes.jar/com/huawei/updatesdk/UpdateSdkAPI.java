package com.huawei.updatesdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import com.huawei.updatesdk.service.otaupdate.UpdateParams.Builder;
import com.huawei.updatesdk.service.otaupdate.d;
import com.huawei.updatesdk.service.otaupdate.e;
import com.huawei.updatesdk.service.otaupdate.g;
import com.huawei.updatesdk.service.otaupdate.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

public final class UpdateSdkAPI
{
  public static final String TAG = "UpdateSdk";
  
  public static void checkAppUpdate(Context paramContext, CheckUpdateCallBack paramCheckUpdateCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {
      return;
    }
    if (com.huawei.updatesdk.a.a.c.b.b.a(paramContext))
    {
      init(paramContext);
      new e(paramContext, new UpdateParams.Builder().setIsShowImmediate(paramBoolean1).setMustBtnOne(paramBoolean2).build(), paramCheckUpdateCallBack).executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
      return;
    }
    if (paramCheckUpdateCallBack != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("status", 2);
      paramCheckUpdateCallBack.onUpdateInfo(localIntent);
    }
    Toast.makeText(paramContext, g.b(paramContext, "upsdk_no_available_network_prompt_toast"), 0).show();
  }
  
  public static void checkAppUpdate(Context paramContext, UpdateParams paramUpdateParams, CheckUpdateCallBack paramCheckUpdateCallBack)
  {
    if ((paramContext == null) || (paramUpdateParams == null) || (paramCheckUpdateCallBack == null)) {}
    long l1;
    long l2;
    do
    {
      return;
      init(paramContext);
      l1 = System.currentTimeMillis();
      l2 = com.huawei.updatesdk.service.a.a.a().b();
    } while ((paramUpdateParams.getMinIntervalDay() != 0) && (Math.abs(l1 - l2) < paramUpdateParams.getMinIntervalDay() * 86400000L));
    if (com.huawei.updatesdk.a.a.c.b.b.a(paramContext))
    {
      com.huawei.updatesdk.service.a.a.a().a(l1);
      new e(paramContext, paramUpdateParams, paramCheckUpdateCallBack).executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
      return;
    }
    paramContext = new Intent();
    paramContext.putExtra("status", 2);
    paramCheckUpdateCallBack.onUpdateInfo(paramContext);
  }
  
  public static void checkClientOTAUpdate(Context paramContext, CheckUpdateCallBack paramCheckUpdateCallBack, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if ((paramContext == null) || (!com.huawei.updatesdk.a.a.c.b.b.a(paramContext))) {}
    long l1;
    long l2;
    do
    {
      return;
      init(paramContext);
      l1 = System.currentTimeMillis();
      l2 = com.huawei.updatesdk.service.a.a.a().b();
    } while ((paramInt != 0) && (Math.abs(l1 - l2) < paramInt * 86400000L));
    com.huawei.updatesdk.service.a.a.a().a(l1);
    paramContext = new e(paramContext, new UpdateParams.Builder().setIsShowImmediate(paramBoolean1).setMustBtnOne(paramBoolean2).setMinIntervalDay(paramInt).build(), paramCheckUpdateCallBack);
    paramContext.a(true);
    paramContext.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
  }
  
  public static void checkTargetAppUpdate(Context paramContext, String paramString, CheckUpdateCallBack paramCheckUpdateCallBack)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramCheckUpdateCallBack == null))
    {
      if (paramCheckUpdateCallBack != null)
      {
        paramContext = new Intent();
        paramContext.putExtra("status", 1);
        paramCheckUpdateCallBack.onUpdateInfo(paramContext);
      }
      return;
    }
    if (com.huawei.updatesdk.a.a.c.b.b.a(paramContext))
    {
      init(paramContext);
      new e(paramContext, new UpdateParams.Builder().setMustBtnOne(false).setTargetPkgName(paramString).build(), paramCheckUpdateCallBack).executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
      return;
    }
    paramContext = new Intent();
    paramContext.putExtra("status", 2);
    paramCheckUpdateCallBack.onUpdateInfo(paramContext);
  }
  
  private static void init(Context paramContext)
  {
    com.huawei.updatesdk.a.b.a.a.a(paramContext);
    Log.i("updatesdk", "UpdateSDK version is: 2.0.6.302 ,flavor: envrelease ,pkgName: " + paramContext.getPackageName());
  }
  
  public static void releaseCallBack()
  {
    d.a().a(null);
    List localList = com.huawei.updatesdk.service.d.a.b.a();
    if ((localList == null) || (localList.isEmpty())) {
      return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      AsyncTask localAsyncTask = (AsyncTask)localIterator.next();
      if (localAsyncTask != null) {
        localAsyncTask.cancel(true);
      }
      Log.d("UpdateSdk", "cancel task");
    }
    localList.clear();
  }
  
  public static void setAppStorePkgName(String paramString)
  {
    h.a().c(paramString);
  }
  
  public static void setServiceZone(String paramString)
  {
    h.a().a(paramString);
  }
  
  public static void showUpdateDialog(Context paramContext, ApkUpgradeInfo paramApkUpgradeInfo, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramApkUpgradeInfo == null)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, AppUpdateActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("app_update_parm", paramApkUpgradeInfo);
    localBundle.putBoolean("app_must_btn", paramBoolean);
    localIntent.putExtras(localBundle);
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      Log.e("UpdateSdk", "go AppUpdateActivity error: " + paramContext.toString());
      return;
    }
    catch (SecurityException paramContext)
    {
      Log.e("UpdateSdk", "go AppUpdateActivity security error: " + paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.UpdateSdkAPI
 * JD-Core Version:    0.7.0.1
 */