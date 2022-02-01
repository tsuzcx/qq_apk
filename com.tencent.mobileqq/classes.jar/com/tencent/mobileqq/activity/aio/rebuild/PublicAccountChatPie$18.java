package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class PublicAccountChatPie$18
  implements Runnable
{
  public PublicAccountChatPie$18(aido paramaido, List paramList) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        this.this$0.app.getMessageFacade().updateMsgFieldByUniseq(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, localChatMessage.uniseq, "extStr", localChatMessage.extStr);
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.tag, 2, "saveReadedToDB uin=" + this.this$0.sessionInfo.curFriendUin + " uniseq=" + localChatMessage.uniseq + " extstr=" + localChatMessage.extStr);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.tag, 4, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.18
 * JD-Core Version:    0.7.0.1
 */