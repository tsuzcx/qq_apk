package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import mqq.app.AppRuntime;

public abstract interface BaseMessageProcessor$Callback
{
  public abstract MessageCache a(BaseMessageProcessor paramBaseMessageProcessor);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessor.Callback
 * JD-Core Version:    0.7.0.1
 */