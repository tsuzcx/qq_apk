package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountListActivity$12
  extends PublicAccountObserver
{
  PublicAccountListActivity$12(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c();
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
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
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.12
 * JD-Core Version:    0.7.0.1
 */