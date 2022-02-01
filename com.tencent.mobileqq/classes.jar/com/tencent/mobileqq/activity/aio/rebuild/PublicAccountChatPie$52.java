package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$52
  extends IPublicAccountObserver.OnCallback
{
  PublicAccountChatPie$52(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onFollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      paramObject = this.a;
      paramObject.c(paramObject.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    }
  }
  
  public void onGetHistoryMsgRet(int paramInt)
  {
    ((PAListUI)PublicAccountChatPie.a(this.a).a()).c(paramInt);
  }
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      if ((paramObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((PublicAccountInfo)paramObject).getUin())))
      {
        this.a.b(1);
        return;
      }
      paramObject = this.a;
      paramObject.c(paramObject.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.a;
      ((PublicAccountChatPie)localObject).c(((PublicAccountChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    }
    if ((paramBoolean) && (!PublicAccountChatPie.b(this.a)))
    {
      localObject = null;
      IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localIPublicAccountDataManager != null) {
        localObject = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
      if ((localObject != null) && (this.a.g != null) && (!PublicAccountChatPie.c(this.a))) {
        this.a.ap();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.52
 * JD-Core Version:    0.7.0.1
 */