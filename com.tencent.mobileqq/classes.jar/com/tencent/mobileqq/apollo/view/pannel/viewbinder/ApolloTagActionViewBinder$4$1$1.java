package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApolloTagActionViewBinder$4$1$1
  implements Runnable
{
  ApolloTagActionViewBinder$4$1$1(ApolloTagActionViewBinder.4.1 param1, List paramList) {}
  
  public void run()
  {
    try
    {
      ApolloTagActionViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0, this.jdField_a_of_type_JavaUtilList);
      ArrayList localArrayList = new ArrayList();
      if ((ApolloTagActionViewBinder.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0) != null) && (ApolloTagActionViewBinder.d(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0) != null) && (ApolloTagActionViewBinder.d(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0).size() > 0))
      {
        Iterator localIterator = ApolloTagActionViewBinder.d(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0).iterator();
        while (localIterator.hasNext())
        {
          ApolloInfo localApolloInfo = (ApolloInfo)localIterator.next();
          if ((localApolloInfo != null) && (ApolloTagActionViewBinder.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0).contains(Integer.valueOf(localApolloInfo.mAction.actionId)))) {
            localArrayList.add(localApolloInfo);
          }
        }
      }
      if (ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0) == null) {
        break label220;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloActionWithTagsViewBinder", 1, localException, new Object[0]);
      return;
    }
    ApolloTagActionViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0).put(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.a, localException);
    label220:
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0.b(localException);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$4$1.a.this$0.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.4.1.1
 * JD-Core Version:    0.7.0.1
 */