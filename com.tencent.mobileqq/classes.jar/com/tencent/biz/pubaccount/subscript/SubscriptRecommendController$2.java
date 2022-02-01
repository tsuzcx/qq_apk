package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;

class SubscriptRecommendController$2
  extends PublicAccountObserver
{
  SubscriptRecommendController$2(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.h();
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.2
 * JD-Core Version:    0.7.0.1
 */