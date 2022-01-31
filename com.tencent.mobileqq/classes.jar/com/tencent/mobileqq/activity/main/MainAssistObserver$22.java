package com.tencent.mobileqq.activity.main;

import agcf;
import bcqf;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class MainAssistObserver$22
  implements Runnable
{
  public MainAssistObserver$22(agcf paramagcf) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "-->onGetOpenId timeout.");
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.isFinishing()) {
      return;
    }
    this.this$0.c = true;
    this.this$0.jdField_a_of_type_Bcqf.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.22
 * JD-Core Version:    0.7.0.1
 */