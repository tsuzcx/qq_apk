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
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class AdVideoButtonUIUtils
{
  public static int a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return 1;
      if (ReadInJoyAdSwitchUtil.a()) {
        return 3;
      }
    } while (!ReadInJoyAdSwitchUtil.c(paramVideoAdInfo));
    return 2;
  }
  
  public static void a(Context paramContext, ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null))
    {
      VideoInfo localVideoInfo = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a;
      if (ReadInJoyAdUtils.a(localVideoInfo)) {
        paramADVideoItemHolder.m.setText(ReadInJoyAdUtils.a(paramContext, localVideoInfo, 1));
      }
      paramADVideoItemHolder.m.setTag(paramADVideoItemHolder);
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
    if ((paramView == null) || (paramContext == null) || (paramLayoutParams == null)) {
      return;
    }
    paramLayoutParams.leftMargin = AIOUtils.a(paramInt1, paramContext.getResources());
    paramLayoutParams.rightMargin = AIOUtils.a(paramInt2, paramContext.getResources());
    paramLayoutParams.topMargin = AIOUtils.a(paramInt3, paramContext.getResources());
    paramLayoutParams.bottomMargin = AIOUtils.a(paramInt4, paramContext.getResources());
    paramLayoutParams.height = AIOUtils.a(paramInt6, paramContext.getResources());
    if (paramInt5 > 0) {
      paramLayoutParams.width = AIOUtils.a(paramInt5, paramContext.getResources());
    }
    paramView.setLayoutParams(paramLayoutParams);
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
    if ((paramADVideoItemHolder == null) || (paramADVideoItemHolder.n == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramADVideoItemHolder.n.setText(paramString);
    a(paramADVideoItemHolder.n);
    ThreadManager.getUIHandler().postDelayed(new AdVideoButtonUIUtils.1(paramADVideoItemHolder), 1000L);
  }
  
  public static void a(boolean paramBoolean, ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.a == null)) {
      return;
    }
    int i = a(paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.a);
    if (!paramBoolean)
    {
      a(paramADVideoItemHolder, i);
      return;
    }
    b(paramADVideoItemHolder, i);
  }
  
  private static void a(boolean paramBoolean, ADVideoItemHolder paramADVideoItemHolder, int paramInt) {}
  
  public static boolean a()
  {
    return Aladdin.getConfig(343).getIntegerFromString("tiktok_big_style", 0) == 1;
  }
  
  public static void b(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 8)) {
      paramView.setVisibility(8);
    }
  }
  
  private static void b(ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getContext();
    } while ((localContext == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a == null));
    Object localObject = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a;
    int i = localContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(77.0F, localContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.k.getLayoutParams();
    a(paramADVideoItemHolder.k, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    a(paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (ReadInJoyAdUtils.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = AIOUtils.a(124.0F, localContext.getResources());
      a(paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams, i);
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setLineSpacing(AIOUtils.a(4.0F, localContext.getResources()), 1.0F);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_l_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(65.0F, localContext.getResources());
      if (!a()) {
        break label475;
      }
    }
    label475:
    for (((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(62.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(120.0F, localContext.getResources()))
    {
      paramADVideoItemHolder.jdField_l_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(65.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = AIOUtils.a(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.a(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(10.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(12.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(10.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramADVideoItemHolder.h.setTypeface(Typeface.DEFAULT);
      paramADVideoItemHolder.h.setTextSize(12.0F);
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.a(38.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(50.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = AIOUtils.a(114.0F, localContext.getResources());
      break;
    }
  }
  
  private static void b(ADVideoItemHolder paramADVideoItemHolder, int paramInt)
  {
    a(true, paramADVideoItemHolder, paramInt);
    b(true, paramADVideoItemHolder, paramInt);
  }
  
  private static void b(boolean paramBoolean, ADVideoItemHolder paramADVideoItemHolder, int paramInt)
  {
    int n = 15;
    int k = 0;
    if (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) {}
    Context localContext;
    do
    {
      return;
      localContext = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getContext();
    } while (localContext == null);
    int i1 = -1;
    int m = 42;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 16;
      j = 13;
      k = 65;
      i1 = 205;
      m = 40;
    }
    for (;;)
    {
      ReadInJoyAdLog.a("AdVideoButtonUIUtils", "leftMargin = " + i + " rightMargin = " + n + " topMargin = " + j + " bottomMargin = " + k + " height = " + m);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      a(paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, localLayoutParams, localContext, i, n, j, k, i1, m);
      if (paramInt == 3)
      {
        b(paramADVideoItemHolder);
        AdVideoDpaTagUtils.a(paramADVideoItemHolder);
        a(paramADVideoItemHolder.p);
        a(paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
        return;
        if (paramInt == 2)
        {
          j = 8;
          k = 5;
          m = 31;
          i = 15;
        }
      }
      else
      {
        c(paramADVideoItemHolder, paramInt);
        AdVideoDpaTagUtils.b(paramADVideoItemHolder);
        b(paramADVideoItemHolder.p);
        b(paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
        return;
      }
      j = 0;
      n = 0;
      i = 0;
    }
  }
  
  public static boolean b()
  {
    return Aladdin.getConfig(343).getIntegerFromString("gray_btn", 0) == 1;
  }
  
  public static void c(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 4)) {
      paramView.setVisibility(4);
    }
  }
  
  private static void c(ADVideoItemHolder paramADVideoItemHolder, int paramInt)
  {
    if ((paramADVideoItemHolder == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getContext();
    } while ((localContext == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a == null));
    Object localObject = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (ReadInJoyAdUtils.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = AIOUtils.a(51.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      if (paramInt != 2) {
        break label300;
      }
    }
    label300:
    for (((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(5.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(0.0F, localContext.getResources()))
    {
      paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = AIOUtils.a(75.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.a(75.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramADVideoItemHolder.h.setTypeface(Typeface.DEFAULT);
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.a(31.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(41.5F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(15.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(15.0F, localContext.getResources());
      paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = AIOUtils.a(55.0F, localContext.getResources());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils
 * JD-Core Version:    0.7.0.1
 */