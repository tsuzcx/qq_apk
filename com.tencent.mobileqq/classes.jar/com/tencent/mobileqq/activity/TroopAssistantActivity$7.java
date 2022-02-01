package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

class TroopAssistantActivity$7
  extends TransProcessorHandler
{
  TroopAssistantActivity$7(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.7
 * JD-Core Version:    0.7.0.1
 */