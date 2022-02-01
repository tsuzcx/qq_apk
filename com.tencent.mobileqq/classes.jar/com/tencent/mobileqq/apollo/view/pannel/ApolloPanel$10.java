package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloRecentViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$10
  implements Runnable
{
  ApolloPanel$10(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "func updateLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
    }
    if (ApolloPanel.b(this.this$0).size() == 0) {}
    ApolloViewBinder localApolloViewBinder;
    do
    {
      return;
      localApolloViewBinder = (ApolloViewBinder)ApolloPanel.b(this.this$0).get(0);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(localApolloViewBinder instanceof ApolloRecentViewBinder)));
    if (localApolloViewBinder.b == 2) {
      localApolloViewBinder.b = 0;
    }
    ((ApolloRecentViewBinder)localApolloViewBinder).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.10
 * JD-Core Version:    0.7.0.1
 */