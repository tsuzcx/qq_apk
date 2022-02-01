package com.tencent.mobileqq.activity.aio.core;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseChatPie$39
  implements Runnable
{
  BaseChatPie$39(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.this$0.app.getMessageFacade().getAndParseAIOList(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.39
 * JD-Core Version:    0.7.0.1
 */