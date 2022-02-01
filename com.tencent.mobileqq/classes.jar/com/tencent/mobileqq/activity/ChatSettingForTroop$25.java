package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$25
  implements Runnable
{
  ChatSettingForTroop$25(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateGridTroopMemberFace,isFinishing() = " + this.this$0.isFinishing());
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.25
 * JD-Core Version:    0.7.0.1
 */