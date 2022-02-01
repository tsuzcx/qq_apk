package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$2
  implements Runnable
{
  ChatSettingForTroop$2(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.chatopttroop", 2, "-->preForward--fetch openid timeout");
    }
    this.this$0.n = true;
    this.this$0.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.2
 * JD-Core Version:    0.7.0.1
 */