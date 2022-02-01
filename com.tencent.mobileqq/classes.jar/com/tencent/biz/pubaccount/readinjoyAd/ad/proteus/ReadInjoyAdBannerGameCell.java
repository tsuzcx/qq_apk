package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyAdBannerGameCell
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    try
    {
      if (paramAdData.as == null) {
        return paramJSONObject;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_game_cell");
      if (!TextUtils.isEmpty(paramAdData.aa)) {
        paramJSONObject.put("id_game_small_img", new JSONObject());
      }
      boolean bool = TextUtils.isEmpty(paramAdData.u);
      if (!bool)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.u);
        paramJSONObject.put("id_tv_author", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.m))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.m);
        paramJSONObject.put("id_tv_title", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.n))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAdData.n, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_bottom_imge", localJSONObject);
      }
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.ah))
      {
        ((JSONObject)localObject).put("text", paramAdData.ah);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      paramJSONObject.put("id_game_operate_area", new JSONObject());
      paramJSONObject.put("id_separator", new JSONObject());
      paramJSONObject.put("id_ad_title", new JSONObject());
      paramJSONObject.put("id_ad_title_rl", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("innerGameModel", paramAdData);
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      return paramJSONObject;
    }
    catch (JSONException paramAdData)
    {
      paramAdData.printStackTrace();
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerGameCell
 * JD-Core Version:    0.7.0.1
 */