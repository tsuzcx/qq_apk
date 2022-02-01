package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;

class BusinessCmrTmpChatPie$15
  extends CardObserver
{
  BusinessCmrTmpChatPie$15(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    BusinessCmrTmpChatPie.a(this.a);
    this.a.bj();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.a.b.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!BusinessCmrTmpChatPie.a(this.a)))
    {
      BusinessCmrTmpChatPie.a(this.a, true);
      BaseChatPie localBaseChatPie = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localBaseChatPie);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(localBaseChatPie);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramBmqqAccountType.getUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBmqqAccountType.getAccountType() == 6)) {
      BusinessCmrTmpChatPie.b(this.a);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = CrmUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.15
 * JD-Core Version:    0.7.0.1
 */