package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class BusinessCmrTmpChatPie$2
  extends IPublicAccountObserver.OnCallback
{
  BusinessCmrTmpChatPie$2(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onDownPublicAccount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onDownPublicAccount");
    }
  }
  
  public void onFollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      paramObject = this.a;
      paramObject.c(paramObject.a.getIntent());
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      paramObject = this.a;
      paramObject.c(paramObject.a.getIntent());
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      BusinessCmrTmpChatPie localBusinessCmrTmpChatPie = this.a;
      localBusinessCmrTmpChatPie.c(localBusinessCmrTmpChatPie.a.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.2
 * JD-Core Version:    0.7.0.1
 */