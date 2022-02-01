package com.tencent.imcore.message.msgproxy;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import mqq.app.AppRuntime;

public class ChatMessageMsgProxy
  extends MsgProxyWrapper
{
  @Metadata
  public ChatMessageMsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramMessageRecord = super.a(paramMessageRecord, paramBoolean);
    if ((paramMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)paramMessageRecord).reParse();
    }
    return paramMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    paramString = super.a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    if ((paramString instanceof ChatMessage)) {
      ((ChatMessage)paramString).reParse();
    }
    return paramString;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    paramString1 = super.a(paramString1, paramInt, paramLong, paramString2);
    if ((paramString1 instanceof ChatMessage)) {
      ((ChatMessage)paramString1).reParse();
    }
    return paramString1;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    paramString1 = super.a(paramString1, paramInt, paramLong, paramString2, paramObject);
    if ((paramString1 instanceof ChatMessage)) {
      ((ChatMessage)paramString1).reParse();
    }
    return paramString1;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    paramString = super.a(paramString, paramInt, paramLong, paramArrayOfByte);
    if ((paramString instanceof ChatMessage)) {
      ((ChatMessage)paramString).reParse();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.ChatMessageMsgProxy
 * JD-Core Version:    0.7.0.1
 */