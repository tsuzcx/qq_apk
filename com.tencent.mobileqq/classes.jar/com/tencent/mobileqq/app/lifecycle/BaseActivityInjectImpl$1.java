package com.tencent.mobileqq.app.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class BaseActivityInjectImpl$1
  implements TeleScreenRunnable
{
  BaseActivityInjectImpl$1(BaseActivityInjectImpl paramBaseActivityInjectImpl, QBaseActivity paramQBaseActivity, Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivityForResultOriginal(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("qqBaseActivity", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */