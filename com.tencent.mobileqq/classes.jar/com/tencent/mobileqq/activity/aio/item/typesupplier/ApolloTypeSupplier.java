package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class ApolloTypeSupplier
  implements MessageTypeSupplier
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (ApolloGameUtil.a(paramChatMessage, paramQQAppInterface) == ApolloGameUtil.c) {
      return 88;
    }
    return 56;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.ApolloTypeSupplier
 * JD-Core Version:    0.7.0.1
 */