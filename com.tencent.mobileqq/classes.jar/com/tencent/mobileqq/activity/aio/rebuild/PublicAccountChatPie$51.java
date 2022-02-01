package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$51
  extends PublicAccountObserver
{
  PublicAccountChatPie$51(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
  }
  
  public void onGetHistoryMsgRet(int paramInt)
  {
    ((PAListUI)PublicAccountChatPie.a(this.a).a()).c(paramInt);
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0)
    {
      if ((paramPublicAccountInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramPublicAccountInfo.getUin()))) {
        this.a.b(1);
      }
    }
    else {
      return;
    }
    this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    if ((paramBoolean) && (!PublicAccountChatPie.b(this.a)))
    {
      localObject = (PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject == null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = ((PublicAccountDataManager)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      if ((localObject != null) && (this.a.m != null) && (!PublicAccountChatPie.c(this.a))) {
        this.a.bj();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.51
 * JD-Core Version:    0.7.0.1
 */