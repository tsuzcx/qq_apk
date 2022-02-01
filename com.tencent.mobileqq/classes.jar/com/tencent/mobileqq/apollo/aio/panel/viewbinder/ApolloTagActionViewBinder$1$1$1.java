package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import com.tencent.mobileqq.apollo.model.ApolloTagButtonData;
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
    for (;;)
    {
      try
      {
        ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0, this.jdField_a_of_type_JavaUtilList);
        Object localObject;
        if (ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0) != null)
        {
          localObject = ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ApolloTagButtonData localApolloTagButtonData = new ApolloTagButtonData((String)((Iterator)localObject).next(), false);
            if (ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0) == null) {
              continue;
            }
            ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0).add(localApolloTagButtonData);
            continue;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0.d != 9) {
          break label363;
        }
        bool = true;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_AndroidContentContext != null)
        {
          ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0, new ApolloTagActionViewBinder.ApolloActionTagsAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_AndroidContentContext, ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0), this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool));
          ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0).setAdapter(ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0));
        }
        if (QLog.isColorLevel())
        {
          if (ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0) == null)
          {
            localObject = "mApolloTagButtonList is null. ";
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mApolloTagButtonList size: ");
            ((StringBuilder)localObject).append(ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$1$1.a.this$0).size());
            localObject = ((StringBuilder)localObject).toString();
          }
          QLog.d("[cmshow]ApolloActionWithTagsViewBinder", 4, (String)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloActionWithTagsViewBinder", 1, localException, new Object[0]);
      }
      return;
      label363:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.1.1.1
 * JD-Core Version:    0.7.0.1
 */