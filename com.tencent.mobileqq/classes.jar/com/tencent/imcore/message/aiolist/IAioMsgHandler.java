package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface IAioMsgHandler
{
  public abstract Object[] a(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, List<ChatMessage> paramList3, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.aiolist.IAioMsgHandler
 * JD-Core Version:    0.7.0.1
 */