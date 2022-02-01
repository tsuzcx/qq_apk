package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import java.util.ArrayList;

public class PATypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = ((MessageForPubAccount)paramChatMessage).mPAMessage;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.items != null) && (paramQQAppInterface.items.size() != 0))
    {
      if (((PAMessage.Item)paramQQAppInterface.items.get(0)).cover != null)
      {
        if (paramQQAppInterface.items.size() == 1) {
          return 6;
        }
        paramQQAppInterface.items.size();
        return 7;
      }
      return 8;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.PATypeSupplier
 * JD-Core Version:    0.7.0.1
 */