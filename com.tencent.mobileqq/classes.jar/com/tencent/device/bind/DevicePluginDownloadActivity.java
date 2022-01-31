package com.tencent.device.bind;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import babh;
import babr;
import bafb;
import bfqn;
import bgnd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import vvp;
import xqc;
import xqd;
import yds;

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
      bgnd.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.jdField_a_of_type_AndroidContentIntent, str, 0, null, SmartDevicePluginProxyActivity.class);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    this.c = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("from");
    if ("connect".equals(this.c))
    {
      paramBundle = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qrurl");
      if (!TextUtils.isEmpty(paramBundle))
      {
        super.setContentView(2131493409);
        super.setTitle(2131626036);
        super.setLeftViewName(2131626036);
        yds.a().a(1);
        yds.a().jdField_a_of_type_JavaLangString = "";
        yds.a().jdField_a_of_type_Int = 0;
        int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("entrance", 1);
        yds.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", i);
        DeviceScanner.openDeviceQCodeUrl(this, null, paramBundle);
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
        if (!bfqn.a((AppInterface)super.getAppRuntime(), this, this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("data"), null)) {
          vvp.a(1, 2131623975);
        }
        super.finish();
        return true;
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uinname", babh.i(this.app, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")));
      if (bgnd.a().a((QQAppInterface)super.getAppRuntime()))
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
      bgnd.a().addObserver(this);
      bgnd.a().a();
      return true;
      super.setContentView(2131493410);
      super.setTitle(2131625801);
      bgnd.a().addObserver(this);
      this.leftView.setText(2131624770);
    } while (bgnd.a().a(this.app));
    bgnd.a().a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bgnd.a().deleteObserver(this);
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
        paramObservable = babr.a(this, 230);
        paramObservable.setNegativeButton(2131625035, new xqc(this));
        paramObservable.setPositiveButton(2131626039, new xqd(this));
        paramObservable.setTitle(2131626035);
        paramObservable.setMessage(2131626034);
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
      paramObservable.putExtra("DataReportSeq", yds.a().jdField_a_of_type_Long);
      bgnd.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */