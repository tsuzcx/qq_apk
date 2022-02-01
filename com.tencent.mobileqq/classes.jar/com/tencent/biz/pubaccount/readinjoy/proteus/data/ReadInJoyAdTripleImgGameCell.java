package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyAdTripleImgGameCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject4 = "";
    String str1 = "";
    String str2 = "";
    Util.a(paramBaseArticleInfo, localJSONObject, true);
    Util.a(paramBaseArticleInfo, localJSONObject);
    Util.d(paramBaseArticleInfo, localJSONObject);
    Util.n(paramBaseArticleInfo, localJSONObject);
    Util.g(paramBaseArticleInfo, localJSONObject);
    Util.h(paramBaseArticleInfo, localJSONObject);
    Util.ab(paramBaseArticleInfo, localJSONObject);
    Util.ae(paramBaseArticleInfo, localJSONObject);
    Util.af(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_ad_small_game_triple_img_cell");
    Util.a(localJSONObject, paramBaseArticleInfo);
    Object localObject1 = str2;
    Object localObject2 = str1;
    Object localObject3 = localObject4;
    if (paramBaseArticleInfo.mSmallMiniGameInfo != null)
    {
      localObject1 = str2;
      localObject2 = str1;
      localObject3 = localObject4;
      if (paramBaseArticleInfo.mSmallMiniGameInfo.a != null)
      {
        localObject1 = str2;
        localObject2 = str1;
        localObject3 = localObject4;
        if (paramBaseArticleInfo.mSmallMiniGameInfo.a.length() > 2)
        {
          localObject3 = paramBaseArticleInfo.mSmallMiniGameInfo.a.optString(0);
          localObject2 = paramBaseArticleInfo.mSmallMiniGameInfo.a.optString(1);
          localObject1 = paramBaseArticleInfo.mSmallMiniGameInfo.a.optString(2);
        }
      }
    }
    localObject4 = new JSONObject();
    ((JSONObject)localObject4).put("multi_img_url1", localObject3);
    localJSONObject.put("id_multi_img_1", localObject4);
    localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("multi_img_url2", localObject2);
    localJSONObject.put("id_multi_img_2", localObject3);
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("multi_img_url3", localObject1);
    localJSONObject.put("id_multi_img_3", localObject2);
    if ((paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.q)))
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("small_game_guide_icon_url", paramBaseArticleInfo.mSmallMiniGameInfo.q);
      localJSONObject.put("id_small_game_guide_icon", localObject1);
    }
    if ((paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.s)))
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("game_follow_btn_url", paramBaseArticleInfo.mSmallMiniGameInfo.s);
      localJSONObject.put("id_game_follow_btn", localObject1);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyAdTripleImgGameCell
 * JD-Core Version:    0.7.0.1
 */