package com.tencent.mobileqq.apollo.view.pannel;

import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$12
  implements Runnable
{
  ApolloPanel$12(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (this.this$0.jdField_a_of_type_JavaUtilList != null) && (this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func initLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.jdField_a_of_type_JavaUtilList.add(this.this$0.jdField_a_of_type_Anqe);
      this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.12
 * JD-Core Version:    0.7.0.1
 */