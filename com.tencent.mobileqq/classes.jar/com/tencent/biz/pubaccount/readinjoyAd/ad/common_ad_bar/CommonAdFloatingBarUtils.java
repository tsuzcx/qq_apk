package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.UIDelegateFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Iterator;
import java.util.List;

public class CommonAdFloatingBarUtils
{
  public static GradientDrawable a(Context paramContext, String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.a(paramFloat1, paramContext.getResources()));
    if (!TextUtils.isEmpty(paramString2)) {
      localGradientDrawable.setStroke(AIOUtils.a(paramFloat2, paramContext.getResources()), Color.parseColor(paramString2));
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localGradientDrawable.setColor(Color.parseColor(paramString1));
    }
    return localGradientDrawable;
  }
  
  public static void a(Activity paramActivity, CommonAdBar paramCommonAdBar, List<BaseData> paramList)
  {
    if ((paramActivity == null) || (paramCommonAdBar == null) || (paramList == null)) {
      return;
    }
    label20:
    BaseData localBaseData;
    for (paramList = paramList.iterator();; paramList = (ProteusInnerData)localBaseData) {
      for (;;)
      {
        if (paramList.hasNext())
        {
          localBaseData = (BaseData)paramList.next();
          if (((localBaseData instanceof ProteusInnerData)) && (localBaseData.d)) {
            if (!((ProteusInnerData)localBaseData).f()) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      a(paramCommonAdBar, paramList);
      paramActivity = UIDelegateFactory.a(paramActivity, paramList);
      if (paramActivity == null) {
        break;
      }
      paramCommonAdBar.a(paramActivity);
      paramActivity.a(paramList);
      if (Build.VERSION.SDK_INT < 21) {
        break;
      }
      paramCommonAdBar.setElevation(9.0F);
      return;
      if (!((ProteusInnerData)localBaseData).g()) {
        break label20;
      }
      paramList = (ProteusInnerData)localBaseData;
      continue;
      paramList = null;
    }
  }
  
  public static void a(CommonAdBar paramCommonAdBar, AdData paramAdData)
  {
    if ((paramCommonAdBar == null) || (paramAdData == null)) {
      return;
    }
    paramCommonAdBar.a();
    ViewGroup.LayoutParams localLayoutParams = paramCommonAdBar.getLayoutParams();
    GradientDrawable localGradientDrawable;
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).g()))
    {
      localLayoutParams.height = AIOUtils.a(64.0F, paramCommonAdBar.getResources());
      localGradientDrawable = a(paramCommonAdBar.getContext(), "#ffffff", 2.0F, 0.0F, "");
      paramAdData = localGradientDrawable;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label208;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = AIOUtils.a(12.0F, paramCommonAdBar.getResources());
      ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = AIOUtils.a(12.0F, paramCommonAdBar.getResources());
      paramAdData = localGradientDrawable;
    }
    for (;;)
    {
      paramCommonAdBar.setLayoutParams(localLayoutParams);
      if (paramAdData == null) {
        break;
      }
      paramCommonAdBar.setBackgroundDrawable(paramAdData);
      return;
      if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).f()))
      {
        localLayoutParams.height = AIOUtils.a(46.0F, paramCommonAdBar.getResources());
        localGradientDrawable = a(paramCommonAdBar.getContext(), "#f7f7f7", 3.0F, 0.0F, "");
        paramAdData = localGradientDrawable;
        if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
        {
          ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = AIOUtils.a(7.0F, paramCommonAdBar.getResources());
          ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = AIOUtils.a(7.0F, paramCommonAdBar.getResources());
          paramAdData = localGradientDrawable;
        }
      }
      else
      {
        label208:
        paramAdData = null;
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean2) && (!paramBoolean3) && (paramBoolean1) && ((paramInt3 == 0) || (paramInt1 <= paramInt3)) && (paramInt1 * 2 >= paramInt2 * 3);
  }
  
  public static boolean a(IUIDelegate paramIUIDelegate)
  {
    if ((paramIUIDelegate instanceof GoodsSoftAdAppDelegate)) {
      return true;
    }
    return paramIUIDelegate instanceof GamesComponentAdDelegate;
  }
  
  public static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean1) && (paramBoolean2) && (!paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdFloatingBarUtils
 * JD-Core Version:    0.7.0.1
 */