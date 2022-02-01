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
  public static String a = "agent_type";
  public static int b = 0;
  private static String c = "DevicePluginDownloadActivity";
  private Intent d;
  private String e = "";
  
  private boolean a()
  {
    this.d = super.getIntent();
    this.e = this.d.getStringExtra("from");
    if ("connect".equals(this.e))
    {
      String str = this.d.getStringExtra("qrurl");
      if (!TextUtils.isEmpty(str))
      {
        super.setContentView(2131624699);
        super.setTitle(2131888536);
        super.setLeftViewName(2131888536);
        SmartDeviceReport.a().a(1);
        SmartDeviceReport.a().b = "";
        SmartDeviceReport.a().c = 0;
        int i = this.d.getIntExtra("entrance", 1);
        SmartDeviceReport.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", i);
        DeviceScanner.openDeviceQCodeUrl(this, null, str);
        super.finish();
        return true;
      }
      super.finish();
      return true;
    }
    if ("share".equals(this.e))
    {
      if ((!TextUtils.isEmpty(this.e)) && (this.e.equals("share")))
      {
        if (this.d.getIntExtra(a, -1) == 0)
        {
          if (!QZoneShareManager.jumpToQzoneShare((AppInterface)super.getAppRuntime(), this, this.d.getBundleExtra("data"), null)) {
            QRUtils.a(1, 2131886094);
          }
          super.finish();
          return true;
        }
        this.d.putExtra("uinname", ContactUtils.c(this.app, this.d.getStringExtra("uin")));
        if (SmartDevicePluginLoader.a().a((QQAppInterface)super.getAppRuntime()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, "start SmartDevicePlugin to goshare");
          }
          b();
          super.finish();
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "download install SmartDevicePlugin");
        }
        SmartDevicePluginLoader.a().addObserver(this);
        SmartDevicePluginLoader.a().b();
        return true;
      }
    }
    else
    {
      super.setContentView(2131624700);
      super.setTitle(2131888325);
      SmartDevicePluginLoader.a().addObserver(this);
      this.leftView.setText(2131887440);
      if (!SmartDevicePluginLoader.a().a(this.app)) {
        SmartDevicePluginLoader.a().b();
      }
    }
    return true;
  }
  
  private void b()
  {
    String str;
    if (this.d.getBooleanExtra("jumpPublicDevice", false)) {
      str = "com.tencent.device.activities.DeviceSquareActivity";
    }
    for (;;)
    {
      break;
      if (this.d.getIntExtra("public_device", 0) != 0)
      {
        this.d.putExtra("nickname", this.app.getCurrentNickname());
        this.d.putExtra("bitmap", this.app.getFaceBitmap(this.app.getCurrentAccountUin(), (byte)2, false));
        str = "com.tencent.device.activities.DeviceScanActivity";
      }
      else
      {
        str = "com.tencent.device.activities.DeviceShareConfirmActivity";
      }
    }
    SmartDevicePluginLoader.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.d, str, 0, null, SmartDevicePluginProxyActivity.class);
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
        paramObject = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recv notify : plugin install finished with code ");
        localStringBuilder.append(paramObservable);
        QLog.d(paramObject, 2, localStringBuilder.toString());
      }
      if (paramObservable.intValue() != 0)
      {
        paramObservable = DialogUtil.a(this, 230);
        paramObservable.setNegativeButton(2131887648, new DevicePluginDownloadActivity.2(this));
        paramObservable.setPositiveButton(2131888538, new DevicePluginDownloadActivity.3(this));
        paramObservable.setTitle(2131888535);
        paramObservable.setMessage(2131888534);
        paramObservable.show();
        return;
      }
      if ("share".equals(this.e))
      {
        b();
      }
      else
      {
        paramObservable = new Intent();
        paramObject = super.getIntent();
        paramObservable.putExtra("DevicePID", paramObject.getStringExtra("DevicePID"));
        paramObservable.putExtra("DeviceSN", paramObject.getStringExtra("DeviceSN"));
        paramObservable.putExtra("DeviceToken", paramObject.getStringExtra("DeviceToken"));
        paramObservable.putExtra("DataReportSeq", SmartDeviceReport.a().d);
        SmartDevicePluginLoader.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
      }
      super.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */