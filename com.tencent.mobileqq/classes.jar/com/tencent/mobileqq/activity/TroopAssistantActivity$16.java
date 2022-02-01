package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class TroopAssistantActivity$16
  extends MqqHandler
{
  TroopAssistantActivity$16(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.app.isLogin()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.c();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.16
 * JD-Core Version:    0.7.0.1
 */