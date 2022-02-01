package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import org.json.JSONObject;

public class VideoFeedsAdReportUtils
{
  public static void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, Context paramContext, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    label54:
    int i;
    label123:
    int j;
    if (paramVideoPlayerWrapper.e() == 0L)
    {
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e = ((int)paramVideoPlayerWrapper.b());
      ReadinjoyAdVideoReportData localReadinjoyAdVideoReportData = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d != 0) {
        break label291;
      }
      bool = true;
      localReadinjoyAdVideoReportData.b = bool;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.c = true;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.h = ((int)paramVideoPlayerWrapper.b());
      localReadinjoyAdVideoReportData = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      AdvertisementInfo localAdvertisementInfo = NativeAdUtils.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localReadinjoyAdVideoReportData.d;
      int m = localReadinjoyAdVideoReportData.e;
      if (!localReadinjoyAdVideoReportData.b) {
        break label297;
      }
      i = 1;
      if (!localReadinjoyAdVideoReportData.c) {
        break label302;
      }
      j = 1;
      label134:
      JSONObject localJSONObject = NativeAdUtils.a(k, m, i, j, localReadinjoyAdVideoReportData.f, 1, localReadinjoyAdVideoReportData.h, 2, 0, localReadinjoyAdVideoReportData.i, ReportConstants.VideoEndType.NORMAL_COMPLETE, true);
      NativeAdUtils.a(new AdReportData().a(paramContext).a(6).b(localReadinjoyAdVideoReportData.g).a(localAdvertisementInfo).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject));
      paramVideoPlayerWrapper.m();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d = 0;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e = 0;
      paramContext = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d != 0) {
        break label308;
      }
    }
    label291:
    label297:
    label302:
    label308:
    for (boolean bool = true;; bool = false)
    {
      paramContext.b = bool;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.c = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.h = 0;
      return;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d = ((int)paramVideoPlayerWrapper.e());
      break;
      bool = false;
      break label54;
      i = 0;
      break label123;
      j = 0;
      break label134;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.VideoFeedsAdReportUtils
 * JD-Core Version:    0.7.0.1
 */