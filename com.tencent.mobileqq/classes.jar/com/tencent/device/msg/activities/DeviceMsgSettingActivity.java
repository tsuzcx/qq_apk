package com.tencent.device.msg.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;

public class DeviceMsgSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  CompoundButton jdField_a_of_type_AndroidWidgetCompoundButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  ArrayList<DeviceMsgSettingActivity.DeviceMsgSetting> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  String b;
  String c;
  
  private void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("din", this.c);
    localBundle.putString("pid", this.b);
    localBundle.putString("appid", "1300000607");
    localBundle.putString("data", paramString);
    int i;
    if (("9971".equals(this.c)) && ("9971".equals(this.b)))
    {
      paramString = "set_device_property";
      i = 2;
    }
    else
    {
      paramString = "set_lightapp_property";
      i = 0;
    }
    SmartDeviceUtil.a(paramString, localBundle, i, null, this.app, new DeviceMsgSettingActivity.3(this));
  }
  
  private void b()
  {
    Intent localIntent = super.getIntent();
    this.b = String.valueOf(localIntent.getIntExtra("pid", 0));
    this.c = localIntent.getStringExtra("din");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)super.getAppRuntime());
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131377334));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131692920);
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    c();
    SmartDeviceReport.a(this.app, Long.parseLong(this.c), "Usr_MsgMgr_Open", 0, 0, Integer.parseInt(this.b));
  }
  
  private void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("din", this.c);
    localBundle.putString("pid", this.b);
    localBundle.putString("appid", "1300000607");
    String str;
    int i;
    if (("9971".equals(this.c)) && ("9971".equals(this.b)))
    {
      str = "get_device_property";
      i = 2;
    }
    else
    {
      str = "get_lightapp_property";
      i = 0;
    }
    SmartDeviceUtil.a(str, localBundle, i, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new DeviceMsgSettingActivity.2(this));
  }
  
  private void d()
  {
    Object localObject = (TextView)super.findViewById(2131377342);
    if (localObject != null) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        ((TextView)localObject).setVisibility(8);
      } else {
        ((TextView)localObject).setVisibility(0);
      }
    }
    localObject = super.findViewById(2131377336);
    if (localObject != null) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        ((View)localObject).setVisibility(8);
      } else {
        ((View)localObject).setVisibility(0);
      }
    }
    localObject = super.findViewById(2131377337);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        ((View)localObject).setVisibility(0);
        LogUtility.c("DeviceMsgSettingActivity", "show none background");
        return;
      }
      LogUtility.c("DeviceMsgSettingActivity", "hide none background");
      ((View)localObject).setVisibility(8);
    }
  }
  
  public void a()
  {
    d();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      DeviceMsgSettingActivity.DeviceMsgSetting localDeviceMsgSetting = (DeviceMsgSettingActivity.DeviceMsgSetting)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setBgType(0);
      localFormSwitchItem.setText(localDeviceMsgSetting.jdField_a_of_type_JavaLangString);
      boolean bool = true;
      localFormSwitchItem.setFocusable(true);
      if (j == 1) {
        localFormSwitchItem.setBgType(0);
      } else if (i == 0) {
        localFormSwitchItem.setBgType(1);
      } else if (i == j - 1) {
        localFormSwitchItem.setBgType(3);
      } else {
        localFormSwitchItem.setBgType(2);
      }
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setTag(Integer.valueOf(localDeviceMsgSetting.jdField_a_of_type_Int));
      if (localDeviceMsgSetting.b != 1) {
        bool = false;
      }
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSwitchItem);
      i += 1;
    }
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
    super.setContentView(2131559045);
    super.setTitle(2131691565);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!PermissionUtils.isStorePermissionEnable(this)) {
        PermissionUtils.requestStorePermission(this, 3, new DeviceMsgSettingActivity.1(this));
      } else {
        b();
      }
    }
    else {
      b();
    }
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity
 * JD-Core Version:    0.7.0.1
 */