package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import org.json.JSONObject;

public class ArticleBottomAdInfoBindUtils
{
  public static void a(AdData paramAdData, JSONObject paramJSONObject)
  {
    if (paramAdData == null) {
      return;
    }
    try
    {
      paramJSONObject.put("visible_three", "show");
      if (TextUtils.isEmpty(paramAdData.q)) {
        str = paramAdData.I;
      } else {
        str = paramAdData.q;
      }
      paramJSONObject.put("author_text", str);
      paramJSONObject.put("title", paramAdData.j);
      paramJSONObject.put("author_icon", paramAdData.J);
      String str = paramAdData.L;
      if (str == null) {
        paramJSONObject.put("dislike_text_android", "广告");
      } else if (!TextUtils.isEmpty(paramAdData.L)) {
        paramJSONObject.put("dislike_text_android", paramAdData.L);
      }
      paramJSONObject.put("article_model", paramAdData);
      paramJSONObject.put("seperator_visible", "show");
      return;
    }
    catch (Exception paramAdData) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action.ArticleBottomAdInfoBindUtils
 * JD-Core Version:    0.7.0.1
 */