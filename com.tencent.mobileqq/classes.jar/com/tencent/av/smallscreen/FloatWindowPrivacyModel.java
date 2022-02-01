package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class FloatWindowPrivacyModel
  extends DialogModelBase
  implements DialogInterface.OnClickListener
{
  BaseVideoAppInterface b;
  BroadcastReceiver c = new FloatWindowPrivacyModel.1(this);
  private QQCustomDialog d = null;
  private QQCustomDialog e = null;
  private long f = 0L;
  private int g = 0;
  
  public FloatWindowPrivacyModel(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  private boolean a(boolean paramBoolean, String paramString, StringBuilder paramStringBuilder)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (SmallScreenUtils.a(this.a, "miui.intent.action.APP_PERM_EDITOR"))
      {
        Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        localIntent.putExtra("extra_pkgname", paramString);
        try
        {
          this.a.startActivity(localIntent);
          paramStringBuilder.append("ACTION_MIUI");
          return true;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", paramString);
          }
          bool = false;
        }
      }
    }
    return bool;
  }
  
  private boolean b(boolean paramBoolean, String paramString, StringBuilder paramStringBuilder)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (SmallScreenUtils.a(this.a, "com.meizu.safe.security.SHOW_APPSEC"))
      {
        Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        localIntent.putExtra("packageName", paramString);
        try
        {
          this.a.startActivity(localIntent);
          paramStringBuilder.append("ACTION_MEIZU");
          return true;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", paramString);
          }
          bool = false;
        }
      }
    }
    return bool;
  }
  
  private boolean c(boolean paramBoolean, String paramString, StringBuilder paramStringBuilder)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if ("vivo".equalsIgnoreCase(DeviceInfoUtil.t()))
      {
        bool = paramBoolean;
        if (SmallScreenUtils.a(this.a, "permission.intent.action.softPermissionDetail"))
        {
          Intent localIntent = new Intent("permission.intent.action.softPermissionDetail");
          try
          {
            localIntent.putExtra("packagename", paramString);
            this.a.startActivity(localIntent);
            paramStringBuilder.append("ACTION_VIVO");
            return true;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", paramString);
            }
            bool = false;
          }
        }
      }
    }
    return bool;
  }
  
  private boolean d(boolean paramBoolean, String paramString, StringBuilder paramStringBuilder)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (SmallScreenUtils.a(this.a, "huawei.intent.action.NOTIFICATIONMANAGER"))
      {
        paramString = new Intent();
        paramString.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        try
        {
          this.a.startActivity(paramString);
          paramStringBuilder.append("ACTION_HUAWEI_1");
          paramBoolean = true;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", paramString);
          }
          paramBoolean = false;
        }
        bool = paramBoolean;
        if (!paramBoolean)
        {
          paramString = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
          try
          {
            this.a.startActivity(paramString);
            paramStringBuilder.append("ACTION_HUAWEI_2");
            return true;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", paramString);
            }
            bool = false;
          }
        }
      }
    }
    return bool;
  }
  
  static boolean e()
  {
    return !"vivo".equalsIgnoreCase(DeviceInfoUtil.t());
  }
  
  private boolean h()
  {
    boolean bool1;
    if ((!SmallScreenUtils.a(this.a, "miui.intent.action.APP_PERM_EDITOR")) && (!SmallScreenUtils.a(this.a, "com.meizu.safe.security.SHOW_APPSEC")) && (!SmallScreenUtils.a(this.a, "huawei.intent.action.NOTIFICATIONMANAGER")) && (!SmallScreenUtils.a(this.a, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = g();
    }
    return bool2;
  }
  
  private QQCustomDialog i()
  {
    if (this.d == null)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230).setMessage(2131893628).setNegativeButton(2131887648, this);
      int i;
      if (h()) {
        i = 2131893630;
      } else {
        i = 2131893641;
      }
      this.d = localQQCustomDialog.setPositiveButton(i, this);
      this.d.setTitle(2131893629);
      this.d.setCancelable(false);
      this.d.setCanceledOnTouchOutside(false);
    }
    return this.d;
  }
  
  private QQCustomDialog j()
  {
    if (this.e == null)
    {
      this.e = DialogUtil.a(this.a, 230).setMessage(2131893464).setPositiveButton(2131893377, this);
      this.e.setCancelable(false);
      this.e.setCanceledOnTouchOutside(false);
    }
    return this.e;
  }
  
  protected void a()
  {
    if (SmallScreenUtils.b(this.a))
    {
      QLog.w("FloatWindowPrivacyModel", 1, "锁屏中，不弹1");
      this.a.finish();
      return;
    }
    if (this.d == null)
    {
      i();
      a("onResume.1", this.d);
      return;
    }
    if (!SmallScreenUtils.c(this.b.getApp()))
    {
      j();
      a("onResume.1", this.e);
      return;
    }
    QLog.w("FloatWindowPrivacyModel", 1, "onResume, finish");
    this.a.finish();
  }
  
  protected void a(Bundle paramBundle)
  {
    this.b = ((BaseVideoAppInterface)this.a.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    this.a.registerReceiver(this.c, paramBundle);
    if (SmallScreenUtils.c(this.b.getApp())) {
      this.a.finish();
    }
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void d()
  {
    this.a.unregisterReceiver(this.c);
  }
  
  void f()
  {
    Object localObject1 = this.a.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool3 = e();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (SmallScreenUtils.a(this.a, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("package:");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(((StringBuilder)localObject2).toString()));
        try
        {
          this.a.startActivity((Intent)localObject2);
          localStringBuilder.append("ACTION_ANDROID");
          bool1 = true;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", localException);
          }
          localStringBuilder.append("Exception:");
          localStringBuilder.append(localException.getMessage());
          bool1 = bool2;
        }
      }
    }
    bool1 = d(c(b(a(bool1, (String)localObject1, localStringBuilder), (String)localObject1, localStringBuilder), (String)localObject1, localStringBuilder), (String)localObject1, localStringBuilder);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("openPermissionActivity, openSuccess[");
    ((StringBuilder)localObject1).append(bool1);
    ((StringBuilder)localObject1).append("], code[");
    ((StringBuilder)localObject1).append(localStringBuilder.toString());
    ((StringBuilder)localObject1).append("]");
    QLog.w("FloatWindowPrivacyModel", 1, ((StringBuilder)localObject1).toString());
    if (!bool1)
    {
      j();
      a("openPermissionActivity", this.e);
      return;
    }
    this.g += 1;
    this.f = SystemClock.elapsedRealtime();
  }
  
  boolean g()
  {
    boolean bool1 = Build.MANUFACTURER.equalsIgnoreCase("OPPO");
    boolean bool2 = false;
    if ((bool1) && (Build.MODEL.equalsIgnoreCase("PCKM80")))
    {
      bool1 = bool2;
    }
    else
    {
      if (Build.MANUFACTURER.equalsIgnoreCase("VIVO"))
      {
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("V1838A")) {
          break label150;
        }
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("V1936A")) {
          break label150;
        }
        if (Build.MODEL.equalsIgnoreCase("vivo X9s L"))
        {
          bool1 = bool2;
          break label150;
        }
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) && (Build.MODEL.equalsIgnoreCase("H60-L01"))) {
        bool1 = bool2;
      } else if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI 5X"))) {
        bool1 = bool2;
      } else {
        bool1 = true;
      }
    }
    label150:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupport, manufacturer[");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("], model[");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("], bSupport[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.i("FloatWindowPrivacyModel", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.d))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        if (h())
        {
          f();
          return;
        }
        j();
        a("WHICH_POSITIVE", this.e);
        return;
      }
      boolean bool = this.a.getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.b.getCurrentAccountUin();
      SmallScreenUtils.a(paramDialogInterface, SmallScreenUtils.a(paramDialogInterface, bool) + 1, bool);
      this.a.finish();
      return;
    }
    if (paramDialogInterface.equals(this.e))
    {
      if (paramInt != 1) {
        return;
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.FloatWindowPrivacyModel
 * JD-Core Version:    0.7.0.1
 */