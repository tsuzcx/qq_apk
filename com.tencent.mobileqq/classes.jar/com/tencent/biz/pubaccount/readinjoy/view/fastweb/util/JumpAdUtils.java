package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

public class JumpAdUtils
{
  public static void a(Activity paramActivity, AdData paramAdData)
  {
    if (paramAdData.a) {
      a(paramActivity, paramAdData.j);
    }
    for (;;)
    {
      paramActivity = (QQAppInterface)ReadInJoyUtils.a();
      if (paramActivity != null) {
        NativeAdUtils.b(paramActivity, paramAdData);
      }
      return;
      if (paramAdData.b == 12) {
        a(paramActivity, paramAdData.h, paramAdData.f);
      } else {
        a(paramActivity, paramAdData.f);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_ad_json", paramString);
    PublicTransFragmentActivity.b(paramActivity, localIntent, ReadInJoyNativeAdFragment.class);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (NetworkUtil.h(paramContext)) {
        str = paramString + "&acttype=42";
      }
    }
    ReadInJoyUtils.a(paramContext, str);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      if (!paramString2.contains("?")) {
        break label70;
      }
    }
    label70:
    for (str = paramString2 + "?"; NativeAdUtils.a(paramContext, paramString1); str = paramString2 + "&")
    {
      ReadInJoyUtils.a(paramContext, str + "_wv=33554437");
      return;
    }
    a(paramContext, str + "_wv=1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils
 * JD-Core Version:    0.7.0.1
 */