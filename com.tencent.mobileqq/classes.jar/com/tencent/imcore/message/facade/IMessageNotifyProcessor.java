package com.tencent.imcore.message.facade;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract interface IMessageNotifyProcessor<T extends BaseQQAppInterface>
{
  public abstract void a(T paramT, List<MessageRecord> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.IMessageNotifyProcessor
 * JD-Core Version:    0.7.0.1
 */