package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
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
import com.tencent.mobileqq.pb.PBStringField;
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
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    case 3: 
      if (paramBoolean) {
        return 3;
      }
      return 1;
    case 4: 
      return 2;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    int j = -1;
    int i = j;
    if (paramAdvertisementInfo.mBusiJson != null)
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mBusiJson.optString("article_ad_ext");
      i = j;
      if (TextUtils.isEmpty(paramAdvertisementInfo)) {}
    }
    try
    {
      i = new JSONObject(paramAdvertisementInfo).optInt("para_pos", 0);
      return i;
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return -1;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, SoftAdReportData paramSoftAdReportData)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {
      return new JSONObject();
    }
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).jdField_a_of_type_JavaLangString = "ce2d9f";
    Object localObject2 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    int i = paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int;
    int j = b(paramAdvertisementInfo);
    localObject1 = new JSONObject();
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      if ((localObject2 != null) && (((GdtDeviceInfoHelper.Result)localObject2).a != null))
      {
        localJSONObject.put("imei", AdDeviceInfoUtil.b());
        localJSONObject.put("oaid", ((GdtDeviceInfoHelper.Result)localObject2).a.aid_ticket.get());
      }
      localJSONObject.put("source_id", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int);
      localJSONObject.put("platform_id", paramAdvertisementInfo.mAdvertisementSoftInfo.d);
      localJSONObject.put("goods_type", paramAdvertisementInfo.mAdvertisementSoftInfo.e);
      localJSONObject.put("goods_id", paramAdvertisementInfo.mAdvertisementSoftInfo.i);
      localJSONObject.put("goods_name", paramAdvertisementInfo.mAdvertisementSoftInfo.j);
      localJSONObject.put("account_id", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_Int);
      localJSONObject.put("content_type", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_Int);
      localJSONObject.put("rowkey", paramAdvertisementInfo.mRowKey);
      localJSONObject.put("cmsid", paramAdvertisementInfo.mAdvertisementSoftInfo.x);
    }
    catch (JSONException paramAdvertisementInfo)
    {
      label312:
      paramAdvertisementInfo.printStackTrace();
      return localObject1;
    }
    try
    {
      localObject2 = new JSONObject(new JSONObject(paramAdvertisementInfo.mAdvertisementSoftInfo.n).optString("reportExt"));
      if (paramSoftAdReportData != null) {
        ((JSONObject)localObject2).put("subjectIndex", paramSoftAdReportData.jdField_a_of_type_Int);
      }
      localJSONObject.put("reportExt", ((JSONObject)localObject2).toString());
    }
    catch (JSONException paramSoftAdReportData)
    {
      paramSoftAdReportData.printStackTrace();
      break label312;
      localJSONObject.put("is_ams_reported", 1);
      break label385;
      localJSONObject.put("exposure_type", 3);
      ((JSONObject)localObject1).put("exposure_info_report", localJSONObject.toString());
    }
    if (paramInt3 != -1) {
      localJSONObject.put("button_state", paramInt3);
    }
    localJSONObject.put("adid", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_JavaLangString);
    localJSONObject.put("position", paramInt5);
    localJSONObject.put("card_style", paramInt4);
    if ((paramInt1 == 2) && (i == 0) && (paramBoolean))
    {
      localJSONObject.put("is_ams_reported", 2);
      label385:
      if (i == 3) {
        localJSONObject.put("author_id", paramAdvertisementInfo.mAdvertisementSoftInfo.P);
      }
      if (paramInt1 != 1) {
        break label489;
      }
      if (paramInt2 != 0) {
        localJSONObject.put("click_pos", paramInt2);
      }
      localJSONObject.put("link_type", j);
      localJSONObject.put("click_type", 3);
      ((JSONObject)localObject1).put("click_info_report", localJSONObject.toString());
      return localObject1;
    }
    label489:
    return localObject1;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = AIOUtils.a(paramInt2, paramContext.getResources());
          localURLDrawableOptions.mRequestHeight = AIOUtils.a(paramInt2, paramContext.getResources());
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
          localURLDrawable.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, AIOUtils.a(paramInt1, paramContext.getResources())));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
        }
        catch (Exception paramContext)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReadInJoyCommonAdUtils", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
          continue;
        }
        paramImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
    }
  }
  
  public static void a(ReadInjoyHeaderAdDownloadView.SimpleRoundProgress paramSimpleRoundProgress)
  {
    if (paramSimpleRoundProgress != null)
    {
      paramSimpleRoundProgress.jdField_a_of_type_Int = Color.parseColor("#CCE5E5E5");
      paramSimpleRoundProgress.jdField_b_of_type_Int = Color.parseColor("#FF00CAFC");
      paramSimpleRoundProgress.jdField_a_of_type_Float = AIOUtils.a(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_b_of_type_Float = AIOUtils.a(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Float = AIOUtils.a(7.0F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Int = 100;
      paramSimpleRoundProgress.e = 270;
      paramSimpleRoundProgress.d = 0;
      paramSimpleRoundProgress.jdField_f_of_type_Int = 1;
    }
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo.g == null)) {}
    for (;;)
    {
      return false;
      try
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramAdvertisementInfo.mAdvertisementSoftInfo.g));
        paramAdvertisementInfo = localIntent.resolveActivityInfo(ReadInJoyUtils.a().getApplication().getPackageManager(), 0);
        if (paramAdvertisementInfo != null)
        {
          boolean bool = TextUtils.isEmpty(paramAdvertisementInfo.packageName);
          if (!bool) {
            return true;
          }
        }
      }
      catch (Exception paramAdvertisementInfo) {}
    }
    return false;
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    int j = 2;
    int i;
    if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g)))
    {
      i = 1;
      if (a(paramAdvertisementInfo)) {
        return 1;
      }
    }
    else
    {
      i = 2;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) {
      j = 0;
    }
    for (;;)
    {
      return j;
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString)) {
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils
 * JD-Core Version:    0.7.0.1
 */