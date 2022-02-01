package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$20
  implements Runnable
{
  ChatSettingForTroop$20(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateGridTroopMemberFace,isFinishing() = " + this.this$0.isFinishing());
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.20
 * JD-Core Version:    0.7.0.1
 */