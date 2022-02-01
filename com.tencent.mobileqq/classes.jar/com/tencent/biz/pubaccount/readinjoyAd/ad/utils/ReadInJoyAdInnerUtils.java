package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoyAdInnerUtils
{
  private static String a = "ReadInJoyAdInnerUtils";
  
  public static String a(String paramString, int paramInt)
  {
    int j = 0;
    i = 0;
    for (;;)
    {
      try
      {
        if (j >= paramString.length()) {
          continue;
        }
        if (String.valueOf(paramString.charAt(j)).getBytes().length != 1) {
          continue;
        }
        i += 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
        i += 2;
        continue;
      }
      if ((j < paramString.length() - 1) && (i >= paramInt))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, j));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyAdUtils", 2, "getTitle error");
    }
    return paramString;
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBusinessJson error articleId123:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" tag:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" cashInfo:");
      ((StringBuilder)localObject).append(paramString3);
      QLog.e("ReadInJoyAdUtils", 2, ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        ((JSONObject)localObject).put("article_id", paramString1);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        ((JSONObject)localObject).put("cash_tag", paramString3);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((JSONObject)localObject).put("tags", paramString2);
      }
      return localObject;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject2 == null) {
      return paramJSONObject1;
    }
    try
    {
      if (paramJSONObject2.has("article_id")) {
        paramJSONObject1.put("article_id", paramJSONObject2.get("article_id"));
      }
      if (paramJSONObject2.has("tags")) {
        paramJSONObject1.put("tags", paramJSONObject2.get("tags"));
      }
      if (paramJSONObject2.has("cash_tag")) {
        paramJSONObject1.put("cash_tag", paramJSONObject2.get("cash_tag"));
      }
      if (paramJSONObject2.has("message")) {
        paramJSONObject1.put("message", paramJSONObject2.get("message"));
      }
      if (paramJSONObject2.has("rowkey")) {
        paramJSONObject1.put("rowkey", paramJSONObject2.get("rowkey"));
      }
      return paramJSONObject1;
    }
    catch (Exception paramJSONObject2)
    {
      paramJSONObject2.printStackTrace();
    }
    return paramJSONObject1;
  }
  
  public static void a(ProteusInnerData paramProteusInnerData, int paramInt)
  {
    if (paramProteusInnerData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 1, "doClickReport adData null");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 1, "doClickReport");
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
      if (localQQAppInterface != null) {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(localQQAppInterface).a(BaseApplication.getContext()).a(1).b(18).b(Integer.valueOf(0)).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramProteusInnerData)).c(paramInt).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramProteusInnerData)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils
 * JD-Core Version:    0.7.0.1
 */