package com.tencent.mobileqq.apollo.task;

import amnd;
import anhr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionPush;

public class ApolloMsgPlayController$1
  implements Runnable
{
  public ApolloMsgPlayController$1(anhr paramanhr, QQAppInterface paramQQAppInterface, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((amnd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_PUSH_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.1
 * JD-Core Version:    0.7.0.1
 */