package com.tencent.mobileqq.activity.contacts.device;

import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceObserver;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import java.util.ArrayList;

class DeviceFragment$7
  extends SmartDeviceObserver
{
  DeviceFragment$7(DeviceFragment paramDeviceFragment) {}
  
  protected void a(ArrayList<DeviceInfo> paramArrayList)
  {
    if (this.a.e)
    {
      DeviceFragment localDeviceFragment = this.a;
      localDeviceFragment.e = false;
      if (DeviceFragment.a(localDeviceFragment) != null) {
        DeviceFragment.b(this.a).a(this.a.i(), true, null);
      }
    }
    if (this.a.b == null) {
      return;
    }
    this.a.b.c = ((ArrayList)paramArrayList.clone());
    this.a.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.7
 * JD-Core Version:    0.7.0.1
 */