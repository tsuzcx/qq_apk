package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class InteraActionReportUtils
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 11: 
      return 1;
    case 12: 
      return 2;
    case 13: 
      return 3;
    }
    return 4;
  }
  
  public static void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((!ReadinJoyActionUtil.a(paramArticleInfo)) || (paramViewBase == null)) {}
    do
    {
      return;
      if ((paramViewBase instanceof ReadInJoyLikeButton))
      {
        NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(11).b(3).a((AdvertisementInfo)paramArticleInfo));
        return;
      }
      if ((paramViewBase instanceof ReadInJoyBiuButton))
      {
        NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(13).b(3).a((AdvertisementInfo)paramArticleInfo));
        return;
      }
    } while (!(paramViewBase instanceof NativeButton));
    if (paramBoolean)
    {
      NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(14).b(3).a((AdvertisementInfo)paramArticleInfo));
      return;
    }
    NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(12).b(3).a((AdvertisementInfo)paramArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.InteraActionReportUtils
 * JD-Core Version:    0.7.0.1
 */