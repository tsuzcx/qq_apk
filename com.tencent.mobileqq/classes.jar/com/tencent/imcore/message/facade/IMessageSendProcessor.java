package com.tencent.imcore.message.facade;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface IMessageSendProcessor<T extends BaseQQAppInterface>
{
  public abstract void a(T paramT, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.IMessageSendProcessor
 * JD-Core Version:    0.7.0.1
 */