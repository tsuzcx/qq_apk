package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyAdBannerInnerGameCell
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    label574:
    for (;;)
    {
      try
      {
        if (paramAdData.a == null) {
          return paramJSONObject;
        }
        JSONObject localJSONObject = paramAdData.b;
        int k = 0;
        if (localJSONObject != null)
        {
          i = paramAdData.b.optInt("sourceId", 0);
          if (i == 8)
          {
            i = 1;
            continue;
          }
        }
        i = 0;
        if (i == 0) {
          paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_game_cell");
        } else {
          paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_game_cell_kol");
        }
        if (i != 0)
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("author_rec_image_url", "https://img.nfa.qq.com/gmaster_prod/16033248/gmaster_1762mtm0zag0_kd_detail_kol.png");
          paramJSONObject.put("id_inner_author_recommend", localJSONObject);
        }
        if (!TextUtils.isEmpty(paramAdData.a.k)) {
          paramJSONObject.put("id_inner_small_img", new JSONObject());
        }
        boolean bool = TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_JavaLangString);
        if (!bool)
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("text", paramAdData.a.jdField_a_of_type_JavaLangString);
          paramJSONObject.put("id_inner_title", localJSONObject);
        }
        if ((!((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentAndGetGiftType(paramAdData)) && (!TextUtils.isEmpty(paramAdData.a.h)))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("text", paramAdData.a.h);
          paramJSONObject.put("id_inner_category", localJSONObject);
        }
        if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.d))
        {
          paramJSONObject.put("id_inner_game_img1", new JSONObject());
          paramJSONObject.put("id_game_img1_container1", new JSONObject());
          i = 1;
          j = 1;
          if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.e))
          {
            paramJSONObject.put("id_inner_game_img2", new JSONObject());
            paramJSONObject.put("id_game_img2_container2", new JSONObject());
            i = 1;
            j = 1;
          }
          if (TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.f)) {
            break label574;
          }
          paramJSONObject.put("id_inner_game_img3", new JSONObject());
          paramJSONObject.put("id_game_img3_container3", new JSONObject());
          i = 1;
          j = k;
          if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.g))
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("text", paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.g);
            paramJSONObject.put("id_inner_ad_name", localJSONObject);
            i = 1;
          }
          if (i != 0) {
            paramJSONObject.put("id_bottom_operation", new JSONObject());
          }
          if (j != 0) {
            paramJSONObject.put("id_game_img_right_space", new JSONObject());
          }
          if (!TextUtils.isEmpty(paramAdData.a.z))
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("text", paramAdData.a.z);
            paramJSONObject.put("id_inner_sign", localJSONObject);
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("innerGameModel", paramAdData);
          paramJSONObject.put("id_view_AdDownloadView", localJSONObject);
          return paramJSONObject;
        }
      }
      catch (JSONException paramAdData)
      {
        paramAdData.printStackTrace();
        return paramJSONObject;
      }
      int i = 0;
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerInnerGameCell
 * JD-Core Version:    0.7.0.1
 */