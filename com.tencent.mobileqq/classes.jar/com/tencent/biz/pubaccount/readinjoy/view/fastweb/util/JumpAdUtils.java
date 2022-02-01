package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.KandianPopupWindowForAd;

public class JumpAdUtils
{
  private static KandianPopupWindowForAd a;
  
  public static Integer a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_ad_json", paramString);
    PublicTransFragmentActivity.b(paramActivity, localIntent, ReadInJoyNativeAdFragment.class);
    return Integer.valueOf(0);
  }
  
  public static Integer a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (NetworkUtil.h(paramContext)) {
        str = paramString + "&acttype=42";
      }
    }
    return ReadInJoyUtils.a(paramContext, str);
  }
  
  public static Integer a(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      if (!paramString2.contains("?")) {
        break label70;
      }
    }
    label70:
    for (str = paramString2 + "?"; NativeAdUtils.a(paramContext, paramString1); str = paramString2 + "&") {
      return ReadInJoyUtils.a(paramContext, str + "_wv=33554437");
    }
    return a(paramContext, str + "_wv=1");
  }
  
  public static void a()
  {
    if ((a != null) && (a.isShowing())) {
      a.dismiss();
    }
    a = null;
  }
  
  public static void a(Activity paramActivity, AdData paramAdData)
  {
    if (paramAdData.a) {
      paramActivity = a(paramActivity, paramAdData.j);
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      if (localQQAppInterface != null) {
        NativeAdUtils.a(localQQAppInterface, paramAdData, paramActivity);
      }
      return;
      if (paramAdData.jdField_b_of_type_Int == 12) {
        paramActivity = a(paramActivity, paramAdData.h, paramAdData.f);
      } else {
        paramActivity = a(paramActivity, paramAdData.f);
      }
    }
  }
  
  public static void a(BaseData paramBaseData, View paramView, Context paramContext)
  {
    Object localObject;
    if ((paramBaseData != null) && ((paramBaseData.s == 10) || (paramBaseData.s == 17) || (paramBaseData.s == 22) || (paramBaseData.s == 9)))
    {
      if (paramBaseData.s != 17) {
        break label138;
      }
      localObject = (ProteusBannerVideoItemData)paramBaseData;
    }
    for (;;)
    {
      if (a == null) {
        a = new KandianPopupWindowForAd((Activity)paramContext);
      }
      if (!a.a()) {
        a.a();
      }
      paramBaseData = new JumpAdUtils.1(paramContext, paramBaseData, (AdData)localObject);
      if (a.a(0, ((AdData)localObject).jdField_b_of_type_JavaUtilArrayList))
      {
        a.a(paramView, paramBaseData);
        a.a(new JumpAdUtils.2(paramContext, (AdData)localObject));
      }
      return;
      label138:
      if (paramBaseData.s == 10) {
        localObject = (ProteusBannerBigPicItemData)paramBaseData;
      } else if (paramBaseData.s == 9) {
        localObject = (RecommendAdData)paramBaseData;
      } else {
        localObject = (ProteusInnerData)paramBaseData;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils
 * JD-Core Version:    0.7.0.1
 */