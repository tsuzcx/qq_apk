package com.tencent.mobileqq.activity;

import ajmw;
import android.view.View;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

class Conversation$53
  implements Runnable
{
  Conversation$53(Conversation paramConversation, int paramInt) {}
  
  public void run()
  {
    View localView = Conversation.a(this.this$0).getChildAt(this.a - Conversation.a(this.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      localView = localView.findViewById(2131375628);
      this.this$0.jdField_a_of_type_Ajmw.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.53
 * JD-Core Version:    0.7.0.1
 */