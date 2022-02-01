package com.tencent.device.bind;

import Override;
import abfg;
import abfh;
import abfi;
import absy;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import bhdj;
import bmij;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneShareManager;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import znl;

public class DevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static int a;
  public static String a;
  private static String b = "DevicePluginDownloadActivity";
  private Intent a;
  private String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "agent_type";
  }
  
  private void a()
  {
    String str;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("jumpPublicDevice", false)) {
      str = "com.tencent.device.activities.DeviceSquareActivity";
    }
    for (;;)
    {
      bmij.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.jdField_a_of_type_AndroidContentIntent, str, 0, null, SmartDevicePluginProxyActivity.class);
      return;
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("public_device", 0) != 0)
      {
        str = "com.tencent.device.activities.DeviceScanActivity";
        this.jdField_a_of_type_AndroidContentIntent.putExtra("nickname", this.app.getCurrentNickname());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("bitmap", this.app.getFaceBitmap(this.app.getCurrentAccountUin(), (byte)2, false));
      }
      else
      {
        str = "com.tencent.device.activities.DeviceShareConfirmActivity";
      }
    }
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    this.c = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("from");
    if ("connect".equals(this.c))
    {
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qrurl");
      if (!TextUtils.isEmpty(str))
      {
        super.setContentView(2131559111);
        super.setTitle(2131691539);
        super.setLeftViewName(2131691539);
        absy.a().a(1);
        absy.a().jdField_a_of_type_JavaLangString = "";
        absy.a().jdField_a_of_type_Int = 0;
        int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("entrance", 1);
        absy.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", i);
        DeviceScanner.openDeviceQCodeUrl(this, null, str);
        super.finish();
      }
    }
    do
    {
      do
      {
        return true;
        super.finish();
        return true;
        if (!"share".equals(this.c)) {
          break;
        }
      } while ((TextUtils.isEmpty(this.c)) || (!this.c.equals("share")));
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra(jdField_a_of_type_JavaLangString, -1) == 0)
      {
        if (!QZoneShareManager.jumpToQzoneShare((AppInterface)super.getAppRuntime(), this, this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("data"), null)) {
          znl.a(1, 2131689486);
        }
        super.finish();
        return true;
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uinname", ContactUtils.getFriendNickName(this.app, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")));
      if (bmij.a().a((QQAppInterface)super.getAppRuntime()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "start SmartDevicePlugin to goshare");
        }
        a();
        super.finish();
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "download install SmartDevicePlugin");
      }
      bmij.a().addObserver(this);
      bmij.a().a();
      return true;
      super.setContentView(2131559112);
      super.setTitle(2131691338);
      bmij.a().addObserver(this);
      this.leftView.setText(2131690499);
    } while (bmij.a().a(this.app));
    bmij.a().a();
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!PermissionUtils.isStorePermissionEnable(this)) {
        PermissionUtils.requestStorePermission(this, 3, new abfg(this));
      }
    }
    for (;;)
    {
      return true;
      a();
      continue;
      a();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bmij.a().deleteObserver(this);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "recv notify : plugin install finished with code " + paramObservable);
      }
      if (paramObservable.intValue() != 0)
      {
        paramObservable = bhdj.a(this, 230);
        paramObservable.setNegativeButton(2131690697, new abfh(this));
        paramObservable.setPositiveButton(2131691541, new abfi(this));
        paramObservable.setTitle(2131691538);
        paramObservable.setMessage(2131691537);
        paramObservable.show();
      }
    }
    else
    {
      return;
    }
    if ("share".equals(this.c)) {
      a();
    }
    for (;;)
    {
      super.finish();
      return;
      paramObservable = new Intent();
      paramObject = super.getIntent();
      paramObservable.putExtra("DevicePID", paramObject.getStringExtra("DevicePID"));
      paramObservable.putExtra("DeviceSN", paramObject.getStringExtra("DeviceSN"));
      paramObservable.putExtra("DeviceToken", paramObject.getStringExtra("DeviceToken"));
      paramObservable.putExtra("DataReportSeq", absy.a().jdField_a_of_type_Long);
      bmij.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */