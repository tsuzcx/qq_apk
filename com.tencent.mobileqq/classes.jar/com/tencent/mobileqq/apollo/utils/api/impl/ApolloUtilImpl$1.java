package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;

class ApolloUtilImpl$1
  implements Runnable
{
  ApolloUtilImpl$1(ApolloUtilImpl paramApolloUtilImpl, AppRuntime paramAppRuntime, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = (QQMessageFacade)this.a.getManager(QQManagerFactory.MGR_MSG_FACADE);
    if (localQQMessageFacade != null) {
      localQQMessageFacade.a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extStr", this.b.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */