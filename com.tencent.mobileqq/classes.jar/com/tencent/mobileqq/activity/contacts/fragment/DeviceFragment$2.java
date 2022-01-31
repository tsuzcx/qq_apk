package com.tencent.mobileqq.activity.contacts.fragment;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

class DeviceFragment$2
  implements Runnable
{
  DeviceFragment$2(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment.2
 * JD-Core Version:    0.7.0.1
 */