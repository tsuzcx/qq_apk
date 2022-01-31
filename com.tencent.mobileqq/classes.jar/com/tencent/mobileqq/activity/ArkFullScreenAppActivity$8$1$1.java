package com.tencent.mobileqq.activity;

import acef;
import aceg;
import alud;
import android.content.Intent;
import aryv;
import bdgm;
import bdjz;
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
        aryv.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity$8$1.a.a, this.jdField_a_of_type_AndroidContentIntent, 100);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "showActionSheet share: intent == null");
      }
      bdgm.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity$8$1.a.a, 230, alud.a(2131701067), alud.a(2131701063), new aceg(this), null).show();
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