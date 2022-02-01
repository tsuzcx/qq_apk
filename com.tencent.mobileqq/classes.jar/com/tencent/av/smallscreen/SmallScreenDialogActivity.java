package com.tencent.av.smallscreen;

import Override;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import bgln;
import bglp;
import bgpa;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import lyl;
import lyu;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lyl(this);
  private bgpa jdField_a_of_type_Bgpa;
  public VideoAppInterface a;
  private final String jdField_a_of_type_JavaLangString = "SmallScreenDialogActivity_" + AudioHelper.b();
  private bgpa b;
  
  private bgpa a()
  {
    bgpa localbgpa;
    if (this.jdField_a_of_type_Bgpa == null)
    {
      localbgpa = bglp.a(this, 230).setMessage(2131695212).setNegativeButton(2131690582, this);
      if (!c()) {
        break label76;
      }
    }
    label76:
    for (int i = 2131695216;; i = 2131695227)
    {
      this.jdField_a_of_type_Bgpa = localbgpa.setPositiveButton(i, this);
      this.jdField_a_of_type_Bgpa.setTitle(2131695214);
      this.jdField_a_of_type_Bgpa.setCancelable(false);
      this.jdField_a_of_type_Bgpa.setCanceledOnTouchOutside(false);
      return this.jdField_a_of_type_Bgpa;
    }
  }
  
  static boolean a()
  {
    return !"vivo".equalsIgnoreCase(bgln.h());
  }
  
  private bgpa b()
  {
    if (this.b == null)
    {
      this.b = bglp.a(this, 230).setMessage(2131695213).setNegativeButton(2131690582, this).setPositiveButton(2131692868, this);
      this.b.setTitle(2131695215);
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
    if ((lyu.a(this, "miui.intent.action.APP_PERM_EDITOR")) || (lyu.a(this, "com.meizu.safe.security.SHOW_APPSEC")) || (lyu.a(this, "huawei.intent.action.NOTIFICATIONMANAGER")) || (lyu.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = b();
      }
      return bool2;
    }
  }
  
  void a()
  {
    boolean bool3 = false;
    String str3 = getPackageName();
    Object localObject1 = null;
    if ((a()) && (lyu.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {
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
        if (lyu.a(this, "miui.intent.action.APP_PERM_EDITOR"))
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
          break label479;
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
        if (lyu.a(this, "com.meizu.safe.security.SHOW_APPSEC"))
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
        label479:
        if (!QLog.isColorLevel()) {
          break label508;
        }
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException2);
        label508:
        bool2 = false;
        localObject2 = str2;
        continue;
      }
      if ((!bool2) && ("vivo".equalsIgnoreCase(bgln.h())) && (lyu.a(this, "permission.intent.action.softPermissionDetail")))
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
            break label537;
          }
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "openPermissionActivity Exception", localException4);
          bool1 = false;
          continue;
        }
        localObject3 = localObject1;
        bool2 = bool1;
        if (!bool1)
        {
          localObject3 = localObject1;
          bool2 = bool1;
          if (lyu.a(this, "huawei.intent.action.NOTIFICATIONMANAGER"))
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
                break label562;
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
                this.jdField_a_of_type_Int += 1;
                this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
                return;
              }
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "openPermissionActivity, openSuccess[" + bool1 + "], code[" + (String)localObject3 + "]");
              if (!bool1)
              {
                b();
                finish();
                return;
              }
            }
          }
        }
        label537:
        label562:
        bool1 = bool2;
        continue;
      }
      bool1 = bool2;
      continue;
      bool2 = false;
    }
  }
  
  void a(String paramString, bgpa parambgpa)
  {
    try
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showDialog, from[" + paramString + "]");
      parambgpa.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showDialog BadTokenException, from[" + paramString + "]", localBadTokenException);
      getWindow().getDecorView().post(new SmallScreenDialogActivity.2(this, paramString, parambgpa));
    }
  }
  
  boolean b()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("PCKM80"))) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "isSupport, manufacturer[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "], bSupport[" + bool1 + "]");
      }
      return bool1;
      if (Build.MANUFACTURER.equalsIgnoreCase("VIVO"))
      {
        bool1 = bool2;
        if (!Build.MODEL.equalsIgnoreCase("V1838A"))
        {
          bool1 = bool2;
          if (!Build.MODEL.equalsIgnoreCase("V1936A"))
          {
            bool1 = bool2;
            if (Build.MODEL.equalsIgnoreCase("vivo X9s L")) {}
          }
        }
      }
      else if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
      {
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("H60-L01")) {}
      }
      else if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("MI 5X")) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_Bgpa)) {
      switch (paramInt)
      {
      }
    }
    while (!paramDialogInterface.equals(this.b))
    {
      return;
      boolean bool = getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      lyu.a(paramDialogInterface, lyu.a(paramDialogInterface, bool) + 1, bool);
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
      if (lyu.b(this))
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "锁屏中，不弹2");
        finish();
        return;
      }
      long l = Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onClick_help_negative, duration[" + l + "], openPermissionCnt[" + this.jdField_a_of_type_Int + "]");
      }
      if ((l < 2000L) || (this.jdField_a_of_type_Int >= 2))
      {
        finish();
        return;
      }
      a("clickCancel", this.jdField_a_of_type_Bgpa);
      return;
    }
    b();
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (lyu.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
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
    if (lyu.b(this))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "锁屏中，不弹1");
      finish();
      return;
    }
    if (this.jdField_a_of_type_Bgpa == null)
    {
      a();
      a("onResume.1", this.jdField_a_of_type_Bgpa);
      return;
    }
    if (!lyu.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))
    {
      b();
      a("onResume.1", this.b);
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, finish");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDialogActivity
 * JD-Core Version:    0.7.0.1
 */