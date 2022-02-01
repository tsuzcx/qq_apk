package com.tencent.mobileqq.activity.aio.item;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

class TextItemBuilder$9$1
  implements Runnable
{
  TextItemBuilder$9$1(TextItemBuilder.9 param9, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    this.b.a.d.getMessageFacade().a(this.b.a.f.b, this.b.a.f.a, this.a.uniseq, "extStr", this.a.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.9.1
 * JD-Core Version:    0.7.0.1
 */