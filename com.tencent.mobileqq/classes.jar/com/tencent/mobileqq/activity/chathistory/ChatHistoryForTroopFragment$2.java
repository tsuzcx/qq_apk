package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryForTroopFragment$2
  implements TroopAIOImageGeter.LoadMediaDataCallBack
{
  ChatHistoryForTroopFragment$2(ChatHistoryForTroopFragment paramChatHistoryForTroopFragment) {}
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    if ((paramArrayOfAIORichMediaData != null) && (paramArrayOfAIORichMediaData.length > 0))
    {
      this.a.a = paramArrayOfAIORichMediaData[(paramArrayOfAIORichMediaData.length - 1)];
      if (QLog.isColorLevel()) {
        QLog.i("chatHistory.troop.portal", 2, "get the first media data");
      }
    }
    do
    {
      return;
      this.a.a = null;
    } while (!QLog.isColorLevel());
    QLog.i("chatHistory.troop.portal", 2, "no media data found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryForTroopFragment.2
 * JD-Core Version:    0.7.0.1
 */