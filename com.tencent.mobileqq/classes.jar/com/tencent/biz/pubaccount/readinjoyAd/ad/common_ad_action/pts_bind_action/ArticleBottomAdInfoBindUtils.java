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
      if (TextUtils.isEmpty(paramAdData.u)) {
        str = paramAdData.X;
      } else {
        str = paramAdData.u;
      }
      paramJSONObject.put("author_text", str);
      paramJSONObject.put("title", paramAdData.l);
      paramJSONObject.put("author_icon", paramAdData.aa);
      String str = paramAdData.ah;
      if (str == null) {
        paramJSONObject.put("dislike_text_android", "广告");
      } else if (!TextUtils.isEmpty(paramAdData.ah)) {
        paramJSONObject.put("dislike_text_android", paramAdData.ah);
      }
      paramJSONObject.put("article_model", paramAdData);
      paramJSONObject.put("seperator_visible", "show");
      return;
    }
    catch (Exception paramAdData) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action.ArticleBottomAdInfoBindUtils
 * JD-Core Version:    0.7.0.1
 */