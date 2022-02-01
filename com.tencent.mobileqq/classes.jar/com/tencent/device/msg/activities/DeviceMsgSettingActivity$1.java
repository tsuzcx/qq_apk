package com.tencent.device.msg.activities;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class DeviceMsgSettingActivity$1
  implements QQPermissionCallback
{
  DeviceMsgSettingActivity$1(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceMsgSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */