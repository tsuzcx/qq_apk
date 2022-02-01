package com.tencent.biz.pubaccount.api;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountDetailTopGestureLayoutProxy
  extends QRouteApi
{
  public abstract void addDisableView(View paramView);
  
  public abstract TopGestureLayout.OnGestureListener getOnFlingGesture();
  
  public abstract TopGestureLayout getTopGestureLayout();
  
  public abstract void init(Context paramContext);
  
  public abstract boolean isInTwoFingerMode();
  
  public abstract void setDefaultDetector(GestureDetector paramGestureDetector);
  
  public abstract GestureDetector.OnGestureListener setOnFlingListener(Context paramContext, IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener paramOnFlingListener);
  
  public abstract void setTopGestureDetector(GestureDetector paramGestureDetector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
 * JD-Core Version:    0.7.0.1
 */