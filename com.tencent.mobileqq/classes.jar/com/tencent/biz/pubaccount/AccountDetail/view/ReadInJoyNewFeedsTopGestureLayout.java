package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInJoyNewFeedsTopGestureLayout
{
  private IPublicAccountDetailTopGestureLayoutProxy a = (IPublicAccountDetailTopGestureLayoutProxy)QRoute.api(IPublicAccountDetailTopGestureLayoutProxy.class);
  
  public ReadInJoyNewFeedsTopGestureLayout(Context paramContext)
  {
    this.a.init(paramContext);
  }
  
  public TopGestureLayout a()
  {
    return this.a.getTopGestureLayout();
  }
  
  public void a(View paramView)
  {
    this.a.addDisableView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */