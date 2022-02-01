package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;

public class StructTypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((((MessageForStructing)paramChatMessage).structingMsg instanceof StructMsgSubImageVideo)) {
      return 111;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.StructTypeSupplier
 * JD-Core Version:    0.7.0.1
 */