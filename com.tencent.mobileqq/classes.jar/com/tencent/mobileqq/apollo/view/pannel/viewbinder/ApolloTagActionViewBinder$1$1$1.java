package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import com.tencent.mobileqq.data.ApolloTagButtonData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.Iterator;
import java.util.List;

class ApolloTagActionViewBinder$1$1$1
  implements Runnable
{
  ApolloTagActionViewBinder$1$1$1(ApolloTagActionViewBinder.1.1 param1, List paramList) {}
  
  public void run()
  {
    try
    {
      ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0, this.jdField_a_of_type_JavaUtilList);
      if (ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0) != null)
      {
        Iterator localIterator = ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0).iterator();
        while (localIterator.hasNext())
        {
          ApolloTagButtonData localApolloTagButtonData = new ApolloTagButtonData((String)localIterator.next(), false);
          if (ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0) != null)
          {
            ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0).add(localApolloTagButtonData);
            continue;
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloActionWithTagsViewBinder", 1, localException, new Object[0]);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0.d == 9) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_AndroidContentContext != null)
      {
        ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0, new ApolloTagActionViewBinder.ApolloActionTagsAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_AndroidContentContext, ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0), this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool));
        ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0).setAdapter(ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0));
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      if (ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0) == null) {}
      for (String str = "mApolloTagButtonList is null. ";; str = "mApolloTagButtonList size: " + ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$1$1.a.this$0).size())
      {
        QLog.d("ApolloActionWithTagsViewBinder", 4, str);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.1.1.1
 * JD-Core Version:    0.7.0.1
 */