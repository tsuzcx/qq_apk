package com.etrump.mixlayout;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

final class VasShieldFont$1
  implements Runnable
{
  VasShieldFont$1(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "loadDefaultFont: type=" + VasShieldFont.a);
    }
    if (!VasShieldFont.a().get())
    {
      if (VasShieldFont.b() == null)
      {
        if (!VasShieldFont.a()) {
          break label135;
        }
        VasShieldFont.c();
        VasShieldFont.b();
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(87);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(87);
      }
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("loadDefaultFont: typeface=");
      if (VasShieldFont.b() == null) {
        break label145;
      }
    }
    label135:
    label145:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VasShieldFont", 2, bool);
      VasShieldFont.b().set(false);
      return;
      VasShieldFont.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.VasShieldFont.1
 * JD-Core Version:    0.7.0.1
 */