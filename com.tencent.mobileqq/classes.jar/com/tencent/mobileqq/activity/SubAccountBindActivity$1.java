package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class SubAccountBindActivity$1
  extends MqqHandler
{
  SubAccountBindActivity$1(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1981)
    {
      if (i != 1990) {
        return;
      }
      this.a.dimissDialog();
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.1
 * JD-Core Version:    0.7.0.1
 */