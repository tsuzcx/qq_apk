package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoySmallImgCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null) {}
    for (String str = paramBaseArticleInfo.mSinglePicture.getFile();; str = null)
    {
      localJSONObject2.put("article_small_imge_url", str);
      localJSONObject1.put("id_article_small_imge", localJSONObject2);
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      Util.a(paramBaseArticleInfo, localJSONObject1);
      Util.d(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.h(paramBaseArticleInfo, localJSONObject1);
      Util.ab(paramBaseArticleInfo, localJSONObject1);
      Util.af(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      Util.a(localJSONObject1, paramBaseArticleInfo);
      Util.ae(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoySmallImgCell
 * JD-Core Version:    0.7.0.1
 */