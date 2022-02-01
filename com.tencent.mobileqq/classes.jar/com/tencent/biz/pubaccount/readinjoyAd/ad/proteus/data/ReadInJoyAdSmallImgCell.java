package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class ReadInJoyAdSmallImgCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", paramAbsBaseArticleInfo.mFirstPagePicUrl);
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject1, true);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindCommentNumText(paramAbsBaseArticleInfo, localJSONObject1);
    ReadInJoyAdUtils.k(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindAdPositionInfoNew(paramAbsBaseArticleInfo, localJSONObject1);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).hasAddLocationInfo(paramAbsBaseArticleInfo)) {
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_location_cell");
    } else {
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_cell");
    }
    localJSONObject1.put("id_small_cell_container", new JSONObject());
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject1, paramAbsBaseArticleInfo);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdSmallImgCell
 * JD-Core Version:    0.7.0.1
 */