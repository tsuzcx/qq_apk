package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyAdTripleImgGameCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject1, true);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSubscriptText(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindCommentInfoData(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindAwesomeCommentInfo(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindPartnerInfo(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSearchWord(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_small_game_triple_img_cell");
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject1, paramAbsBaseArticleInfo);
    Object localObject1 = paramAbsBaseArticleInfo.mSmallMiniGameInfo;
    Object localObject3 = "";
    if ((localObject1 != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.k != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.k.length() > 2))
    {
      localObject3 = paramAbsBaseArticleInfo.mSmallMiniGameInfo.k.optString(0);
      localObject2 = paramAbsBaseArticleInfo.mSmallMiniGameInfo.k.optString(1);
      localObject1 = paramAbsBaseArticleInfo.mSmallMiniGameInfo.k.optString(2);
    }
    else
    {
      localObject2 = "";
      localObject1 = localObject2;
    }
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("multi_img_url1", localObject3);
    localJSONObject1.put("id_multi_img_1", localJSONObject2);
    localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("multi_img_url2", localObject2);
    localJSONObject1.put("id_multi_img_2", localObject3);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("multi_img_url3", localObject1);
    localJSONObject1.put("id_multi_img_3", localObject2);
    if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.t)))
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("small_game_guide_icon_url", paramAbsBaseArticleInfo.mSmallMiniGameInfo.t);
      localJSONObject1.put("id_small_game_guide_icon", localObject1);
    }
    if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.v)))
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("game_follow_btn_url", paramAbsBaseArticleInfo.mSmallMiniGameInfo.v);
      localJSONObject1.put("id_game_follow_btn", localObject1);
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdTripleImgGameCell
 * JD-Core Version:    0.7.0.1
 */