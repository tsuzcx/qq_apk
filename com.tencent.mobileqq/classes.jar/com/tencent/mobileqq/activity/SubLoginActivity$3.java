package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class SubLoginActivity$3
  extends MqqHandler
{
  SubLoginActivity$3(SubLoginActivity paramSubLoginActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1982)
    {
      if (i != 2001)
      {
        if (i != 2002) {
          return;
        }
        if (!this.a.isFinishing()) {
          SubLoginActivity.a(this.a, true);
        }
      }
      else
      {
        this.a.hideJuhua();
      }
    }
    else {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.3
 * JD-Core Version:    0.7.0.1
 */