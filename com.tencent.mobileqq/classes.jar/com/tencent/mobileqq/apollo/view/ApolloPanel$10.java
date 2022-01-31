package com.tencent.mobileqq.apollo.view;

import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$10
  implements Runnable
{
  ApolloPanel$10(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.this$0.jdField_a_of_type_JavaUtilList != null) && (this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func initLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.jdField_a_of_type_JavaUtilList.add(this.this$0.jdField_a_of_type_Alhr);
      this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.10
 * JD-Core Version:    0.7.0.1
 */