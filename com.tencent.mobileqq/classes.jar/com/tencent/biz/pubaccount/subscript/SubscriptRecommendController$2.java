package com.tencent.biz.pubaccount.subscript;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;

class SubscriptRecommendController$2
  extends IPublicAccountObserver.OnCallback
{
  SubscriptRecommendController$2(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onFollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0) {
      this.a.h();
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.2
 * JD-Core Version:    0.7.0.1
 */