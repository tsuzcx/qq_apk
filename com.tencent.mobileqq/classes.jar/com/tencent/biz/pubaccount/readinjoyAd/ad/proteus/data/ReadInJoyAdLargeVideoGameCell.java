package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyAdLargeVideoGameCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_icon", "pa_video_play.png");
    localJSONObject1.put("id_large_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_cover", "mengceng.png");
    localJSONObject1.put("id_large_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    localObject = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    if (localObject != null) {
      localObject = ((URL)localObject).getPath();
    } else {
      localObject = null;
    }
    localJSONObject2.put("article_large_imge_url", localObject);
    localJSONObject1.put("id_article_large_imge", localJSONObject2);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_duration", ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(paramAbsBaseArticleInfo.mVideoDuration));
    localJSONObject1.put("id_large_video_duration", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("video_play_icon", "small_video_play_icon");
    localJSONObject1.put("id_video_play_icon", localObject);
    localJSONObject1.put("id_video_paly_text", new JSONObject());
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject1, true);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindAwesomeCommentInfo(paramAbsBaseArticleInfo, localJSONObject1);
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSubscriptText(paramAbsBaseArticleInfo, localJSONObject1);
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject1);
    }
    else
    {
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindADBanner(paramAbsBaseArticleInfo, localJSONObject1);
    }
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_large_video_activity_wrapper", new JSONObject());
    localObject = new JSONObject();
    ((JSONObject)localObject).put("activity_img_path", "free_netflow_icon");
    localJSONObject1.put("id_large_video_activity_img", localObject);
    localJSONObject1.put("id_large_video_activity_label", new JSONObject());
    localObject = new JSONObject();
    if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.f))) {
      ((JSONObject)localObject).put("video_paly_text", paramAbsBaseArticleInfo.mSmallMiniGameInfo.f);
    } else {
      ((JSONObject)localObject).put("video_paly_text", "轻触玩游戏");
    }
    localJSONObject1.put("id_video_paly_text", localObject);
    localObject = new JSONObject();
    if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.g))) {
      ((JSONObject)localObject).put("video_play_icon", paramAbsBaseArticleInfo.mSmallMiniGameInfo.g);
    }
    localJSONObject1.put("id_video_play_icon", localObject);
    if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.q)))
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("small_game_guide_icon_url", paramAbsBaseArticleInfo.mSmallMiniGameInfo.q);
      localJSONObject1.put("id_small_game_guide_icon", localObject);
    }
    if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.s)))
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("game_follow_btn_url", paramAbsBaseArticleInfo.mSmallMiniGameInfo.s);
      localJSONObject1.put("id_game_follow_btn", localObject);
    }
    if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.u)))
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("guide_name_text", paramAbsBaseArticleInfo.mSmallMiniGameInfo.u);
      localJSONObject1.put("id_guide_name_text", localObject);
    }
    localJSONObject1.put("style_ID", "ReadInjoy_ad_small_game_large_cell");
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindCommentInfoData(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindColumnEntrances(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject1, paramAbsBaseArticleInfo);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindPartnerInfo(paramAbsBaseArticleInfo, localJSONObject1);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdLargeVideoGameCell
 * JD-Core Version:    0.7.0.1
 */