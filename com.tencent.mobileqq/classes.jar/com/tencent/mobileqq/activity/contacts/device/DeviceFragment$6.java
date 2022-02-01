package com.tencent.mobileqq.activity.contacts.device;

import com.tencent.mobileqq.app.FriendListObserver;

class DeviceFragment$6
  extends FriendListObserver
{
  DeviceFragment$6(DeviceFragment paramDeviceFragment) {}
  
  public void onPullIpad()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.e();
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.6
 * JD-Core Version:    0.7.0.1
 */