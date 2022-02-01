package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$21
  implements Runnable
{
  ArkAppQQModule$21(ArkAppQQModule paramArkAppQQModule, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      QQToast.makeText(localActivity, this.b, 0).show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() activity is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.21
 * JD-Core Version:    0.7.0.1
 */