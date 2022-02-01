package com.tencent.mobileqq.activity.aio.item;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

class FileTimDocGrayTipsItemBuilder$1
  implements Runnable
{
  FileTimDocGrayTipsItemBuilder$1(FileTimDocGrayTipsItemBuilder paramFileTimDocGrayTipsItemBuilder, FileTimDocGrayTipsItemBuilder.TipHolder paramTipHolder) {}
  
  public void run()
  {
    this.this$0.a.getMessageFacade().a(this.a.a.frienduin, this.a.a.istroop, this.a.a.uniseq, "extStr", this.a.a.getExtInfoString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */