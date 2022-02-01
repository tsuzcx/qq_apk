package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;

class ConfessMsgLoader$1
  implements Runnable
{
  ConfessMsgLoader$1(ConfessMsgLoader paramConfessMsgLoader, AIOContext paramAIOContext) {}
  
  public void run()
  {
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    this.a.a().getMessageFacade().a(localBaseSessionInfo.b, localBaseSessionInfo.a, localBaseSessionInfo.v, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgLoader.1
 * JD-Core Version:    0.7.0.1
 */