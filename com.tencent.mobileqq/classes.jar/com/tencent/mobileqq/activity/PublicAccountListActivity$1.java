package com.tencent.mobileqq.activity;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;

class PublicAccountListActivity$1
  extends IPublicAccountObserver.OnCallback
{
  PublicAccountListActivity$1(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onFollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0) {
      this.a.c();
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0) {
      this.a.c();
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.1
 * JD-Core Version:    0.7.0.1
 */