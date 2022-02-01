package com.tencent.mobileqq.apollo.aio.item.api.impl;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloMessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class ApolloMessageTypeSupplierImpl
  implements MessageTypeSupplier, IApolloMessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    return 56;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.api.impl.ApolloMessageTypeSupplierImpl
 * JD-Core Version:    0.7.0.1
 */