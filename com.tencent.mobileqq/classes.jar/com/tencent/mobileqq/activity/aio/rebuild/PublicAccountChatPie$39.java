package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$39
  implements DialogInterface.OnClickListener
{
  PublicAccountChatPie$39(PublicAccountChatPie paramPublicAccountChatPie, PublicAccountInfo paramPublicAccountInfo, IPublicAccountDataManager paramIPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
    paramDialogInterface.mIsAgreeSyncLbs = true;
    paramDialogInterface.mIsSyncLbsSelected = true;
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.savePublicAccountInfo(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a(1, null);
    paramDialogInterface = new PublicAccountChatPie.39.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a.execute(paramDialogInterface);
    PublicAccountChatPie.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.39
 * JD-Core Version:    0.7.0.1
 */