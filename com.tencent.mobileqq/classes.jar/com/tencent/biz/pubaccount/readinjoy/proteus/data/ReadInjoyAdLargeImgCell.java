package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import org.json.JSONObject;

public class ReadInjoyAdLargeImgCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null) {}
    for (Object localObject = paramBaseArticleInfo.mSinglePicture.getFile();; localObject = null)
    {
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_article_double_image", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      if (!ReadInJoyAdUtils.a(paramBaseArticleInfo)) {
        break;
      }
      ReadInJoyAdUtils.f(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.g(paramBaseArticleInfo, localJSONObject1);
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.d(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      Util.f(paramBaseArticleInfo, localJSONObject1);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
      if (((AdvertisementInfo)paramBaseArticleInfo).mShowAdButton) {
        localJSONObject1.put("id_view_AdDownloadView", localObject);
      }
      if (!TextUtils.isEmpty(((AdvertisementInfo)paramBaseArticleInfo).mImaxImg))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
        localObject = URLDrawable.getDrawable(((AdvertisementInfo)paramBaseArticleInfo).mImaxImg, (URLDrawable.URLDrawableOptions)localObject);
        if (localObject != null) {
          ((URLDrawable)localObject).startDownload();
        }
      }
    }
    Util.a(paramBaseArticleInfo, localJSONObject1, true, "3");
    Util.e(paramBaseArticleInfo, localJSONObject1);
    ReadInJoyAdUtils.a(paramBaseArticleInfo, localJSONObject1);
    ReadInJoyAdUtils.i(paramBaseArticleInfo, localJSONObject1);
    if (!ReadInJoyAdUtils.c(paramBaseArticleInfo)) {
      ReadInJoyAdUtils.j(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      ReadInJoyAdUtils.b(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.c(paramBaseArticleInfo, localJSONObject1);
      Util.a(localJSONObject1, paramBaseArticleInfo);
      break;
      ReadInJoyAdUtils.h(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoyAdLargeImgCell
 * JD-Core Version:    0.7.0.1
 */