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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadDefaultFont: type=");
      ((StringBuilder)localObject).append(VasShieldFont.b);
      QLog.d("VasShieldFont", 2, ((StringBuilder)localObject).toString());
    }
    if (!VasShieldFont.g().get())
    {
      if (VasShieldFont.h() == null) {
        if (VasShieldFont.i())
        {
          VasShieldFont.j();
          VasShieldFont.d();
        }
        else
        {
          VasShieldFont.c(this.a);
        }
      }
      localObject = this.b;
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeMessages(87);
        this.b.sendEmptyMessage(87);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadDefaultFont: typeface=");
      boolean bool;
      if (VasShieldFont.h() != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("VasShieldFont", 2, ((StringBuilder)localObject).toString());
    }
    VasShieldFont.k().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.VasShieldFont.1
 * JD-Core Version:    0.7.0.1
 */