package com.tencent.device.bind;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.smartdevice.SmartDevicePluginLoader;

class DevicePluginDownloadActivity$3
  implements DialogInterface.OnClickListener
{
  DevicePluginDownloadActivity$3(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SmartDevicePluginLoader.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity.3
 * JD-Core Version:    0.7.0.1
 */