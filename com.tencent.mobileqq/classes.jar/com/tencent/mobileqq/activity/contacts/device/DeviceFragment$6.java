package com.tencent.mobileqq.activity.contacts.device;

import com.tencent.mobileqq.app.FriendListObserver;

class DeviceFragment$6
  extends FriendListObserver
{
  DeviceFragment$6(DeviceFragment paramDeviceFragment) {}
  
  protected void onPullIpad()
  {
    if (this.a.b == null) {
      return;
    }
    this.a.b.e();
    this.a.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.6
 * JD-Core Version:    0.7.0.1
 */