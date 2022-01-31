package com.tencent.mobileqq.activity;

import acth;
import android.view.View;
import android.widget.TextView;

class ConversationTitleBtnCtrl$1$1
  implements Runnable
{
  ConversationTitleBtnCtrl$1$1(ConversationTitleBtnCtrl.1 param1, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0) {
      if (acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0) != null)
      {
        if (this.jdField_a_of_type_Int > 99)
        {
          acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setText("99+");
          acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setVisibility(0);
        }
      }
      else if (acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0) != null) {
        acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setVisibility(8);
      }
    }
    label188:
    do
    {
      do
      {
        return;
        acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setText("" + this.jdField_a_of_type_Int);
        break;
        if (!this.jdField_a_of_type_Boolean) {
          break label188;
        }
        if (acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0) != null) {
          acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setVisibility(0);
        }
      } while (acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0) == null);
      acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setVisibility(8);
      return;
      if (acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0) != null) {
        acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setVisibility(8);
      }
    } while (acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0) == null);
    acth.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl$1.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1.1
 * JD-Core Version:    0.7.0.1
 */