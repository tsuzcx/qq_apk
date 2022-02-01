package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;

public class AccountDetailTopGestureLayout$PublicAccountTopGestureDetector
  extends TopGestureLayout.TopGestureDetector
{
  public AccountDetailTopGestureLayout$PublicAccountTopGestureDetector(AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout, Context paramContext)
  {
    super(paramAccountDetailTopGestureLayout, paramContext);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (AccountDetailTopGestureLayout.a(this.a) != null) {
      return AccountDetailTopGestureLayout.a(this.a).a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout.PublicAccountTopGestureDetector
 * JD-Core Version:    0.7.0.1
 */