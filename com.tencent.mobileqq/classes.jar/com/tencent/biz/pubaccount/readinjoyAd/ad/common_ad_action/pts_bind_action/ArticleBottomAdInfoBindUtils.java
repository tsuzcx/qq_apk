package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
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
      String str;
      if (TextUtils.isEmpty(paramAdData.i))
      {
        str = paramAdData.A;
        paramJSONObject.put("author_text", str);
        paramJSONObject.put("title", paramAdData.b);
        paramJSONObject.put("author_icon", paramAdData.B);
        if (paramAdData.D != null) {
          break label101;
        }
        paramJSONObject.put("dislike_text_android", "广告");
      }
      for (;;)
      {
        paramJSONObject.put("article_model", paramAdData);
        paramJSONObject.put("seperator_visible", "show");
        return;
        str = paramAdData.i;
        break;
        label101:
        if (!TextUtils.isEmpty(paramAdData.D)) {
          paramJSONObject.put("dislike_text_android", paramAdData.D);
        }
      }
      return;
    }
    catch (Exception paramAdData) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action.ArticleBottomAdInfoBindUtils
 * JD-Core Version:    0.7.0.1
 */