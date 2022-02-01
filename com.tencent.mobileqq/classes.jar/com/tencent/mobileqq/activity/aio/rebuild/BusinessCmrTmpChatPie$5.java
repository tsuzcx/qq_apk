package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

class BusinessCmrTmpChatPie$5
  extends PublicAccountObserver
{
  BusinessCmrTmpChatPie$5(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onDownPublicAccount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onDownPublicAccount");
    }
  }
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.a.getIntent());
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.a.getIntent());
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c(this.a.a.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.5
 * JD-Core Version:    0.7.0.1
 */