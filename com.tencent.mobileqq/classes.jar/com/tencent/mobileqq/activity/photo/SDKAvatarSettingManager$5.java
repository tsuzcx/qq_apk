package com.tencent.mobileqq.activity.photo;

import agpn;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class SDKAvatarSettingManager$5
  implements Runnable
{
  public SDKAvatarSettingManager$5(agpn paramagpn) {}
  
  public void run()
  {
    if (agpn.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "-->preForward--fetch openid timeout");
    }
    this.this$0.a = true;
    this.this$0.d();
    agpn.a(this.this$0, agpn.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.5
 * JD-Core Version:    0.7.0.1
 */