package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

public class AdVideoButtonUIUtils
{
  public static int a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {
      return 1;
    }
    if (ReadInJoyAdSwitchUtil.a()) {
      return 3;
    }
    if (ReadInJoyAdSwitchUtil.c(paramVideoAdInfo)) {
      return 2;
    }
    return 1;
  }
  
  public static void a(Context paramContext, ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.az != null) && (paramADVideoItemHolder.az.c != null))
    {
      VideoInfo localVideoInfo = paramADVideoItemHolder.az.c;
      if (ReadInJoyAdUtils.a(localVideoInfo)) {
        paramADVideoItemHolder.N.setText(ReadInJoyAdUtils.a(paramContext, localVideoInfo, 1));
      }
      paramADVideoItemHolder.N.setTag(paramADVideoItemHolder);
    }
  }
  
  public static void a(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 0)) {
      paramView.setVisibility(0);
    }
  }
  
  private static void a(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt)
  {
    paramLayoutParams.width = paramInt;
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  private static void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramView != null) && (paramContext != null))
    {
      if (paramLayoutParams == null) {
        return;
      }
      paramLayoutParams.leftMargin = AIOUtils.b(paramInt1, paramContext.getResources());
      paramLayoutParams.rightMargin = AIOUtils.b(paramInt2, paramContext.getResources());
      paramLayoutParams.topMargin = AIOUtils.b(paramInt3, paramContext.getResources());
      paramLayoutParams.bottomMargin = AIOUtils.b(paramInt4, paramContext.getResources());
      paramLayoutParams.height = AIOUtils.b(paramInt6, paramContext.getResources());
      if (paramInt5 > 0) {
        paramLayoutParams.width = AIOUtils.b(paramInt5, paramContext.getResources());
      }
      paramView.setLayoutParams(paramLayoutParams);
    }
  }
  
  public static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setAlpha(0.5F);
  }
  
  public static void a(ADVideoItemHolder paramADVideoItemHolder) {}
  
  private static void a(ADVideoItemHolder paramADVideoItemHolder, int paramInt)
  {
    a(false, paramADVideoItemHolder, paramInt);
    b(false, paramADVideoItemHolder, paramInt);
  }
  
  public static void a(ADVideoItemHolder paramADVideoItemHolder, String paramString)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.R != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramADVideoItemHolder.R.setText(paramString);
      a(paramADVideoItemHolder.R);
      ThreadManager.getUIHandler().postDelayed(new AdVideoButtonUIUtils.1(paramADVideoItemHolder), 1000L);
    }
  }
  
  public static void a(boolean paramBoolean, ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.az != null) && (paramADVideoItemHolder.az.c != null))
    {
      if (paramADVideoItemHolder.az.c.as == null) {
        return;
      }
      int i = a(paramADVideoItemHolder.az.c.as);
      if (!paramBoolean)
      {
        a(paramADVideoItemHolder, i);
        return;
      }
      b(paramADVideoItemHolder, i);
    }
  }
  
  private static void a(boolean paramBoolean, ADVideoItemHolder paramADVideoItemHolder, int paramInt) {}
  
  public static boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(343);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("tiktok_big_style", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 8)) {
      paramView.setVisibility(8);
    }
  }
  
  private static void b(ADVideoItemHolder paramADVideoItemHolder)
  {
    if (paramADVideoItemHolder != null)
    {
      if (paramADVideoItemHolder.U == null) {
        return;
      }
      Context localContext = paramADVideoItemHolder.U.getContext();
      if (localContext == null) {
        return;
      }
      if (paramADVideoItemHolder.az != null)
      {
        if (paramADVideoItemHolder.az.c == null) {
          return;
        }
        Object localObject = paramADVideoItemHolder.az.c;
        int i = localContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.b(77.0F, localContext.getResources());
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.aI.getLayoutParams();
        a(paramADVideoItemHolder.aI, localLayoutParams, i);
        localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.K.getLayoutParams();
        a(paramADVideoItemHolder.K, localLayoutParams, i);
        localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.f.getLayoutParams();
        if (ReadInJoyAdUtils.a((VideoInfo)localObject)) {
          localLayoutParams.bottomMargin = AIOUtils.b(124.0F, localContext.getResources());
        } else {
          localLayoutParams.bottomMargin = AIOUtils.b(114.0F, localContext.getResources());
        }
        a(paramADVideoItemHolder.f, localLayoutParams, i);
        paramADVideoItemHolder.f.setLineSpacing(AIOUtils.b(4.0F, localContext.getResources()), 1.0F);
        localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.y.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(65.0F, localContext.getResources());
        if (a()) {
          ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(62.0F, localContext.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(120.0F, localContext.getResources());
        }
        paramADVideoItemHolder.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.U.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(65.0F, localContext.getResources());
        paramADVideoItemHolder.U.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.z.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = AIOUtils.b(60.0F, localContext.getResources());
        ((LinearLayout.LayoutParams)localObject).height = AIOUtils.b(60.0F, localContext.getResources());
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(10.0F, localContext.getResources());
        ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(12.0F, localContext.getResources());
        paramADVideoItemHolder.z.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.E.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(10.0F, localContext.getResources());
        paramADVideoItemHolder.E.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramADVideoItemHolder.C.setTypeface(Typeface.DEFAULT);
        paramADVideoItemHolder.C.setTextSize(12.0F);
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.V.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = AIOUtils.b(38.0F, localContext.getResources());
        paramADVideoItemHolder.V.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.aj.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(50.0F, localContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
        paramADVideoItemHolder.aj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private static void b(ADVideoItemHolder paramADVideoItemHolder, int paramInt)
  {
    a(true, paramADVideoItemHolder, paramInt);
    b(true, paramADVideoItemHolder, paramInt);
  }
  
  private static void b(boolean paramBoolean, ADVideoItemHolder paramADVideoItemHolder, int paramInt)
  {
    if (paramADVideoItemHolder.U == null) {
      return;
    }
    Context localContext = paramADVideoItemHolder.U.getContext();
    if (localContext == null) {
      return;
    }
    int i = 0;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (paramInt == 3)
    {
      i = 16;
      j = 15;
      k = 13;
      m = 65;
      n = 205;
      i1 = 40;
    }
    else if (paramInt == 2)
    {
      i = 15;
      j = 15;
      k = 8;
      m = 5;
      n = -1;
      i1 = 31;
    }
    else
    {
      j = 0;
      k = 0;
      m = 0;
      n = -1;
      i1 = 42;
    }
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leftMargin = ");
    localStringBuilder.append(i);
    localStringBuilder.append(" rightMargin = ");
    localStringBuilder.append(j);
    localStringBuilder.append(" topMargin = ");
    localStringBuilder.append(k);
    localStringBuilder.append(" bottomMargin = ");
    localStringBuilder.append(m);
    localStringBuilder.append(" height = ");
    localStringBuilder.append(i1);
    ((IRIJAdLogService)localObject).d("AdVideoButtonUIUtils", localStringBuilder.toString());
    localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.U.getLayoutParams();
    a(paramADVideoItemHolder.U, (RelativeLayout.LayoutParams)localObject, localContext, i, j, k, m, n, i1);
    if (paramInt == 3)
    {
      b(paramADVideoItemHolder);
      AdVideoDpaTagUtils.a(paramADVideoItemHolder);
      a(paramADVideoItemHolder.aM);
      a(paramADVideoItemHolder.aN);
      return;
    }
    c(paramADVideoItemHolder, paramInt);
    AdVideoDpaTagUtils.b(paramADVideoItemHolder);
    b(paramADVideoItemHolder.aM);
    b(paramADVideoItemHolder.aN);
  }
  
  public static boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(343);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("gray_btn", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static void c(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 4)) {
      paramView.setVisibility(4);
    }
  }
  
  private static void c(ADVideoItemHolder paramADVideoItemHolder, int paramInt)
  {
    if (paramADVideoItemHolder != null)
    {
      if (paramADVideoItemHolder.U == null) {
        return;
      }
      Context localContext = paramADVideoItemHolder.U.getContext();
      if (localContext == null) {
        return;
      }
      if (paramADVideoItemHolder.az != null)
      {
        if (paramADVideoItemHolder.az.c == null) {
          return;
        }
        Object localObject = paramADVideoItemHolder.az.c;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.f.getLayoutParams();
        if (ReadInJoyAdUtils.a((VideoInfo)localObject)) {
          localLayoutParams.bottomMargin = AIOUtils.b(51.0F, localContext.getResources());
        } else {
          localLayoutParams.bottomMargin = AIOUtils.b(55.0F, localContext.getResources());
        }
        paramADVideoItemHolder.f.setLayoutParams(localLayoutParams);
        localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.U.getLayoutParams();
        if (paramInt == 2) {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(5.0F, localContext.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(0.0F, localContext.getResources());
        }
        paramADVideoItemHolder.U.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.z.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = AIOUtils.b(75.0F, localContext.getResources());
        ((LinearLayout.LayoutParams)localObject).height = AIOUtils.b(75.0F, localContext.getResources());
        paramADVideoItemHolder.z.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramADVideoItemHolder.C.setTypeface(Typeface.DEFAULT);
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.V.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = AIOUtils.b(31.0F, localContext.getResources());
        paramADVideoItemHolder.V.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.aj.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(41.5F, localContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(15.0F, localContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(15.0F, localContext.getResources());
        paramADVideoItemHolder.aj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils
 * JD-Core Version:    0.7.0.1
 */