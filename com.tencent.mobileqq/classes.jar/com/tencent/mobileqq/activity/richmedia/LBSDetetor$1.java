package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class LBSDetetor$1
  implements Handler.Callback
{
  LBSDetetor$1(LBSDetetor paramLBSDetetor) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check timeout. reqCookie:");
      localStringBuilder.append(paramMessage.what);
      QLog.d("LBSDetetor", 2, localStringBuilder.toString());
    }
    LBSDetetor.a(this.a, false, null, paramMessage.what);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.LBSDetetor.1
 * JD-Core Version:    0.7.0.1
 */