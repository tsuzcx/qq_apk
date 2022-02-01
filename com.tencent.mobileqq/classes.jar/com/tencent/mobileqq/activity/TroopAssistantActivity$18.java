package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class TroopAssistantActivity$18
  extends MqqHandler
{
  TroopAssistantActivity$18(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.app.isLogin()) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.a.c();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.18
 * JD-Core Version:    0.7.0.1
 */