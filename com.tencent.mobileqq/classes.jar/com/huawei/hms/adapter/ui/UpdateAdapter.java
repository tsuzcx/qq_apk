package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.updatesdk.UpdateSdkAPI;
import java.lang.ref.WeakReference;

public class UpdateAdapter
  implements IBridgeActivityDelegate
{
  private WeakReference<Activity> a;
  private int b;
  private UpdateBean c;
  private String d;
  
  private void a()
  {
    UpdateSdkAPI.checkTargetAppUpdate(d(), "com.huawei.hms", new UpdateAdapter.1(this));
  }
  
  private boolean a(Context paramContext, String paramString, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramInt == 0)) {
      bool1 = false;
    }
    do
    {
      PackageManagerHelper.PackageStates localPackageStates;
      do
      {
        return bool1;
        paramContext = new PackageManagerHelper(paramContext);
        localPackageStates = paramContext.getPackageStates(paramString);
        bool1 = bool2;
      } while (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localPackageStates));
      bool1 = bool2;
    } while (paramContext.getPackageVersionCode(paramString) < paramInt);
    return false;
  }
  
  private void b()
  {
    Activity localActivity = d();
    UpdateBean localUpdateBean = new UpdateBean();
    localUpdateBean.setHmsOrApkUpgrade(true);
    HMSLog.i("UpdateAdapter", "target HMS Core packageName is " + this.d);
    localUpdateBean.setClientPackageName(this.d);
    localUpdateBean.setClientVersionCode(this.b);
    localUpdateBean.setClientAppId("C10132067");
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(localActivity.getApplicationContext());
    }
    localUpdateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    this.c = localUpdateBean;
    HMSLog.i("UpdateAdapter", "old framework HMSCore upgrade process");
    UpdateManager.startUpdate(localActivity, 1001, localUpdateBean);
    this.c = null;
  }
  
  private void c()
  {
    Activity localActivity = d();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    localActivity.finish();
  }
  
  private Activity d()
  {
    if (this.a == null) {
      return null;
    }
    return (Activity)this.a.get();
  }
  
  private void e()
  {
    SystemManager.getInstance().notifyUpdateResult(8);
    c();
  }
  
  public int getRequestCode()
  {
    return 1001;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
    Object localObject = paramActivity.getIntent();
    if (localObject == null)
    {
      e();
      return;
    }
    this.b = ((Intent)localObject).getIntExtra("update_version", 0);
    if (this.b == 0)
    {
      e();
      return;
    }
    if (((Intent)localObject).getBooleanExtra("new_update", false))
    {
      HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
      localObject = HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName();
      ComponentName localComponentName = new ComponentName((String)localObject, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
      Intent localIntent = new Intent();
      localIntent.putExtra("kpms_key_caller_packagename", paramActivity.getApplicationContext().getPackageName());
      localIntent.putExtra("kitUpdatePackageName", (String)localObject);
      localIntent.setComponent(localComponentName);
      paramActivity.startActivityForResult(localIntent, 1001);
      return;
    }
    paramActivity = HMSPackageManager.getInstance(paramActivity);
    localObject = paramActivity.getHMSPackageStates();
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localObject))
    {
      if (HMSPublishStateHolder.getPublishState() == 0)
      {
        a();
        return;
      }
      if (HMSPublishStateHolder.getPublishState() == 1)
      {
        this.d = "com.huawei.hms";
        b();
        return;
      }
      this.d = "com.huawei.hwid";
      b();
      return;
    }
    this.d = paramActivity.getHMSPackageName();
    b();
  }
  
  public void onBridgeActivityDestroy()
  {
    HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != getRequestCode())
    {
      this.c = null;
      return false;
    }
    HMSLog.i("UpdateAdapter", "onBridgeActivityResult");
    if (paramInt2 == 1214)
    {
      HMSLog.i("UpdateAdapter", "Enter update escape route");
      Activity localActivity = d();
      if (localActivity == null)
      {
        HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
        this.c = null;
        return true;
      }
      UpdateManager.startUpdate(localActivity, 1001, this.c);
      this.c = null;
    }
    if (paramInt2 == -1) {
      if (paramIntent != null)
      {
        if (paramIntent.getIntExtra("kit_update_result", 0) == 1)
        {
          HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
          SystemManager.getInstance().notifyUpdateResult(0);
          this.c = null;
          c();
          return true;
        }
        paramInt1 = paramIntent.getIntExtra("intent.extra.RESULT", -1);
        if (paramInt1 != 0) {
          break label162;
        }
        HMSLog.i("UpdateAdapter", "Error resolved successfully!");
        SystemManager.getInstance().notifyUpdateResult(0);
      }
    }
    for (;;)
    {
      c();
      return true;
      label162:
      if (paramInt1 == 13)
      {
        HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
        SystemManager.getInstance().notifyUpdateResult(13);
      }
      else if (paramInt1 == 8)
      {
        HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
        SystemManager.getInstance().notifyUpdateResult(8);
      }
      else
      {
        HMSLog.i("UpdateAdapter", "Other error codes.");
        SystemManager.getInstance().notifyUpdateResult(paramInt1);
        continue;
        if (paramInt2 == 0)
        {
          HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
          this.c = null;
          paramIntent = d();
          if (paramIntent == null) {
            return true;
          }
          if (a(paramIntent, HMSPackageManager.getInstance(paramIntent.getApplicationContext()).getHMSPackageName(), this.b))
          {
            HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
            SystemManager.getInstance().notifyUpdateResult(13);
          }
          else
          {
            SystemManager.getInstance().notifyUpdateResult(0);
          }
        }
      }
    }
  }
  
  public void onBridgeConfigurationChanged()
  {
    HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.ui.UpdateAdapter
 * JD-Core Version:    0.7.0.1
 */