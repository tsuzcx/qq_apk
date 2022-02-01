package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;

class GeneralSettingActivity$12
  extends Handler
{
  GeneralSettingActivity$12(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((this.a.d != null) && (this.a.d.isShowing()))
      {
        this.a.d.cancel();
        this.a.d.a(this.a.getString(2131887798));
        this.a.d.c(true);
        this.a.d.a(false);
        this.a.d.b(true);
      }
    }
    else
    {
      if (!this.a.isFinishing())
      {
        this.a.d.a(this.a.getString(2131887796));
        this.a.d.d(2130851772);
        this.a.d.b(false);
      }
      this.a.i.sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.12
 * JD-Core Version:    0.7.0.1
 */