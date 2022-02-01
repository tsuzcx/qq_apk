package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoTypeSupplier
  implements MessageTypeSupplier
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    switch (((MessageForShortVideo)paramChatMessage).busiType)
    {
    default: 
      return 29;
    case 1: 
      return 38;
    case 2: 
      return 46;
    case 1007: 
      return 40;
    }
    return 41;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.ShortVideoTypeSupplier
 * JD-Core Version:    0.7.0.1
 */