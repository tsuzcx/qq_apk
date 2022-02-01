package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.qphone.base.util.QLog;

class Conversation$37
  extends TroopOnlinePushObserver
{
  Conversation$37(Conversation paramConversation) {}
  
  protected void onTroopBlockStatusChanged(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_ontroopblockstatuschanged");
    }
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.37
 * JD-Core Version:    0.7.0.1
 */