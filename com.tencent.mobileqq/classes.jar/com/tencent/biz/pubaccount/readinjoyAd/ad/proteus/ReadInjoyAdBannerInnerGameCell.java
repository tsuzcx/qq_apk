package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyAdBannerInnerGameCell
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    int k = 1;
    for (;;)
    {
      try
      {
        if (paramAdData.a == null) {
          return paramJSONObject;
        }
        if ((paramAdData.b != null) && (paramAdData.b.optInt("sourceId", 0) == 8))
        {
          i = 1;
          if (i != 0) {
            break label483;
          }
          paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_game_cell");
          if (i != 0)
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("author_rec_image_url", "https://img.nfa.qq.com/gmaster_prod/16033248/gmaster_1762mtm0zag0_kd_detail_kol.png");
            paramJSONObject.put("id_inner_author_recommend", localJSONObject);
          }
          if (!TextUtils.isEmpty(paramAdData.a.k)) {
            paramJSONObject.put("id_inner_small_img", new JSONObject());
          }
          if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_JavaLangString))
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("text", paramAdData.a.jdField_a_of_type_JavaLangString);
            paramJSONObject.put("id_inner_title", localJSONObject);
          }
          if ((!FastWeqAdUtils.c(paramAdData)) && (!TextUtils.isEmpty(paramAdData.a.h)))
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("text", paramAdData.a.h);
            paramJSONObject.put("id_inner_category", localJSONObject);
          }
          if (TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.d)) {
            break label501;
          }
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
            break label498;
          }
          paramJSONObject.put("id_inner_game_img3", new JSONObject());
          paramJSONObject.put("id_game_img3_container3", new JSONObject());
          i = 0;
          j = 1;
          if (TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.g)) {
            break label495;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("text", paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.g);
          paramJSONObject.put("id_inner_ad_name", localJSONObject);
          j = k;
          if (j != 0) {
            paramJSONObject.put("id_bottom_operation", new JSONObject());
          }
          if (i != 0) {
            paramJSONObject.put("id_game_img_right_space", new JSONObject());
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
      continue;
      label483:
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_game_cell_kol");
      continue;
      label495:
      continue;
      label498:
      continue;
      label501:
      i = 0;
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerInnerGameCell
 * JD-Core Version:    0.7.0.1
 */