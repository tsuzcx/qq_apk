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
    this.a.f.dismiss();
    if (!paramBoolean)
    {
      ToastUtil.a().a(this.a.getString(2131890030));
      DeviceMsgSettingActivity.b(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(this.a.getString(2131890030));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          ToastUtil.a().a(this.a.getString(2131890030));
          continue;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle != null) {
          continue;
        }
        ToastUtil.a().a(this.a.getString(2131892163));
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
      localDeviceMsgSetting.a = localJSONObject.getInt("id");
      localDeviceMsgSetting.b = localJSONObject.getString("name");
      localDeviceMsgSetting.c = localJSONObject.getInt("enable");
      this.a.e.add(localDeviceMsgSetting);
      paramInt += 1;
    }
    LogUtility.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
    ToastUtil.a().a(this.a.getString(2131890030));
    this.a.h.post(new DeviceMsgSettingActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */