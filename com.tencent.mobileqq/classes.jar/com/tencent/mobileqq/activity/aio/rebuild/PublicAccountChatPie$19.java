package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class PublicAccountChatPie$19
  implements Runnable
{
  PublicAccountChatPie$19(PublicAccountChatPie paramPublicAccountChatPie, List paramList) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        this.this$0.d.getMessageFacade().a(this.this$0.ah.b, this.this$0.ah.a, localChatMessage.uniseq, "extStr", localChatMessage.extStr);
        if (QLog.isColorLevel())
        {
          String str = this.this$0.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("saveReadedToDB uin=");
          localStringBuilder.append(this.this$0.ah.b);
          localStringBuilder.append(" uniseq=");
          localStringBuilder.append(localChatMessage.uniseq);
          localStringBuilder.append(" extstr=");
          localStringBuilder.append(localChatMessage.extStr);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.c, 4, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.19
 * JD-Core Version:    0.7.0.1
 */