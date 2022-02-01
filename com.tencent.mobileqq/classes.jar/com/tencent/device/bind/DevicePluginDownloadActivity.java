package com.tencent.device.bind;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneShareManager;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

public class DevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static int a = 0;
  public static String a = "agent_type";
  private static String b = "DevicePluginDownloadActivity";
  private Intent a;
  private String c = "";
  
  private void a()
  {
    String str;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("jumpPublicDevice", false)) {
      str = "com.tencent.device.activities.DeviceSquareActivity";
    }
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("public_device", 0) != 0)
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("nickname", this.app.getCurrentNickname());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("bitmap", this.app.getFaceBitmap(this.app.getCurrentAccountUin(), (byte)2, false));
        str = "com.tencent.device.activities.DeviceScanActivity";
      }
      else
      {
        str = "com.tencent.device.activities.DeviceShareConfirmActivity";
      }
    }
    SmartDevicePluginLoader.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.jdField_a_of_type_AndroidContentIntent, str, 0, null, SmartDevicePluginProxyActivity.class);
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
        super.setContentView(2131559047);
        super.setTitle(2131691574);
        super.setLeftViewName(2131691574);
        SmartDeviceReport.a().a(1);
        SmartDeviceReport.a().jdField_a_of_type_JavaLangString = "";
        SmartDeviceReport.a().jdField_a_of_type_Int = 0;
        int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("entrance", 1);
        SmartDeviceReport.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", i);
        DeviceScanner.openDeviceQCodeUrl(this, null, str);
        super.finish();
        return true;
      }
      super.finish();
      return true;
    }
    if ("share".equals(this.c))
    {
      if ((!TextUtils.isEmpty(this.c)) && (this.c.equals("share")))
      {
        if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra(jdField_a_of_type_JavaLangString, -1) == 0)
        {
          if (!QZoneShareManager.jumpToQzoneShare((AppInterface)super.getAppRuntime(), this, this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("data"), null)) {
            QRUtils.a(1, 2131689486);
          }
          super.finish();
          return true;
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("uinname", ContactUtils.c(this.app, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")));
        if (SmartDevicePluginLoader.a().a((QQAppInterface)super.getAppRuntime()))
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
        SmartDevicePluginLoader.a().addObserver(this);
        SmartDevicePluginLoader.a().a();
        return true;
      }
    }
    else
    {
      super.setContentView(2131559048);
      super.setTitle(2131691370);
      SmartDevicePluginLoader.a().addObserver(this);
      this.leftView.setText(2131690529);
      if (!SmartDevicePluginLoader.a().a(this.app)) {
        SmartDevicePluginLoader.a().a();
      }
    }
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!PermissionUtils.isStorePermissionEnable(this)) {
        PermissionUtils.requestStorePermission(this, 3, new DevicePluginDownloadActivity.1(this));
      } else {
        a();
      }
    }
    else {
      a();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SmartDevicePluginLoader.a().deleteObserver(this);
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
      if (QLog.isColorLevel())
      {
        paramObject = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recv notify : plugin install finished with code ");
        localStringBuilder.append(paramObservable);
        QLog.d(paramObject, 2, localStringBuilder.toString());
      }
      if (paramObservable.intValue() != 0)
      {
        paramObservable = DialogUtil.a(this, 230);
        paramObservable.setNegativeButton(2131690728, new DevicePluginDownloadActivity.2(this));
        paramObservable.setPositiveButton(2131691576, new DevicePluginDownloadActivity.3(this));
        paramObservable.setTitle(2131691573);
        paramObservable.setMessage(2131691572);
        paramObservable.show();
        return;
      }
      if ("share".equals(this.c))
      {
        a();
      }
      else
      {
        paramObservable = new Intent();
        paramObject = super.getIntent();
        paramObservable.putExtra("DevicePID", paramObject.getStringExtra("DevicePID"));
        paramObservable.putExtra("DeviceSN", paramObject.getStringExtra("DeviceSN"));
        paramObservable.putExtra("DeviceToken", paramObject.getStringExtra("DeviceToken"));
        paramObservable.putExtra("DataReportSeq", SmartDeviceReport.a().jdField_a_of_type_Long);
        SmartDevicePluginLoader.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
      }
      super.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */