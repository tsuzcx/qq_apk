package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.SoftAdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class ReadInJoyCommonSoftAdUtils
{
  public static int a(int paramInt, boolean paramBoolean)
  {
    int i = 5;
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return 0;
          }
          return 4;
        }
        return 2;
      }
      if (paramBoolean) {
        return 3;
      }
      i = 1;
    }
    return i;
  }
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mBusiJson != null)
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mBusiJson.optString("article_ad_ext");
      if (!TextUtils.isEmpty(paramAdvertisementInfo)) {
        try
        {
          int i = new JSONObject(paramAdvertisementInfo).optInt("para_pos", 0);
          return i;
        }
        catch (Exception paramAdvertisementInfo)
        {
          paramAdvertisementInfo.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, SoftAdReportData paramSoftAdReportData)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      Object localObject1 = new GdtDeviceInfoHelper.Params();
      ((GdtDeviceInfoHelper.Params)localObject1).a = "ce2d9f";
      Object localObject2 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
      int i = paramAdvertisementInfo.mAdvertisementSoftInfo.o;
      int j = b(paramAdvertisementInfo);
      localObject1 = new JSONObject();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((localObject2 != null) && (((GdtDeviceInfoHelper.Result)localObject2).a != null))
        {
          localJSONObject.put("imei", AdDeviceInfoUtil.b());
          localJSONObject.put("oaid", ((GdtDeviceInfoHelper.Result)localObject2).a.aid_ticket.get());
        }
        localJSONObject.put("source_id", paramAdvertisementInfo.mAdvertisementSoftInfo.o);
        localJSONObject.put("platform_id", paramAdvertisementInfo.mAdvertisementSoftInfo.p);
        localJSONObject.put("goods_type", paramAdvertisementInfo.mAdvertisementSoftInfo.q);
        localJSONObject.put("goods_id", paramAdvertisementInfo.mAdvertisementSoftInfo.r);
        localJSONObject.put("goods_name", paramAdvertisementInfo.mAdvertisementSoftInfo.s);
        localJSONObject.put("account_id", paramAdvertisementInfo.mAdvertisementSoftInfo.t);
        localJSONObject.put("content_type", paramAdvertisementInfo.mAdvertisementSoftInfo.m);
        localJSONObject.put("rowkey", paramAdvertisementInfo.mRowKey);
        localJSONObject.put("cmsid", paramAdvertisementInfo.mAdvertisementSoftInfo.H);
        try
        {
          localObject2 = new JSONObject(new JSONObject(paramAdvertisementInfo.mAdvertisementSoftInfo.x).optString("reportExt"));
          if (paramSoftAdReportData != null) {
            ((JSONObject)localObject2).put("subjectIndex", paramSoftAdReportData.a);
          }
          localJSONObject.put("reportExt", ((JSONObject)localObject2).toString());
        }
        catch (JSONException paramSoftAdReportData)
        {
          paramSoftAdReportData.printStackTrace();
        }
        if (paramInt3 != -1) {
          localJSONObject.put("button_state", paramInt3);
        }
        localJSONObject.put("adid", paramAdvertisementInfo.mAdvertisementSoftInfo.e);
        localJSONObject.put("position", paramInt5);
        localJSONObject.put("card_style", paramInt4);
        if ((paramInt1 == 2) && (i == 0) && (paramBoolean)) {
          localJSONObject.put("is_ams_reported", 2);
        } else {
          localJSONObject.put("is_ams_reported", 1);
        }
        if (i == 3) {
          localJSONObject.put("author_id", paramAdvertisementInfo.mAdvertisementSoftInfo.aa);
        }
        if (paramInt1 == 1)
        {
          if (paramInt2 != 0) {
            localJSONObject.put("click_pos", paramInt2);
          }
          localJSONObject.put("link_type", j);
          localJSONObject.put("click_type", 3);
          ((JSONObject)localObject1).put("click_info_report", localJSONObject.toString());
          return localObject1;
        }
        localJSONObject.put("exposure_type", 3);
        ((JSONObject)localObject1).put("exposure_info_report", localJSONObject.toString());
        return localObject1;
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
        return localObject1;
      }
    }
    return new JSONObject();
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      float f = paramInt2;
      localURLDrawableOptions.mRequestWidth = AIOUtils.b(f, paramContext.getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.b(f, paramContext.getResources());
      if (paramInt3 != -1) {
        localURLDrawableOptions.mUseMemoryCache = false;
      }
      URLDrawable localURLDrawable = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      localURLDrawable.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, AIOUtils.b(paramInt1, paramContext.getResources())));
      if (paramInt3 == 0)
      {
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else if (paramInt3 == 1)
      {
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else
      {
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
      }
      paramImageView.setImageDrawable(localURLDrawable);
      return;
    }
    catch (Exception paramContext)
    {
      label195:
      break label195;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("后台下发的url格式有问题：");
      paramContext.append(paramString);
      QLog.d("ReadInJoyCommonAdUtils", 2, paramContext.toString());
    }
  }
  
  public static void a(ReadInjoyHeaderAdDownloadView.SimpleRoundProgress paramSimpleRoundProgress)
  {
    if (paramSimpleRoundProgress != null)
    {
      paramSimpleRoundProgress.b = Color.parseColor("#CCE5E5E5");
      paramSimpleRoundProgress.d = Color.parseColor("#FF00CAFC");
      paramSimpleRoundProgress.c = AIOUtils.b(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.e = AIOUtils.b(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.f = AIOUtils.b(7.0F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.g = 100;
      paramSimpleRoundProgress.i = 270;
      paramSimpleRoundProgress.h = 0;
      paramSimpleRoundProgress.j = 1;
    }
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    int i;
    if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.l)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.k)))
    {
      i = 1;
      if (c(paramAdvertisementInfo)) {
        return 1;
      }
    }
    else
    {
      i = 2;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.l)) {
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.j)) {
      return 2;
    }
    return i;
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementSoftInfo != null)) {
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.k == null) {
        return false;
      }
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramAdvertisementInfo.mAdvertisementSoftInfo.k));
      paramAdvertisementInfo = localIntent.resolveActivityInfo(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication().getPackageManager(), 0);
      if (paramAdvertisementInfo != null)
      {
        boolean bool = TextUtils.isEmpty(paramAdvertisementInfo.packageName);
        return !bool;
      }
      return false;
    }
    catch (Exception paramAdvertisementInfo) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils
 * JD-Core Version:    0.7.0.1
 */