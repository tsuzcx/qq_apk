package com.tencent.mobileqq.activity;

import abzq;
import abzr;
import alpo;
import android.content.Intent;
import arum;
import bdcd;
import bdfq;
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
        arum.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity$8$1.a.a, this.jdField_a_of_type_AndroidContentIntent, 100);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "showActionSheet share: intent == null");
      }
      bdcd.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity$8$1.a.a, 230, alpo.a(2131701055), alpo.a(2131701051), new abzr(this), null).show();
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