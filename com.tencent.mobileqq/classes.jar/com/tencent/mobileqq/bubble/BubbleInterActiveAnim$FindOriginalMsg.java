package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class BubbleInterActiveAnim$FindOriginalMsg
{
  private boolean a;
  private MessageRecord b;
  private boolean c;
  private ChatMessage d;
  
  public BubbleInterActiveAnim$FindOriginalMsg(MessageRecord paramMessageRecord, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    this.b = paramMessageRecord;
    this.c = paramBoolean;
    this.d = paramChatMessage;
  }
  
  boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public FindOriginalMsg c()
  {
    if (!this.c)
    {
      if (this.d.uniseq == this.b.uniseq) {
        this.c = true;
      }
      this.a = true;
      return this;
    }
    this.a = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.FindOriginalMsg
 * JD-Core Version:    0.7.0.1
 */