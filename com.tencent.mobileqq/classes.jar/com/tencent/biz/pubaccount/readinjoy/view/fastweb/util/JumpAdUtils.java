package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.KandianPopupWindowForAd;

public class JumpAdUtils
{
  private static KandianPopupWindowForAd a;
  
  public static Integer a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_ad_json", paramString);
    PublicTransFragmentActivity.b(paramActivity, localIntent, ((IRIJAdService)QRoute.api(IRIJAdService.class)).getReadInJoyNativeAdFragment());
    return Integer.valueOf(0);
  }
  
  public static Integer a(Context paramContext, String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (NetworkUtil.isWifiConnected(paramContext))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("&acttype=42");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return Integer.valueOf(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).jumpTo(paramContext, (String)localObject));
  }
  
  public static Integer a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      if (paramString2.contains("?"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("?");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("&");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(paramContext, paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append((String)localObject);
      paramString1.append("_wv=33554437");
      paramString1 = paramString1.toString();
      return Integer.valueOf(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).jumpTo(paramContext, paramString1));
    }
    paramString1 = new StringBuilder();
    paramString1.append((String)localObject);
    paramString1.append("_wv=1");
    return a(paramContext, paramString1.toString());
  }
  
  public static void a()
  {
    KandianPopupWindowForAd localKandianPopupWindowForAd = a;
    if ((localKandianPopupWindowForAd != null) && (localKandianPopupWindowForAd.isShowing())) {
      a.dismiss();
    }
    a = null;
  }
  
  public static void a(Activity paramActivity, AdData paramAdData)
  {
    if (paramAdData.c) {
      paramActivity = a(paramActivity, paramAdData.r);
    } else if (paramAdData.d == 12) {
      paramActivity = a(paramActivity, paramAdData.p, paramAdData.n);
    } else {
      paramActivity = a(paramActivity, paramAdData.n);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localQQAppInterface != null) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportNativeEngineAdClick(localQQAppInterface, paramAdData, paramActivity);
    }
  }
  
  public static void a(BaseData paramBaseData, View paramView, Context paramContext)
  {
    if ((paramBaseData != null) && ((paramBaseData.u == 10) || (paramBaseData.u == 17) || (paramBaseData.u == 22) || (paramBaseData.u == 9)))
    {
      if (paramBaseData.u == 17) {
        paramBaseData = (ProteusBannerVideoItemData)paramBaseData;
      } else if (paramBaseData.u == 10) {
        paramBaseData = (AdData)paramBaseData;
      } else if (paramBaseData.u == 9) {
        paramBaseData = (AdData)paramBaseData;
      } else {
        paramBaseData = (AdData)paramBaseData;
      }
      if (a == null) {
        a = new KandianPopupWindowForAd((Activity)paramContext);
      }
      if (!a.a()) {
        a.a();
      }
      JumpAdUtils.1 local1 = new JumpAdUtils.1(paramContext, paramBaseData);
      if (a.a(0, paramBaseData.b))
      {
        a.a(paramView, local1);
        a.a(new JumpAdUtils.2(paramContext, paramBaseData));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils
 * JD-Core Version:    0.7.0.1
 */