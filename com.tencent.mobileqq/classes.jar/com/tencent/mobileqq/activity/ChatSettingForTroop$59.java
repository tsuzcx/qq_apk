package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$59
  implements IApolloExtensionObserver
{
  ChatSettingForTroop$59(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onGetMyTroopEffect  result = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(true);
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 26) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.59
 * JD-Core Version:    0.7.0.1
 */