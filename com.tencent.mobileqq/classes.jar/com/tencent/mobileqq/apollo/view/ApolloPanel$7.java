package com.tencent.mobileqq.apollo.view;

import amng;
import amnk;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$7
  implements Runnable
{
  ApolloPanel$7(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "func updateLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
    }
    if (this.this$0.jdField_a_of_type_JavaUtilList == null) {}
    amnk localamnk;
    do
    {
      return;
      localamnk = (amnk)this.this$0.jdField_a_of_type_JavaUtilList.get(0);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(localamnk instanceof amng)));
    if (localamnk.b == 2) {
      localamnk.b = 0;
    }
    ((amng)localamnk).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.7
 * JD-Core Version:    0.7.0.1
 */