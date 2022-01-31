package com.tencent.mobileqq.apollo.view;

import ajdh;
import ajdn;
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
    ajdn localajdn;
    do
    {
      return;
      localajdn = (ajdn)this.this$0.jdField_a_of_type_JavaUtilList.get(0);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(localajdn instanceof ajdh)));
    if (localajdn.c == 2) {
      localajdn.c = 0;
    }
    ((ajdh)localajdn).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.7
 * JD-Core Version:    0.7.0.1
 */