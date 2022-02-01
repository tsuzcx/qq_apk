package com.tencent.mobileqq.apollo.view.pannel;

import anqf;
import anqh;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$8
  implements Runnable
{
  ApolloPanel$8(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "func updateLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
    }
    if (this.this$0.jdField_a_of_type_JavaUtilList == null) {}
    anqh localanqh;
    do
    {
      return;
      localanqh = (anqh)this.this$0.jdField_a_of_type_JavaUtilList.get(0);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(localanqh instanceof anqf)));
    if (localanqh.b == 2) {
      localanqh.b = 0;
    }
    ((anqf)localanqh).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.8
 * JD-Core Version:    0.7.0.1
 */