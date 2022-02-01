package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseMsgLoader$1
  implements Runnable
{
  BaseMsgLoader$1(BaseMsgLoader paramBaseMsgLoader, AIOContext paramAIOContext) {}
  
  public void run()
  {
    this.a.a().getMessageFacade().c(this.a.O().b, this.a.O().a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader.1
 * JD-Core Version:    0.7.0.1
 */