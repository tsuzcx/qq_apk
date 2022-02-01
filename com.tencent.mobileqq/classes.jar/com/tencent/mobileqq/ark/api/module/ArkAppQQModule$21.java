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
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null)
    {
      QQToast.a(localActivity, this.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() activity is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.21
 * JD-Core Version:    0.7.0.1
 */