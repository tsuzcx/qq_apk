package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.os.MqqHandler;

class BaseChatPie$64
  implements Runnable
{
  BaseChatPie$64(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ((FriendsManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b();
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(64));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.64
 * JD-Core Version:    0.7.0.1
 */