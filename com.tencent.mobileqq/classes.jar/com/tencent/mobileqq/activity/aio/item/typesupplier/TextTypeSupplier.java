package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;

public class TextTypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      return 63;
    }
    if ((paramChatMessage instanceof MessageForWantGiftMsg)) {
      return 72;
    }
    if ((paramChatMessage.vipBubbleID == 100000L) && (!paramChatMessage.isSend())) {
      return 9;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.TextTypeSupplier
 * JD-Core Version:    0.7.0.1
 */