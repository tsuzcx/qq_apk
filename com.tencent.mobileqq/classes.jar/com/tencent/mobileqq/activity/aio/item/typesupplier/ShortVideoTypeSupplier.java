package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoTypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int i = ((MessageForShortVideo)paramChatMessage).busiType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 1007)
        {
          if (i != 1008) {
            return 29;
          }
          return 41;
        }
        return 40;
      }
      return 46;
    }
    return 38;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.ShortVideoTypeSupplier
 * JD-Core Version:    0.7.0.1
 */