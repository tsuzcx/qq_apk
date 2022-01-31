package com.tencent.mobileqq.apollo.view;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$13
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_JavaUtilList != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "clear bindList");
      }
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.13
 * JD-Core Version:    0.7.0.1
 */