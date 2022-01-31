package com.tencent.device.bind;

import aagb;
import amrk;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import bdgc;
import bdgm;
import bdjz;
import bjev;
import bkce;
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
import ybk;
import zsj;
import zsk;
import zsl;

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
      bkce.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.jdField_a_of_type_AndroidContentIntent, str, 0, null, SmartDevicePluginProxyActivity.class);
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
        super.setContentView(2131559008);
        super.setTitle(2131691668);
        super.setLeftViewName(2131691668);
        aagb.a().a(1);
        aagb.a().jdField_a_of_type_JavaLangString = "";
        aagb.a().jdField_a_of_type_Int = 0;
        int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("entrance", 1);
        aagb.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", i);
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
        if (!bjev.a((AppInterface)super.getAppRuntime(), this, this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("data"), null)) {
          ybk.a(1, 2131689512);
        }
        super.finish();
        return true;
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uinname", bdgc.i(this.app, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")));
      if (bkce.a().a((QQAppInterface)super.getAppRuntime()))
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
      bkce.a().addObserver(this);
      bkce.a().a();
      return true;
      super.setContentView(2131559009);
      super.setTitle(2131691431);
      bkce.a().addObserver(this);
      this.leftView.setText(2131690382);
    } while (bkce.a().a(this.app));
    bkce.a().a();
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!amrk.a(this)) {
        amrk.a(this, 3, new zsj(this));
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
    bkce.a().deleteObserver(this);
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
        paramObservable = bdgm.a(this, 230);
        paramObservable.setNegativeButton(2131690648, new zsk(this));
        paramObservable.setPositiveButton(2131691671, new zsl(this));
        paramObservable.setTitle(2131691667);
        paramObservable.setMessage(2131691666);
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
      paramObservable.putExtra("DataReportSeq", aagb.a().jdField_a_of_type_Long);
      bkce.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */