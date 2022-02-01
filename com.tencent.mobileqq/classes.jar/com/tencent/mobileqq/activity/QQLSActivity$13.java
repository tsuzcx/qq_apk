package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class QQLSActivity$13
  extends Handler
{
  QQLSActivity$13(QQLSActivity paramQQLSActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 200)
    {
      switch (i)
      {
      default: 
        return;
      case 16: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "message finish activity finish, enter aio");
        }
        this.a.finish();
        return;
      case 15: 
        QQLSActivity.w(this.a);
        return;
      case 14: 
        QQLSActivity.b(this.a, false);
        return;
      case 13: 
        QQLSActivity.v(this.a);
        return;
      case 12: 
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("check sensor HasCallBack ====");
          paramMessage.append(QQLSActivity.q(this.a));
          QLog.d("QQLSActivity", 2, paramMessage.toString());
        }
        if (QQLSActivity.q(this.a))
        {
          QQLSActivity.u(this.a);
          return;
        }
        if (!QQLSActivity.r(this.a)) {
          break;
        }
        QQLSActivity.s(this.a);
        return;
      case 11: 
        boolean bool = QQLSActivity.t(this.a);
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("LS MSG_CHECKISLOCK");
          paramMessage.append(bool);
          QLog.d("QQLSActivity", 2, paramMessage.toString());
        }
        if (bool) {
          break;
        }
        this.a.finish();
        return;
      case 10: 
        paramMessage = new Intent(this.a, QQLSActivity.class);
        paramMessage.addFlags(131072);
        this.a.startActivity(paramMessage);
        return;
      case 9: 
        if (QQLSActivity.d(this.a)) {
          break;
        }
        ReportController.b(QQLSActivity.i(this.a), "CliOper", "", "", "0X800444B", "0X800444B", 0, 0, "", "", "", "");
        paramMessage = new Intent(this.a, QQLSUnlockActivity.class);
        this.a.startActivity(paramMessage);
        return;
      case 8: 
        this.a.b();
        return;
      case 7: 
        if ((QQLSActivity.q(this.a)) || (!QQLSActivity.r(this.a))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "sensor don't callback 1000ms later");
        }
        QQLSActivity.s(this.a);
        return;
      case 6: 
        if (QQLSActivity.o(this.a)) {
          break;
        }
        if (hasMessages(6)) {
          removeMessages(6);
        }
        QQLSActivity.p(this.a);
        if (QQLSActivity.g(this.a) != null) {
          ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.g(this.a).getWindowToken(), 0);
        }
        QQLSActivity.e(this.a).setVisibility(0);
        paramMessage = obtainMessage(4);
        if (hasMessages(4)) {
          removeMessages(4);
        }
        sendMessageDelayed(paramMessage, 1200L);
        return;
      case 5: 
        if (QQLSActivity.o(this.a)) {
          break;
        }
        if (hasMessages(5)) {
          removeMessages(5);
        }
        QQLSActivity.p(this.a);
        if (QQLSActivity.g(this.a) != null) {
          ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.g(this.a).getWindowToken(), 0);
        }
        QQLSActivity.n(this.a).setVisibility(0);
        paramMessage = obtainMessage(3);
        if (hasMessages(3)) {
          removeMessages(3);
        }
        sendMessageDelayed(paramMessage, 1200L);
        return;
      case 4: 
        QQLSActivity.e(this.a).setVisibility(4);
        return;
      case 3: 
        QQLSActivity.n(this.a).setVisibility(4);
        return;
      case 2: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "message finish activity finish");
        }
        this.a.finish();
        return;
      case 1: 
        this.a.d();
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "message send finish");
        }
        QQLSActivity.k(this.a);
        return;
      }
    }
    else
    {
      this.a.n.a(QQLSActivity.i(this.a), (String)paramMessage.obj, 1008, false, -1, false);
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.13
 * JD-Core Version:    0.7.0.1
 */