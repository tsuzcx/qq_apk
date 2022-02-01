package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyGalleryBigCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id_test", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      localObject = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + HardCodeUtil.a(2131712829));
      localJSONObject1.put("id_gallery_cnt", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject1.put("id_gallery_img", localObject);
      localJSONObject1.put("id_gallery_bg", new JSONObject());
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label207;
      }
      Util.a(paramBaseArticleInfo, localJSONObject1);
      Util.d(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      Util.i(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      Util.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label207:
      Util.f(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyGalleryBigCell
 * JD-Core Version:    0.7.0.1
 */