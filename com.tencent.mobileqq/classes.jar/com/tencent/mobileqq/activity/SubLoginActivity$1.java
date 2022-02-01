package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class SubLoginActivity$1
  extends MqqHandler
{
  SubLoginActivity$1(SubLoginActivity paramSubLoginActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.1
 * JD-Core Version:    0.7.0.1
 */