package com.tencent.mobileqq.activity.photo;

import agpl;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class SDKAvatarSettingManager$4
  implements Runnable
{
  public SDKAvatarSettingManager$4(agpl paramagpl) {}
  
  public void run()
  {
    if (agpl.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
    }
    this.this$0.b = true;
    agpl.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.4
 * JD-Core Version:    0.7.0.1
 */