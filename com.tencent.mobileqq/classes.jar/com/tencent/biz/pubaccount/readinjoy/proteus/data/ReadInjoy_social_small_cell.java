package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import java.net.URL;
import org.json.JSONObject;

public class ReadInjoy_social_small_cell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Util.a(paramBaseArticleInfo, localJSONObject1, Long.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a));
    Util.g(paramBaseArticleInfo, localJSONObject1);
    Util.h(paramBaseArticleInfo, localJSONObject1);
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("biu_tips_text", "Biu 了");
    localJSONObject1.put("id_biu_tips", localJSONObject2);
    Util.l(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary", new JSONObject());
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", paramBaseArticleInfo.mSinglePicture.toString());
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    Util.a(paramBaseArticleInfo, localJSONObject1, false);
    Util.e(paramBaseArticleInfo, localJSONObject1);
    Util.k(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_social_small_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoy_social_small_cell
 * JD-Core Version:    0.7.0.1
 */