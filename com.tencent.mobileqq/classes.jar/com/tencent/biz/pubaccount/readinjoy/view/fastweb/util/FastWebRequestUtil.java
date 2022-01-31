package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BannerAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoRecommendData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mmr;
import mms;
import mmt;
import mmu;
import mmv;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class FastWebRequestUtil
{
  public static String a;
  public static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://c.mp.qq.com/cgi-bin/ad/get_mp_ads?";
    jdField_b_of_type_JavaLangString = "https://c.mp.qq.com/review/recommand/index.php/article/recommend?from=native";
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
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", false, 0L, 0L, localHashMap, null);
    }
    return -1L;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (a(paramString)) {
      str = paramString.replace("/0?", "/320?");
    }
    return str;
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.startsWith("http:"));
      str = paramString;
    } while (paramString.startsWith("https"));
    if (paramBoolean) {
      return "https:" + paramString;
    }
    return "http:" + paramString;
  }
  
  public static void a(String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("Q.readinjoy.fast_web", 2, "" + paramString);
    try
    {
      l = a(paramString);
      if (l == -1L) {
        return;
      }
      paramString = new Bundle();
      paramString.putString("articleId", String.valueOf(l));
      QLog.d("Q.readinjoy.fast_web", 2, "" + "http://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l);
      paramString = new String(HttpUtil.a(BaseApplicationImpl.getContext(), "http://c.mp.qq.com/review/img-txt-comment/list?source=1", "POST", paramString, null));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        long l;
        int i;
        paramFastWebArticleInfo = null;
      }
    }
    try
    {
      QLog.d("Q.readinjoy.fast_web", 2, "http://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l + " " + paramString);
      i = new JSONObject(paramString).getInt("readCount");
      if (i > paramFastWebArticleInfo.jdField_a_of_type_Long)
      {
        paramFastWebArticleInfo.jdField_a_of_type_Long = i;
        ThreadManager.getUIHandler().post(new mmv());
        return;
      }
    }
    catch (Exception localException)
    {
      paramFastWebArticleInfo = paramString;
      paramString = localException;
      QLog.e("Q.readinjoy.fast_web", 2, paramString, new Object[] { "" + paramFastWebArticleInfo });
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, FastWebRequestUtil.RecommendAndAdCallback paramRecommendAndAdCallback)
  {
    paramRecommendAndAdCallback = new FastWebRequestUtil.RecommendAndAd(paramString1, paramRecommendAndAdCallback);
    a(paramString1, paramString2, paramString3, paramBoolean, new mmr(paramRecommendAndAdCallback));
    b(paramString1, paramString3, paramString4, paramBoolean, new mms(paramRecommendAndAdCallback));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, FastWebRequestUtil.ResponseCallback paramResponseCallback)
  {
    ThreadManager.executeOnNetWorkThread(new mmt(paramString3, paramString1, paramString2, paramResponseCallback));
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.matches(".*_open_\\d+_\\d+/.*"));
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt & 0xF)
    {
    case 0: 
    case 1: 
    case 3: 
    default: 
      return -1;
    case 4: 
      return 2;
    }
    return 3;
  }
  
  private static AdData b(JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    if (paramJSONObject.has("type")) {}
    for (int i = paramJSONObject.getInt("type");; i = 0)
    {
      Object localObject;
      if (i == 100) {
        localObject = new AttachedAdData();
      }
      for (;;)
      {
        ((AdData)localObject).jdField_a_of_type_Boolean = paramJSONObject.has("native");
        if (((AdData)localObject).jdField_a_of_type_Boolean) {
          ((AdData)localObject).j = paramJSONObject.getString("native");
        }
        if (paramJSONObject.has("posid")) {
          ((AdData)localObject).jdField_a_of_type_JavaLangString = paramJSONObject.getString("posid");
        }
        if (paramJSONObject.has("title")) {
          ((AdData)localObject).jdField_b_of_type_JavaLangString = paramJSONObject.getString("title");
        }
        if (paramJSONObject.has("content")) {
          ((AdData)localObject).jdField_c_of_type_JavaLangString = paramJSONObject.getString("content");
        }
        if (paramJSONObject.has("img_url"))
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("img_url");
          if (localJSONArray.length() > 0) {
            ((AdData)localObject).d = a(localJSONArray.getString(0), true);
          }
        }
        if (paramJSONObject.has("img_type")) {
          ((AdData)localObject).jdField_a_of_type_Int = paramJSONObject.getInt("img_type");
        }
        if (paramJSONObject.has("click_url")) {
          ((AdData)localObject).e = a(paramJSONObject.getString("click_url"), true);
        }
        if (paramJSONObject.has("jump_url")) {
          ((AdData)localObject).f = a(paramJSONObject.getString("jump_url"), true);
        }
        if (paramJSONObject.has("expose_url")) {
          ((AdData)localObject).g = a(paramJSONObject.getString("expose_url"), true);
        }
        if (paramJSONObject.has("producttype")) {
          ((AdData)localObject).jdField_b_of_type_Int = paramJSONObject.getInt("producttype");
        }
        if (paramJSONObject.has("pkg_name")) {
          ((AdData)localObject).h = paramJSONObject.getString("pkg_name");
        }
        if (paramJSONObject.has("app_name")) {
          ((AdData)localObject).i = paramJSONObject.getString("app_name");
        }
        if (paramJSONObject.has("openudid")) {
          ((AdData)localObject).k = paramJSONObject.getString("openudid");
        }
        if (paramJSONObject.has("ad_id")) {
          ((AdData)localObject).jdField_c_of_type_Int = paramJSONObject.getInt("ad_id");
        }
        return localObject;
        if (paramBoolean)
        {
          localObject = new BannerAdData();
        }
        else
        {
          localObject = new RecommendAdData();
          ((RecommendAdData)localObject).e = paramInt;
        }
      }
    }
  }
  
  private static RecommendData b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    int i = paramJSONObject.getInt("type");
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      localObject = new RecommendData();
    }
    while (localObject != null)
    {
      ((RecommendData)localObject).jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(((RecommendData)localObject).jdField_a_of_type_JavaLangString)) {
        break label195;
      }
      QLog.e("Q.readinjoy.fast_web", 2, "RecommendData: title is null or empty");
      return null;
      localObject = new VideoRecommendData();
      ((VideoRecommendData)localObject).j = paramJSONObject.optString("videoVid");
      if (TextUtils.isEmpty(((VideoRecommendData)localObject).j))
      {
        QLog.e("Q.readinjoy.fast_web", 2, "RecommendData: videoID is null or empty");
        return null;
      }
      ((VideoRecommendData)localObject).i = paramJSONObject.optString("share_url");
      ((VideoRecommendData)localObject).e = paramJSONObject.optInt("videoDuration");
      ((VideoRecommendData)localObject).g = paramJSONObject.optInt("videoHeight");
      ((VideoRecommendData)localObject).f = paramJSONObject.optInt("videoWidth");
      ((VideoRecommendData)localObject).h = paramJSONObject.optInt("videoType");
      continue;
      localObject = null;
    }
    label195:
    ((RecommendData)localObject).jdField_c_of_type_JavaLangString = a(paramJSONObject.optString("pageUrl"), true);
    if (TextUtils.isEmpty(((RecommendData)localObject).jdField_c_of_type_JavaLangString))
    {
      QLog.e("Q.readinjoy.fast_web", 2, "RecommendData: pageUrl is null or empty");
      return null;
    }
    ((RecommendData)localObject).jdField_b_of_type_JavaLangString = a(paramJSONObject.optString("coverImg"), true);
    ((RecommendData)localObject).jdField_b_of_type_JavaLangString = a(((RecommendData)localObject).jdField_b_of_type_JavaLangString);
    ((RecommendData)localObject).jdField_a_of_type_Long = paramJSONObject.optLong("publishTime");
    ((RecommendData)localObject).jdField_b_of_type_Long = paramJSONObject.optLong("pageId");
    ((RecommendData)localObject).d = paramJSONObject.optString("accountName");
    ((RecommendData)localObject).e = paramJSONObject.optString("uin");
    ((RecommendData)localObject).f = paramJSONObject.optString("rowkey");
    ((RecommendData)localObject).g = paramJSONObject.optString("style");
    ((RecommendData)localObject).h = paramJSONObject.optString("rcmInfo");
    ((RecommendData)localObject).jdField_a_of_type_Int = i;
    return localObject;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, FastWebRequestUtil.ResponseCallback paramResponseCallback)
  {
    ThreadManager.executeOnNetWorkThread(new mmu(paramBoolean, paramString2, paramString1, paramString3, paramResponseCallback));
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt & 0xF0) >> 4 == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil
 * JD-Core Version:    0.7.0.1
 */