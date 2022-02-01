package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class SubAccountUgActivity$3
  extends MqqHandler
{
  SubAccountUgActivity$3(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1980) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.3
 * JD-Core Version:    0.7.0.1
 */