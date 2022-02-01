package com.tencent.mobileqq.activity.photo;

import akkr;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class SDKAvatarSettingManager$5
  implements Runnable
{
  public SDKAvatarSettingManager$5(akkr paramakkr) {}
  
  public void run()
  {
    if (akkr.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "-->preForward--fetch openid timeout");
    }
    this.this$0.a = true;
    this.this$0.d();
    akkr.a(this.this$0, akkr.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.5
 * JD-Core Version:    0.7.0.1
 */