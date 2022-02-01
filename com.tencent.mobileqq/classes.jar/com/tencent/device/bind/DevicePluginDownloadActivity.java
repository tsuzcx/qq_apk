package com.tencent.device.bind;

import Override;
import abtl;
import abtm;
import abtn;
import achd;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import apdr;
import bhlg;
import bhlq;
import bhpc;
import bmud;
import bnrt;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import zyx;

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
      bnrt.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.jdField_a_of_type_AndroidContentIntent, str, 0, null, SmartDevicePluginProxyActivity.class);
      return;
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("public_device", 0) != 0)
      {
        str = "com.tencent.device.activities.DeviceScanActivity";
        this.jdField_a_of_type_AndroidContentIntent.putExtra("nickname", this.app.getCurrentNickname());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("bitmap", this.app.a(this.app.getCurrentAccountUin(), (byte)2, false));
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
        super.setContentView(2131559075);
        super.setTitle(2131691414);
        super.setLeftViewName(2131691414);
        achd.a().a(1);
        achd.a().jdField_a_of_type_JavaLangString = "";
        achd.a().jdField_a_of_type_Int = 0;
        int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("entrance", 1);
        achd.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", i);
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
        if (!bmud.a((AppInterface)super.getAppRuntime(), this, this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("data"), null)) {
          zyx.a(1, 2131689486);
        }
        super.finish();
        return true;
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uinname", bhlg.i(this.app, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")));
      if (bnrt.a().a((QQAppInterface)super.getAppRuntime()))
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
      bnrt.a().addObserver(this);
      bnrt.a().a();
      return true;
      super.setContentView(2131559076);
      super.setTitle(2131691214);
      bnrt.a().addObserver(this);
      this.leftView.setText(2131690384);
    } while (bnrt.a().a(this.app));
    bnrt.a().a();
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!apdr.a(this)) {
        apdr.a(this, 3, new abtl(this));
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
    bnrt.a().deleteObserver(this);
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
        paramObservable = bhlq.a(this, 230);
        paramObservable.setNegativeButton(2131690580, new abtm(this));
        paramObservable.setPositiveButton(2131691416, new abtn(this));
        paramObservable.setTitle(2131691413);
        paramObservable.setMessage(2131691412);
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
      paramObservable.putExtra("DataReportSeq", achd.a().jdField_a_of_type_Long);
      bnrt.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */