package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public class ReadInJoyAdSmallGameCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = localJSONObject2;
    if (paramAbsBaseArticleInfo != null)
    {
      localJSONObject1 = localJSONObject2;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.smallGameData)) {
        localJSONObject1 = new JSONObject(paramAbsBaseArticleInfo.smallGameData);
      }
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdSmallGameCell
 * JD-Core Version:    0.7.0.1
 */