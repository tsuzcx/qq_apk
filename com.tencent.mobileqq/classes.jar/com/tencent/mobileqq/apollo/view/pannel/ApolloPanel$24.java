package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$24
  implements Runnable
{
  ApolloPanel$24(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (this.this$0.jdField_a_of_type_JavaUtilList != null) && (this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "refreshPanel. Thread id = " + Thread.currentThread().getId());
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.24
 * JD-Core Version:    0.7.0.1
 */