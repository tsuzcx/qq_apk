package com.tencent.mobileqq.apollo.view.pannel;

import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.HorizontalListView;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$12
  implements Runnable
{
  ApolloPanel$12(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((ApolloPanel.a(this.this$0) != null) && (ApolloPanel.a(this.this$0) != null) && (ApolloPanel.a(this.this$0) != null))
    {
      ApolloPanel.a(this.this$0).a(this.a);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        break label148;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1036) {
        break label143;
      }
      i = 1;
      if ((!ApolloPanel.b(this.this$0)) && (i == 0)) {
        break label153;
      }
      ApolloPanel.a(this.this$0).setVisibility(8);
    }
    for (;;)
    {
      ApolloPanel.a(this.this$0).setVisibility(0);
      ApolloPanel.a(this.this$0).notifyDataSetChanged();
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        break label167;
      }
      return;
      label143:
      i = 0;
      break;
      label148:
      i = 0;
      break;
      label153:
      ApolloPanel.a(this.this$0).setVisibility(0);
    }
    label167:
    Iterator localIterator = this.a.iterator();
    label177:
    ApolloActionPackage localApolloActionPackage;
    while (localIterator.hasNext())
    {
      localApolloActionPackage = (ApolloActionPackage)localIterator.next();
      if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate)) {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 3000) {
          break label257;
        }
      }
    }
    label257:
    for (int i = 2;; i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)
    {
      VipUtils.a(null, "cmshow", "Apollo", "tabreddot", i, 0, new String[] { String.valueOf(localApolloActionPackage.packageId) });
      break label177;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.12
 * JD-Core Version:    0.7.0.1
 */