package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface IMsgUpdateCallback
{
  public abstract void a(AIOContext paramAIOContext, ChatMessage paramChatMessage);
  
  public abstract boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage);
  
  public abstract void b(AIOContext paramAIOContext, ChatMessage paramChatMessage);
  
  public abstract boolean b(AIOContext paramAIOContext, ChatMessage paramChatMessage);
  
  public abstract void c(AIOContext paramAIOContext, ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */