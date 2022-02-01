package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$13
  implements Runnable
{
  ApolloPanel$13(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (this.this$0.jdField_a_of_type_JavaUtilList != null) && (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showGameViewOnly begins. Thread id = " + Thread.currentThread().getId());
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.jdField_a_of_type_JavaUtilList.add(this.this$0.jdField_a_of_type_Anpu);
      ApolloPanel.a(this.this$0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.this$0.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.13
 * JD-Core Version:    0.7.0.1
 */