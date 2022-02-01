package com.tencent.mobileqq.activity;

import aeau;
import android.view.View;
import android.widget.TextView;

class ConversationQbossBannerTitleEntranceCtrl$1$1
  implements Runnable
{
  ConversationQbossBannerTitleEntranceCtrl$1$1(ConversationQbossBannerTitleEntranceCtrl.1 param1, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0) {
      if (aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0) != null)
      {
        if (this.jdField_a_of_type_Int > 99)
        {
          aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setText("99+");
          aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setVisibility(0);
        }
      }
      else if (aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0) != null) {
        aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setVisibility(8);
      }
    }
    label188:
    do
    {
      do
      {
        return;
        aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setText("" + this.jdField_a_of_type_Int);
        break;
        if (!this.jdField_a_of_type_Boolean) {
          break label188;
        }
        if (aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0) != null) {
          aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setVisibility(0);
        }
      } while (aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0) == null);
      aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setVisibility(8);
      return;
      if (aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0) != null) {
        aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setVisibility(8);
      }
    } while (aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0) == null);
    aeau.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl$1.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.1.1
 * JD-Core Version:    0.7.0.1
 */