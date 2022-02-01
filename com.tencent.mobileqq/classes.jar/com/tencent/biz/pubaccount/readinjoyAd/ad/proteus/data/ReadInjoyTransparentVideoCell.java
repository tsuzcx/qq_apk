package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class ReadInjoyTransparentVideoCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    String str = paramAbsBaseArticleInfo.mFirstPagePicUrl;
    localJSONObject2.put("article_large_imge_url", str);
    localJSONObject2.put("article_model", paramAbsBaseArticleInfo);
    localJSONObject1.put("id_article_double_image", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_large_imge_url", str);
    localJSONObject1.put("id_article_large_imge", localJSONObject2);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject1, true, "3");
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject1);
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).hasColorIcon(paramAbsBaseArticleInfo)) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdSourceTag(paramAbsBaseArticleInfo, localJSONObject1);
    } else {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdColorIcon(paramAbsBaseArticleInfo, localJSONObject1);
    }
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject1, paramAbsBaseArticleInfo);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_transparent_video_over_item");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyTransparentVideoCell
 * JD-Core Version:    0.7.0.1
 */