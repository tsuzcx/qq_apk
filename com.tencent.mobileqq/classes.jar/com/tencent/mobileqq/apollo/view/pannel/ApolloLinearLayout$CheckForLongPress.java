package com.tencent.mobileqq.apollo.view.pannel;

import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloLinearLayout$CheckForLongPress
  implements Runnable
{
  private int a;
  
  ApolloLinearLayout$CheckForLongPress(ApolloLinearLayout paramApolloLinearLayout) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = ApolloLinearLayout.b(this.this$0);
  }
  
  public void run()
  {
    ViewParent localViewParent = ApolloLinearLayout.a(this.this$0);
    ApolloLinearLayout.ViewHolder localViewHolder;
    if ((localViewParent != null) && (this.jdField_a_of_type_Int == ApolloLinearLayout.a(this.this$0)) && (this.this$0.jdField_a_of_type_AndroidViewView != null))
    {
      localViewHolder = (ApolloLinearLayout.ViewHolder)this.this$0.jdField_a_of_type_AndroidViewView.getTag();
      if ((localViewHolder != null) && (localViewHolder.a != null) && (localViewHolder.a.mAction != null)) {
        break label72;
      }
    }
    label72:
    do
    {
      do
      {
        return;
        this.this$0.b = true;
        localViewParent.requestDisallowInterceptTouchEvent(true);
        ApolloLinearLayout.a(this.this$0, 2);
      } while ((localViewHolder.a == null) || (localViewHolder.a.mType == 1) || (localViewHolder.a.mAction == null));
      this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView, localViewHolder.a);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    VipUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "cmshow", "Apollo", "long_press_icon", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localViewHolder.a.mAction.actionId, "" + localViewHolder.a.mPackageId, "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */