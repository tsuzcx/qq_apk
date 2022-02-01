package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QQSpecialCareSettingActivity$2
  extends Handler
{
  QQSpecialCareSettingActivity$2(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    QQSpecialCareSettingActivity localQQSpecialCareSettingActivity;
    switch (paramMessage.what)
    {
    default: 
    case 8195: 
      if (QQSpecialCareSettingActivity.a(this.a) != null) {
        QQSpecialCareSettingActivity.a(this.a).cancel();
      }
      localQQSpecialCareSettingActivity = this.a;
      QQSpecialCareSettingActivity.a(localQQSpecialCareSettingActivity, QQToast.a(localQQSpecialCareSettingActivity, paramMessage.arg1, paramMessage.arg2, 0).b(this.a.getTitleBarHeight()));
      return;
    case 8194: 
      if ((QQSpecialCareSettingActivity.a(this.a) != null) && (QQSpecialCareSettingActivity.a(this.a).isShowing()))
      {
        QQSpecialCareSettingActivity.a(this.a).dismiss();
        QQSpecialCareSettingActivity.a(this.a, null);
        return;
      }
      break;
    case 8193: 
      if (QQSpecialCareSettingActivity.a(this.a) == null)
      {
        localQQSpecialCareSettingActivity = this.a;
        QQSpecialCareSettingActivity.a(localQQSpecialCareSettingActivity, new QQProgressDialog(localQQSpecialCareSettingActivity, localQQSpecialCareSettingActivity.getTitleBarHeight()));
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
          QQSpecialCareSettingActivity.a(this.a).a((String)paramMessage.obj);
        }
      }
      if ((!this.a.isFinishing()) && (!QQSpecialCareSettingActivity.a(this.a).isShowing())) {
        try
        {
          QQSpecialCareSettingActivity.a(this.a).show();
          return;
        }
        catch (Exception paramMessage)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQSpecialCareSettingActivity", 2, "QQProgressDialog show exception.", paramMessage);
          }
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */