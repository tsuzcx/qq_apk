package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract interface IAddMessageHandler
{
  public abstract void a(AppRuntime paramAppRuntime, IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Map<String, MessageRecord> paramMap, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.adder.IAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */