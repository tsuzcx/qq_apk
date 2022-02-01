package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
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
      if (paramAdData.ay != null) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindPkButton(paramJSONObject, paramAdData.az);
      }
      boolean bool = TextUtils.isEmpty(paramAdData.l);
      if (!bool)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.l);
        paramJSONObject.put("id_tv_title", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.n))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAdData.n, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_bottom_imge", localJSONObject);
      }
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.ah))
      {
        ((JSONObject)localObject).put("text", paramAdData.ah);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.u))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.u);
        paramJSONObject.put("id_tv_author", localObject);
        return paramJSONObject;
      }
    }
    catch (JSONException paramAdData)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JSONException = ");
        ((StringBuilder)localObject).append(paramAdData.getMessage());
        QLog.e("ReadInjoy_ad_banner_pk_cell", 2, ((StringBuilder)localObject).toString());
      }
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerPkCell
 * JD-Core Version:    0.7.0.1
 */