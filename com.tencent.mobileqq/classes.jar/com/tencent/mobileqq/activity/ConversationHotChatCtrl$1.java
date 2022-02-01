package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class ConversationHotChatCtrl$1
  extends HotChatObserver
{
  ConversationHotChatCtrl$1(ConversationHotChatCtrl paramConversationHotChatCtrl, BaseActivity paramBaseActivity) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, HardCodeUtil.a(2131702635), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.dismiss();
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, HardCodeUtil.a(2131702636), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationHotChatCtrl.1
 * JD-Core Version:    0.7.0.1
 */