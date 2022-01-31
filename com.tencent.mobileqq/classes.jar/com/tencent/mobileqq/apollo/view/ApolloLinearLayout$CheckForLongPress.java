package com.tencent.mobileqq.apollo.view;

import ajbx;
import ajbz;
import android.view.View;
import android.view.ViewParent;
import bajr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloActionData;

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
    ajbz localajbz;
    if ((localViewParent != null) && (this.jdField_a_of_type_Int == ApolloLinearLayout.a(this.this$0)) && (this.this$0.jdField_a_of_type_AndroidViewView != null))
    {
      localajbz = (ajbz)this.this$0.jdField_a_of_type_AndroidViewView.getTag();
      if ((localajbz != null) && (localajbz.a != null) && (localajbz.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localajbz.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status == 1)) {
        break label86;
      }
    }
    label86:
    do
    {
      do
      {
        return;
        this.this$0.b = true;
        localViewParent.requestDisallowInterceptTouchEvent(true);
        ApolloLinearLayout.a(this.this$0, 2);
      } while ((localajbz.a == null) || (localajbz.a.b == 1) || (localajbz.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null));
      this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView, localajbz.a);
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    bajr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "long_press_icon", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localajbz.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "" + localajbz.a.jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */