package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class ReadInjoyAdLargeImgCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = new JSONObject();
    Object localObject1 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
    ((JSONObject)localObject2).put("article_large_imge_url", localObject1);
    ((JSONObject)localObject2).put("article_model", paramAbsBaseArticleInfo);
    localJSONObject.put("id_article_double_image", localObject2);
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("article_large_imge_url", localObject1);
    localJSONObject.put("id_article_large_imge", localObject2);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isEducationLargeImgAd(paramAbsBaseArticleInfo))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindEducationAd(paramAbsBaseArticleInfo, localJSONObject);
    }
    else
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
      {
        ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindADBanner(paramAbsBaseArticleInfo, localJSONObject);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("article_model", paramAbsBaseArticleInfo);
        localObject1 = (AdvertisementInfo)paramAbsBaseArticleInfo;
        if (((AdvertisementInfo)localObject1).mShowAdButton) {
          localJSONObject.put("id_view_AdDownloadView", localObject2);
        }
        if (!TextUtils.isEmpty(((AdvertisementInfo)localObject1).mImaxImg))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(-16777216);
          localObject1 = URLDrawable.getDrawable(((AdvertisementInfo)localObject1).mImaxImg, (URLDrawable.URLDrawableOptions)localObject2);
          if (localObject1 != null) {
            ((URLDrawable)localObject1).startDownload();
          }
        }
      }
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject, true, "3");
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindADPositionInfo(paramAbsBaseArticleInfo, localJSONObject);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindDownloadAdStar(paramAbsBaseArticleInfo, localJSONObject);
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).hasColorIcon(paramAbsBaseArticleInfo)) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdSourceTag(paramAbsBaseArticleInfo, localJSONObject);
      } else {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdColorIcon(paramAbsBaseArticleInfo, localJSONObject);
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindBubble(paramAbsBaseArticleInfo, localJSONObject);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAtmosphere(paramAbsBaseArticleInfo, localJSONObject);
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject, paramAbsBaseArticleInfo);
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject);
    ReadInJoyAdUtils.k(paramAbsBaseArticleInfo, localJSONObject);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindLargeImgStyleID(paramAbsBaseArticleInfo, localJSONObject);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyAdLargeImgCell
 * JD-Core Version:    0.7.0.1
 */