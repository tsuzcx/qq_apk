package com.tencent.mobileqq.apollo.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ApolloUtil$2
  implements Runnable
{
  ApolloUtil$2(ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(20);
      if (localObject != null) {
        ((QQMessageFacade)localObject).a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.2
 * JD-Core Version:    0.7.0.1
 */