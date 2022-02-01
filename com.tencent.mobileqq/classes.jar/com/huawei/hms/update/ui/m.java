package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.io.File;

public class m
  extends a
  implements com.huawei.hms.update.a.a.b
{
  private com.huawei.hms.update.a.a.a k;
  private com.huawei.hms.update.a.a.c l;
  private int m = 0;
  
  private static Uri a(Context paramContext, File paramFile)
  {
    int i = 1;
    PackageManagerHelper localPackageManagerHelper = new PackageManagerHelper(paramContext);
    String str1 = paramContext.getPackageName();
    String str2 = str1 + ".hms.update.provider";
    if (Build.VERSION.SDK_INT > 23) {
      if (paramContext.getApplicationInfo().targetSdkVersion <= 23) {}
    }
    while (i != 0)
    {
      return UpdateProvider.getUriForFile(paramContext, str2, paramFile);
      if (!localPackageManagerHelper.hasProvider(str1, str2)) {
        i = 0;
      }
    }
    return Uri.fromFile(paramFile);
  }
  
  private void a(Intent paramIntent, com.huawei.hms.update.a.a.b paramb)
  {
    int i;
    String str;
    Object localObject;
    int j;
    try
    {
      i = paramIntent.getIntExtra("status", -99);
      HMSLog.i("UpdateWizard", "CheckUpdateCallBack status is " + i);
      str = paramIntent.getStringExtra("failreason");
      if (!TextUtils.isEmpty(str)) {
        HMSLog.e("UpdateWizard", "checkTargetAppUpdate reason is " + str);
      }
      if (i != 7) {
        break label307;
      }
      paramIntent = paramIntent.getSerializableExtra("updatesdk_update_info");
      if ((paramIntent instanceof ApkUpgradeInfo))
      {
        localObject = (ApkUpgradeInfo)paramIntent;
        paramIntent = ((ApkUpgradeInfo)localObject).getPackage_();
        i = ((ApkUpgradeInfo)localObject).getVersionCode_();
        str = ((ApkUpgradeInfo)localObject).getDownurl_();
        j = ((ApkUpgradeInfo)localObject).getSize_();
        localObject = ((ApkUpgradeInfo)localObject).getSha256_();
        if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals(this.c.b()))) {
          a(paramb, 1201, null);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramIntent)
    {
      HMSLog.e("UpdateWizard", "intent has some error" + paramIntent.getMessage());
      a(paramb, 1201, null);
      return;
    }
    if (i < this.c.c())
    {
      HMSLog.e("UpdateWizard", "CheckUpdateCallBack versionCode is " + i + "bean.getClientVersionCode() is " + this.c.c());
      a(paramb, 1203, null);
      return;
    }
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      a(paramb, 1201, null);
      return;
    }
    a(paramb, 1000, new com.huawei.hms.update.a.a.c(paramIntent, i, str, j, (String)localObject));
    return;
    label307:
    if (i == 3)
    {
      a(paramb, 1202, null);
      return;
    }
    a(paramb, 1201, null);
  }
  
  private void a(com.huawei.hms.update.a.a.b paramb)
  {
    if (paramb == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = b();
      if ((localActivity == null) || (localActivity.isFinishing()))
      {
        a(paramb, 1201, null);
        return;
      }
    } while (!a(localActivity));
    UpdateSdkAPI.checkTargetAppUpdate(localActivity, this.c.b(), new m.2(this, paramb));
  }
  
  private static void a(com.huawei.hms.update.a.a.b paramb, int paramInt, com.huawei.hms.update.a.a.c paramc)
  {
    if (paramb != null) {
      new Handler(Looper.getMainLooper()).post(new m.1(paramb, paramInt, paramc));
    }
  }
  
  private void a(File paramFile)
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      paramFile = a(localActivity, paramFile);
      if (paramFile == null)
      {
        HMSLog.e("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
        e();
        return;
      }
    } while (!a(localActivity));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramFile, "application/vnd.android.package-archive");
    localIntent.setFlags(3);
    localIntent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
    try
    {
      localActivity.startActivityForResult(localIntent, getRequestCode());
      return;
    }
    catch (ActivityNotFoundException paramFile)
    {
      HMSLog.e("UpdateWizard", "In startInstaller, Failed to start package installer." + paramFile.getMessage());
      e();
    }
  }
  
  private boolean a(Activity paramActivity)
  {
    if (HMSPackageManager.getInstance(paramActivity).isApkUpdateNecessary(this.c.c())) {
      return true;
    }
    c();
    SystemManager.getInstance().notifyUpdateResult(0);
    return false;
  }
  
  private void d()
  {
    Object localObject = b();
    if (localObject != null) {}
    for (localObject = SystemUtils.getNetType(((Activity)localObject).getBaseContext());; localObject = "")
    {
      HMSLog.i("UpdateWizard", "current network is " + (String)localObject);
      if (!"WIFI".equals(localObject)) {
        break;
      }
      a(f.class);
      f();
      HMSLog.i("UpdateWizard", "current network is wifi");
      return;
    }
    a(e.b.class);
    HMSLog.i("UpdateWizard", "current network is not wifi");
  }
  
  private void e()
  {
    if (!a(false))
    {
      b(8, this.f);
      return;
    }
    a(8, this.f);
  }
  
  private void f()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      a(k.c.class);
    }
    while (!a(localActivity)) {
      return;
    }
    g();
    this.k = new com.huawei.hms.update.a.c(new com.huawei.hms.update.a.d(localActivity));
    this.k.a(this, this.l);
  }
  
  private void g()
  {
    if (this.k != null)
    {
      this.k.a();
      this.k = null;
    }
  }
  
  void a()
  {
    b(13, this.f);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, File paramFile)
  {
    HMSLog.i("UpdateWizard", "Enter onDownloadPackage, status: " + com.huawei.hms.update.a.a.d.a(paramInt1) + ", reveived: " + paramInt2 + ", total: " + paramInt3);
    switch (paramInt1)
    {
    case 2101: 
    default: 
    case 2000: 
    case 2100: 
      do
      {
        return;
        c();
        if (paramFile == null)
        {
          e();
          return;
        }
        if (FileUtil.verifyHash(this.l.e, paramFile))
        {
          a(paramFile);
          return;
        }
        HMSLog.i("UpdateWizard", "Hash value mismatch for download file");
        return;
      } while ((this.d == null) || (!(this.d instanceof f)));
      if ((paramInt2 < 0) || (paramInt3 <= 0)) {
        break;
      }
    }
    for (paramInt1 = (int)(paramInt2 * 100L / paramInt3);; paramInt1 = 0)
    {
      this.m = paramInt1;
      ((f)this.d).b(paramInt1);
      return;
      a(k.c.class);
      return;
      a(k.d.class);
      return;
      a(e.c.class);
      return;
    }
  }
  
  public void a(int paramInt, com.huawei.hms.update.a.a.c paramc)
  {
    HMSLog.i("UpdateWizard", "Enter onCheckUpdate, status: " + com.huawei.hms.update.a.a.d.a(paramInt));
    switch (paramInt)
    {
    default: 
      a(k.b.class);
      return;
    case 1000: 
      this.l = paramc;
      d();
      return;
    }
    a(k.b.class);
  }
  
  public void a(b paramb)
  {
    HMSLog.i("UpdateWizard", "Enter onCancel.");
    if ((paramb instanceof j))
    {
      a();
      return;
    }
    if ((paramb instanceof d))
    {
      g();
      a();
      return;
    }
    if ((paramb instanceof f))
    {
      g();
      a(e.d.class);
      return;
    }
    if ((paramb instanceof e.d))
    {
      a(f.class);
      f();
      return;
    }
    if ((paramb instanceof e.c))
    {
      a();
      return;
    }
    if ((paramb instanceof e.b))
    {
      a();
      return;
    }
    e();
  }
  
  void a(Class<? extends b> paramClass)
  {
    if (!a(b())) {
      return;
    }
    c();
    try
    {
      paramClass = (b)paramClass.newInstance();
      if ((!TextUtils.isEmpty(this.h)) && ((paramClass instanceof j)))
      {
        this.h = ResourceLoaderUtil.getString("hms_update_title");
        ((j)paramClass).a(this.h);
      }
      if ((this.m > 0) && ((paramClass instanceof f))) {
        ((f)paramClass).a(this.m);
      }
      paramClass.a(this);
      this.d = paramClass;
      return;
    }
    catch (InstantiationException paramClass)
    {
      HMSLog.e("UpdateWizard", "In showDialog, Failed to show the dialog." + paramClass.getMessage());
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      break label99;
    }
    catch (IllegalStateException paramClass)
    {
      label99:
      break label99;
    }
  }
  
  public void b(b paramb)
  {
    HMSLog.i("UpdateWizard", "Enter onDoWork.");
    if ((paramb instanceof j))
    {
      paramb.c();
      a(d.class);
      a(this);
    }
    do
    {
      return;
      if ((paramb instanceof e.d))
      {
        paramb.c();
        a();
        return;
      }
      if ((paramb instanceof e.c))
      {
        a(f.class);
        f();
        return;
      }
      if ((paramb instanceof e.b))
      {
        a(f.class);
        f();
        return;
      }
      if ((paramb instanceof k.b))
      {
        e();
        return;
      }
      if ((paramb instanceof k.c))
      {
        e();
        return;
      }
    } while (!(paramb instanceof k.d));
    e();
  }
  
  public int getRequestCode()
  {
    return 2006;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {}
    do
    {
      return;
      this.f = 6;
    } while (!a(paramActivity));
    if ((this.c.isNeedConfirm()) && (!TextUtils.isEmpty(this.h)))
    {
      a(j.class);
      return;
    }
    a(d.class);
    a(this);
  }
  
  public void onBridgeActivityDestroy()
  {
    g();
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.e) && (this.b != null)) {
      bool1 = this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.f != 6);
      bool1 = bool2;
    } while (paramInt1 != getRequestCode());
    if (a(this.g, this.i)) {
      b(0, this.f);
    }
    for (;;)
    {
      return true;
      e();
    }
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.e) && (this.b != null)) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
    }
    do
    {
      do
      {
        return;
      } while (4 != paramInt);
      HMSLog.i("UpdateWizard", "In onKeyUp, Call finish.");
      paramKeyEvent = b();
    } while ((paramKeyEvent == null) || (paramKeyEvent.isFinishing()));
    paramKeyEvent.setResult(0, null);
    paramKeyEvent.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.m
 * JD-Core Version:    0.7.0.1
 */