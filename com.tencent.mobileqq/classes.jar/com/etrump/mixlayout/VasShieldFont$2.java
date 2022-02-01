package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

final class VasShieldFont$2
  extends TimerTask
{
  VasShieldFont$2(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "schedule: userfontid=" + VasShieldFont.c);
    }
    if ((VasShieldFont.c == 0) && (VasShieldFont.b()))
    {
      VasShieldFont.a(false);
      VasShieldFont.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("keySysFontGrayTip", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.VasShieldFont.2
 * JD-Core Version:    0.7.0.1
 */