package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$38
  implements DialogInterface.OnClickListener
{
  PublicAccountChatPie$38(PublicAccountChatPie paramPublicAccountChatPie, PublicAccountInfo paramPublicAccountInfo, PublicAccountDataManager paramPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs = true;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected = true;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a(1, null);
    paramDialogInterface = new PublicAccountChatPie.38.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a.execute(paramDialogInterface);
    PublicAccountChatPie.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.38
 * JD-Core Version:    0.7.0.1
 */