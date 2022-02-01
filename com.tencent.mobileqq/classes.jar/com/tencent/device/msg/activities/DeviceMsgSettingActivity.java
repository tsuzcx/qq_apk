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
  String a;
  String b;
  String c;
  AppInterface d;
  ArrayList<DeviceMsgSettingActivity.DeviceMsgSetting> e = new ArrayList();
  QQProgressDialog f;
  LinearLayout g;
  Handler h = new Handler();
  CompoundButton i;
  
  private void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.a);
    localBundle.putString("din", this.c);
    localBundle.putString("pid", this.b);
    localBundle.putString("appid", "1300000607");
    localBundle.putString("data", paramString);
    int j;
    if (("9971".equals(this.c)) && ("9971".equals(this.b)))
    {
      paramString = "set_device_property";
      j = 2;
    }
    else
    {
      paramString = "set_lightapp_property";
      j = 0;
    }
    SmartDeviceUtil.a(paramString, localBundle, j, null, this.app, new DeviceMsgSettingActivity.3(this));
  }
  
  private void b()
  {
    Intent localIntent = super.getIntent();
    this.b = String.valueOf(localIntent.getIntExtra("pid", 0));
    this.c = localIntent.getStringExtra("din");
    this.d = ((AppInterface)super.getAppRuntime());
    this.a = this.d.getCurrentAccountUin();
    this.f = new QQProgressDialog(this, super.getTitleBarHeight());
    this.g = ((LinearLayout)super.findViewById(2131445723));
    this.f.c(2131890031);
    if ((!super.isFinishing()) && (!this.f.isShowing())) {
      this.f.show();
    }
    c();
    SmartDeviceReport.a(this.app, Long.parseLong(this.c), "Usr_MsgMgr_Open", 0, 0, Integer.parseInt(this.b));
  }
  
  private void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.a);
    localBundle.putString("din", this.c);
    localBundle.putString("pid", this.b);
    localBundle.putString("appid", "1300000607");
    String str;
    int j;
    if (("9971".equals(this.c)) && ("9971".equals(this.b)))
    {
      str = "get_device_property";
      j = 2;
    }
    else
    {
      str = "get_lightapp_property";
      j = 0;
    }
    SmartDeviceUtil.a(str, localBundle, j, null, this.d, new DeviceMsgSettingActivity.2(this));
  }
  
  private void d()
  {
    Object localObject = (TextView)super.findViewById(2131445731);
    if (localObject != null) {
      if (this.e.size() == 0) {
        ((TextView)localObject).setVisibility(8);
      } else {
        ((TextView)localObject).setVisibility(0);
      }
    }
    localObject = super.findViewById(2131445725);
    if (localObject != null) {
      if (this.e.size() == 0) {
        ((View)localObject).setVisibility(8);
      } else {
        ((View)localObject).setVisibility(0);
      }
    }
    localObject = super.findViewById(2131445726);
    if (localObject != null)
    {
      if (this.e.size() == 0)
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
    int k = this.e.size();
    int j = 0;
    while (j < k)
    {
      DeviceMsgSettingActivity.DeviceMsgSetting localDeviceMsgSetting = (DeviceMsgSettingActivity.DeviceMsgSetting)this.e.get(j);
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setBgType(0);
      localFormSwitchItem.setText(localDeviceMsgSetting.b);
      boolean bool = true;
      localFormSwitchItem.setFocusable(true);
      if (k == 1) {
        localFormSwitchItem.setBgType(0);
      } else if (j == 0) {
        localFormSwitchItem.setBgType(1);
      } else if (j == k - 1) {
        localFormSwitchItem.setBgType(3);
      } else {
        localFormSwitchItem.setBgType(2);
      }
      Switch localSwitch = localFormSwitchItem.getSwitch();
      localSwitch.setTag(Integer.valueOf(localDeviceMsgSetting.a));
      if (localDeviceMsgSetting.c != 1) {
        bool = false;
      }
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      this.g.addView(localFormSwitchItem);
      j += 1;
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
    super.setContentView(2131624697);
    super.setTitle(2131888527);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity
 * JD-Core Version:    0.7.0.1
 */