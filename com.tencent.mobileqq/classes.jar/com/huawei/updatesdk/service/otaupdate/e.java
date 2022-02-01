package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.a.b.d.a.d.a;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.e.c.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
  extends AsyncTask<Void, Void, com.huawei.updatesdk.a.b.d.a.d>
{
  private Context a;
  private CheckUpdateCallBack b;
  private UpdateParams c;
  private Toast d;
  private boolean e = false;
  private List<String> f = new ArrayList();
  private com.huawei.updatesdk.a.b.d.b g;
  
  public e(Context paramContext, UpdateParams paramUpdateParams, CheckUpdateCallBack paramCheckUpdateCallBack)
  {
    this.c = paramUpdateParams;
    this.a = paramContext;
    this.b = paramCheckUpdateCallBack;
    h.a().a(paramUpdateParams.getServiceZone());
    if (TextUtils.isEmpty(h.a().b())) {
      h.a().c(paramUpdateParams.getAppStorePkgName());
    }
  }
  
  private PackageInfo a(Context paramContext, String paramString)
  {
    PackageInfo localPackageInfo = com.huawei.updatesdk.service.e.c.a(paramString, paramContext);
    paramContext = localPackageInfo;
    if (localPackageInfo == null)
    {
      paramContext = new PackageInfo();
      paramContext.packageName = paramString;
      paramContext.versionName = "1.0";
      paramContext.versionCode = 1;
      paramString = new ApplicationInfo();
      paramString.targetSdkVersion = 19;
      paramContext.applicationInfo = paramString;
    }
    return paramContext;
  }
  
  private com.huawei.updatesdk.a.b.d.a.d a(Context paramContext, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a(paramContext, (String)paramList.next()));
    }
    paramContext = com.huawei.updatesdk.service.appmgr.bean.a.a(localArrayList);
    paramContext.a(0);
    if (isCancelled())
    {
      Log.w("CheckOtaAndUpdataTask", "UpdateSDK task is canceled and return empty upgradeInfo");
      return null;
    }
    this.g = new com.huawei.updatesdk.a.b.d.b(paramContext, null);
    return this.g.a();
  }
  
  private void a(Context paramContext, ApkUpgradeInfo paramApkUpgradeInfo)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, AppUpdateActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("app_update_parm", paramApkUpgradeInfo);
    localBundle.putBoolean("app_must_btn", this.c.isMustBtnOne());
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
      com.huawei.updatesdk.a.a.b.a.a.a.d("CheckOtaAndUpdataTask", "go AppUpdateActivity error: " + paramContext.toString());
    }
  }
  
  private void a(List<ApkUpgradeInfo> paramList)
  {
    if (i.a(paramList)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApkUpgradeInfo localApkUpgradeInfo = (ApkUpgradeInfo)paramList.next();
        if ((localApkUpgradeInfo != null) && (!TextUtils.isEmpty(localApkUpgradeInfo.getFullDownUrl_()))) {
          localApkUpgradeInfo.setDownurl_(localApkUpgradeInfo.getFullDownUrl_());
        }
      }
    }
  }
  
  private boolean a()
  {
    return (!this.e) && (TextUtils.isEmpty(this.c.getTargetPkgName())) && (i.a(this.c.getPackageList()));
  }
  
  private void b()
  {
    if (this.d != null) {
      this.d.cancel();
    }
  }
  
  private void b(com.huawei.updatesdk.a.b.d.a.d paramd)
  {
    if (this.b != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("status", 6);
      if (paramd.d() != null) {
        localIntent.putExtra("failcause", paramd.d().ordinal());
      }
      localIntent.putExtra("failreason", paramd.e());
      localIntent.putExtra("responsecode", paramd.b());
      this.b.onUpdateInfo(localIntent);
      this.b.onUpdateStoreError(paramd.a());
    }
  }
  
  protected com.huawei.updatesdk.a.b.d.a.d a(Void... paramVarArgs)
  {
    com.huawei.updatesdk.a.a.b.a.a.a.a("CheckOtaAndUpdataTask", "CheckOtaAndUpdataTask doInBackground");
    com.huawei.updatesdk.service.d.a.b.a(this);
    if ((Build.VERSION.SDK_INT < 24) && (com.huawei.updatesdk.a.a.c.a.b.d() != 0) && (com.huawei.updatesdk.service.e.c.a(com.huawei.updatesdk.a.b.a.a.a().b()) == c.a.a) && (!com.huawei.updatesdk.service.e.c.c()))
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("CheckOtaAndUpdataTask", "api <24,HiApp not installed and no permission");
      return null;
    }
    h.a().a(this.a);
    paramVarArgs = g.c(this.a, "upsdk_store_url");
    com.huawei.updatesdk.a.b.d.a.c.a(com.huawei.updatesdk.a.a.c.a.b.a(this.a, paramVarArgs));
    String str = this.c.getTargetPkgName();
    paramVarArgs = str;
    if (TextUtils.isEmpty(str)) {
      paramVarArgs = this.a.getPackageName();
    }
    if (i.a(this.c.getPackageList())) {
      if (!TextUtils.isEmpty(paramVarArgs)) {
        this.f.add(paramVarArgs);
      }
    }
    for (;;)
    {
      com.huawei.updatesdk.service.a.a.a().a(h.a().c());
      return a(this.a, this.f);
      this.f.addAll(this.c.getPackageList());
    }
  }
  
  protected void a(com.huawei.updatesdk.a.b.d.a.d paramd)
  {
    com.huawei.updatesdk.service.d.a.b.a().remove(this);
    b();
    if (paramd == null) {
      if (this.b != null)
      {
        paramd = new Intent();
        paramd.putExtra("status", 3);
        this.b.onUpdateInfo(paramd);
      }
    }
    label433:
    label443:
    do
    {
      for (;;)
      {
        return;
        int i = paramd.b();
        Object localObject;
        if ((paramd.a() == 0) && (paramd.c() == 0))
        {
          paramd = (com.huawei.updatesdk.service.appmgr.bean.b)paramd;
          localObject = paramd.list_;
          if (!i.a(paramd.notRcmList_))
          {
            paramd = (ApkUpgradeInfo)paramd.notRcmList_.get(0);
            Log.w("CheckOtaAndUpdataTask", "UpdateSDK get update info is not recommend,reason: " + paramd.getNotRcmReason_() + ",is same signature: " + paramd.getSameS_());
          }
          a((List)localObject);
          paramd = (com.huawei.updatesdk.a.b.d.a.d)localObject;
          if (i.a((List)localObject))
          {
            paramd = (com.huawei.updatesdk.a.b.d.a.d)localObject;
            if (this.b != null)
            {
              paramd = new Intent();
              paramd.putExtra("status", 3);
              paramd.putExtra("responsecode", i);
              this.b.onUpdateInfo(paramd);
              paramd = (com.huawei.updatesdk.a.b.d.a.d)localObject;
            }
          }
          if (i.a(paramd)) {
            break;
          }
          localObject = (ApkUpgradeInfo)paramd.get(0);
          if (this.b != null)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("updatesdk_update_info", (Serializable)localObject);
            localIntent.putParcelableArrayListExtra("updatesdk_update_info_list", paramd);
            localIntent.putExtra("status", 7);
            localIntent.putExtra("responsecode", i);
            this.b.onUpdateInfo(localIntent);
          }
          if (localObject == null) {
            break label433;
          }
          Log.i("CheckOtaAndUpdataTask", "ApkUpgradeInfo,version = " + ((ApkUpgradeInfo)localObject).getVersion_() + ",versionCode = " + ((ApkUpgradeInfo)localObject).getVersionCode_() + ",detailId = " + ((ApkUpgradeInfo)localObject).getDetailId_() + ",devType = " + ((ApkUpgradeInfo)localObject).getDevType_() + ",oldVersionCode = " + ((ApkUpgradeInfo)localObject).getOldVersionCode_());
        }
        for (;;)
        {
          if (!this.c.isShowImmediate()) {
            break label443;
          }
          a(this.a, (ApkUpgradeInfo)localObject);
          return;
          b(paramd);
          com.huawei.updatesdk.a.a.b.a.a.a.d("CheckOtaAndUpdataTask", "get app update msg failed,responseCode is " + paramd.a());
          paramd = null;
          break;
          Log.e("CheckOtaAndUpdataTask", "info == null");
        }
      }
    } while (!a());
    Toast.makeText(this.a, g.b(this.a, "upsdk_update_check_no_new_version"), 0).show();
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.g != null) {
      this.g.d();
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    d.a().a(this.b);
    if (a())
    {
      this.d = Toast.makeText(this.a, g.b(this.a, "upsdk_checking_update_prompt"), 1);
      this.d.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.e
 * JD-Core Version:    0.7.0.1
 */