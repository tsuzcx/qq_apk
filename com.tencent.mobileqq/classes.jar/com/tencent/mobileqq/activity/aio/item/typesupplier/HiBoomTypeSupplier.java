package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hiboom.HiBoomManager;

public class HiBoomTypeSupplier
  implements MessageTypeSupplier
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (HiBoomManager.a(paramQQAppInterface).a()) {
      return 78;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.HiBoomTypeSupplier
 * JD-Core Version:    0.7.0.1
 */