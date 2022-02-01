package com.tencent.biz.qqstory.takevideo.rmw;

import android.content.ComponentName;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;

class RMWServiceProxy$1
  implements IBinder.DeathRecipient
{
  RMWServiceProxy$1(RMWServiceProxy paramRMWServiceProxy, ComponentName paramComponentName) {}
  
  public void binderDied()
  {
    RMWLog.c("RMWServiceProxy", "binderDied, delay 1s then reconnect");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(this.jdField_a_of_type_AndroidContentComponentName);
    new Handler(Looper.getMainLooper()).postDelayed(new RMWServiceProxy.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */