package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import org.json.JSONObject;

public class ReadInjoyTopicRecommendPgcMultiCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Util.z(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    Util.d(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", HardCodeUtil.a(2131712988));
    localJSONObject1.put("id_summary", localJSONObject2);
    Util.a(paramBaseArticleInfo, localJSONObject1, true);
    Util.g(paramBaseArticleInfo, localJSONObject1);
    Util.n(paramBaseArticleInfo, localJSONObject1);
    Util.G(paramBaseArticleInfo, localJSONObject1);
    Util.I(paramBaseArticleInfo, localJSONObject1);
    Util.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoyTopicRecommendPgcMultiCell
 * JD-Core Version:    0.7.0.1
 */