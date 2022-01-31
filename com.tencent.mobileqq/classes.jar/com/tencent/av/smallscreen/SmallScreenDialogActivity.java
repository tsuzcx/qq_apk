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
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import jop;
import joq;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jop(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQCustomDialog b;
  
  private QQCustomDialog a()
  {
    QQCustomDialog localQQCustomDialog;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      localQQCustomDialog = DialogUtil.a(this, 230).setMessage(2131429401).setNegativeButton(2131432998, this);
      if (!b()) {
        break label76;
      }
    }
    label76:
    for (int i = 2131429415;; i = 2131429414)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog.setPositiveButton(i, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131429402);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
  }
  
  private QQCustomDialog b()
  {
    if (this.b == null)
    {
      this.b = DialogUtil.a(this, 230).setMessage(2131429403).setNegativeButton(2131432998, this).setPositiveButton(2131433499, this);
      this.b.setTitle(2131429404);
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
  
  private boolean b()
  {
    return (SmallScreenUtils.a(this, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(this, "com.meizu.safe.security.SHOW_APPSEC")) || ((SmallScreenUtils.a(this, "huawei.intent.action.NOTIFICATIONMANAGER")) && (!a())) || (SmallScreenUtils.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  void a()
  {
    int k = 1;
    Object localObject = getPackageName();
    Intent localIntent;
    if (SmallScreenUtils.a(this, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    label405:
    label444:
    for (;;)
    {
      try
      {
        startActivity(localIntent);
        i = 1;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity e = " + localException2);
        i = 0;
        continue;
      }
      int j = i;
      if (i == 0)
      {
        j = i;
        if (SmallScreenUtils.a(this, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        startActivity(localIntent);
        j = 1;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          break label327;
        }
        QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity e = " + localException3);
        j = 0;
        continue;
      }
      int i = j;
      if (j == 0)
      {
        i = j;
        if (SmallScreenUtils.a(this, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          i = j;
          if (!a())
          {
            localIntent = new Intent();
            localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
          }
        }
      }
      try
      {
        startActivity(localIntent);
        j = 1;
      }
      catch (Exception localException4)
      {
        if (!QLog.isColorLevel()) {
          break label366;
        }
        QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity e = " + localException4);
        j = 0;
        continue;
      }
      i = j;
      if (j == 0) {
        localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
      }
      try
      {
        startActivity(localIntent);
        i = 1;
      }
      catch (Exception localException5)
      {
        if (!QLog.isColorLevel()) {
          break label405;
        }
        QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity e = " + localException5);
        i = 0;
        continue;
        continue;
      }
      if ((i == 0) && (SmallScreenUtils.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
      {
        localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + (String)localObject));
        try
        {
          startActivity((Intent)localObject);
          i = k;
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            break label444;
          }
          QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity e = " + localException1);
          i = 0;
          continue;
        }
        if (i == 0) {
          b();
        }
        return;
      }
      label327:
      label366:
      i = 0;
    }
  }
  
  public void a(QQCustomDialog paramQQCustomDialog)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenDialogActivity", 2, "showDialog");
      }
      paramQQCustomDialog.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenDialogActivity", 2, "showDialog ", localBadTokenException);
      }
      getWindow().getDecorView().post(new joq(this, paramQQCustomDialog));
    }
  }
  
  boolean a()
  {
    return Build.MODEL.equals("H60-L01");
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {
      switch (paramInt)
      {
      }
    }
    while (!paramDialogInterface.equals(this.b))
    {
      return;
      boolean bool = getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      SmallScreenUtils.a(paramDialogInterface, SmallScreenUtils.a(paramDialogInterface, bool) + 1, bool);
      finish();
      return;
      if (b())
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
      a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      return;
    }
    b();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (SmallScreenUtils.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      a();
      a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      return;
    }
    if (!SmallScreenUtils.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))
    {
      b();
      a(this.b);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDialogActivity
 * JD-Core Version:    0.7.0.1
 */