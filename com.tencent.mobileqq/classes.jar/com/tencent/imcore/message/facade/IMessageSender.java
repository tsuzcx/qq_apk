package com.tencent.imcore.message.facade;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface IMessageSender<T extends BaseQQAppInterface>
{
  public abstract void a(T paramT, MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.IMessageSender
 * JD-Core Version:    0.7.0.1
 */