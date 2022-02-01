package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloMsgPlayController$1
  implements Runnable
{
  ApolloMsgPlayController$1(ApolloMsgPlayController paramApolloMsgPlayController, QQAppInterface paramQQAppInterface, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      ((IApolloPushManager)localQQAppInterface.getRuntimeService(IApolloPushManager.class, "all")).triggerAction(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloMsgPlayController.1
 * JD-Core Version:    0.7.0.1
 */