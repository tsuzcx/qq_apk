package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public class ReadInJoyAdExpandPicCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_model", paramAbsBaseArticleInfo);
    localJSONObject1.put("id_ad_expand_view", localJSONObject2);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_expand_card_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdExpandPicCell
 * JD-Core Version:    0.7.0.1
 */