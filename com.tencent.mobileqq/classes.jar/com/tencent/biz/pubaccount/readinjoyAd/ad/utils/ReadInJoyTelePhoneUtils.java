package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import mqq.app.AppActivity;
import org.json.JSONObject;

public class ReadInJoyTelePhoneUtils
{
  public static JSONObject a(int paramInt1, int paramInt2, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("perstatus", paramInt1);
      localJSONObject.put("callact", paramInt2);
      localJSONObject.put("callnum", paramString);
      if (paramAdvertisementInfo != null) {
        localJSONObject.put("phone_cmpt_id", String.valueOf(paramAdvertisementInfo.mPhoneComponetId));
      }
      paramString = new JSONObject();
      paramString.put("comp_stat_src", "");
      paramString.put("phone_component_info", localJSONObject.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    if (!(paramContext instanceof AppActivity)) {
      return;
    }
    b(paramContext, paramString, paramAdvertisementInfo);
  }
  
  public static void b(Context paramContext, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
    NativeAdUtils.a(new AdReportData().a(paramContext).a(116).b(Integer.valueOf(22)).b(28).a(paramAdvertisementInfo).e(a(2, 1, paramString, paramAdvertisementInfo)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyTelePhoneUtils
 * JD-Core Version:    0.7.0.1
 */