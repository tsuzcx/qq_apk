package com.tencent.mobileqq.activity.aio.item;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;

class BasePicItemBuilder$4
  implements Runnable
{
  BasePicItemBuilder$4(BasePicItemBuilder paramBasePicItemBuilder, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.this$0.a.getMessageFacade().b(this.a.frienduin, this.a.istroop, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */