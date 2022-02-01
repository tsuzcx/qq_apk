package com.tencent.mobileqq.apollo.view.pannel;

import android.view.View;
import android.view.ViewParent;
import annl;
import anoa;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloActionData;
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
    anoa localanoa;
    if ((localViewParent != null) && (this.jdField_a_of_type_Int == ApolloLinearLayout.a(this.this$0)) && (this.this$0.jdField_a_of_type_AndroidViewView != null))
    {
      localanoa = (anoa)this.this$0.jdField_a_of_type_AndroidViewView.getTag();
      if ((localanoa != null) && (localanoa.a != null) && (localanoa.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null)) {
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
      } while ((localanoa.a == null) || (localanoa.a.b == 1) || (localanoa.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null));
      this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView, localanoa.a);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    VipUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "long_press_icon", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + localanoa.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "" + localanoa.a.jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */