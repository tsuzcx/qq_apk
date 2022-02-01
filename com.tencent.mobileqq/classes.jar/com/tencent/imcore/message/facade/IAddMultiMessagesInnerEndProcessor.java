package com.tencent.imcore.message.facade;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract interface IAddMultiMessagesInnerEndProcessor<FT extends BaseQQMessageFacade, T extends BaseQQAppInterface>
{
  public abstract void a(FT paramFT, T paramT, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor
 * JD-Core Version:    0.7.0.1
 */