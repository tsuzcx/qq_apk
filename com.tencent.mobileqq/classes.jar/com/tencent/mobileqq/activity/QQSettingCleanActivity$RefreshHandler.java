package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;

class QQSettingCleanActivity$RefreshHandler
  extends Handler
{
  QQSettingCleanActivity$RefreshHandler(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((this.a.a != null) && (this.a.a.isShowing()))
      {
        this.a.a.cancel();
        this.a.a.a(this.a.getString(2131690861));
        this.a.a.c(true);
        this.a.a.a(false);
        this.a.a.b(true);
      }
    }
    else
    {
      if (!this.a.isFinishing())
      {
        this.a.a.a(this.a.getString(2131690859));
        this.a.a.d(2130850009);
        this.a.a.b(false);
      }
      sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.RefreshHandler
 * JD-Core Version:    0.7.0.1
 */