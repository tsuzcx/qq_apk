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
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    int j = 0;
    String str = "set_lightapp_property";
    paramString = str;
    int i = j;
    if ("9971".equals(this.c))
    {
      paramString = str;
      i = j;
      if ("9971".equals(this.b))
      {
        i = 2;
        paramString = "set_device_property";
      }
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131377908));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131692960);
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
    int j = 0;
    String str2 = "get_lightapp_property";
    String str1 = str2;
    int i = j;
    if ("9971".equals(this.c))
    {
      str1 = str2;
      i = j;
      if ("9971".equals(this.b))
      {
        i = 2;
        str1 = "get_device_property";
      }
    }
    SmartDeviceUtil.a(str1, localBundle, i, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new DeviceMsgSettingActivity.2(this));
  }
  
  private void d()
  {
    Object localObject = (TextView)super.findViewById(2131377916);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = super.findViewById(2131377910);
      if (localObject != null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label99;
        }
        ((View)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = super.findViewById(2131377911);
      if (localObject != null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label107;
        }
        ((View)localObject).setVisibility(0);
        LogUtility.c("DeviceMsgSettingActivity", "show none background");
      }
      return;
      ((TextView)localObject).setVisibility(0);
      break;
      label99:
      ((View)localObject).setVisibility(0);
    }
    label107:
    LogUtility.c("DeviceMsgSettingActivity", "hide none background");
    ((View)localObject).setVisibility(8);
  }
  
  public void a()
  {
    d();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j)
    {
      DeviceMsgSettingActivity.DeviceMsgSetting localDeviceMsgSetting = (DeviceMsgSettingActivity.DeviceMsgSetting)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setBgType(0);
      localFormSwitchItem.setText(localDeviceMsgSetting.jdField_a_of_type_JavaLangString);
      localFormSwitchItem.setFocusable(true);
      label76:
      Switch localSwitch;
      if (j == 1)
      {
        localFormSwitchItem.setBgType(0);
        localSwitch = localFormSwitchItem.a();
        localSwitch.setTag(Integer.valueOf(localDeviceMsgSetting.jdField_a_of_type_Int));
        if (localDeviceMsgSetting.b != 1) {
          break label173;
        }
      }
      label173:
      for (boolean bool = true;; bool = false)
      {
        localSwitch.setChecked(bool);
        localSwitch.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSwitchItem);
        i += 1;
        break;
        if (i == 0)
        {
          localFormSwitchItem.setBgType(1);
          break label76;
        }
        if (i == j - 1)
        {
          localFormSwitchItem.setBgType(3);
          break label76;
        }
        localFormSwitchItem.setBgType(2);
        break label76;
      }
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559151);
    super.setTitle(2131691643);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!PermissionUtils.isStorePermissionEnable(this)) {
        PermissionUtils.requestStorePermission(this, 3, new DeviceMsgSettingActivity.1(this));
      }
    }
    for (;;)
    {
      return true;
      b();
      continue;
      b();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719088);
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    Object localObject1 = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject2;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (DeviceMsgSettingActivity.DeviceMsgSetting)localIterator.next();
        if (((DeviceMsgSettingActivity.DeviceMsgSetting)localObject2).jdField_a_of_type_Int == j)
        {
          int k = ((DeviceMsgSettingActivity.DeviceMsgSetting)localObject2).b;
          if (paramBoolean)
          {
            i = 1;
            label109:
            if (k != i) {
              break label174;
            }
            localObject1 = this.app;
            long l = Long.parseLong(this.c);
            if (!paramBoolean) {
              break label169;
            }
            i = 1;
            label136:
            SmartDeviceReport.a((AppRuntime)localObject1, l, "Usr_MsgMgr_Setting", i, 1, Integer.parseInt(this.b));
          }
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break label109;
      label169:
      i = 2;
      break label136;
      for (;;)
      {
        try
        {
          label174:
          localObject2 = new JSONObject().put("id", ((DeviceMsgSettingActivity.DeviceMsgSetting)localObject2).jdField_a_of_type_Int);
          if (!paramBoolean) {
            break label228;
          }
          i = 1;
          ((JSONArray)localObject1).put(((JSONObject)localObject2).put("enable", i));
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        break;
        label228:
        i = 0;
      }
      this.jdField_a_of_type_AndroidWidgetCompoundButton = paramCompoundButton;
      a(((JSONArray)localObject1).toString());
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity
 * JD-Core Version:    0.7.0.1
 */