package com.tencent.mobileqq.activity.aio.item;

import ahcj;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;

public class PicItemBuilder$3
  implements Runnable
{
  public PicItemBuilder$3(ahcj paramahcj, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.this$0.a.getMessageFacade().removeMsgByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */