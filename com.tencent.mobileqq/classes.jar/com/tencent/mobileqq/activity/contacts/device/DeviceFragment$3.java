package com.tencent.mobileqq.activity.contacts.device;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

class DeviceFragment$3
  implements Runnable
{
  DeviceFragment$3(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.3
 * JD-Core Version:    0.7.0.1
 */