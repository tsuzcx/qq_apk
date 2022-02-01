package com.tencent.device.bind;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class DevicePluginDownloadActivity$1
  implements QQPermissionCallback
{
  DevicePluginDownloadActivity$1(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DevicePluginDownloadActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */