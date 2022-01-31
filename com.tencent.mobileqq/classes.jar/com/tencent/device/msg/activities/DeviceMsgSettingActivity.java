package com.tencent.device.msg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qaq;
import qas;
import qat;

public class DeviceMsgSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public Handler a;
  public CompoundButton a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public QQProgressDialog a;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  public String b;
  public String c;
  
  public DeviceMsgSettingActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
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
    SmartDeviceUtil.a(paramString, localBundle, i, null, this.app, new qas(this));
  }
  
  private void b()
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
    SmartDeviceUtil.a(str1, localBundle, i, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new qaq(this));
  }
  
  private void c()
  {
    Object localObject = (TextView)super.findViewById(2131364231);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = super.findViewById(2131364232);
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
      localObject = super.findViewById(2131364229);
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
    c();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j)
    {
      qat localqat = (qat)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setBgType(0);
      localFormSwitchItem.setText(localqat.jdField_a_of_type_JavaLangString);
      localFormSwitchItem.setFocusable(true);
      label76:
      Switch localSwitch;
      if (j == 1)
      {
        localFormSwitchItem.setBgType(0);
        localSwitch = localFormSwitchItem.a();
        localSwitch.setTag(Integer.valueOf(localqat.jdField_a_of_type_Int));
        if (localqat.b != 1) {
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968911);
    super.setTitle(2131427784);
    paramBundle = super.getIntent();
    this.b = String.valueOf(paramBundle.getIntExtra("pid", 0));
    this.c = paramBundle.getStringExtra("din");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)super.getAppRuntime());
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131364233));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131427801);
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    b();
    SmartDeviceReport.a(this.app, Long.parseLong(this.c), "Usr_MsgMgr_Open", 0, 0, Integer.parseInt(this.b));
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131427805);
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (qat)localIterator.next();
      if (((qat)localObject).jdField_a_of_type_Int == j)
      {
        int k = ((qat)localObject).b;
        long l;
        if (paramBoolean)
        {
          i = 1;
          if (k != i) {
            break label164;
          }
          paramCompoundButton = this.app;
          l = Long.parseLong(this.c);
          if (!paramBoolean) {
            break label159;
          }
        }
        label159:
        for (int i = 1;; i = 2)
        {
          SmartDeviceReport.a(paramCompoundButton, l, "Usr_MsgMgr_Setting", i, 1, Integer.parseInt(this.b));
          return;
          i = 0;
          break;
        }
        for (;;)
        {
          try
          {
            label164:
            localObject = new JSONObject().put("id", ((qat)localObject).jdField_a_of_type_Int);
            if (!paramBoolean) {
              break label218;
            }
            i = 1;
            localJSONArray.put(((JSONObject)localObject).put("enable", i));
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          break;
          label218:
          i = 0;
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetCompoundButton = paramCompoundButton;
    a(localJSONArray.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity
 * JD-Core Version:    0.7.0.1
 */