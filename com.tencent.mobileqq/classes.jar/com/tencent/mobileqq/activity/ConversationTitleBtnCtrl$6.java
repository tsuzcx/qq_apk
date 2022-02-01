package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ConversationTitleBtnCtrl$6
  implements QQPermissionCallback
{
  ConversationTitleBtnCtrl$6(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(ConversationTitleBtnCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl).a());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.b(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.6
 * JD-Core Version:    0.7.0.1
 */