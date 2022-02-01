package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import org.json.JSONObject;

public class ReadInJoyAdSmallGameNewStyleCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    if (paramBaseArticleInfo != null)
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("game_title", paramBaseArticleInfo.mSubscribeName);
      localJSONObject1.put("id_game_title", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("game_desc", paramBaseArticleInfo.mSummary);
      localJSONObject1.put("id_game_desc", localJSONObject2);
      localJSONObject2 = new JSONObject();
      if ((paramBaseArticleInfo.mSmallMiniGameInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.e))) {
        break label222;
      }
      localJSONObject2.put("game_btn_text", paramBaseArticleInfo.mSmallMiniGameInfo.e);
    }
    for (;;)
    {
      localJSONObject1.put("id_game_btn", localJSONObject2);
      if (paramBaseArticleInfo.mSmallMiniGameInfo != null)
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("background_img_url", paramBaseArticleInfo.mSmallMiniGameInfo.i);
        localJSONObject1.put("id_background_img", localJSONObject2);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("left_big_img_url", paramBaseArticleInfo.mSmallMiniGameInfo.h);
        localJSONObject1.put("id_left_big_img", localJSONObject2);
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_game_new_style_cell");
      Util.a(paramBaseArticleInfo, localJSONObject1);
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      Util.h(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      label222:
      localJSONObject2.put("game_btn_text", "去玩");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyAdSmallGameNewStyleCell
 * JD-Core Version:    0.7.0.1
 */