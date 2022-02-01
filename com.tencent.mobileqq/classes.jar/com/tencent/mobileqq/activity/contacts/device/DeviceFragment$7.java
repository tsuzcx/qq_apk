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
    if (this.a.f)
    {
      DeviceFragment localDeviceFragment = this.a;
      localDeviceFragment.f = false;
      if (DeviceFragment.a(localDeviceFragment) != null) {
        DeviceFragment.b(this.a).a(this.a.b(), true, null);
      }
    }
    if (this.a.a == null) {
      return;
    }
    this.a.a.a = ((ArrayList)paramArrayList.clone());
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.7
 * JD-Core Version:    0.7.0.1
 */