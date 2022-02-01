package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public abstract interface IReloadFilter
{
  public abstract List<ChatMessage> a(AIOContext paramAIOContext, List<ChatMessage> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter
 * JD-Core Version:    0.7.0.1
 */