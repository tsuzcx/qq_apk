package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.TextView;

class ConversationQbossBannerTitleEntranceCtrl$2$1
  implements Runnable
{
  ConversationQbossBannerTitleEntranceCtrl$2$1(ConversationQbossBannerTitleEntranceCtrl.2 param2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null)
      {
        if (this.jdField_a_of_type_Int > 99)
        {
          ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setText("99+");
        }
        else
        {
          TextView localTextView = ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localTextView.setText(localStringBuilder.toString());
        }
        ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(0);
      }
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(0);
      }
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
      }
    }
    else
    {
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
      }
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.2.1
 * JD-Core Version:    0.7.0.1
 */