package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class LongMsgTypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -1036) {
      return 17;
    }
    return 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.LongMsgTypeSupplier
 * JD-Core Version:    0.7.0.1
 */