package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class ReadInjoyAdBrandOptimizationCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.avatar)) {
      localJSONObject1.put("avator_url", "default_comment_avatar");
    } else {
      localJSONObject1.put("avator_url", paramAbsBaseArticleInfo.avatar);
    }
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSubscribeName(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject1, true);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject1);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindCommentNumText(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_brand_optimization_cell");
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject1, paramAbsBaseArticleInfo);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindADBanner(paramAbsBaseArticleInfo, localJSONObject1);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_model", paramAbsBaseArticleInfo);
      localJSONObject1.put("id_view_AdBanner", localJSONObject2);
    }
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_model", paramAbsBaseArticleInfo);
    localJSONObject1.put("id_article_brand_optimization", localJSONObject2);
    localJSONObject1.put("id_info_operate_parent", new JSONObject());
    localJSONObject1.put("id_ad_brand_container", new JSONObject());
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyAdBrandOptimizationCell
 * JD-Core Version:    0.7.0.1
 */