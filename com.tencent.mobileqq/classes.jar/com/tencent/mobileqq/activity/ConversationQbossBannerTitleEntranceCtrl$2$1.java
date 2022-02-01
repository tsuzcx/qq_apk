package com.tencent.mobileqq.activity;

import adty;
import android.view.View;
import android.widget.TextView;

class ConversationQbossBannerTitleEntranceCtrl$2$1
  implements Runnable
{
  ConversationQbossBannerTitleEntranceCtrl$2$1(ConversationQbossBannerTitleEntranceCtrl.2 param2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0) {
      if (adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null)
      {
        if (this.jdField_a_of_type_Int > 99)
        {
          adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setText("99+");
          adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(0);
        }
      }
      else if (adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
        adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
      }
    }
    label188:
    do
    {
      do
      {
        return;
        adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setText("" + this.jdField_a_of_type_Int);
        break;
        if (!this.jdField_a_of_type_Boolean) {
          break label188;
        }
        if (adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
          adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(0);
        }
      } while (adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) == null);
      adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
      return;
      if (adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) != null) {
        adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
      }
    } while (adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0) == null);
    adty.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$2.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.2.1
 * JD-Core Version:    0.7.0.1
 */