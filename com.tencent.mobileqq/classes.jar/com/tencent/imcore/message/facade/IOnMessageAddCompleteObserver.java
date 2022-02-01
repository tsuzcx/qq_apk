package com.tencent.imcore.message.facade;

import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract interface IOnMessageAddCompleteObserver<T extends BaseQQMessageFacade>
{
  public abstract void a(T paramT, List<MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.IOnMessageAddCompleteObserver
 * JD-Core Version:    0.7.0.1
 */