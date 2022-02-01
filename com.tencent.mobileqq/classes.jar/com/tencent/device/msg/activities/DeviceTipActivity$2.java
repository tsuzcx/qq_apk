package com.tencent.device.msg.activities;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class DeviceTipActivity$2
  implements QQPermissionCallback
{
  DeviceTipActivity$2(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceTipActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity.2
 * JD-Core Version:    0.7.0.1
 */