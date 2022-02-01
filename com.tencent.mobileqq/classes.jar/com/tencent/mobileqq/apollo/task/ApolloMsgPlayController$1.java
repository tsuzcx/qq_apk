package com.tencent.mobileqq.apollo.task;

import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloMsgPlayController$1
  implements Runnable
{
  ApolloMsgPlayController$1(ApolloMsgPlayController paramApolloMsgPlayController, QQAppInterface paramQQAppInterface, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((IApolloPushManager)localQQAppInterface.getRuntimeService(IApolloPushManager.class, "all")).triggerAction(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionPush);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.1
 * JD-Core Version:    0.7.0.1
 */