package com.tencent.biz.pubaccount.api;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountTipsManager
  extends QRouteApi
{
  public static final String TAG_ON_NEARBY_TIPS_CLICK = "tag_on_nearby_tips_click";
  
  public abstract View createEcshopDistanceTipsBar(String paramString, View.OnClickListener paramOnClickListener);
  
  public abstract void hidePendant();
  
  public abstract void init(Context paramContext);
  
  public abstract void showPendant(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void showTipsBar(ViewGroup paramViewGroup, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountTipsManager
 * JD-Core Version:    0.7.0.1
 */