package com.tencent.mobileqq.activity.aio.core.msglist.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface MessageTypeSupplier
{
  public abstract int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier
 * JD-Core Version:    0.7.0.1
 */