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
      ToastUtil.a().a(this.a.getString(2131692959));
      DeviceMsgSettingActivity.b(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(this.a.getString(2131692959));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          ToastUtil.a().a(this.a.getString(2131692959));
          this.a.jdField_a_of_type_AndroidOsHandler.post(new DeviceMsgSettingActivity.2.1(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          ToastUtil.a().a(this.a.getString(2131694516));
          DeviceMsgSettingActivity.b(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        LogUtility.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        ToastUtil.a().a(this.a.getString(2131692959));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        DeviceMsgSettingActivity.DeviceMsgSetting localDeviceMsgSetting = new DeviceMsgSettingActivity.DeviceMsgSetting(this.a, null);
        localDeviceMsgSetting.jdField_a_of_type_Int = localJSONObject.getInt("id");
        localDeviceMsgSetting.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
        localDeviceMsgSetting.b = localJSONObject.getInt("enable");
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localDeviceMsgSetting);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */