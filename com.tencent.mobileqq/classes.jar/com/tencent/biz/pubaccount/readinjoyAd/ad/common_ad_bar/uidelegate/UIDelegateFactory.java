package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;

public class UIDelegateFactory
{
  public static IUIDelegate a(Context paramContext, AdData paramAdData)
  {
    if ((paramContext == null) || (paramAdData == null)) {
      return null;
    }
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).g())) {
      return new GamesComponentAdDelegate(paramContext, 2);
    }
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).f())) {
      return new GoodsSoftAdAppDelegate(paramContext, 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.UIDelegateFactory
 * JD-Core Version:    0.7.0.1
 */