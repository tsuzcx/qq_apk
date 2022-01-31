package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import bdgk;
import bdgm;
import bdjz;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import mbm;
import mbt;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mbm(this);
  private bdjz jdField_a_of_type_Bdjz;
  public VideoAppInterface a;
  private final String jdField_a_of_type_JavaLangString = "SmallScreenDialogActivity_" + AudioHelper.b();
  private bdjz b;
  
  private bdjz a()
  {
    bdjz localbdjz;
    if (this.jdField_a_of_type_Bdjz == null)
    {
      localbdjz = bdgm.a(this, 230).setMessage(2131696330).setNegativeButton(2131690648, this);
      if (!c()) {
        break label76;
      }
    }
    label76:
    for (int i = 2131696334;; i = 2131696345)
    {
      this.jdField_a_of_type_Bdjz = localbdjz.setPositiveButton(i, this);
      this.jdField_a_of_type_Bdjz.setTitle(2131696332);
      this.jdField_a_of_type_Bdjz.setCancelable(false);
      this.jdField_a_of_type_Bdjz.setCanceledOnTouchOutside(false);
      return this.jdField_a_of_type_Bdjz;
    }
  }
  
  static boolean a()
  {
    return !"vivo".equalsIgnoreCase(bdgk.h());
  }
  
  private bdjz b()
  {
    if (this.b == null)
    {
      this.b = bdgm.a(this, 230).setMessage(2131696331).setNegativeButton(2131690648, this).setPositiveButton(2131693378, this);
      this.b.setTitle(2131696333);
      this.b.setCancelable(false);
      this.b.setCanceledOnTouchOutside(false);
    }
    return this.b;
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    VasWebviewUtil.openQQBrowserWithoutAD(this, "https://kf.qq.com/touch/apifaq/1506297fqqea150629iuAjqU.html?platform=14", 524288L, localIntent, false, -1);
  }
  
  private boolean c()
  {
    return (mbt.a(this, "miui.intent.action.APP_PERM_EDITOR")) || (mbt.a(this, "com.meizu.safe.security.SHOW_APPSEC")) || ((mbt.a(this, "huawei.intent.action.NOTIFICATIONMANAGER")) && (!b())) || (mbt.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  void a()
  {
    boolean bool3 = false;
    String str3 = getPackageName();
    Object localObject1 = null;
    if ((a()) && (mbt.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {
      localObject1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + str3));
    }
    for (;;)
    {
      try
      {
        startActivity((Intent)localObject1);
        localObject1 = "ACTION_ANDROID";
        bool2 = true;
      }
      catch (Exception localException1)
      {
        Object localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException1);
        str1 = "Exception:" + localException1.getMessage();
        bool2 = false;
        continue;
      }
      boolean bool1 = bool2;
      localObject3 = localObject1;
      if (!bool2)
      {
        bool1 = bool2;
        localObject3 = localObject1;
        if (mbt.a(this, "miui.intent.action.APP_PERM_EDITOR"))
        {
          localObject3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
          ((Intent)localObject3).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
          ((Intent)localObject3).putExtra("extra_pkgname", str3);
        }
      }
      try
      {
        startActivity((Intent)localObject3);
        localObject3 = "ACTION_MIUI";
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          break label488;
        }
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException3);
        bool1 = false;
        str2 = str1;
        continue;
      }
      boolean bool2 = bool1;
      localObject1 = localObject3;
      if (!bool1)
      {
        bool2 = bool1;
        localObject1 = localObject3;
        if (mbt.a(this, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localObject1 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          ((Intent)localObject1).setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          ((Intent)localObject1).putExtra("packageName", str3);
        }
      }
      try
      {
        startActivity((Intent)localObject1);
        localObject1 = "ACTION_MEIZU";
        bool2 = true;
      }
      catch (Exception localException2)
      {
        label488:
        if (!QLog.isColorLevel()) {
          break label517;
        }
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException2);
        label517:
        bool2 = false;
        localObject2 = str2;
        continue;
        label546:
        label571:
        bool1 = bool2;
        continue;
      }
      if ((!bool2) && ("vivo".equalsIgnoreCase(bdgk.h())) && (mbt.a(this, "permission.intent.action.softPermissionDetail")))
      {
        localObject3 = new Intent("permission.intent.action.softPermissionDetail");
        try
        {
          ((Intent)localObject3).putExtra("packagename", str3);
          startActivity((Intent)localObject3);
          localObject1 = "ACTION_VIVO";
          bool1 = true;
        }
        catch (Exception localException4)
        {
          if (!QLog.isColorLevel()) {
            break label546;
          }
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException4);
          bool1 = false;
          continue;
          bool1 = bool2;
          continue;
        }
        localObject3 = localObject1;
        bool2 = bool1;
        if (!bool1)
        {
          localObject3 = localObject1;
          bool2 = bool1;
          if (mbt.a(this, "huawei.intent.action.NOTIFICATIONMANAGER"))
          {
            localObject3 = localObject1;
            bool2 = bool1;
            if (!b())
            {
              localObject3 = new Intent();
              ((Intent)localObject3).setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
              try
              {
                startActivity((Intent)localObject3);
                localObject1 = "ACTION_HUAWEI_1";
                bool1 = true;
              }
              catch (Exception localException5)
              {
                if (!QLog.isColorLevel()) {
                  break label571;
                }
                QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException5);
                bool1 = false;
                continue;
              }
              localObject3 = localObject1;
              bool2 = bool1;
              if (!bool1)
              {
                localObject3 = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
                try
                {
                  startActivity((Intent)localObject3);
                  localObject3 = "ACTION_HUAWEI_2";
                  bool1 = true;
                }
                catch (Exception localException6)
                {
                  String str1;
                  String str2;
                  Object localObject2;
                  Object localObject4 = localObject2;
                  bool1 = bool3;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException6);
                  localObject4 = localObject2;
                  bool1 = bool3;
                  continue;
                }
                QLog.w(this.jdField_a_of_type_JavaLangString, 1, "openPermissionActivity, openSuccess[" + bool1 + "], code[" + (String)localObject3 + "]");
                if (!bool1) {
                  b();
                }
                return;
              }
            }
          }
        }
      }
      bool2 = false;
    }
  }
  
  void a(String paramString, bdjz parambdjz)
  {
    try
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showDialog, from[" + paramString + "]");
      parambdjz.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showDialog BadTokenException, from[" + paramString + "]", localBadTokenException);
      getWindow().getDecorView().post(new SmallScreenDialogActivity.2(this, paramString, parambdjz));
    }
  }
  
  boolean b()
  {
    return Build.MODEL.equals("H60-L01");
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_Bdjz)) {
      switch (paramInt)
      {
      }
    }
    while (!paramDialogInterface.equals(this.b))
    {
      return;
      boolean bool = getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      mbt.a(paramDialogInterface, mbt.a(paramDialogInterface, bool) + 1, bool);
      finish();
      return;
      if (c())
      {
        a();
        return;
      }
      b();
      finish();
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (mbt.b(this))
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "锁屏中，不弹2");
        finish();
        return;
      }
      a("clickCancel", this.jdField_a_of_type_Bdjz);
      return;
    }
    b();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (mbt.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
      finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onResume()
  {
    super.onResume();
    if (mbt.b(this))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "锁屏中，不弹1");
      finish();
      return;
    }
    if (this.jdField_a_of_type_Bdjz == null)
    {
      a();
      a("onResume.1", this.jdField_a_of_type_Bdjz);
      return;
    }
    if (!mbt.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))
    {
      b();
      a("onResume.1", this.b);
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, finish");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDialogActivity
 * JD-Core Version:    0.7.0.1
 */