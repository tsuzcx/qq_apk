package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class PublicAccountDetailTopGestureLayoutProxyImpl
  implements IPublicAccountDetailTopGestureLayoutProxy
{
  private AccountDetailTopGestureLayout mGestureLayout;
  
  public void addDisableView(View paramView)
  {
    this.mGestureLayout.a(paramView);
  }
  
  public TopGestureLayout.OnGestureListener getOnFlingGesture()
  {
    return this.mGestureLayout.a();
  }
  
  public TopGestureLayout getTopGestureLayout()
  {
    return this.mGestureLayout;
  }
  
  public void init(Context paramContext)
  {
    this.mGestureLayout = new AccountDetailTopGestureLayout(paramContext);
  }
  
  public boolean isInTwoFingerMode()
  {
    return this.mGestureLayout.isInTwoFingerMode();
  }
  
  public void setDefaultDetector(GestureDetector paramGestureDetector)
  {
    this.mGestureLayout.setDefaultDetector(paramGestureDetector);
  }
  
  public GestureDetector.OnGestureListener setOnFlingListener(Context paramContext, IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener paramOnFlingListener)
  {
    return this.mGestureLayout.a(paramContext, paramOnFlingListener);
  }
  
  public void setTopGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mGestureLayout.setTopGestureDetector(paramGestureDetector);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountDetailTopGestureLayoutProxyImpl
 * JD-Core Version:    0.7.0.1
 */