package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class PublicAccountChatPie$7
  implements Runnable
{
  PublicAccountChatPie$7(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    int j = PublicAccountChatPie.a(this.this$0);
    int i = j;
    if (j > 2) {
      i = 2;
    }
    List localList = this.this$0.a.getMessageFacade().a("2747277822", 1008, i);
    ((IApolloExtensionHandler)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(2, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7
 * JD-Core Version:    0.7.0.1
 */