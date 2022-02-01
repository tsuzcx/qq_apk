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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("schedule: userfontid=");
      localStringBuilder.append(VasShieldFont.e);
      QLog.d("VasShieldFont", 2, localStringBuilder.toString());
    }
    if ((VasShieldFont.e == 0) && (VasShieldFont.l()))
    {
      VasShieldFont.a(false);
      VasShieldFont.a(this.a, this.b.b, this.b.a);
      this.a.getPreferences().edit().putBoolean("keySysFontGrayTip", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.VasShieldFont.2
 * JD-Core Version:    0.7.0.1
 */