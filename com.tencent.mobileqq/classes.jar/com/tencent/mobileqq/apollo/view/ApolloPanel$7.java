package com.tencent.mobileqq.apollo.view;

import ajrh;
import ajrn;
import com.tencent.mobileqq.activity.BaseChatPie;
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
    ajrn localajrn;
    do
    {
      return;
      localajrn = (ajrn)this.this$0.jdField_a_of_type_JavaUtilList.get(0);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(localajrn instanceof ajrh)));
    if (localajrn.c == 2) {
      localajrn.c = 0;
    }
    ((ajrh)localajrn).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.7
 * JD-Core Version:    0.7.0.1
 */