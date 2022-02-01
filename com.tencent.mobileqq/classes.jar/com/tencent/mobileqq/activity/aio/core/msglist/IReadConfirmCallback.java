package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public abstract interface IReadConfirmCallback
{
  public abstract void a(AIOContext paramAIOContext);
  
  public abstract void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt);
  
  public abstract void b(AIOContext paramAIOContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */