package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInjoyAdHorizSmallGameCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = localJSONObject2;
    if (paramAbsBaseArticleInfo != null)
    {
      localJSONObject1 = localJSONObject2;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.smallGameData))
      {
        localJSONObject1 = new JSONObject(paramAbsBaseArticleInfo.smallGameData);
        a(localJSONObject1, paramAbsBaseArticleInfo);
      }
    }
    return localJSONObject1;
  }
  
  private static JSONObject a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    for (;;)
    {
      int j;
      try
      {
        paramAbsBaseArticleInfo = new JSONArray();
        int k = paramJSONObject.optInt("card_size");
        int i = 1;
        Object localObject1;
        if (i <= k)
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("style_ID", "ReadInjoy_ad_small_game_collection_cell");
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("game_icon");
          ((StringBuilder)localObject2).append(i);
          ((JSONObject)localObject1).put("game_icon", paramJSONObject.optString(((StringBuilder)localObject2).toString()));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("game_title");
          ((StringBuilder)localObject2).append(i);
          ((JSONObject)localObject1).put("game_title", paramJSONObject.optString(((StringBuilder)localObject2).toString()));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("game_type_label");
          ((StringBuilder)localObject2).append(i);
          ((JSONObject)localObject1).put("game_type_label", paramJSONObject.optString(((StringBuilder)localObject2).toString()));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("game_type_label");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("_color");
          ((JSONObject)localObject1).put("game_type_label_color", paramJSONObject.optString(((StringBuilder)localObject2).toString()));
          localObject2 = new StringBuilder();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("game_blue_label");
          localStringBuilder.append(i);
          ((StringBuilder)localObject2).append(paramJSONObject.optString(localStringBuilder.toString()));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("game_gray_label");
          localStringBuilder.append(i);
          ((StringBuilder)localObject2).append(paramJSONObject.optString(localStringBuilder.toString()));
          ((JSONObject)localObject1).put("game_gray_label", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("game_button_label");
          ((StringBuilder)localObject2).append(i);
          ((JSONObject)localObject1).put("game_button_label", paramJSONObject.optString(((StringBuilder)localObject2).toString()));
          j = 1;
          if (j <= 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("avator_icon");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append("_");
            ((StringBuilder)localObject2).append(j);
            localObject2 = paramJSONObject.optString(((StringBuilder)localObject2).toString());
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("avator_icon_");
              localStringBuilder.append(j);
              ((JSONObject)localObject1).put(localStringBuilder.toString(), localObject2);
            }
          }
          else
          {
            paramAbsBaseArticleInfo.put(localObject1);
            paramJSONObject.put("datas", paramAbsBaseArticleInfo);
            i += 1;
          }
        }
        else
        {
          return paramJSONObject;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ex.error");
          ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.getMessage());
          QLog.d("ReadInjoyAdHorizSmallGameCell", 2, ((StringBuilder)localObject1).toString());
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyAdHorizSmallGameCell
 * JD-Core Version:    0.7.0.1
 */