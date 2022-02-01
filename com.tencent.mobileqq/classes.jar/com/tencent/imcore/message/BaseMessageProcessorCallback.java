package com.tencent.imcore.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import mqq.app.AppRuntime;

public class BaseMessageProcessorCallback
  implements BaseMessageProcessor.Callback
{
  public MessageCache a(BaseMessageProcessor paramBaseMessageProcessor)
  {
    return (MessageCache)paramBaseMessageProcessor.a().getMsgCache();
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return MessageHandlerUtils.a((QQAppInterface)paramAppRuntime, paramMessageRecord, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */