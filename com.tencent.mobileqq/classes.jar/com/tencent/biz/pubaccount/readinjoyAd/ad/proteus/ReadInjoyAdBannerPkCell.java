package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyAdBannerPkCell
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_pk_cell");
      if (paramAdData.M != null) {
        ReadInJoyAdUtils.a(paramJSONObject, paramAdData.a);
      }
      if (!TextUtils.isEmpty(paramAdData.b))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.b);
        paramJSONObject.put("id_tv_title", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.d))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAdData.d, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_bottom_imge", localJSONObject);
      }
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.D))
      {
        ((JSONObject)localObject).put("text", paramAdData.D);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.i))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.i);
        paramJSONObject.put("id_tv_author", localObject);
      }
    }
    catch (JSONException paramAdData)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInjoy_ad_banner_pk_cell", 2, "JSONException = " + paramAdData.getMessage());
    }
    return paramJSONObject;
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerPkCell
 * JD-Core Version:    0.7.0.1
 */