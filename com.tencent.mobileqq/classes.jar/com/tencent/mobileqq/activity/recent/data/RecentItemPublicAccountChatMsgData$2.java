package com.tencent.mobileqq.activity.recent.data;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;

class RecentItemPublicAccountChatMsgData$2
  implements Runnable
{
  public void run()
  {
    this.a.getMessageFacade().a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extLong", Integer.valueOf(this.b.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData.2
 * JD-Core Version:    0.7.0.1
 */