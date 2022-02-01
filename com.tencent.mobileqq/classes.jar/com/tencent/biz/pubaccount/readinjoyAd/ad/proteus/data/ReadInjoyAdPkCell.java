package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONObject;

public class ReadInjoyAdPkCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject;
    if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      localObject = paramAbsBaseArticleInfo.mSinglePicture.getFile();
    } else {
      localObject = null;
    }
    localJSONObject2.put("article_large_imge_url", localObject);
    localJSONObject1.put("id_article_large_imge", localJSONObject2);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      localObject = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindPkButton(localJSONObject1, ((AdvertisementInfo)localObject).mAdvertisementExtInfo);
      }
    }
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject1, true, "3");
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject1);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_pk_cell");
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject1, paramAbsBaseArticleInfo);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyAdPkCell
 * JD-Core Version:    0.7.0.1
 */