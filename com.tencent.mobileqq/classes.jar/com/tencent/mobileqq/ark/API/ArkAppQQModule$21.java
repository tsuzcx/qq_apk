package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import aptb;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ArkAppQQModule$21
  implements Runnable
{
  public ArkAppQQModule$21(aptb paramaptb, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0).a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.21
 * JD-Core Version:    0.7.0.1
 */