package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.UIDelegateFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import java.util.Iterator;
import java.util.List;

public class CommonAdFloatingBarUtils
{
  public static GradientDrawable a(Context paramContext, String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(paramFloat1, paramContext.getResources()));
    if (!TextUtils.isEmpty(paramString2)) {
      localGradientDrawable.setStroke(AIOUtils.b(paramFloat2, paramContext.getResources()), Color.parseColor(paramString2));
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localGradientDrawable.setColor(Color.parseColor(paramString1));
    }
    return localGradientDrawable;
  }
  
  public static void a(Activity paramActivity, CommonAdBar paramCommonAdBar, List<BaseData> paramList)
  {
    if ((paramActivity != null) && (paramCommonAdBar != null))
    {
      if (paramList == null) {
        return;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (BaseData)localIterator.next();
        if (((paramList instanceof ProteusInnerData)) && (paramList.aS))
        {
          paramList = (ProteusInnerData)paramList;
          if (paramList.f()) {
            break label80;
          }
          if (paramList.g()) {
            break label80;
          }
        }
      }
      paramList = null;
      label80:
      a(paramCommonAdBar, paramList);
      paramActivity = UIDelegateFactory.a(paramActivity, paramList);
      if (paramActivity == null) {
        return;
      }
      paramCommonAdBar.a(paramActivity);
      paramActivity.b(paramList);
      if (Build.VERSION.SDK_INT >= 21) {
        paramCommonAdBar.setElevation(9.0F);
      }
    }
  }
  
  public static void a(CommonAdBar paramCommonAdBar, AdData paramAdData)
  {
    if (paramCommonAdBar != null)
    {
      if (paramAdData == null) {
        return;
      }
      Object localObject2 = null;
      paramCommonAdBar.a();
      ViewGroup.LayoutParams localLayoutParams = paramCommonAdBar.getLayoutParams();
      boolean bool = paramAdData instanceof ProteusInnerData;
      Object localObject1;
      if ((bool) && (((ProteusInnerData)paramAdData).g()))
      {
        localLayoutParams.height = AIOUtils.b(64.0F, paramCommonAdBar.getResources());
        paramAdData = a(paramCommonAdBar.getContext(), "#ffffff", 2.0F, 0.0F, "");
        localObject1 = paramAdData;
        if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
        {
          localObject1 = (RelativeLayout.LayoutParams)localLayoutParams;
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(12.0F, paramCommonAdBar.getResources());
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(12.0F, paramCommonAdBar.getResources());
          localObject1 = paramAdData;
        }
      }
      else
      {
        localObject1 = localObject2;
        if (bool)
        {
          localObject1 = localObject2;
          if (((ProteusInnerData)paramAdData).f())
          {
            localLayoutParams.height = AIOUtils.b(46.0F, paramCommonAdBar.getResources());
            paramAdData = a(paramCommonAdBar.getContext(), "#f7f7f7", 3.0F, 0.0F, "");
            localObject1 = paramAdData;
            if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
            {
              localObject1 = (RelativeLayout.LayoutParams)localLayoutParams;
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(7.0F, paramCommonAdBar.getResources());
              ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(7.0F, paramCommonAdBar.getResources());
              localObject1 = paramAdData;
            }
          }
        }
      }
      paramCommonAdBar.setLayoutParams(localLayoutParams);
      if (localObject1 != null) {
        paramCommonAdBar.setBackgroundDrawable((Drawable)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdFloatingBarUtils
 * JD-Core Version:    0.7.0.1
 */