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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new FloatWindowPrivacyModel.1(this);
  BaseVideoAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private QQCustomDialog b = null;
  
  public FloatWindowPrivacyModel(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  private QQCustomDialog a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_MqqAppBaseActivity, 230).setMessage(2131695868).setNegativeButton(2131690728, this);
      int i;
      if (c()) {
        i = 2131695870;
      } else {
        i = 2131695881;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog.setPositiveButton(i, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131695869);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    }
    return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  }
  
  static boolean a()
  {
    return !"vivo".equalsIgnoreCase(DeviceInfoUtil.h());
  }
  
  private boolean a(boolean paramBoolean, String paramString, StringBuilder paramStringBuilder)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "miui.intent.action.APP_PERM_EDITOR"))
      {
        Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        localIntent.putExtra("extra_pkgname", paramString);
        try
        {
          this.jdField_a_of_type_MqqAppBaseActivity.startActivity(localIntent);
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
  
  private QQCustomDialog b()
  {
    if (this.b == null)
    {
      this.b = DialogUtil.a(this.jdField_a_of_type_MqqAppBaseActivity, 230).setMessage(2131695705).setPositiveButton(2131695618, this);
      this.b.setCancelable(false);
      this.b.setCanceledOnTouchOutside(false);
    }
    return this.b;
  }
  
  private boolean b(boolean paramBoolean, String paramString, StringBuilder paramStringBuilder)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "com.meizu.safe.security.SHOW_APPSEC"))
      {
        Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        localIntent.putExtra("packageName", paramString);
        try
        {
          this.jdField_a_of_type_MqqAppBaseActivity.startActivity(localIntent);
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
  
  private boolean c()
  {
    boolean bool1;
    if ((!SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "miui.intent.action.APP_PERM_EDITOR")) && (!SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "com.meizu.safe.security.SHOW_APPSEC")) && (!SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) && (!SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = b();
    }
    return bool2;
  }
  
  private boolean c(boolean paramBoolean, String paramString, StringBuilder paramStringBuilder)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if ("vivo".equalsIgnoreCase(DeviceInfoUtil.h()))
      {
        bool = paramBoolean;
        if (SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "permission.intent.action.softPermissionDetail"))
        {
          Intent localIntent = new Intent("permission.intent.action.softPermissionDetail");
          try
          {
            localIntent.putExtra("packagename", paramString);
            this.jdField_a_of_type_MqqAppBaseActivity.startActivity(localIntent);
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
      if (SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
      {
        paramString = new Intent();
        paramString.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        try
        {
          this.jdField_a_of_type_MqqAppBaseActivity.startActivity(paramString);
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
            this.jdField_a_of_type_MqqAppBaseActivity.startActivity(paramString);
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
  
  protected void a()
  {
    if (SmallScreenUtils.b(this.jdField_a_of_type_MqqAppBaseActivity))
    {
      QLog.w("FloatWindowPrivacyModel", 1, "锁屏中，不弹1");
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      a();
      a("onResume.1", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      return;
    }
    if (!SmallScreenUtils.c(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface.getApp()))
    {
      b();
      a("onResume.1", this.b);
      return;
    }
    QLog.w("FloatWindowPrivacyModel", 1, "onResume, finish");
    this.jdField_a_of_type_MqqAppBaseActivity.finish();
  }
  
  protected void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface = ((BaseVideoAppInterface)this.jdField_a_of_type_MqqAppBaseActivity.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    this.jdField_a_of_type_MqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (SmallScreenUtils.c(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface.getApp())) {
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
    }
  }
  
  protected void b() {}
  
  boolean b()
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
          break label142;
        }
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("V1936A")) {
          break label142;
        }
        if (Build.MODEL.equalsIgnoreCase("vivo X9s L"))
        {
          bool1 = bool2;
          break label142;
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
    label142:
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
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_a_of_type_MqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  void e()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppBaseActivity.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool3 = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (SmallScreenUtils.a(this.jdField_a_of_type_MqqAppBaseActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("package:");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(((StringBuilder)localObject2).toString()));
        try
        {
          this.jdField_a_of_type_MqqAppBaseActivity.startActivity((Intent)localObject2);
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
      b();
      a("openPermissionActivity", this.b);
      return;
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        if (c())
        {
          e();
          return;
        }
        b();
        a("WHICH_POSITIVE", this.b);
        return;
      }
      boolean bool = this.jdField_a_of_type_MqqAppBaseActivity.getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface.getCurrentAccountUin();
      SmallScreenUtils.a(paramDialogInterface, SmallScreenUtils.a(paramDialogInterface, bool) + 1, bool);
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
      return;
    }
    if (paramDialogInterface.equals(this.b))
    {
      if (paramInt != 1) {
        return;
      }
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.FloatWindowPrivacyModel
 * JD-Core Version:    0.7.0.1
 */