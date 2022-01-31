package com.tencent.mobileqq.activity;

import ahek;
import android.view.View;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

class Conversation$56
  implements Runnable
{
  Conversation$56(Conversation paramConversation, int paramInt) {}
  
  public void run()
  {
    View localView = Conversation.a(this.this$0).getChildAt(this.a - Conversation.a(this.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      localView = localView.findViewById(2131309349);
      this.this$0.jdField_a_of_type_Ahek.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.56
 * JD-Core Version:    0.7.0.1
 */