package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.qphone.base.util.BaseApplication;

class PublicAccountChatPie$22
  implements IPublicAccountManager.refuseAcceptDone
{
  PublicAccountChatPie$22(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.ak = false;
    this.a.bv();
    this.a.bi();
    AddMessageHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131698277), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.22
 * JD-Core Version:    0.7.0.1
 */