package com.tencent.mobileqq.activity.main;

import akam;
import bisl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class MainAssistObserver$24
  implements Runnable
{
  public MainAssistObserver$24(akam paramakam) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "-->onGetOpenId timeout.");
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.isFinishing()) {
      return;
    }
    this.this$0.c = true;
    this.this$0.jdField_a_of_type_Bisl.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.24
 * JD-Core Version:    0.7.0.1
 */