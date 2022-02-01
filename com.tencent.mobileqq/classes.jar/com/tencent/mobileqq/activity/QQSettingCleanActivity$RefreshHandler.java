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
      if ((this.a.c != null) && (this.a.c.isShowing()))
      {
        this.a.c.cancel();
        this.a.c.a(this.a.getString(2131887798));
        this.a.c.c(true);
        this.a.c.a(false);
        this.a.c.b(true);
      }
    }
    else
    {
      if (!this.a.isFinishing())
      {
        this.a.c.a(this.a.getString(2131887796));
        this.a.c.d(2130851772);
        this.a.c.b(false);
      }
      sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.RefreshHandler
 * JD-Core Version:    0.7.0.1
 */