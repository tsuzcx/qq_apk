package com.tencent.biz.pubaccount.readinjoyAd.ad.atlas;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.NegFeedback;

public class ReadInJoyAdAtlasUtil
{
  private static HashMap<Integer, Pair<Integer, Integer>> a = new HashMap();
  
  static
  {
    HashMap localHashMap = a;
    Integer localInteger1 = Integer.valueOf(1000);
    Integer localInteger2 = Integer.valueOf(560);
    localHashMap.put(Integer.valueOf(385), new Pair(localInteger1, localInteger2));
    a.put(Integer.valueOf(65), new Pair(localInteger1, localInteger2));
    a.put(Integer.valueOf(600), new Pair(localInteger1, localInteger2));
    localHashMap = a;
    localInteger1 = Integer.valueOf(1280);
    localInteger2 = Integer.valueOf(720);
    localHashMap.put(Integer.valueOf(769), new Pair(localInteger1, localInteger2));
    a.put(Integer.valueOf(710), new Pair(localInteger2, localInteger1));
  }
  
  public static AdvertisementInfo a(oidb_0x885.AdInfo paramAdInfo)
  {
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    if ((paramAdInfo != null) && (paramAdInfo.has()))
    {
      localAdvertisementInfo.mAdKdPos = paramAdInfo.int32_kd_pos.get();
      localAdvertisementInfo.mAdCl = paramAdInfo.bytes_cl.get().toStringUtf8();
      localAdvertisementInfo.mAdImg = paramAdInfo.bytes_img.get().toStringUtf8();
      localAdvertisementInfo.mAdImgs = paramAdInfo.bytes_img_s.get().toStringUtf8();
      localAdvertisementInfo.mAdTxt = paramAdInfo.bytes_txt.get().toStringUtf8();
      localAdvertisementInfo.mAdDesc = paramAdInfo.bytes_desc.get().toStringUtf8();
      localAdvertisementInfo.mAdRl = paramAdInfo.bytes_rl.get().toStringUtf8();
      localAdvertisementInfo.mAdApurl = paramAdInfo.bytes_apurl.get().toStringUtf8();
      localAdvertisementInfo.mAdTraceId = paramAdInfo.bytes_trace_id.get().toStringUtf8();
      localAdvertisementInfo.mAdProductId = paramAdInfo.bytes_product_id.get().toStringUtf8();
      localAdvertisementInfo.mAdProductType = paramAdInfo.int32_product_type.get();
      localAdvertisementInfo.mAdType = paramAdInfo.uint32_ad_type.get();
      localAdvertisementInfo.mAdLandingPage = paramAdInfo.bytes_landing_page.get().toStringUtf8();
      localAdvertisementInfo.mAdPrice = paramAdInfo.bytes_price.get().toStringUtf8();
      localAdvertisementInfo.mAdBtnTxt = paramAdInfo.bytes_button_txt.get().toStringUtf8();
      localAdvertisementInfo.mAdViewId = paramAdInfo.bytes_view_id.get().toStringUtf8();
      localAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdInfo.bytes_customized_invoke_url.get().toStringUtf8();
      localAdvertisementInfo.mAdCorporationName = paramAdInfo.bytes_corporation_name.get().toStringUtf8();
      localAdvertisementInfo.mAdCorporateImageName = paramAdInfo.bytes_corporate_image_name.get().toStringUtf8();
      localAdvertisementInfo.mAdCorporateLogo = paramAdInfo.bytes_corporate_logo.get().toStringUtf8();
      localAdvertisementInfo.mAdUin = paramAdInfo.uint64_ad_uin.get();
      localAdvertisementInfo.mAdExt = paramAdInfo.bytes_ext.get().toStringUtf8();
      if (TextUtils.isEmpty(localAdvertisementInfo.mAdExt)) {
        localAdvertisementInfo.mAdExt = new JSONObject().toString();
      }
      localAdvertisementInfo.mAdVideoUrl = paramAdInfo.bytes_video_url.get().toStringUtf8();
      localAdvertisementInfo.mAdCostType = paramAdInfo.uint32_cost_type.get();
      localAdvertisementInfo.mAdAid = paramAdInfo.uint64_aid.get();
      localAdvertisementInfo.mAdLayout = paramAdInfo.enum_ad_layout.get();
      localAdvertisementInfo.mAdMaterialId = paramAdInfo.uint32_ad_material_id.get();
      localAdvertisementInfo.mAdJumpMode = paramAdInfo.enum_ad_jump_mode.get();
      localAdvertisementInfo.mAdExtInfo = paramAdInfo.bytes_extra_data.get().toStringUtf8();
      if (TextUtils.isEmpty(localAdvertisementInfo.mAdExtInfo)) {
        localAdvertisementInfo.mAdExtInfo = new JSONObject().toString();
      }
      localAdvertisementInfo.mAdAppDownLoadSchema = paramAdInfo.bytes_app_download_schema.get().toStringUtf8();
      localAdvertisementInfo.mAdCanvasJson = paramAdInfo.string_canvas_json.get();
      localAdvertisementInfo.mAdLandingPageReportUrl = paramAdInfo.bytes_landing_page_report_url.get().toStringUtf8();
      localAdvertisementInfo.mAdAdvertiseId = paramAdInfo.uint64_advertiser_id.get();
      localAdvertisementInfo.mAdDestType = paramAdInfo.uint32_dest_type.get();
      localAdvertisementInfo.mAdEffectUrl = paramAdInfo.string_effect_url.get();
      localAdvertisementInfo.mAdNocoId = paramAdInfo.int64_noco_id.get();
      localAdvertisementInfo.mAdVia = paramAdInfo.bytes_via.get().toStringUtf8();
      localAdvertisementInfo.mAdFeedId = paramAdInfo.uint64_feeds_id.get();
      localAdvertisementInfo.mAdInteractionReportUrl = paramAdInfo.string_interaction_report_url.get();
      if (paramAdInfo.rpt_msg_neg_feedback.has())
      {
        localAdvertisementInfo.mAdDislikeInfos = new ArrayList();
        Iterator localIterator = paramAdInfo.rpt_msg_neg_feedback.get().iterator();
        while (localIterator.hasNext())
        {
          oidb_0x885.NegFeedback localNegFeedback = (oidb_0x885.NegFeedback)localIterator.next();
          if (localNegFeedback != null) {
            localAdvertisementInfo.mAdDislikeInfos.add(new AdDislikeInfo(localNegFeedback));
          }
        }
      }
      localAdvertisementInfo.mAdScoreNum = paramAdInfo.uint32_app_score_num.get();
      if (paramAdInfo.string_download_api_url.has()) {
        localAdvertisementInfo.mAdDownloadApiUrl = paramAdInfo.string_download_api_url.get();
      }
      localAdvertisementInfo.mAdVideoFileSize = paramAdInfo.uint64_video_file_size.get();
      localAdvertisementInfo.processAdExtraDataInfo(localAdvertisementInfo.mAdExtInfo);
      localAdvertisementInfo.mAdvertisementExtInfo = new AdvertisementExtInfo(localAdvertisementInfo.mAdExtInfo);
      localAdvertisementInfo.mInteractEffectType = paramAdInfo.uint32_interact_effect_type.get();
      if (paramAdInfo.string_interact_image_list.has()) {
        localAdvertisementInfo.mInteractImageList = paramAdInfo.string_interact_image_list.get();
      }
      localAdvertisementInfo.mInteractType = paramAdInfo.uint32_interact_type.get();
      int i;
      if (paramAdInfo.int32_soft_ad_type.has()) {
        i = paramAdInfo.int32_soft_ad_type.get();
      } else {
        i = 0;
      }
      localAdvertisementInfo.mSoftAdType = i;
      if (paramAdInfo.bytes_soft_ad_data.has()) {
        paramAdInfo = paramAdInfo.bytes_soft_ad_data.get().toStringUtf8();
      } else {
        paramAdInfo = new JSONObject().toString();
      }
      localAdvertisementInfo.mSoftAdData = paramAdInfo;
      if (localAdvertisementInfo.mSoftAdType == 2) {
        localAdvertisementInfo.processSoftDataInfo(localAdvertisementInfo.mSoftAdData);
      }
    }
    return localAdvertisementInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.atlas.ReadInJoyAdAtlasUtil
 * JD-Core Version:    0.7.0.1
 */