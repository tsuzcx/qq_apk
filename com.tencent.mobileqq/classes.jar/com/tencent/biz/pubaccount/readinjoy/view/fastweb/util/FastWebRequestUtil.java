package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import android.graphics.Paint.FontMetricsInt;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusInteractiveItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.FeedbackCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.gdtad.util.GdtDeviceUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.util.ObjectUtil;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class FastWebRequestUtil
{
  public static String a;
  private static Map<String, String> a;
  public static String b = "https://kandian.qq.com/kandian_article/get_article_recomm?from=native";
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://c.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  }
  
  private static int a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (!paramJSONObject.isNull("ad_pos_type")) {
      i = paramJSONObject.optInt("ad_pos_type", 0);
    }
    return i;
  }
  
  private static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(Uri.parse(paramString).getQueryParameter("article_id"));
      return l;
    }
    catch (Exception localException)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("which", "3");
      localHashMap.put("article_url", "" + paramString);
      localHashMap.put("error", "" + localException.toString());
      localHashMap.put("param_uin", ReadInJoyUtils.a());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", false, 0L, 0L, localHashMap, null);
    }
    return -1L;
  }
  
  @NotNull
  private static AdData a(JSONObject paramJSONObject)
  {
    Object localObject1;
    if ((paramJSONObject.has("type")) && (paramJSONObject.optInt("type") == 100)) {
      localObject1 = new AttachedAdData();
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return localObject1;
                        if (TextUtils.isEmpty(paramJSONObject.optString("video"))) {
                          break;
                        }
                        localObject2 = new ProteusBannerVideoItemData();
                        localObject1 = localObject2;
                      } while (!paramJSONObject.has("video_file_size"));
                      ((ProteusBannerVideoItemData)localObject2).f = paramJSONObject.optLong("video_file_size");
                      return localObject2;
                      localObject2 = new ProteusBannerBigPicItemData();
                      localObject1 = localObject2;
                    } while (!paramJSONObject.has("local_info"));
                    paramJSONObject = paramJSONObject.optJSONObject("local_info");
                    if (QLog.isColorLevel()) {
                      QLog.d("FastWebRequestUtil", 2, "has local info ->" + paramJSONObject);
                    }
                    localObject1 = localObject2;
                  } while (paramJSONObject == null);
                  ((ProteusBannerBigPicItemData)localObject2).X = paramJSONObject.optString("store_name");
                  ((ProteusBannerBigPicItemData)localObject2).Y = paramJSONObject.optString("store_addr");
                  ((ProteusBannerBigPicItemData)localObject2).Z = paramJSONObject.optString("store_url");
                  ((ProteusBannerBigPicItemData)localObject2).ab = paramJSONObject.optString("store_long");
                  ((ProteusBannerBigPicItemData)localObject2).aa = paramJSONObject.optString("store_lat");
                  ((ProteusBannerBigPicItemData)localObject2).ac = paramJSONObject.optString("dist_desc");
                  ((ProteusBannerBigPicItemData)localObject2).ad = paramJSONObject.optString("corporate_image_name");
                  ((ProteusBannerBigPicItemData)localObject2).ae = paramJSONObject.optString("distance_limit");
                  localObject1 = localObject2;
                } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).X));
                localObject1 = localObject2;
              } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).Y));
              localObject1 = localObject2;
            } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).Z));
            localObject1 = localObject2;
          } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).ab));
          localObject1 = localObject2;
        } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).aa));
        localObject1 = localObject2;
      } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).ac));
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).ae));
    ((ProteusBannerBigPicItemData)localObject2).f = true;
    return localObject2;
  }
  
  private static AdData a(JSONObject paramJSONObject, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastWebRequestUtil", 1, "parseAdItem failed");
      }
      return null;
    }
    Object localObject;
    if (paramInt1 == 2)
    {
      localObject = new ProteusInnerData();
      ((AdData)localObject).d = true;
    }
    for (;;)
    {
      ((AdData)localObject).T = paramJSONObject.toString();
      ((AdData)localObject).t = paramInt1;
      ((AdData)localObject).r = paramInt3;
      ((AdData)localObject).a(paramJSONObject, paramString);
      if (!((AdData)localObject).a(paramJSONObject, paramInt2)) {
        break;
      }
      ((AdData)localObject).a();
      return localObject;
      if (paramInt1 == 1) {
        localObject = a(paramJSONObject);
      } else {
        localObject = new RecommendAdData();
      }
    }
    ((AdData)localObject).a();
    return null;
  }
  
  private static AdData a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AdData localAdData1 = a(paramJSONObject1, paramInt1, paramString2, paramInt2, paramInt3);
    if (localAdData1 == null)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = localAdData1;
    paramJSONObject1 = localAdData1;
    for (;;)
    {
      try
      {
        if (localAdData1.o != 32) {
          break;
        }
        localObject = localAdData1;
        paramJSONObject1 = localAdData1;
        if (localAdData1.a == null) {
          break;
        }
        paramJSONObject1 = localAdData1;
        AdData localAdData2 = AdExposeFreshManager.a().a("RIJAdRefreshSceneNativeArticle", localAdData1);
        localObject = localAdData1;
        if (localAdData2 == null) {
          break;
        }
        localObject = localAdData1;
        paramJSONObject1 = localAdData1;
        if (ObjectUtil.equals(localAdData1, localAdData2)) {
          break;
        }
        paramJSONObject1 = localAdData1;
        localObject = new JSONObject(localAdData2.T);
        paramJSONObject1 = localAdData1;
        ((JSONObject)localObject).put("rowkey", paramString1);
        paramJSONObject1 = localAdData1;
        paramString1 = a(ReadInJoyAdInnerUtils.a((JSONObject)localObject, paramJSONObject2), paramInt1, paramString2, paramInt2, paramInt3);
        paramJSONObject1 = paramString1;
        paramString2 = new StringBuilder().append("parseExposeFreshAdData，success, adId：");
        if (paramString1 != null)
        {
          paramJSONObject1 = paramString1;
          paramJSONObject2 = Integer.valueOf(paramString1.c);
          paramJSONObject1 = paramString1;
          QLog.d("AdExposeFreshManager", 1, paramJSONObject2);
          return paramString1;
        }
      }
      catch (Throwable paramJSONObject2)
      {
        QLog.d("AdExposeFreshManager", 1, "parseExposeFreshAdData，fail, adId：", paramJSONObject2);
        return paramJSONObject1;
      }
      paramJSONObject2 = "0";
    }
  }
  
  private static ProteusItemData a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return new ProteusRecommendItemData();
    }
    return new ProteusInteractiveItemData();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramString.startsWith("http:"));
        str = paramString;
      } while (paramString.startsWith("https"));
      str = paramString;
    } while (paramString.startsWith("mqqapi:"));
    if (paramBoolean) {
      return "https:" + paramString;
    }
    return "http:" + paramString;
  }
  
  private static String a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("card_info");
    if (paramJSONObject == null) {
      return "null";
    }
    return paramJSONObject.optString("rowKey", "null");
  }
  
  public static List<BaseData> a(String paramString, int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      localObject = localArrayList;
      if (paramList.hasNext()) {
        localObject = b(paramString, paramInt, (String)paramList.next());
      }
    }
    return localObject;
  }
  
  public static Map<String, String> a(Context paramContext)
  {
    if (jdField_a_of_type_JavaUtilMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastWebRequestUtil", 2, "getDisplayParams : " + jdField_a_of_type_JavaUtilMap);
      }
      return jdField_a_of_type_JavaUtilMap;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = TemplateFactory.a("native_article", true);
    if (localObject1 == null) {
      return localHashMap;
    }
    localObject1 = ((TemplateFactory)localObject1).getTemplate("ReadInjoy_article_text_cell");
    if (localObject1 == null) {
      return localHashMap;
    }
    Object localObject2 = ((TemplateBean)localObject1).getViewBean().findViewById("id_article_paragraph");
    String str1;
    String str2;
    if (localObject2 != null)
    {
      localObject1 = (String)((ViewBean)localObject2).valueBean.normalValue.get("margin_left");
      str1 = (String)((ViewBean)localObject2).valueBean.normalValue.get("margin_top");
      str2 = (String)((ViewBean)localObject2).valueBean.normalValue.get("setLineSpace:");
      localObject2 = (String)((ViewBean)localObject2).valueBean.normalValue.get("setFontSizeString:");
    }
    try
    {
      int i = (int)FastWebPTSUtils.a();
      int i1 = Utils.dp2px(Integer.valueOf(str2).intValue());
      int j = Utils.dp2px(Integer.valueOf((String)localObject1).intValue());
      int k = Utils.dp2px(Integer.valueOf(str1).intValue());
      int m = ScreenUtil.getInstantScreenHeight(paramContext);
      int n = ScreenUtil.getInstantScreenWidth(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = Utils.dp2px(Integer.valueOf((String)localObject2).intValue());
        paramContext = new TextPaint();
        paramContext.setTextSize(Utils.dp2px(i));
        i = paramContext.getFontMetricsInt(new Paint.FontMetricsInt());
        i1 = (int)(i1 * 2 / 3.0D);
        int i2 = (int)paramContext.measureText("我");
        localHashMap.put("screenWidth", String.valueOf(n));
        localHashMap.put("screenHeight", String.valueOf(m));
        localHashMap.put("lineHeight", String.valueOf(i + i1));
        localHashMap.put("contentPadding", String.valueOf(j));
        localHashMap.put("paragraphSpace", String.valueOf(k));
        localHashMap.put("fontSize", String.valueOf(i2));
        jdField_a_of_type_JavaUtilMap = localHashMap;
        if (QLog.isColorLevel()) {
          QLog.d("FastWebRequestUtil", 2, "getDisplayParams : " + localHashMap.toString());
        }
        return localHashMap;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("FastWebRequestUtil", 2, paramContext, new Object[0]);
        localHashMap.clear();
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt1 == 0) {}
    try
    {
      paramJSONObject.put("label_separator_line_top_bg_color", paramJSONObject.optString("label_separator_line_top_bg_color", "#E5E5E5"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebRequestUtil", 1, "parseProteusItem msg=" + paramJSONObject);
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramJSONObject.put("label_separator_line_bottom_bg_color", paramJSONObject.optString("label_separator_line_bottom_bg_color", "#E5E5E5"));
      return;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, ProteusItemData paramProteusItemData, int paramInt, SparseArray<Float> paramSparseArray)
  {
    if ((paramArticleInfo == null) || (paramProteusItemData == null) || (paramProteusItemData.c == null)) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = paramProteusItemData.c.optJSONObject("card_info");
        if (localJSONObject == null) {
          break label183;
        }
        localJSONObject.put("strategyId", paramArticleInfo.mStrategyId);
        localJSONObject.put("algorithmID", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("articleTitle", paramArticleInfo.mTitle);
        localJSONObject.put("articleRowKey", paramArticleInfo.innerUniqueID);
      }
      catch (Exception paramArticleInfo)
      {
        Object localObject;
        QLog.d("FastWebRequestUtil", 1, "addExtraInfo error! msg=" + paramArticleInfo);
        return;
      }
      paramProteusItemData.b = localObject;
      paramProteusItemData.x = paramInt;
      paramProteusItemData.c.put("dt_rowkey", paramArticleInfo.innerUniqueID);
      a(paramProteusItemData);
      return;
      if (localJSONObject != null) {
        localJSONObject.put("channelID", paramArticleInfo.mChannelID);
      }
      float f1 = FastWebPTSDataConverter.b(paramSparseArray);
      continue;
      f1 = FastWebPTSDataConverter.c(paramSparseArray);
      continue;
      label183:
      float f2 = -1000.0F;
      f1 = f2;
      switch (paramInt)
      {
      }
      f1 = f2;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, ReadInJoyFeedbackPopupWindow.FeedbackCallback paramFeedbackCallback)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "deleteFeeds.");
    ThreadManager.excute(new FastWebRequestUtil.6(paramArticleInfo, paramFeedbackCallback), 128, null, true);
  }
  
  private static void a(ProteusItemData paramProteusItemData)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramProteusItemData.c.keys();
    String str;
    Object localObject;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject = paramProteusItemData.c.optJSONObject(str);
      if (localObject != null) {
        localHashMap.put("dt_" + str, ((JSONObject)localObject).optString("text"));
      }
    }
    localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject = (String)localHashMap.get(str);
      paramProteusItemData.c.put(str, localObject);
    }
  }
  
  public static void a(String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("Q.readinjoy.fast_web", 2, "" + paramString);
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    try
    {
      long l = a(paramString);
      if (l == -1L) {
        return;
      }
      localObject = arrayOfByte;
      paramString = new Bundle();
      localObject = arrayOfByte;
      paramString.putString("articleId", String.valueOf(l));
      localObject = arrayOfByte;
      QLog.d("Q.readinjoy.fast_web", 2, "" + "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l);
      localObject = arrayOfByte;
      Bundle localBundle = new Bundle();
      localObject = arrayOfByte;
      HttpUtil.addCookie(localBundle);
      localObject = arrayOfByte;
      arrayOfByte = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://c.mp.qq.com/review/img-txt-comment/list?source=1", "POST", paramString, localBundle);
      localObject = "";
      paramString = (String)localObject;
      if (arrayOfByte != null) {
        paramString = new String(arrayOfByte);
      }
      localObject = paramString;
      QLog.d("Q.readinjoy.fast_web", 2, "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l + " " + paramString);
      localObject = paramString;
      int i = new JSONObject(paramString).getInt("readCount");
      localObject = paramString;
      if (i > paramFastWebArticleInfo.a)
      {
        localObject = paramString;
        paramFastWebArticleInfo.a = i;
        localObject = paramString;
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.5());
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Q.readinjoy.fast_web", 2, paramString, new Object[] { "" + (String)localObject });
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, FastWebRequestUtil.ResponseCallback paramResponseCallback, int paramInt)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.3(paramString1, paramString2, paramInt, paramResponseCallback));
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt1, long paramLong, FastWebRequestUtil.ResponseCallback paramResponseCallback, int paramInt2)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.4(paramString1, paramString2, paramString3, paramString4, paramString6, paramString7, paramBoolean, paramInt1, paramLong, paramString5, paramInt2, paramResponseCallback));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, FastWebRequestUtil.RecommendAndAdCallback paramRecommendAndAdCallback, int paramInt1, int paramInt2, long paramLong)
  {
    paramRecommendAndAdCallback = new FastWebRequestUtil.RecommendAndAd(paramString1, paramRecommendAndAdCallback);
    a(paramString1, paramString2, paramString3, new FastWebRequestUtil.1(paramRecommendAndAdCallback), paramInt2);
    a(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramString6, paramString7, paramInt1, paramLong, new FastWebRequestUtil.2(paramRecommendAndAdCallback), paramInt2);
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optString("kd_ug_rsp_info");
    Object localObject2;
    if ((localObject1 != null) && (paramJSONObject.opt("id_recommend_category_txt") != null) && (paramJSONObject.opt("kd_ug_download_url") != null))
    {
      localObject1 = new FastWebRecommendUGInfo((String)localObject1, WebFastAdapter.a(paramJSONObject));
      a(paramJSONObject, (FastWebRecommendUGInfo)localObject1);
      localObject2 = ((FastWebRecommendUGInfo)localObject1).b;
      paramJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
      paramJSONObject.put("text_color", "#FF4A2D");
      paramJSONObject.put("label_ug_progress_bgcolor", "#FFE9E9");
      paramJSONObject.put("label_ug_progress_fgcolor", "#FFCECE");
      if (PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
        break label165;
      }
      if ((((FastWebRecommendUGInfo)localObject1).b()) && (!TextUtils.isEmpty(((FastWebRecommendUGInfo)localObject1).c)))
      {
        paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).e);
        paramJSONObject.put("label_ug_progress_progress", 100);
      }
    }
    else
    {
      return;
    }
    paramJSONObject.put("text", "");
    return;
    label165:
    if ((((FastWebRecommendUGInfo)localObject1).a()) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject2 = DownloadManagerV2.a().b((String)localObject2);
      if (localObject2 == null)
      {
        paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).f);
        paramJSONObject.put("label_ug_progress_progress", 0);
        return;
      }
      if (((DownloadInfo)localObject2).a() == 4)
      {
        paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).g);
        paramJSONObject.put("label_ug_progress_progress", 100);
        return;
      }
      if ((((DownloadInfo)localObject2).a() == 20) || (((DownloadInfo)localObject2).a() == 1) || (((DownloadInfo)localObject2).a() == 2))
      {
        paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).h + ((DownloadInfo)localObject2).f + "%");
        paramJSONObject.put("label_ug_progress_progress", ((DownloadInfo)localObject2).f);
        return;
      }
      paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).j);
      paramJSONObject.put("label_ug_progress_progress", ((DownloadInfo)localObject2).f);
      return;
    }
    paramJSONObject.put("text", "");
  }
  
  private static void a(JSONObject paramJSONObject, FastWebRecommendUGInfo paramFastWebRecommendUGInfo)
  {
    str2 = "";
    str1 = str2;
    if (paramJSONObject.opt("card_info") != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("card_info");
      str1 = str2;
      if (paramJSONObject.opt("rowKey") != null) {
        str1 = paramJSONObject.getString("rowKey");
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        str1 = str2;
      }
    }
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramFastWebRecommendUGInfo.jdField_a_of_type_JavaLangString, str1, "1"));
  }
  
  private static boolean a(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if ((!(localBaseData instanceof ProteusInnerData)) || (!((ProteusInnerData)localBaseData).e())) {
        break label52;
      }
      bool = true;
    }
    label52:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private static String b(Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    ReadInJoyAdLog.a("REPORT_LINK", "requestAdData start");
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("ext=" + URLEncoder.encode(paramJSONObject.toString(), "utf-8"));
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramJSONObject = (Map.Entry)paramMap.next();
        localStringBuilder.append("&" + (String)paramJSONObject.getKey() + "=" + URLEncoder.encode((String)paramJSONObject.getValue(), "utf-8"));
      }
      paramMap = ((QQAppInterface)ReadInJoyUtils.a()).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData:" + localStringBuilder + "    uin : " + paramMap);
      }
      paramMap = new Bundle();
      HttpUtil.addCookie(paramMap);
      paramJSONObject = localStringBuilder.toString();
      paramJSONObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), paramJSONObject, "GET", null, paramMap);
      if (paramJSONObject == null)
      {
        QLog.e("Q.readinjoy.fast_web", 2, "requestAdData bytes null");
        return null;
      }
      paramMap = "";
      if (paramJSONObject != null) {
        paramMap = new String(paramJSONObject);
      }
      paramJSONObject = paramMap;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData result:" + paramMap);
        return paramMap;
      }
    }
    catch (Exception paramMap)
    {
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  private static List<BaseData> b(String paramString1, int paramInt, String paramString2)
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(paramString2).getJSONArray("data");
      int i = 0;
      Object localObject1 = null;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
        if (paramInt == 6)
        {
          localJSONObject.put("dt_parent_rowkey", paramString1);
          localJSONObject.put("dt_rowkey", a(localJSONObject));
          a(i, localJSONArray.length(), localJSONObject);
          a(localJSONObject);
        }
        Object localObject2 = TemplateFactory.a("native_article", true);
        if (localObject2 != null) {}
        for (localObject2 = ((TemplateFactory)localObject2).getTemplateBean(localJSONObject);; localObject2 = null)
        {
          if (localObject2 != null)
          {
            ProteusItemData localProteusItemData = a(paramInt);
            localObject1 = localProteusItemData;
            if (localProteusItemData != null)
            {
              localProteusItemData.a = ((TemplateBean)localObject2);
              localProteusItemData.c = localJSONObject;
              localArrayList.add(localProteusItemData);
              localObject1 = localProteusItemData;
            }
          }
          FastWebPtsLiteDataUtil.a(localObject1);
          i += 1;
          break;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      QLog.e("FastWebRequestUtil", 1, new Object[] { "parseProteusData error:", paramString1.toString(), " item:" + paramString2 });
      QLog.d("FastWebRequestUtil", 1, "parseProteusItem,type=" + paramInt + " item=" + paramString2 + " datasSize=" + localArrayList.size());
    }
  }
  
  private static Map<String, String> b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    paramString5 = (QQAppInterface)ReadInJoyUtils.a();
    paramString6 = paramString5.getAccount();
    paramString6 = ((TicketManager)paramString5.getManager(2)).getSkey(paramString6);
    paramString5 = new HashMap();
    if (paramBoolean) {
      paramString3 = "0";
    }
    paramString5.put("puin", paramString3);
    paramString5.put("id", paramString1);
    paramString5.put("tag", paramString4);
    if (paramString6 == null) {}
    for (paramString1 = "";; paramString1 = ReadInJoyWebDataManager.a(paramString6))
    {
      paramString5.put("token", paramString1);
      paramString5.put("cookie", NativeAdUtils.a());
      paramString5.put("scene", String.valueOf(3));
      paramString5.put("rowkey", paramString2);
      paramString5.put("source_channel_id", String.valueOf(paramLong));
      if (paramInt2 > 0) {
        paramString5.put("contentCount", String.valueOf(paramInt2));
      }
      paramString1 = a(BaseApplication.getContext());
      if (paramString1 != null) {}
      try
      {
        paramString2 = new JSONObject();
        if (paramString1.containsKey("fontSize")) {
          paramString2.put("fontSize", paramString1.get("fontSize"));
        }
        if (paramString1.containsKey("lineHeight")) {
          paramString2.put("lineHeight", paramString1.get("lineHeight"));
        }
        if (paramString1.containsKey("paragraphSpace")) {
          paramString2.put("paragraphSpace", paramString1.get("paragraphSpace"));
        }
        if (paramString1.containsKey("screenWidth")) {
          paramString2.put("screenWidth", paramString1.get("screenWidth"));
        }
        if (paramString1.containsKey("screenHeight")) {
          paramString2.put("screenHeight", paramString1.get("screenHeight"));
        }
        if (paramString1.containsKey("contentPadding")) {
          paramString2.put("contentPadding", paramString1.get("contentPadding"));
        }
        paramString5.put("article_display_params", paramString2.toString());
        paramString5.put("noExposeList", AdReqFreshManager.a().a());
        return paramString5;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return paramString5;
  }
  
  private static JSONObject b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject1).jdField_a_of_type_JavaLangString = "ce2d9f";
        localObject1 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
          localJSONObject.put("muidtype", 1);
          localObject3 = AdDeviceInfoUtil.b();
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label657;
          }
          localObject2 = "0000000000000000";
          localJSONObject.put("muid", localObject2);
          localJSONObject.put("carrier", GdtDeviceUtil.a(BaseApplicationImpl.getContext()));
          localJSONObject.put("carrier_code", AdDeviceInfoUtil.b());
          localJSONObject.put("c_os", "android");
          localJSONObject.put("appid", String.valueOf(AppSetting.a()));
          localJSONObject.put("app_version_id", AppSetting.a());
          localJSONObject.put("imei", localObject3);
          if (localObject1 != null)
          {
            localJSONObject.put("conn", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn.get());
            localJSONObject.put("hostver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qq_ver.get());
            localJSONObject.put("c_osver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver.get());
            localJSONObject.put("qadid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
            localJSONObject.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
            localJSONObject.put("taid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            localJSONObject.put("androidid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
            localJSONObject.put("mac_addr", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
              localJSONObject.put("ipv4", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
            }
            localJSONObject.put("muid_from_gdt", "1");
            localJSONObject.put("muidtype", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type.get());
            if (!TextUtils.isEmpty(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get())) {
              continue;
            }
            localObject2 = "";
            localJSONObject.put("muid", localObject2);
            localJSONObject.put("bytes_wx_ver", AdDeviceInfoUtil.a(BaseApplication.getContext()));
            if (QLog.isColorLevel()) {
              QLog.i("FastWebRequestUtil", 2, "makePhoneInfo0x6cf: deviceInfo: oa=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get() + ", ta=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            }
          }
          localObject2 = Build.BRAND;
          localObject3 = Build.MODEL;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localJSONObject.put("c_mf", localObject2);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localJSONObject.put("c_device", localObject3);
          }
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = new JSONArray(paramString);
            localObject2 = new JSONArray();
            int i = 0;
            if (i < paramString.length())
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("qie_context", paramString.getJSONObject(i).toString());
              ((JSONArray)localObject2).put(localObject3);
              i += 1;
              continue;
              localObject2 = ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get();
              continue;
            }
            if (((JSONArray)localObject2).length() > 0) {
              localJSONObject.put("pos", localObject2);
            }
          }
          localJSONObject.put("present_from", paramInt);
          if (StudyModeManager.a()) {
            localJSONObject.put("reqLearningPatternFlag", 1);
          }
          if (localObject1 != null) {
            localJSONObject.put("device_ext", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext.get());
          }
          return localJSONObject;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localJSONObject;
      }
      Object localObject1 = null;
      continue;
      label657:
      Object localObject2 = localObject3;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, ReadInJoyFeedbackPopupWindow.FeedbackCallback paramFeedbackCallback)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "shieldFeedSource");
    ThreadManager.excute(new FastWebRequestUtil.7(paramArticleInfo, paramFeedbackCallback), 128, null, true);
  }
  
  private static void b(List<BaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    HashSet localHashSet1 = new HashSet(paramList.size());
    HashSet localHashSet2 = new HashSet();
    int i = 0;
    while (i < paramList.size())
    {
      AdData localAdData = (AdData)paramList.get(i);
      if ((localAdData != null) && (localAdData.o == 32) && (localAdData.a != null))
      {
        localAdData.a.scene = "RIJAdRefreshSceneNativeArticle";
        localHashSet1.add(Long.valueOf(localAdData.a.mAdAid));
        localHashSet2.add(localAdData);
      }
      i += 1;
    }
    AdReqFreshManager.a().a("RIJAdRefreshSceneNativeArticle", localHashSet1);
    AdExposeFreshManager.a().b("RIJAdRefreshSceneNativeArticle", localHashSet2);
  }
  
  private static boolean b(String paramString1, String paramString2, List<BaseData> paramList, JSONObject paramJSONObject)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramList == null)) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramString1);
        NativeAdUtils.a(((JSONObject)localObject).optString("cookie"));
        String str = ((JSONObject)localObject).optString("ad_switchs");
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("result");
        int j = ((JSONObject)localObject).optInt("req_type", 0);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          ((JSONObject)localObject).put("rowkey", paramString2);
          int k = a((JSONObject)localObject);
          if (k == 1)
          {
            localObject = a((JSONObject)localObject, paramJSONObject, paramString2, 1, str, -1, j);
            ReadInJoyAdUtils.a((AdData)localObject);
            if (localObject != null) {
              paramList.add(localObject);
            }
          }
          else if (k == 2)
          {
            AdData localAdData = a((JSONObject)localObject, paramJSONObject, paramString2, 2, str, -1, j);
            localObject = localAdData;
            if (localAdData == null) {
              continue;
            }
            localObject = localAdData;
            if (!((ProteusInnerData)localAdData).e()) {
              continue;
            }
            localObject = localAdData;
            if (!a(paramList)) {
              continue;
            }
          }
          else
          {
            localObject = a((JSONObject)localObject, paramJSONObject, paramString2, 0, str, ((JSONObject)localObject).getInt("ad_pos"), j);
            ReadInJoyAdUtils.a((AdData)localObject);
            continue;
          }
        }
        else
        {
          return true;
        }
      }
      catch (Exception paramString2)
      {
        QLog.e("Q.readinjoy.fast_web", 2, paramString2, new Object[] { "" + paramString1 });
        return false;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil
 * JD-Core Version:    0.7.0.1
 */