package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoy_gallery_big_cell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id_test", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null) {}
    for (Object localObject = paramBaseArticleInfo.mSinglePicture.getPath();; localObject = null)
    {
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + "图");
      localJSONObject1.put("id_gallery_cnt", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject1.put("id_gallery_img", localObject);
      localJSONObject1.put("id_gallery_bg", new JSONObject());
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      Util.a(paramBaseArticleInfo, localJSONObject1);
      Util.b(paramBaseArticleInfo, localJSONObject1);
      Util.c(paramBaseArticleInfo, localJSONObject1);
      Util.e(paramBaseArticleInfo, localJSONObject1);
      Util.d(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_img_cell");
      Util.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoy_gallery_big_cell
 * JD-Core Version:    0.7.0.1
 */