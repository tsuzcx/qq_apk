package com.tencent.mobileqq.activity.aio.item;

import afzl;
import afzm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class FileTimDocGrayTipsItemBuilder$1
  implements Runnable
{
  public FileTimDocGrayTipsItemBuilder$1(afzl paramafzl, afzm paramafzm) {}
  
  public void run()
  {
    this.this$0.a.getMessageFacade().updateMsgFieldByUniseq(this.a.a.frienduin, this.a.a.istroop, this.a.a.uniseq, "extStr", this.a.a.getExtInfoString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */