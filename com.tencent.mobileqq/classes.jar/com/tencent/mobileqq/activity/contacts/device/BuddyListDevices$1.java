package com.tencent.mobileqq.activity.contacts.device;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;

class BuddyListDevices$1
  implements Animation.AnimationListener
{
  BuddyListDevices$1(BuddyListDevices paramBuddyListDevices, SmartDeviceProxyMgr paramSmartDeviceProxyMgr, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b("");
    this.b.setBackgroundResource(2130839577);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.BuddyListDevices.1
 * JD-Core Version:    0.7.0.1
 */