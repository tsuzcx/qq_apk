package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.qphone.base.util.BaseApplication;

class PublicAccountChatPie$23
  implements IPublicAccountManager.refuseAcceptDone
{
  PublicAccountChatPie$23(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(boolean paramBoolean)
  {
    PublicAccountChatPie localPublicAccountChatPie = this.a;
    localPublicAccountChatPie.aa = false;
    localPublicAccountChatPie.aB();
    this.a.ao();
    AddMessageHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131698342), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.23
 * JD-Core Version:    0.7.0.1
 */