package com.tencent.mobileqq.activity.contacts.device;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;

class DeviceFragment$4
  extends MessageObserver
{
  DeviceFragment$4(DeviceFragment paramDeviceFragment) {}
  
  protected void onSelfIpadOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (this.a.a == null) {
      return;
    }
    DeviceFragment localDeviceFragment = this.a;
    boolean bool;
    if (paramInt1 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localDeviceFragment.e = bool;
    this.a.a.e();
    this.a.a.a(this.a.e, AppConstants.DATALINE_IPAD_UIN);
    this.a.a.notifyDataSetChanged();
  }
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (this.a.a == null) {
      return;
    }
    DeviceFragment localDeviceFragment = this.a;
    boolean bool;
    if (paramInt1 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localDeviceFragment.d = bool;
    this.a.a.d();
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.4
 * JD-Core Version:    0.7.0.1
 */