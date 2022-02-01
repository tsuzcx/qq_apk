package com.tencent.mobileqq.apollo.task;

import anhr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ApolloMsgPlayController$3
  implements Runnable
{
  public ApolloMsgPlayController$3(anhr paramanhr, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(QQManagerFactory.MGR_MSG_FACADE);
      if (localObject != null) {
        ((QQMessageFacade)localObject).updateMsgFieldByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.3
 * JD-Core Version:    0.7.0.1
 */