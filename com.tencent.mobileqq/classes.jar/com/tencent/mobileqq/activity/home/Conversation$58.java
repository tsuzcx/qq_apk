package com.tencent.mobileqq.activity.home;

import akou;
import android.view.View;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

class Conversation$58
  implements Runnable
{
  Conversation$58(Conversation paramConversation, int paramInt) {}
  
  public void run()
  {
    View localView = Conversation.a(this.this$0).getChildAt(this.a - Conversation.a(this.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      localView = localView.findViewById(2131376253);
      this.this$0.jdField_a_of_type_Akou.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.58
 * JD-Core Version:    0.7.0.1
 */