package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyAdLargeVideoGameCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_icon", "pa_video_play.png");
    localJSONObject1.put("id_large_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_cover", "mengceng.png");
    localJSONObject1.put("id_large_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    if (localObject != null)
    {
      localObject = ((URL)localObject).getPath();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("large_video_duration", ReadInJoyDisplayUtils.a(paramBaseArticleInfo.mVideoDuration));
      localJSONObject1.put("id_large_video_duration", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("video_play_icon", "small_video_play_icon");
      localJSONObject1.put("id_video_play_icon", localObject);
      localJSONObject1.put("id_video_paly_text", new JSONObject());
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      Util.ab(paramBaseArticleInfo, localJSONObject1);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label543;
      }
      Util.a(paramBaseArticleInfo, localJSONObject1);
      Util.d(paramBaseArticleInfo, localJSONObject1);
      label194:
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("id_large_video_activity_wrapper", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("activity_img_path", "free_netflow_icon");
      localJSONObject1.put("id_large_video_activity_img", localObject);
      localJSONObject1.put("id_large_video_activity_label", new JSONObject());
      localObject = new JSONObject();
      if ((paramBaseArticleInfo.mSmallMiniGameInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.f))) {
        break label551;
      }
      ((JSONObject)localObject).put("video_paly_text", paramBaseArticleInfo.mSmallMiniGameInfo.f);
    }
    for (;;)
    {
      localJSONObject1.put("id_video_paly_text", localObject);
      localObject = new JSONObject();
      if ((paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.g))) {
        ((JSONObject)localObject).put("video_play_icon", paramBaseArticleInfo.mSmallMiniGameInfo.g);
      }
      localJSONObject1.put("id_video_play_icon", localObject);
      if ((paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.q)))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("small_game_guide_icon_url", paramBaseArticleInfo.mSmallMiniGameInfo.q);
        localJSONObject1.put("id_small_game_guide_icon", localObject);
      }
      if ((paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.s)))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("game_follow_btn_url", paramBaseArticleInfo.mSmallMiniGameInfo.s);
        localJSONObject1.put("id_game_follow_btn", localObject);
      }
      if ((paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.u)))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("guide_name_text", paramBaseArticleInfo.mSmallMiniGameInfo.u);
        localJSONObject1.put("id_guide_name_text", localObject);
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_game_large_cell");
      Util.h(paramBaseArticleInfo, localJSONObject1);
      Util.an(paramBaseArticleInfo, localJSONObject1);
      Util.a(localJSONObject1, paramBaseArticleInfo);
      Util.ae(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      localObject = null;
      break;
      label543:
      Util.f(paramBaseArticleInfo, localJSONObject1);
      break label194;
      label551:
      ((JSONObject)localObject).put("video_paly_text", "轻触玩游戏");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyAdLargeVideoGameCell
 * JD-Core Version:    0.7.0.1
 */