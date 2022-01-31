package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportUtil
{
  private static int a(long paramLong)
  {
    switch ((int)paramLong)
    {
    default: 
      return 8;
    case 0: 
      return 1;
    case 56: 
      return 2;
    }
    return 3;
  }
  
  public static JSONObject a(ArticleInfo paramArticleInfo, RecommendData paramRecommendData)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("source", a(paramArticleInfo.mChannelID));
      localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
      localJSONObject.put("rowkey", paramRecommendData.f);
      localJSONObject.put("rec_articleid", "" + paramRecommendData.jdField_b_of_type_Long);
      localJSONObject.put("rec_puin", "" + paramRecommendData.e);
      localJSONObject.put("mp_article_id", "" + paramArticleInfo.mArticleID);
      localJSONObject.put("kandian_mode", "" + ReadInJoyUtils.e());
      if (NetworkState.isWifiConn()) {}
      for (int i = 1;; i = 2)
      {
        localJSONObject.put("network_type", i);
        localJSONObject.put("os", "1");
        localJSONObject.put("version", "7.6.3".replace(".", ""));
        localJSONObject.put("imei", ReadInJoyUtils.f());
        localJSONObject.put("imsi", ReadInJoyUtils.g());
        localJSONObject.put("rcmInfo", paramRecommendData.h);
        localJSONObject.put("content_type", paramRecommendData.a);
        localJSONObject.put("net_type", HttpUtil.a() + "");
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, BaseData paramBaseData)
  {
    switch (paramBaseData.d)
    {
    default: 
      return;
    }
    RecommendData localRecommendData = (RecommendData)paramBaseData;
    paramBaseData = a(paramArticleInfo, localRecommendData);
    try
    {
      paramBaseData.put("rec_location", "" + localRecommendData.jdField_b_of_type_Int);
      paramBaseData.put("rec_total", "" + localRecommendData.c);
      paramBaseData.put("ad", "0");
      a(paramArticleInfo, "0X8008BA5", paramBaseData.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    PublicAccountReportUtils.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", paramArticleInfo.innerUniqueID, paramString2, false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, List paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    if (paramList.hasNext())
    {
      int k;
      switch (((BaseData)paramList.next()).d)
      {
      case 4: 
      default: 
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = i + 1;
        i = j;
        j = k;
        continue;
        k = j + 1;
        j = i;
        i = k;
      }
    }
    paramList = new HashMap();
    paramList.put("rowkey", paramArticleInfo.innerUniqueID);
    paramList.put("url", paramArticleInfo.mArticleContentUrl);
    paramList.put("imgCount", "" + i);
    paramList.put("videoCount", "" + j);
    paramList.put("textCount", "-1");
    paramList.put("param_uin", ReadInJoyUtils.a());
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebItemCount", true, 0L, 0L, paramList, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      NativeAdUtils.a(paramQQAppInterface, paramAdData);
      QLog.d("Q.readinjoy.fast_web", 2, "" + paramAdData.b + "  : " + paramAdData.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil
 * JD-Core Version:    0.7.0.1
 */