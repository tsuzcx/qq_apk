package com.tencent.mobileqq.activity.contacts.device;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;

class DeviceFragment$4
  extends MessageObserver
{
  DeviceFragment$4(DeviceFragment paramDeviceFragment) {}
  
  protected void onSelfIpadOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (this.a.b == null) {
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
    this.a.b.e();
    this.a.b.a(this.a.d, AppConstants.DATALINE_IPAD_UIN);
    this.a.b.notifyDataSetChanged();
  }
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (this.a.b == null) {
      return;
    }
    DeviceFragment localDeviceFragment = this.a;
    boolean bool;
    if (paramInt1 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localDeviceFragment.c = bool;
    this.a.b.d();
    this.a.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.4
 * JD-Core Version:    0.7.0.1
 */