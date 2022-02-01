package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class ApolloMessageUtilImpl$1
  implements Runnable
{
  ApolloMessageUtilImpl$1(MessageForApollo paramMessageForApollo, AppRuntime paramAppRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("do markRead for ");
        localStringBuilder.append(this.a);
        QLog.i("[cmshow]ApolloMessageUtilImpl", 2, localStringBuilder.toString());
      }
      this.a.hasPlayed = true;
      this.a.mApolloMessage.isPlayed = true;
      this.a.msgData = MessagePkgUtils.a(this.a.mApolloMessage);
      ((QQAppInterface)this.b).getMessageFacade().a(this.c, this.d, this.a.uniseq, this.a.msgData);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloMessageUtilImpl", 1, "markRead error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */