package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface ChatHistoryImageView$OperCallBack
{
  public abstract void a();
  
  public abstract void a(AIORichMediaInfo paramAIORichMediaInfo);
  
  public abstract void a(ChatMessage paramChatMessage);
  
  public abstract boolean a();
  
  public abstract boolean a(AIORichMediaInfo paramAIORichMediaInfo);
  
  public abstract void b(ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.OperCallBack
 * JD-Core Version:    0.7.0.1
 */