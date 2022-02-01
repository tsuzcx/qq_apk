package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyAdSmallImgCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    String str;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      str = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_small_imge_url", str);
      localJSONObject1.put("id_article_small_imge", localJSONObject2);
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      ReadInJoyAdUtils.g(paramBaseArticleInfo, localJSONObject1);
      Util.d(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.i(paramBaseArticleInfo, localJSONObject1);
      Util.ad(paramBaseArticleInfo, localJSONObject1);
      if (!NativeAdUtils.a(paramBaseArticleInfo)) {
        break label125;
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_location_cell");
    }
    for (;;)
    {
      localJSONObject1.put("id_small_cell_container", new JSONObject());
      Util.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      str = null;
      break;
      label125:
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_cell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyAdSmallImgCell
 * JD-Core Version:    0.7.0.1
 */