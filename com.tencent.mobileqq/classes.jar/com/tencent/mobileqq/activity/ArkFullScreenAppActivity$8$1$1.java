package com.tencent.mobileqq.activity;

import acrj;
import acrk;
import amtj;
import android.content.Intent;
import atky;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ArkFullScreenAppActivity$8$1$1
  implements Runnable
{
  ArkFullScreenAppActivity$8$1$1(ArkFullScreenAppActivity.8.1 param1, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentIntent != null)
      {
        atky.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity$8$1.a.a, this.jdField_a_of_type_AndroidContentIntent, 100);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "showActionSheet share: intent == null");
      }
      bfur.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity$8$1.a.a, 230, amtj.a(2131699834), amtj.a(2131699830), new acrk(this), null).show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 1, "getShareMsg showActionSheet error: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1.1
 * JD-Core Version:    0.7.0.1
 */