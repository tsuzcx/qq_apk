package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
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
      if (paramAdData.U != null) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindPkButton(paramJSONObject, paramAdData.a);
      }
      boolean bool = TextUtils.isEmpty(paramAdData.j);
      if (!bool)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.j);
        paramJSONObject.put("id_tv_title", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.l))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAdData.l, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_bottom_imge", localJSONObject);
      }
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.L))
      {
        ((JSONObject)localObject).put("text", paramAdData.L);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.q))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.q);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerPkCell
 * JD-Core Version:    0.7.0.1
 */