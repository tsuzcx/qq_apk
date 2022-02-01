package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AccountDetailBaseAdapter$11
  implements Animation.AnimationListener
{
  AccountDetailBaseAdapter$11(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.setVisibility(0);
    this.a.a.a.startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.11
 * JD-Core Version:    0.7.0.1
 */