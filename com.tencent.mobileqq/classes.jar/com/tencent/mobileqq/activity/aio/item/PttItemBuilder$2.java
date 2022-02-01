package com.tencent.mobileqq.activity.aio.item;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class PttItemBuilder$2
  implements Runnable
{
  PttItemBuilder$2(PttItemBuilder paramPttItemBuilder, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.this$0.a.getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */