package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QQSpecialFriendSettingActivity$3
  extends Handler
{
  QQSpecialFriendSettingActivity$3(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 8195: 
      QQToast.a(this.a, paramMessage.arg1, paramMessage.arg2, 0).b(this.a.getTitleBarHeight());
      return;
    case 8194: 
      if ((QQSpecialFriendSettingActivity.a(this.a) != null) && (QQSpecialFriendSettingActivity.a(this.a).isShowing()))
      {
        QQSpecialFriendSettingActivity.a(this.a).dismiss();
        QQSpecialFriendSettingActivity.a(this.a, null);
        return;
      }
      break;
    case 8193: 
      if (QQSpecialFriendSettingActivity.a(this.a) == null)
      {
        QQSpecialFriendSettingActivity localQQSpecialFriendSettingActivity = this.a;
        QQSpecialFriendSettingActivity.a(localQQSpecialFriendSettingActivity, new QQProgressDialog(localQQSpecialFriendSettingActivity, localQQSpecialFriendSettingActivity.getTitleBarHeight()));
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
          QQSpecialFriendSettingActivity.a(this.a).a((String)paramMessage.obj);
        }
      }
      if ((!this.a.isFinishing()) && (!QQSpecialFriendSettingActivity.a(this.a).isShowing())) {
        try
        {
          QQSpecialFriendSettingActivity.a(this.a).show();
          return;
        }
        catch (Exception paramMessage)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQSpecialFriendSettingActivity", 2, "QQProgressDialog show exception.", paramMessage);
          }
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */