package com.tencent.device.msg.activities;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceMsgSettingActivity$2
  implements BusinessObserver
{
  DeviceMsgSettingActivity$2(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (!paramBoolean)
    {
      ToastUtil.a().a(this.a.getString(2131692919));
      DeviceMsgSettingActivity.b(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(this.a.getString(2131692919));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          ToastUtil.a().a(this.a.getString(2131692919));
          continue;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle != null) {
          continue;
        }
        ToastUtil.a().a(this.a.getString(2131694481));
        DeviceMsgSettingActivity.b(this.a);
        return;
      }
      catch (JSONException paramBundle)
      {
        JSONObject localJSONObject;
        DeviceMsgSettingActivity.DeviceMsgSetting localDeviceMsgSetting;
        continue;
        paramInt = 0;
        continue;
      }
      if (paramInt >= paramBundle.length()) {
        continue;
      }
      localJSONObject = paramBundle.getJSONObject(paramInt);
      localDeviceMsgSetting = new DeviceMsgSettingActivity.DeviceMsgSetting(this.a, null);
      localDeviceMsgSetting.jdField_a_of_type_Int = localJSONObject.getInt("id");
      localDeviceMsgSetting.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
      localDeviceMsgSetting.b = localJSONObject.getInt("enable");
      this.a.jdField_a_of_type_JavaUtilArrayList.add(localDeviceMsgSetting);
      paramInt += 1;
    }
    LogUtility.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
    ToastUtil.a().a(this.a.getString(2131692919));
    this.a.jdField_a_of_type_AndroidOsHandler.post(new DeviceMsgSettingActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */