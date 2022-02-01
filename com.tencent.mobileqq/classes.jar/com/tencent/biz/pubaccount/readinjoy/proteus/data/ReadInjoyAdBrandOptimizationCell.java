package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import org.json.JSONObject;

public class ReadInjoyAdBrandOptimizationCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramBaseArticleInfo.avatar)) {
      localJSONObject1.put("avator_url", "default_comment_avatar");
    }
    for (;;)
    {
      Util.s(paramBaseArticleInfo, localJSONObject1);
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      ReadInJoyAdUtils.g(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.a(paramBaseArticleInfo, localJSONObject1);
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      Util.i(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_brand_optimization_cell");
      Util.a(localJSONObject1, paramBaseArticleInfo);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        Util.f(paramBaseArticleInfo, localJSONObject1);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("article_model", paramBaseArticleInfo);
        localJSONObject1.put("id_view_AdBanner", localJSONObject2);
      }
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_article_brand_optimization", localJSONObject2);
      localJSONObject1.put("id_info_operate_parent", new JSONObject());
      localJSONObject1.put("id_ad_brand_container", new JSONObject());
      return localJSONObject1;
      localJSONObject1.put("avator_url", paramBaseArticleInfo.avatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoyAdBrandOptimizationCell
 * JD-Core Version:    0.7.0.1
 */