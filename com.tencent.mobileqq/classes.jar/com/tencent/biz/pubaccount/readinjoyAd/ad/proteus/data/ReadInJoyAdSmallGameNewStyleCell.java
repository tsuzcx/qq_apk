package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class ReadInJoyAdSmallGameNewStyleCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (paramAbsBaseArticleInfo != null)
    {
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("game_title", paramAbsBaseArticleInfo.mSubscribeName);
      localJSONObject1.put("id_game_title", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("game_desc", paramAbsBaseArticleInfo.mSummary);
      localJSONObject1.put("id_game_desc", localJSONObject2);
      localJSONObject2 = new JSONObject();
      if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.e))) {
        localJSONObject2.put("game_btn_text", paramAbsBaseArticleInfo.mSmallMiniGameInfo.e);
      } else {
        localJSONObject2.put("game_btn_text", "去玩");
      }
      localJSONObject1.put("id_game_btn", localJSONObject2);
      if (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null)
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("background_img_url", paramAbsBaseArticleInfo.mSmallMiniGameInfo.i);
        localJSONObject1.put("id_background_img", localJSONObject2);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("left_big_img_url", paramAbsBaseArticleInfo.mSmallMiniGameInfo.h);
        localJSONObject1.put("id_left_big_img", localJSONObject2);
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_game_new_style_cell");
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSubscriptText(paramAbsBaseArticleInfo, localJSONObject1);
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindCommentInfoData(paramAbsBaseArticleInfo, localJSONObject1);
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdSmallGameNewStyleCell
 * JD-Core Version:    0.7.0.1
 */