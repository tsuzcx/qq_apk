package com.tencent.biz.pubaccount;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.NativeAd.util.VideoFeedsAdTagHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStudyModeUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.video.EntranceButtonExposureHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AccountVInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdVideoPos;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AppAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.BiuMultiLevel;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.BiuOneLevelItem;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ECommerceEntranceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ExposeArticleInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsIdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InnerMsg;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InterruptedWeishiAd;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.JumpInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.LikeDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PkgInstallInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PositionInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SoftAdDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SubscriptInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.TopBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCFeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCVideoInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UrlJumpInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UserExposeArticle;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoColumnInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoFloatInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.GameComponentInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VideoPlayRecommendHandler
  extends BusinessHandler
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.reading", "com.tencent.rijvideo", "com.tencent.weishi" };
  
  public VideoPlayRecommendHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public VideoPlayRecommendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a()
  {
    int i = 1;
    if (StudyModeManager.a()) {
      i = 8193;
    }
    return i;
  }
  
  private VideoInfo.ECommerceEntranceInfo a(oidb_0x6cf.InterruptedWeishiAd paramInterruptedWeishiAd, oidb_0x6cf.RspBody paramRspBody)
  {
    VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo2;
    if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.has())
    {
      localECommerceEntranceInfo2 = new VideoInfo.ECommerceEntranceInfo();
      localECommerceEntranceInfo2.jdField_a_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_title);
      localECommerceEntranceInfo2.jdField_b_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_subtitle);
      localECommerceEntranceInfo2.jdField_c_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_thumbnail_url);
      localECommerceEntranceInfo2.jdField_d_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_link_icon_url);
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
        localECommerceEntranceInfo2.jdField_a_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
        localECommerceEntranceInfo2.jdField_g_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
        localECommerceEntranceInfo2.jdField_d_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
        localECommerceEntranceInfo2.jdField_f_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
        localECommerceEntranceInfo2.jdField_e_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
      }
      localECommerceEntranceInfo2.jdField_e_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_jump_url);
      localECommerceEntranceInfo2.jdField_f_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_common_data);
      localECommerceEntranceInfo2.jdField_h_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_style.get();
      localECommerceEntranceInfo1 = localECommerceEntranceInfo2;
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.has())
      {
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
        localECommerceEntranceInfo2.jdField_h_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
        localECommerceEntranceInfo2.jdField_g_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
        localECommerceEntranceInfo2.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
        localECommerceEntranceInfo2.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
        localECommerceEntranceInfo2.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
      }
    }
    for (VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo1 = localECommerceEntranceInfo2;; localECommerceEntranceInfo1 = null)
    {
      int i;
      if ((localECommerceEntranceInfo1 != null) && (paramRspBody.msg_ecommerce_entrance_config.has()) && (paramRspBody.msg_ecommerce_entrance_config.get() != null))
      {
        if (paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has()) {
          localECommerceEntranceInfo1.jdField_b_of_type_Int = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
        }
        paramInterruptedWeishiAd = a(paramRspBody.msg_ecommerce_entrance_config.bytes_show_positon);
        if (!TextUtils.isEmpty(paramInterruptedWeishiAd))
        {
          paramInterruptedWeishiAd = paramInterruptedWeishiAd.split(",");
          if ((paramInterruptedWeishiAd != null) && (paramInterruptedWeishiAd.length > 0))
          {
            localECommerceEntranceInfo1.jdField_a_of_type_ArrayOfInt = new int[paramInterruptedWeishiAd.length];
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i < paramInterruptedWeishiAd.length) {}
        try
        {
          localECommerceEntranceInfo1.jdField_a_of_type_ArrayOfInt[i] = Integer.parseInt(paramInterruptedWeishiAd[i]);
          label685:
          i += 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "get commerceEntranceInfo in config: " + localECommerceEntranceInfo1.toString());
          }
          return localECommerceEntranceInfo1;
        }
        catch (Exception paramRspBody)
        {
          break label685;
        }
      }
    }
  }
  
  private VideoInfo a(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
  {
    boolean bool2 = true;
    int j = 0;
    VideoInfo localVideoInfo = b(paramArticleSummary, paramRspBody);
    boolean bool1;
    if (localVideoInfo != null)
    {
      if ((TextUtils.isEmpty(localVideoInfo.jdField_c_of_type_JavaLangString)) && (QLog.isColorLevel())) {
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList 获取原文章标题, NULL ERROR");
      }
      if ((paramArticleSummary.bytes_inner_id.has()) && (paramArticleSummary.bytes_inner_id.get() != null)) {
        localVideoInfo.jdField_g_of_type_JavaLangString = paramArticleSummary.bytes_inner_id.get().toStringUtf8();
      }
      if (paramArticleSummary.uint64_article_id.has()) {
        localVideoInfo.jdField_c_of_type_Long = paramArticleSummary.uint64_article_id.get();
      }
      if (paramRspBody.msg_interrupted_ad_weishi.has())
      {
        paramRspBody = (oidb_0x6cf.InterruptedWeishiAd)paramRspBody.msg_interrupted_ad_weishi.get();
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = new VideoInfo.InterruptedWeishiAd();
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString = a(paramRspBody.bytes_ad_url);
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
        if (paramRspBody.uint32_is_show_in_play_end.has()) {
          if (paramRspBody.uint32_is_show_in_play_end.get() == 1) {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      paramArticleSummary.jdField_b_of_type_Boolean = bool1;
      paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
      label217:
      int i;
      if (paramRspBody.uint32_is_show_in_switch.has()) {
        if (paramRspBody.uint32_is_show_in_switch.get() == 1)
        {
          bool1 = bool2;
          paramArticleSummary.jdField_a_of_type_Boolean = bool1;
          paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
          if (!paramRspBody.uint32_show_after_play_time.has()) {
            break label348;
          }
          i = paramRspBody.uint32_show_after_play_time.get();
          label247:
          paramArticleSummary.jdField_a_of_type_Int = i;
          paramArticleSummary = a(paramRspBody.bytes_show_positon);
          if (paramArticleSummary == null) {
            break label353;
          }
          paramArticleSummary = paramArticleSummary.split(",");
          label272:
          if ((paramArticleSummary == null) || (paramArticleSummary.length <= 0)) {
            break label358;
          }
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt = new int[paramArticleSummary.length];
          i = 0;
          label295:
          if (i >= paramArticleSummary.length) {
            break label358;
          }
        }
      }
      try
      {
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt[i] = Integer.parseInt(paramArticleSummary[i]);
        label317:
        i += 1;
        break label295;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        break label217;
        bool1 = false;
        break label217;
        label348:
        i = -1;
        break label247;
        label353:
        paramArticleSummary = null;
        break label272;
        label358:
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
        i = j;
        if (paramRspBody.uint32_interrupted_ad_type.has()) {
          i = paramRspBody.uint32_interrupted_ad_type.get();
        }
        paramArticleSummary.jdField_b_of_type_Int = i;
        if (paramRspBody.appInfo.has())
        {
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_download_wording);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_e_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_open_wording);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_name);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_icon_url);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).uint32_jump_type.get();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_bundle);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_schema);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_url);
        }
        return localVideoInfo;
      }
      catch (Exception localException)
      {
        break label317;
      }
    }
  }
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private oidb_0x6cf.PositionInfo a()
  {
    if (ContextCompat.checkSelfPermission(BaseApplicationImpl.getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0)
    {
      SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_anti_cheating");
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getPositionInfo() latitude=" + localSosoLbsInfo.mLocation.mLat02 + ", longitude=" + localSosoLbsInfo.mLocation.mLon02);
        }
        if ((localSosoLbsInfo.mLocation.mLat02 != 0.0D) && (localSosoLbsInfo.mLocation.mLon02 != 0.0D))
        {
          oidb_0x6cf.PositionInfo localPositionInfo = new oidb_0x6cf.PositionInfo();
          localPositionInfo.latitude.set((int)(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
          localPositionInfo.longitude.set((int)(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
          return localPositionInfo;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getPositionInfo() permission not granted");
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    Bundle localBundle;
    Object localObject6;
    List localList;
    StringBuilder localStringBuilder;
    Object localObject1;
    Object localObject7;
    Object localObject8;
    Object localObject5;
    VideoInfo localVideoInfo;
    boolean bool3;
    Object localObject2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      localBundle = new Bundle();
      localObject6 = null;
      localList = null;
      localStringBuilder = null;
      paramFromServiceMsg = null;
      localObject1 = null;
      localObject7 = null;
      localObject8 = null;
      localObject5 = null;
      localVideoInfo = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList onReceive :" + bool1);
      }
      bool3 = ((Boolean)paramToServiceMsg.getAttribute("VALUE_REQUEST_GAME_DATA", Boolean.valueOf(false))).booleanValue();
      if (!bool1) {
        break label1583;
      }
      localObject2 = localObject5;
      localObject1 = localStringBuilder;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        localObject2 = localObject5;
        localObject1 = localStringBuilder;
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        localObject2 = localObject5;
        localObject1 = localStringBuilder;
        if (paramFromServiceMsg.uint32_result.has())
        {
          localObject2 = localObject5;
          localObject1 = localStringBuilder;
          if (paramFromServiceMsg.uint32_result.get() == 83)
          {
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (QLog.isColorLevel())
            {
              localObject2 = localObject5;
              localObject1 = localStringBuilder;
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 热门长视频黑名单");
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            localBundle.putBoolean("VALUE_USER_IN_BLACK", true);
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            localRspBody = new oidb_0x6cf.RspBody();
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            localRspBody.mergeFrom(paramFromServiceMsg);
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (localRspBody.uint64_pos_ad_time.has())
            {
              localObject2 = localObject5;
              localObject1 = localStringBuilder;
              this.jdField_a_of_type_Long = localRspBody.uint64_pos_ad_time.get();
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (localRspBody.bytes_cookie.has())
            {
              localObject2 = localObject5;
              localObject1 = localStringBuilder;
              if (localRspBody.bytes_cookie.get() != null)
              {
                localObject2 = localObject5;
                localObject1 = localStringBuilder;
                localBundle.putString("VALUE_COOKIE", localRspBody.bytes_cookie.get().toStringUtf8());
              }
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (!localRspBody.bytes_ads_context.has()) {
              continue;
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            String str = localRspBody.bytes_ads_context.get().toStringUtf8();
            i = 1;
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null)
            {
              localObject2 = localObject5;
              localObject1 = localStringBuilder;
              this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
            if (bool3) {
              continue;
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (!localRspBody.rpt_article_list.has()) {
              continue;
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (localRspBody.rpt_article_list.get() == null) {
              continue;
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            localList = localRspBody.rpt_article_list.get();
            paramObject = localObject7;
            paramFromServiceMsg = localObject6;
            if (localList == null) {
              continue;
            }
            paramObject = localObject7;
            paramFromServiceMsg = localObject6;
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            if (localList.isEmpty()) {
              continue;
            }
            localObject2 = localObject5;
            localObject1 = localStringBuilder;
            paramFromServiceMsg = new ArrayList(localList.size());
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        oidb_0x6cf.RspBody localRspBody;
        int i;
        Object localObject3;
        label1583:
        continue;
        continue;
        Object localObject4 = paramObject;
        paramObject = paramFromServiceMsg;
        continue;
        localObject4 = "null";
        continue;
        boolean bool2 = false;
        continue;
      }
      try
      {
        paramObject = new ArrayList(paramFromServiceMsg.size());
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList, 解析推荐视频列表: article size=" + localList.size());
          }
          ReadInJoyAdLog.a("AdVideoDataLink", "视频浮层混排回包: article size=" + localList.size());
          localObject1 = localList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (oidb_0x6cf.ArticleSummary)((Iterator)localObject1).next();
          try
          {
            localObject2 = b((oidb_0x6cf.ArticleSummary)localObject2, localRspBody);
            if (localObject2 == null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList，解析推荐视频列表：article = " + ((VideoInfo)localObject2).b());
            }
            paramFromServiceMsg.add(localObject2);
            paramObject.add(((VideoInfo)localObject2).jdField_j_of_type_JavaLangString);
            ReadInJoyAdLog.a("AdVideoDataLink", "isAd = " + ((VideoInfo)localObject2).jdField_c_of_type_Boolean + " article = " + ((VideoInfo)localObject2).jdField_c_of_type_JavaLangString);
          }
          catch (Exception localException1) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, ERROR e=" + localException1.getMessage());
          continue;
          paramObject = localObject3;
        }
        catch (Exception localException2)
        {
          localObject1 = paramFromServiceMsg;
          localObject3 = paramObject;
          paramFromServiceMsg = localException2;
        }
      }
      catch (Exception paramObject)
      {
        localObject1 = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
        localObject3 = localVideoInfo;
        continue;
        localObject1 = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
        paramObject = localObject1;
      }
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, ERROR e=" + paramFromServiceMsg.getMessage());
        localObject4 = localObject1;
        paramObject = localObject3;
      }
      ReadInJoyUserInfoModule.a(paramObject);
      if (!bool3)
      {
        paramFromServiceMsg = paramToServiceMsg.getAttribute("is_from_first_recommend_video");
        if ((paramFromServiceMsg != null) && ((paramFromServiceMsg instanceof Boolean))) {
          localBundle.putBoolean("is_from_first_recommend_video", ((Boolean)paramFromServiceMsg).booleanValue());
        }
        localBundle.putString("VALUE_REQUEST_VIDEO_ARTICLE_ID", (String)paramToServiceMsg.getAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID"));
        VideoFeedsAdTagHelper.a(localBundle, (ArrayList)localObject4);
        localBundle.putBoolean("VALUE_REQUEST_GAME_DATA", false);
        paramToServiceMsg = paramToServiceMsg.getAttribute("VALUE_OBSERVER_TAG");
        if ((paramToServiceMsg instanceof Integer)) {
          localBundle.putInt("VALUE_OBSERVER_TAG", ((Integer)paramToServiceMsg).intValue());
        }
        super.notifyUI(0, bool1, localBundle);
        return;
        bool1 = false;
        break;
        localObject3 = localObject5;
        localObject1 = localStringBuilder;
        localBundle.putBoolean("VALUE_USER_IN_BLACK", false);
        continue;
        if (paramFromServiceMsg != null)
        {
          localObject3 = paramObject;
          localObject1 = paramFromServiceMsg;
          if (!paramFromServiceMsg.isEmpty()) {}
        }
        else
        {
          localObject3 = paramObject;
          localObject1 = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list 中合法数据为空");
          }
        }
        localObject3 = paramObject;
        localObject1 = paramFromServiceMsg;
        a(paramFromServiceMsg);
        localObject3 = paramObject;
        localObject1 = paramFromServiceMsg;
        localBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", paramFromServiceMsg);
        if (i != 0)
        {
          localObject3 = paramObject;
          localObject1 = paramFromServiceMsg;
          NativeAdUtils.a((String)localObject4);
        }
        localObject3 = paramObject;
        localObject1 = paramFromServiceMsg;
        if (localRspBody.req_article_summary.has())
        {
          localObject3 = paramObject;
          localObject1 = paramFromServiceMsg;
          if (localRspBody.req_article_summary.get() != null)
          {
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            localVideoInfo = a((oidb_0x6cf.ArticleSummary)localRspBody.req_article_summary.get(), localRspBody);
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            if (QLog.isColorLevel())
            {
              localObject3 = paramObject;
              localObject1 = paramFromServiceMsg;
              localStringBuilder = new StringBuilder().append("handleGetRecommendList，解析第一个视频的详细信息：firstVideoInfo = ");
              if (localVideoInfo == null) {
                continue;
              }
              localObject3 = paramObject;
              localObject1 = paramFromServiceMsg;
              localObject4 = localVideoInfo.b();
              localObject3 = paramObject;
              localObject1 = paramFromServiceMsg;
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, (String)localObject4);
            }
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            localBundle.putParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO", localVideoInfo);
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            if (localRspBody.msg_ecommerce_entrance_config.has())
            {
              localObject3 = paramObject;
              localObject1 = paramFromServiceMsg;
              if (localRspBody.msg_ecommerce_entrance_config.get() != null)
              {
                localObject3 = paramObject;
                localObject1 = paramFromServiceMsg;
                localBundle.putParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO", a((oidb_0x6cf.InterruptedWeishiAd)localRspBody.msg_ecommerce_entrance_config.get(), localRspBody));
              }
            }
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            if (localRspBody.uint32_is_end.has())
            {
              localObject3 = paramObject;
              localObject1 = paramFromServiceMsg;
              if (localRspBody.uint32_is_end.get() != 0) {
                continue;
              }
              bool2 = true;
              localObject3 = paramObject;
              localObject1 = paramFromServiceMsg;
              localBundle.putBoolean("VALUE_HAS_MORE_DATA", bool2);
            }
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            if (!localRspBody.msg_entrance_download_info.has()) {
              continue;
            }
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            if (localRspBody.msg_entrance_download_info.get() == null) {
              continue;
            }
            localObject3 = paramObject;
            localObject1 = paramFromServiceMsg;
            localBundle.putParcelable("value_entrance_download_info", a((oidb_0x6cf.EntranceDownloadInfo)localRspBody.msg_entrance_download_info.get()));
            localObject1 = paramFromServiceMsg;
            paramFromServiceMsg = paramObject;
            paramObject = localObject1;
            continue;
            paramObject = localObject8;
            paramFromServiceMsg = localList;
            localObject3 = localObject5;
            localObject1 = localStringBuilder;
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject3 = localObject5;
            localObject1 = localStringBuilder;
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null");
            paramObject = localObject8;
            paramFromServiceMsg = localList;
            continue;
          }
        }
        localObject3 = paramObject;
        localObject1 = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = paramObject;
        localObject1 = paramFromServiceMsg;
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList: 返回的req_article_summary null");
        continue;
        localObject3 = localObject5;
        localObject1 = localStringBuilder;
        VideoFeedsAdTagHelper.a(localRspBody, localBundle, this.jdField_a_of_type_Long);
        paramFromServiceMsg = null;
        paramObject = null;
        continue;
        paramObject = localObject1;
        localObject4 = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null 或者直接出错了");
        paramObject = localObject1;
        localObject4 = paramFromServiceMsg;
        continue;
      }
      localBundle.putBoolean("VALUE_REQUEST_GAME_DATA", true);
      continue;
      i = 0;
      localObject4 = null;
    }
  }
  
  private void a(Object paramObject, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<oidb_0x885.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ArrayList<VideoInfo> paramArrayList2, Bundle paramBundle, int paramInt8)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    if (paramVideoInfo.jdField_g_of_type_JavaLangString == null) {
      paramVideoInfo.jdField_g_of_type_JavaLangString = "";
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  articleId = " + paramVideoInfo.jdField_g_of_type_JavaLangString + ", secondVideoArticleID = " + paramString1 + ", type = " + paramInt1 + ",polymericTopicId = " + paramLong2);
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    Object localObject1 = ByteStringMicro.copyFromUtf8(paramVideoInfo.jdField_g_of_type_JavaLangString);
    localReqBody.bytes_inner_id.set((ByteStringMicro)localObject1);
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint32_req_source.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
      localReqBody.rpt_bytes_redo_inner_id.add(paramString1);
    }
    if (paramLong2 != -1L) {
      localReqBody.uint32_req_topic_id.set((int)paramLong2);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      localReqBody.bytes_req_web.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString3);
      localReqBody.bytes_cookie.set(paramString1);
    }
    paramString3 = new oidb_0x6cf.ReqAdvertisePara();
    paramString3.msg_phone_info.set(AdDeviceInfoUtil.a());
    paramString3.uint64_last_time.set(this.jdField_a_of_type_Long);
    paramString2 = new oidb_0x6cf.VideoFloatInfo();
    paramString2.uint32_ad_support.set(1);
    label415:
    boolean bool;
    label432:
    label481:
    Object localObject2;
    JSONObject localJSONObject;
    Object localObject3;
    Map.Entry localEntry;
    if ((paramArrayList1 == null) || (paramArrayList1.size() <= 0))
    {
      paramString2.uint32_info_num.set(0);
      paramString3.msg_video_float_info.set(paramString2);
      paramString1 = new oidb_0x885.AdReqInfo();
      paramString1.uint64_ad_channel_id.set(0L);
      paramString1.int32_revision_video.set(paramInt7);
      paramString1.source_channel_id.set(this.jdField_a_of_type_Int);
      if ((paramVideoInfo != null) && (paramVideoInfo.jdField_c_of_type_Int != 0) && (paramVideoInfo.jdField_b_of_type_Int != 0))
      {
        if (paramVideoInfo.jdField_c_of_type_Int <= paramVideoInfo.jdField_b_of_type_Int) {
          break label1537;
        }
        paramString1.int32_scene_id.set(2);
      }
      if (paramArrayList != null) {
        break label1549;
      }
      paramString1.int32_req_type.set(0);
      bool = false;
      paramString3.msg_ad_req_info.set(paramString1);
      paramString1 = new GdtDeviceInfoHelper.Params();
      paramString1.jdField_a_of_type_JavaLangString = "ce2d9f";
      paramString1 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), paramString1);
      if (paramString1 == null) {
        break label1613;
      }
      paramString1 = paramString1.a;
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("carrier_code", AdDeviceInfoUtil.b());
        ((JSONObject)localObject1).put("softAdExpoCounts", paramInt5);
        if (StudyModeManager.a()) {
          ((JSONObject)localObject1).put("reqLearningPatternFlag", 1);
        }
        localObject2 = new JSONObject();
        localJSONObject = new JSONObject();
        localObject3 = SoftAdExpoStatManager.a().a();
        if ((localObject3 == null) || (((Map)localObject3).size() <= 0)) {
          break label1619;
        }
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localEntry = (Map.Entry)((Iterator)localObject3).next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        paramString3.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
      label639:
      if ((!VideoAdStrategyManager.d()) || (paramArrayList != null)) {
        localReqBody.req_advertise_para.set(paramString3);
      }
      localReqBody.uint32_req_dislike_type.set(1);
      paramString1 = localReqBody.uint32_req_vertical_video;
      if (!paramBoolean) {
        break label1997;
      }
      paramInt1 = 1;
      label700:
      paramString1.set(paramInt1);
      paramString1 = localReqBody.uint32_is_ugc;
      if (!paramVideoInfo.jdField_b_of_type_Boolean) {
        break label2003;
      }
      paramInt1 = 1;
      label725:
      paramString1.set(paramInt1);
      if (!TextUtils.isEmpty(paramString4)) {
        localReqBody.bytes_req_range_cookie.set(ByteStringMicro.copyFromUtf8(paramString4));
      }
      if (paramVideoInfo.jdField_b_of_type_Boolean)
      {
        paramString1 = new oidb_0x6cf.FeedsIdInfo();
        paramString1.uint64_feeds_id.set(paramVideoInfo.jdField_d_of_type_Long);
        paramString1.uint32_feeds_type.set(paramVideoInfo.jdField_h_of_type_Int);
        localReqBody.ugc_feeds_info.set(paramString1);
      }
      if ((paramWeishiRedDotInfo != null) && (paramWeishiRedDotInfo.a() != null) && (paramWeishiRedDotInfo.a().size() > 0)) {
        paramString1 = new ArrayList();
      }
    }
    for (;;)
    {
      try
      {
        paramString3 = ByteStringMicro.copyFromUtf8(paramWeishiRedDotInfo.a());
        paramInt1 = Integer.parseInt(paramWeishiRedDotInfo.c());
        paramLong1 = Long.parseLong(paramWeishiRedDotInfo.b());
        paramString4 = ByteStringMicro.copyFromUtf8(paramWeishiRedDotInfo.d());
        paramWeishiRedDotInfo = paramWeishiRedDotInfo.a().iterator();
        if (paramWeishiRedDotInfo.hasNext())
        {
          localObject1 = (String)paramWeishiRedDotInfo.next();
          localObject2 = new oidb_0x6cf.InnerMsg();
          ((oidb_0x6cf.InnerMsg)localObject2).bytes_title.set(paramString3);
          ((oidb_0x6cf.InnerMsg)localObject2).uint32_strategy_id.set(paramInt1);
          ((oidb_0x6cf.InnerMsg)localObject2).uint64_algorithm_id.set(paramLong1);
          ((oidb_0x6cf.InnerMsg)localObject2).bytes_push_context.set(paramString4);
          ((oidb_0x6cf.InnerMsg)localObject2).article_content_type.set(2);
          ((oidb_0x6cf.InnerMsg)localObject2).uint32_jump_src_type.set(10);
          ((oidb_0x6cf.InnerMsg)localObject2).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          paramString1.add(localObject2);
          continue;
        }
      }
      catch (Exception paramString3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList: 解析redDotInfo失败" + paramString3);
        }
        if (!paramString1.isEmpty()) {
          localReqBody.rpt_inner_msg_list.set(paramString1);
        }
        if (!QLog.isColorLevel())
        {
          if (paramArrayOfByte != null)
          {
            localReqBody.bytes_req_context_pb.set(ByteStringMicro.copyFrom(paramArrayOfByte));
            if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
            {
              paramArrayList1 = (VideoInfo)paramArrayList1.get(paramArrayList1.size() - 1);
              if (!TextUtils.isEmpty(paramArrayList1.jdField_g_of_type_JavaLangString)) {
                localReqBody.bytes_end_rowkey.set(ByteStringMicro.copyFromUtf8(paramArrayList1.jdField_g_of_type_JavaLangString));
              }
              localReqBody.uint64_end_recommend_seq.set(paramArrayList1.jdField_e_of_type_Long);
            }
          }
          localReqBody.uint32_req_times.set(paramInt3);
          localReqBody.uint32_req_network.set(b());
          localReqBody.uint32_req_os.set(1);
          localReqBody.uint32_req_sim_type.set(ReadInJoyHelper.d());
          localReqBody.uint32_req_column_id.set(paramInt2);
          localReqBody.enum_req_video_show_mode.set(paramInt6);
          paramArrayList1 = a();
          if (paramArrayList1 != null) {
            localReqBody.msg_position_info.set(paramArrayList1);
          }
          if ((paramArrayList2 == null) || (paramArrayList2.size() <= 0)) {
            break label2300;
          }
          paramArrayList1 = new oidb_0x6cf.UserExposeArticle();
          paramString1 = new ArrayList();
          paramString2 = paramArrayList2.iterator();
          if (!paramString2.hasNext()) {
            break label2280;
          }
          paramString3 = (VideoInfo)paramString2.next();
          if (TextUtils.isEmpty(paramString3.jdField_g_of_type_JavaLangString)) {
            continue;
          }
          paramWeishiRedDotInfo = new oidb_0x6cf.ExposeArticleInfo();
          paramWeishiRedDotInfo.bytes_rowkeys.set(ByteStringMicro.copyFromUtf8(paramString3.jdField_g_of_type_JavaLangString));
          paramWeishiRedDotInfo.uint64_algorithm_id.set(paramString3.jdField_f_of_type_Long);
          paramString1.add(paramWeishiRedDotInfo);
          continue;
          paramString1 = new ArrayList();
          int i = 0;
          paramInt1 = 0;
          if (paramInt1 < paramArrayList1.size())
          {
            localObject1 = (VideoInfo)paramArrayList1.get(paramInt1);
            if (!((VideoInfo)localObject1).jdField_c_of_type_Boolean)
            {
              i += 1;
              paramInt1 += 1;
              continue;
            }
            localObject2 = new oidb_0x6cf.AdVideoPos();
            if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
            {
              if (!TextUtils.isEmpty(((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString)) {
                ((oidb_0x6cf.AdVideoPos)localObject2).bytes_trace_id.set(ByteStringMicro.copyFromUtf8(((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString));
              }
              ((oidb_0x6cf.AdVideoPos)localObject2).uint64_aid.set(((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_e_of_type_Long);
            }
            ((oidb_0x6cf.AdVideoPos)localObject2).int32_kd_pos.set(paramInt1);
            paramString1.add(localObject2);
            continue;
          }
          paramString2.uint32_info_num.set(i);
          if (paramString1.size() <= 0) {
            break;
          }
          paramString2.rpt_msg_ad_video_pos.set(paramString1);
          break;
          label1537:
          paramString1.int32_scene_id.set(1);
          break label415;
          label1549:
          paramString1.int32_req_type.set(2);
          localObject1 = new oidb_0x885.GameComponentInfo();
          ((oidb_0x885.GameComponentInfo)localObject1).uint32_day_display_count.set(paramInt5);
          ((oidb_0x885.GameComponentInfo)localObject1).uint32_session_display_count.set(paramInt4);
          ((oidb_0x885.GameComponentInfo)localObject1).rpt_tag_info.set(paramArrayList);
          paramString1.msg_game_component_info.set((MessageMicro)localObject1);
          bool = true;
          break label432;
          label1613:
          paramString1 = null;
          break label481;
          label1619:
          ((JSONObject)localObject2).put("expo_stat", localJSONObject);
          localJSONObject = new JSONObject();
          localObject3 = SoftAdExpoStatManager.a().a(paramInt8, paramArrayList1);
          if ((localObject3 != null) && (!((Map)localObject3).isEmpty()))
          {
            localObject3 = ((Map)localObject3).entrySet().iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localEntry = (Map.Entry)((Iterator)localObject3).next();
              localJSONObject.put("" + localEntry.getKey(), localEntry.getValue());
              continue;
            }
          }
          ((JSONObject)localObject2).put("expo_stat_pre", localJSONObject);
          if (!SoftAdExpoStatManager.a().a()) {
            break label2499;
          }
          paramInt1 = 1;
          ((JSONObject)localObject2).put("soft_first_req", paramInt1);
          ((JSONObject)localObject2).put("last_expo_ad_pos", SoftAdExpoStatManager.a().a());
          ((JSONObject)localObject2).put("last_req_video_cnt", SoftAdExpoStatManager.a().b());
          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "softAdData:" + ((JSONObject)localObject2).toString());
          ((JSONObject)localObject1).put("softAdData", localObject2);
          if (paramString1 != null) {
            ((JSONObject)localObject1).put("device_ext", paramString1.device_ext.get());
          }
          if (AdExposeFreshManager.a().a())
          {
            localObject2 = AdReqFreshManager.a().a();
            paramString1 = new JSONArray();
            if ((localObject2 != null) && (((Set)localObject2).size() > 0))
            {
              localObject2 = ((Set)localObject2).iterator();
              if (((Iterator)localObject2).hasNext())
              {
                paramString1.put((Long)((Iterator)localObject2).next());
                continue;
              }
            }
            ((JSONObject)localObject1).put("noExposeList", paramString1);
          }
          ((JSONObject)localObject1).put("reqTimeVVAdload", 1);
          if ((VideoAdStrategyManager.jdField_a_of_type_Int != 2) || (!VideoAdStrategyManager.jdField_c_of_type_Boolean)) {
            break label639;
          }
          ((JSONObject)localObject1).put("videoTimeVV_VV", 1);
          break label639;
          label1997:
          paramInt1 = 0;
          break label700;
          label2003:
          paramInt1 = 0;
          break label725;
          if (paramString1.isEmpty()) {
            continue;
          }
          localReqBody.rpt_inner_msg_list.set(paramString1);
          continue;
        }
      }
      finally
      {
        if (!paramString1.isEmpty()) {
          localReqBody.rpt_inner_msg_list.set(paramString1);
        }
      }
      paramString1 = new StringBuilder("getRecommendList AdvertiseParam:\n");
      paramString1.append("last_time=").append(this.jdField_a_of_type_Long).append(", info_num=").append(paramString2.uint32_info_num.get());
      if ((paramString2.rpt_msg_ad_video_pos.has()) && (paramString2.rpt_msg_ad_video_pos.get() != null))
      {
        paramString1.append(", adList=\n");
        paramString2 = paramString2.rpt_msg_ad_video_pos.get().iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (oidb_0x6cf.AdVideoPos)paramString2.next();
          paramString1.append("[pos=").append(paramString3.int32_kd_pos.get()).append(", aid=").append(paramString3.uint64_aid.get()).append(", traceID=").append(paramString3.bytes_trace_id.get().toStringUtf8()).append("]\n");
        }
        if (paramArrayList != null) {
          paramString1.append(" request for softAd or gameComponent");
        }
      }
      for (;;)
      {
        ReadInJoyAdLog.a("AdVideoDataLink", paramString1.toString());
        break;
        paramString1.append("\n").append(" request for article and videoAd");
      }
      label2280:
      paramArrayList1.rpt_article.set(paramString1);
      localReqBody.user_expose_article.set(paramArrayList1);
      label2300:
      a(localReqBody);
      paramInt1 = ((Integer)ReadInJoyHelper.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue();
      localReqBody.uint32_youngster_status.set(paramInt1);
      localReqBody.uint32_req_recommend_flag.set(a());
      localReqBody.bytes_req_recommend_json.set(ByteStringMicro.copyFromUtf8(RIJStudyModeUtils.a()));
      if (paramBundle != null)
      {
        paramInt1 = paramBundle.getInt("video_feeds_req_sub_source", -1);
        if (paramInt1 == 7)
        {
          localReqBody.uint32_req_sub_source.set(paramInt1);
          paramArrayList1 = paramBundle.getString("video_column_topic_id", null);
          if (!TextUtils.isEmpty(paramArrayList1)) {
            localReqBody.uint32_req_column_id.set(Integer.parseInt(paramArrayList1));
          }
        }
      }
      paramArrayList1 = super.makeOIDBPkg("OidbSvc.0x6cf", 1743, 0, localReqBody.toByteArray());
      paramArrayList1.addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramObject.hashCode()));
      paramArrayList1.addAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID", paramVideoInfo.jdField_g_of_type_JavaLangString);
      paramArrayList1.addAttribute("VALUE_REQUEST_GAME_DATA", Boolean.valueOf(bool));
      paramArrayList1.setEnableFastResend(true);
      super.sendPbReq(paramArrayList1);
      return;
      label2499:
      paramInt1 = 0;
    }
  }
  
  private void a(String paramString, VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        VideoInfo.LocationInfo localLocationInfo = new VideoInfo.LocationInfo();
        paramString = new JSONObject(paramString);
        localLocationInfo.jdField_a_of_type_JavaLangString = paramString.optString("location_name", null);
        if (paramString.optInt("is_user_selected", 0) == 1)
        {
          localLocationInfo.jdField_a_of_type_Boolean = bool;
          if (!TextUtils.isEmpty(localLocationInfo.jdField_a_of_type_JavaLangString)) {
            paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo = localLocationInfo;
          }
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "locationInfoStr parse Error=" + paramString.toString());
      }
      bool = false;
    }
  }
  
  private void a(List<VideoInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    int i = 0;
    while (i < paramList.size())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramList.get(i);
      if ((localVideoInfo.jdField_c_of_type_Boolean) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_o_of_type_Int == 32))
      {
        localVideoInfo = AdExposeFreshManager.a().a("RIJAdRefreshSceneFloatVideo", localVideoInfo);
        paramList.set(i, localVideoInfo);
        localHashSet1.add(Long.valueOf(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_e_of_type_Long));
        localHashSet2.add(localVideoInfo);
      }
      i += 1;
    }
    AdReqFreshManager.a().a("RIJAdRefreshSceneFloatVideo", localHashSet1);
    AdExposeFreshManager.a().a("RIJAdRefreshSceneFloatVideo", localHashSet2);
  }
  
  private void a(oidb_0x6cf.ReqBody paramReqBody)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str = arrayOfString[i];
      oidb_0x6cf.PkgInstallInfo localPkgInstallInfo = new oidb_0x6cf.PkgInstallInfo();
      localPkgInstallInfo.bytes_pkg_name.set(ByteStringMicro.copyFromUtf8(str));
      str = PackageUtil.a(BaseApplicationImpl.getContext(), str);
      PBUInt32Field localPBUInt32Field = localPkgInstallInfo.uint32_is_installed;
      if (!str.equals("0")) {}
      for (int j = 1;; j = 0)
      {
        localPBUInt32Field.set(j);
        localPkgInstallInfo.bytes_version.set(ByteStringMicro.copyFromUtf8(str));
        localPkgInstallInfo.uint32_platform_type.set(1);
        localArrayList.add(localPkgInstallInfo);
        i += 1;
        break;
      }
    }
    paramReqBody.rpt_pkg_install_info.set(localArrayList);
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (paramVideoInfo.i != 2) {
        break;
      }
    } while ((!TextUtils.isEmpty(paramVideoInfo.p)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString)));
    while ((paramVideoInfo.i != 1) || (TextUtils.isEmpty(paramVideoInfo.p)) || (TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  private int b()
  {
    switch (NetworkUtil.a(BaseApplicationImpl.getApplication().getApplicationContext()))
    {
    case 2: 
    default: 
      return 2;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  private VideoInfo b(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
  {
    localVideoInfo = new VideoInfo();
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localVideoInfo.jdField_c_of_type_JavaLangString = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    String str1 = a(paramRspBody.bytes_rsp_ug_interface_data);
    try
    {
      Object localObject1 = new JSONObject(((JSONObject)new JSONObject(str1).getJSONArray("items").get(0)).getString("extData"));
      localObject4 = null;
      try
      {
        localObject5 = ((JSONObject)new JSONObject(str1).getJSONArray("items").get(0)).getJSONObject("privateInfo");
        localObject4 = localObject5;
      }
      catch (Exception localException3)
      {
        Object localObject5;
        label128:
        break label128;
      }
      localObject5 = null;
      try
      {
        str1 = ((JSONObject)new JSONObject(str1).getJSONArray("items").get(0)).getString("backoffGroup");
        localObject5 = str1;
      }
      catch (Exception localException5)
      {
        label165:
        Object localObject6;
        int i;
        int j;
        label1079:
        label1223:
        break label165;
      }
      if ((localObject1 != null) && (localObject4 != null) && (!TextUtils.isEmpty((CharSequence)localObject5))) {}
      try
      {
        str1 = ((JSONObject)localObject1).optString("top_base_pic");
        localObject6 = ((JSONObject)localObject1).optString("top_redenv_pic");
        str2 = ((JSONObject)localObject1).optString("top_txt_showpic");
        str3 = ((JSONObject)localObject1).optString("top_close_pic");
        str4 = ((JSONObject)localObject1).optString("download_word_color");
        str5 = ((JSONObject)localObject1).optString("apk_link");
        str6 = ((JSONObject)localObject4).getJSONObject(a(paramArticleSummary.bytes_kb_id)).optString("deepLink");
        str7 = ((JSONObject)localObject1).optString("clipboard_data");
        str8 = (String)((JSONObject)localObject4).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getJSONObject("statInfo").getJSONArray("999").get(0);
        str9 = ((JSONObject)localObject1).optString("pkg_name");
        str10 = ((JSONObject)localObject1).optString("top_downloading_txt");
        str11 = ((JSONObject)localObject1).optString("top_dldparse_txt");
        str12 = ((JSONObject)localObject1).optString("top_downloaded_txt");
        i = ((JSONObject)localObject1).optInt("max_click_num");
        j = ((JSONObject)localObject1).optInt("max_exposure_num");
        k = ((JSONObject)localObject4).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getInt("useUG");
        if (k == 2) {
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)))
          {
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo = new VideoInfo.UGDownloadInfo();
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_JavaLangString = str1;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_JavaLangString = str2;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_d_of_type_JavaLangString = str3;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_e_of_type_JavaLangString = str4;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_f_of_type_JavaLangString = str5;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_g_of_type_JavaLangString = str6;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_h_of_type_JavaLangString = str7;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i = str8;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_j_of_type_JavaLangString = str9;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_k_of_type_JavaLangString = str10;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_l_of_type_JavaLangString = str11;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_m_of_type_JavaLangString = str12;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_Int = i;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_Int = j;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_n_of_type_JavaLangString = ((String)localObject5);
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int = k;
          }
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          String str2;
          String str3;
          String str4;
          String str5;
          String str6;
          String str7;
          String str8;
          String str9;
          String str10;
          String str11;
          String str12;
          int k;
          Object localObject2;
          continue;
          if ((k == 1) && (!TextUtils.isEmpty(localException4)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)) && (!TextUtils.isEmpty(str10)) && (!TextUtils.isEmpty(str11)) && (!TextUtils.isEmpty(str12)))
          {
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo = new VideoInfo.UGDownloadInfo();
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_JavaLangString = localException4;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_JavaLangString = str2;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_d_of_type_JavaLangString = str3;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_e_of_type_JavaLangString = str4;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_f_of_type_JavaLangString = str5;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_g_of_type_JavaLangString = str6;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_h_of_type_JavaLangString = str7;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i = str8;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_j_of_type_JavaLangString = str9;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_k_of_type_JavaLangString = str10;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_l_of_type_JavaLangString = str11;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_m_of_type_JavaLangString = str12;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_Int = i;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_Int = j;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_n_of_type_JavaLangString = ((String)localObject5);
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int = k;
          }
        }
      }
      try
      {
        str1 = ((JSONObject)localObject1).optString("shoot_base_pic");
        localObject6 = ((JSONObject)localObject1).optString("shoot_redenv_pic");
        str2 = ((JSONObject)localObject1).optString("shoot_txt_showpic");
        str3 = ((JSONObject)localObject1).optString("shoot_close_pic");
        str4 = ((JSONObject)localObject1).optString("download_word_color");
        str5 = ((JSONObject)localObject1).optString("apk_link");
        str6 = ((JSONObject)localObject4).getJSONObject(a(paramArticleSummary.bytes_kb_id)).optString("deepLink");
        str7 = ((JSONObject)localObject1).optString("clipboard_data");
        str8 = (String)((JSONObject)localObject4).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getJSONObject("statInfo").getJSONArray("999").get(0);
        str9 = ((JSONObject)localObject1).optString("pkg_name");
        str10 = ((JSONObject)localObject1).optString("shoot_downloading_txt");
        str11 = ((JSONObject)localObject1).optString("shoot_dldparse_txt");
        str12 = ((JSONObject)localObject1).optString("shoot_downloaded_txt");
        i = ((JSONObject)localObject1).optInt("max_click_num");
        j = ((JSONObject)localObject1).optInt("max_exposure_num");
        k = ((JSONObject)localObject4).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getInt("useUG");
        if (k != 2) {
          break label1521;
        }
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)))
        {
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo = new VideoInfo.UGDownloadInfo();
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_JavaLangString = str1;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_JavaLangString = str2;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_d_of_type_JavaLangString = str3;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_e_of_type_JavaLangString = str4;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_f_of_type_JavaLangString = str5;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_g_of_type_JavaLangString = str6;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_h_of_type_JavaLangString = str7;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i = str8;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_j_of_type_JavaLangString = str9;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_k_of_type_JavaLangString = str10;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_l_of_type_JavaLangString = str11;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_m_of_type_JavaLangString = str12;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_Int = i;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_Int = j;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_n_of_type_JavaLangString = ((String)localObject5);
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int = k;
        }
      }
      catch (Exception localException2)
      {
        break label1079;
        localVideoInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
        break label1223;
        if ((!paramArticleSummary.uint64_time.has()) || (paramArticleSummary.uint64_time.get() == 0L)) {
          break label1878;
        }
        localVideoInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramArticleSummary.uint64_time.get() * 1000L));
        localVideoInfo.jdField_a_of_type_Long = paramArticleSummary.uint64_time.get();
        if ((!paramArticleSummary.bytes_subscribe_id.has()) || (paramArticleSummary.bytes_subscribe_id.get() == null)) {
          break label1913;
        }
        localVideoInfo.jdField_j_of_type_JavaLangString = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_subscribe_name.has()) || (paramArticleSummary.bytes_subscribe_name.get() == null)) {
          break label1948;
        }
        localVideoInfo.jdField_k_of_type_JavaLangString = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_article_content_url.has()) || (paramArticleSummary.bytes_article_content_url.get() == null)) {
          break label1983;
        }
        localVideoInfo.jdField_f_of_type_JavaLangString = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_aio_share_url.has()) || (paramArticleSummary.bytes_aio_share_url.get() == null)) {
          break label2018;
        }
        localVideoInfo.jdField_m_of_type_JavaLangString = paramArticleSummary.bytes_aio_share_url.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_qzone_share_url.has()) || (paramArticleSummary.bytes_qzone_share_url.get() == null)) {
          break label2053;
        }
        localVideoInfo.jdField_n_of_type_JavaLangString = paramArticleSummary.bytes_qzone_share_url.get().toStringUtf8();
        if (!paramArticleSummary.uint32_strategy_id.has()) {
          break label2075;
        }
        localVideoInfo.jdField_s_of_type_Int = paramArticleSummary.uint32_strategy_id.get();
        if (!paramArticleSummary.uint64_algorithm_id.has()) {
          break label2097;
        }
        localVideoInfo.jdField_f_of_type_Long = paramArticleSummary.uint64_algorithm_id.get();
        if ((!paramArticleSummary.bytes_recommend_reason.has()) || (paramArticleSummary.bytes_recommend_reason.get() == null)) {
          break label2132;
        }
        localVideoInfo.jdField_h_of_type_JavaLangString = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
        if (!paramArticleSummary.uint32_video_comment_count.has()) {
          break label2154;
        }
        localVideoInfo.jdField_e_of_type_Int = paramArticleSummary.uint32_video_comment_count.get();
        if (!paramArticleSummary.uint32_like_count.has()) {
          break label2176;
        }
        localVideoInfo.jdField_v_of_type_Int = paramArticleSummary.uint32_like_count.get();
        if (!paramArticleSummary.uint32_biu_count.has()) {
          break label2198;
        }
        localVideoInfo.jdField_f_of_type_Int = paramArticleSummary.uint32_biu_count.get();
        if (!paramArticleSummary.uint32_ads_guide_time.has()) {
          break label2220;
        }
        localVideoInfo.jdField_j_of_type_Int = paramArticleSummary.uint32_ads_guide_time.get();
        if (!paramArticleSummary.uint32_ads_jump_type.has()) {
          break label2242;
        }
        localVideoInfo.jdField_k_of_type_Int = paramArticleSummary.uint32_ads_jump_type.get();
        if (!paramArticleSummary.uint32_video_source_type.has()) {
          break label2273;
        }
        if (paramArticleSummary.uint32_video_source_type.get() != 1) {
          break label3804;
        }
        boolean bool = true;
        for (;;)
        {
          localVideoInfo.jdField_f_of_type_Boolean = bool;
          if (!paramArticleSummary.uint32_account_grade.has()) {
            break label2304;
          }
          if (paramArticleSummary.uint32_account_grade.get() != 1) {
            break label3810;
          }
          bool = true;
          localVideoInfo.jdField_a_of_type_Boolean = bool;
          if (!paramArticleSummary.uint32_myself_like_status.has()) {
            break label2335;
          }
          if (paramArticleSummary.uint32_myself_like_status.get() != 1) {
            break label3816;
          }
          bool = true;
          localVideoInfo.jdField_r_of_type_Boolean = bool;
          if (!paramArticleSummary.bytes_video_report_info.has()) {
            break label2358;
          }
          localVideoInfo.w = a(paramArticleSummary.bytes_video_report_info);
          if (!paramArticleSummary.uint64_article_id.has()) {
            break label2380;
          }
          localVideoInfo.jdField_c_of_type_Long = paramArticleSummary.uint64_article_id.get();
          if (!paramArticleSummary.uint32_trigger_sec.has()) {
            break label2402;
          }
          localVideoInfo.jdField_n_of_type_Int = paramArticleSummary.uint32_trigger_sec.get();
          if ((!paramArticleSummary.msg_top_bar_info.has()) || (paramArticleSummary.msg_top_bar_info.get() == null)) {
            break label2622;
          }
          Object localObject3 = paramArticleSummary.msg_top_bar_info;
          localObject4 = new VideoInfo.TopBarInfo();
          ((VideoInfo.TopBarInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
          if (!((oidb_0x6cf.TopBarInfo)localObject3).uint32_topbar_id.has()) {
            break label3822;
          }
          i = ((oidb_0x6cf.TopBarInfo)localObject3).uint32_topbar_id.get();
          ((VideoInfo.TopBarInfo)localObject4).jdField_a_of_type_Int = i;
          ((VideoInfo.TopBarInfo)localObject4).jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_icon_url);
          ((VideoInfo.TopBarInfo)localObject4).jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_title);
          ((VideoInfo.TopBarInfo)localObject4).jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_common_data);
          ((VideoInfo.TopBarInfo)localObject4).jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_background_url);
          ((VideoInfo.TopBarInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_jump_url);
          localObject5 = ((VideoInfo.TopBarInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo;
          if (!((oidb_0x6cf.TopBarInfo)localObject3).uint32_jump_type.has()) {
            break label3827;
          }
          i = ((oidb_0x6cf.TopBarInfo)localObject3).uint32_jump_type.get();
          ((UrlJumpInfo)localObject5).jdField_a_of_type_Int = i;
          ((VideoInfo.TopBarInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_ios_jump_bundle);
          ((VideoInfo.TopBarInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_jump_schema);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)localObject4);
          if ((!paramArticleSummary.msg_download_bar_info.has()) || (paramArticleSummary.msg_download_bar_info.get() == null)) {
            break label2786;
          }
          localObject3 = paramArticleSummary.msg_download_bar_info;
          localObject4 = new VideoInfo.DownloadBarInfo();
          ((VideoInfo.DownloadBarInfo)localObject4).jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_logo_url);
          if (!((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_appear_time.has()) {
            break label3832;
          }
          i = ((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_appear_time.get();
          ((VideoInfo.DownloadBarInfo)localObject4).jdField_a_of_type_Int = i;
          if (!((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_button_bg_color.has()) {
            break label3837;
          }
          i = ((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_button_bg_color.get();
          ((VideoInfo.DownloadBarInfo)localObject4).jdField_b_of_type_Int = i;
          ((VideoInfo.DownloadBarInfo)localObject4).jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_download_button_text);
          ((VideoInfo.DownloadBarInfo)localObject4).jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_open_button_text);
          ((VideoInfo.DownloadBarInfo)localObject4).jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_common_data);
          ((VideoInfo.DownloadBarInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(((oidb_0x6cf.DownloadBarInfo)localObject3).msg_url_jump_info);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)localObject4);
          if ((!paramArticleSummary.json_video_list.has()) || (paramArticleSummary.json_video_list.get() == null)) {
            break label3175;
          }
          try
          {
            localVideoInfo.jdField_l_of_type_JavaLangString = paramArticleSummary.json_video_list.get().toStringUtf8();
            localObject3 = new JSONObject(paramArticleSummary.json_video_list.get().toStringUtf8()).getJSONArray("videos").optJSONObject(0);
            if (localObject3 == null) {
              break label3175;
            }
            localVideoInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("vid");
            if (!((JSONObject)localObject3).has("width")) {
              break label2892;
            }
            localVideoInfo.jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("width");
            if (!((JSONObject)localObject3).has("height")) {
              break label2916;
            }
            localVideoInfo.jdField_c_of_type_Int = ((JSONObject)localObject3).getInt("height");
            if (!((JSONObject)localObject3).has("duration")) {
              break label2943;
            }
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              localVideoInfo.jdField_d_of_type_Int = Integer.parseInt(((JSONObject)localObject3).optString("duration"));
              localVideoInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("picture");
              if (!((JSONObject)localObject3).has("innerUniqueID")) {
                break label2980;
              }
              localVideoInfo.jdField_g_of_type_JavaLangString = ((JSONObject)localObject3).optString("innerUniqueID");
              localVideoInfo.jdField_a_of_type_Int = 1;
              if (!((JSONObject)localObject3).has("busiType")) {
                break label3010;
              }
              localVideoInfo.jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("busiType");
              localVideoInfo.jdField_o_of_type_JavaLangString = ((JSONObject)localObject3).optString("thirdAction");
              localVideoInfo.p = ((JSONObject)localObject3).optString("thirdIcon");
              localVideoInfo.jdField_q_of_type_JavaLangString = ((JSONObject)localObject3).optString("thirdUinName");
              if (TextUtils.isEmpty(((JSONObject)localObject3).optString("thirdName"))) {
                break label3076;
              }
              localVideoInfo.jdField_k_of_type_JavaLangString = ((JSONObject)localObject3).optString("thirdName");
              if (TextUtils.isEmpty(((JSONObject)localObject3).optString("third_uin"))) {
                break label3103;
              }
              localVideoInfo.jdField_j_of_type_JavaLangString = ((JSONObject)localObject3).optString("third_uin");
              localObject3 = ((JSONObject)localObject3).optJSONArray("video_info");
              if (localObject3 == null) {
                break label3175;
              }
              i = 0;
              if (i >= ((JSONArray)localObject3).length()) {
                break label3175;
              }
              localObject4 = ((JSONArray)localObject3).optJSONObject(i);
              if (localObject4 == null) {
                break label3875;
              }
              j = ((JSONObject)localObject4).optInt("network_type");
              l = ((JSONObject)localObject4).optLong("file_size");
              if (j != 2) {
                break label3875;
              }
              localVideoInfo.jdField_b_of_type_Long = l;
              if ((!paramArticleSummary.uint32_is_ugc.has()) || (paramArticleSummary.uint32_is_ugc.get() != 1)) {
                break label3921;
              }
              localVideoInfo.jdField_b_of_type_Boolean = true;
              if ((!paramArticleSummary.msg_ugc_feeds_info.has()) || (paramArticleSummary.msg_ugc_feeds_info.get() == null)) {
                break label3921;
              }
              localObject3 = (oidb_0x6cf.UGCFeedsInfo)paramArticleSummary.msg_ugc_feeds_info.get();
              if ((!((oidb_0x6cf.UGCFeedsInfo)localObject3).ugc_feeds_info.has()) || (((oidb_0x6cf.UGCFeedsInfo)localObject3).ugc_feeds_info.get() == null)) {
                break label3317;
              }
              localObject4 = (oidb_0x6cf.FeedsIdInfo)((oidb_0x6cf.UGCFeedsInfo)localObject3).ugc_feeds_info.get();
              if (!((oidb_0x6cf.FeedsIdInfo)localObject4).uint64_feeds_id.has()) {
                break label3293;
              }
              localVideoInfo.jdField_d_of_type_Long = ((oidb_0x6cf.FeedsIdInfo)localObject4).uint64_feeds_id.get();
              if (!((oidb_0x6cf.FeedsIdInfo)localObject4).uint32_feeds_type.has()) {
                break label3317;
              }
              localVideoInfo.jdField_h_of_type_Int = ((oidb_0x6cf.FeedsIdInfo)localObject4).uint32_feeds_type.get();
              if (!((oidb_0x6cf.UGCFeedsInfo)localObject3).uint32_follow_status.has()) {
                break label3350;
              }
              if (((oidb_0x6cf.UGCFeedsInfo)localObject3).uint32_follow_status.get() != 2) {
                break label3882;
              }
              bool = true;
              localVideoInfo.jdField_q_of_type_Boolean = bool;
              if (!((oidb_0x6cf.UGCFeedsInfo)localObject3).uint64_cuin.has()) {
                break label3377;
              }
              localVideoInfo.jdField_j_of_type_JavaLangString = String.valueOf(((oidb_0x6cf.UGCFeedsInfo)localObject3).uint64_cuin.get());
              if ((!((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_ugc_video_info_list.has()) || (((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_ugc_video_info_list.get() == null)) {
                break label3567;
              }
              localObject4 = (oidb_0x6cf.UGCVideoInfo)((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_ugc_video_info_list.get();
              localVideoInfo.jdField_r_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_video_url);
              localVideoInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_pic_url);
              localVideoInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_title);
              localVideoInfo.jdField_d_of_type_Int = ((int)(((oidb_0x6cf.UGCVideoInfo)localObject4).uint64_duration.get() / 1000L));
              localVideoInfo.jdField_b_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_video_width.get();
              localVideoInfo.jdField_c_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_video_height.get();
              localVideoInfo.jdField_g_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_uniq_id);
              localVideoInfo.jdField_a_of_type_Long = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_create_time.get();
              localVideoInfo.jdField_f_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_share_url);
              localVideoInfo.jdField_a_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_busi_type.get();
              localVideoInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_vid);
              if (!((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_at_multi_level.has()) {
                break label3895;
              }
              localObject4 = new ArrayList();
              localObject5 = (oidb_0x6cf.BiuMultiLevel)((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_at_multi_level.get();
              if ((!((oidb_0x6cf.BiuMultiLevel)localObject5).rpt_biu_mutli_level.has()) || (((oidb_0x6cf.BiuMultiLevel)localObject5).rpt_biu_mutli_level.isEmpty())) {
                break label3888;
              }
              localObject5 = ((oidb_0x6cf.BiuMultiLevel)localObject5).rpt_biu_mutli_level.get();
              if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
                break label3888;
              }
              localObject5 = ((List)localObject5).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                oidb_0x6cf.BiuOneLevelItem localBiuOneLevelItem = (oidb_0x6cf.BiuOneLevelItem)((Iterator)localObject5).next();
                localObject6 = new VideoInfo.RichTitleInfo();
                ((VideoInfo.RichTitleInfo)localObject6).jdField_a_of_type_JavaLangString = a(localBiuOneLevelItem.bytes_biu_comments);
                if (localBiuOneLevelItem.msg_jump_info.has())
                {
                  ((VideoInfo.RichTitleInfo)localObject6).jdField_b_of_type_JavaLangString = String.valueOf(((oidb_0x6cf.JumpInfo)localBiuOneLevelItem.msg_jump_info.get()).uint64_id);
                  ((VideoInfo.RichTitleInfo)localObject6).jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.JumpInfo)localBiuOneLevelItem.msg_jump_info.get()).bytes_wording);
                  ((VideoInfo.RichTitleInfo)localObject6).jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.JumpInfo)localBiuOneLevelItem.msg_jump_info.get()).bytes_jump_url);
                }
                ((VideoInfo.RichTitleInfo)localObject6).jdField_a_of_type_Int = localBiuOneLevelItem.op_type.get();
                ((ArrayList)localObject4).add(localObject6);
              }
              bool = false;
              continue;
              bool = false;
              break label2297;
              bool = false;
              break label2328;
              i = -1;
              break label2469;
              i = 0;
              break label2575;
              i = 0;
              break label2691;
              i = 0;
              break label2717;
              localJSONException1 = localJSONException1;
              if (!QLog.isColorLevel()) {
                break label3859;
              }
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, jsonVideoList 解析出错");
              localAdvertisementInfo = null;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              long l;
              for (;;)
              {
                localNumberFormatException.printStackTrace();
                continue;
                i += 1;
                continue;
                bool = false;
              }
              localVideoInfo.jdField_d_of_type_JavaUtilArrayList = localNumberFormatException;
              if (!localAdvertisementInfo.bytes_location_info.has()) {
                break label3921;
              }
              a(a(localAdvertisementInfo.bytes_location_info), localVideoInfo);
              if ((!paramArticleSummary.msg_feeds_info.has()) || (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).feeds_type.get() != 1)) {
                break label4373;
              }
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = new VideoAdInfo(this.jdField_a_of_type_Long, (oidb_0x6cf.PosAdInfo)((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).msg_pos_ad_info.get());
              if (!((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.has()) {
                break label4029;
              }
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.a(((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.get());
              if (!QLog.isColorLevel()) {
                break label4068;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList recv adInfo=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.toString());
              localVideoInfo.jdField_c_of_type_Boolean = true;
              i = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_g_of_type_Int;
              if (i != 65) {
                break label4145;
              }
              localVideoInfo.i = 2;
              if (a(localVideoInfo)) {
                break label4270;
              }
              if (!QLog.isColorLevel()) {
                break label4143;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidImageAd traceID=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
              return null;
              if ((i != 185) && (i != 350) && (i != 450) && (i != 1122)) {
                break label4229;
              }
              localVideoInfo.i = 1;
              if (a(localVideoInfo)) {
                break label4270;
              }
              if (!QLog.isColorLevel()) {
                break label4227;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidVideoAd traceID=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
              return null;
              if (!QLog.isColorLevel()) {
                break label4268;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isUnknownTypeAd traceID=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
              return null;
              AdvertisementInfo localAdvertisementInfo = NativeAdUtils.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
              if (!ReadInJoyAdSwitchUtil.a(null, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
                break label4365;
              }
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("svrresp_result", 0);
                localJSONObject.put("svrresp_count", 1);
                NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(80).b(13).a(localAdvertisementInfo).a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).b(localJSONObject));
                ReadInJoyAdUtils.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
                localVideoInfo.u = a(paramArticleSummary.bytes_video_logo_url);
                if (!paramArticleSummary.msg_account_v_info.has()) {
                  break label4459;
                }
                if (paramArticleSummary.msg_account_v_info.uint32_is_unowned.get() != 1) {
                  break label4927;
                }
                bool = true;
                localVideoInfo.jdField_m_of_type_Boolean = bool;
                localVideoInfo.jdField_o_of_type_Int = paramArticleSummary.msg_account_v_info.uint32_follow_count.get();
                if (paramArticleSummary.msg_account_v_info.uint32_is_show_follow.get() != 1) {
                  break label4933;
                }
                bool = true;
                localVideoInfo.jdField_k_of_type_Boolean = bool;
                if (!paramArticleSummary.msg_like_download_bar_info.has()) {
                  break label4707;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = new VideoInfo.LikeActionDownloadBar();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_b_of_type_JavaLangString = a(paramArticleSummary.msg_like_download_bar_info.bytes_bar_text);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_JavaLangString = a(paramArticleSummary.msg_like_download_bar_info.bytes_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString = a(paramArticleSummary.msg_like_download_bar_info.bytes_common_data);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).uint32_jump_type.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_bundle);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_schema);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_clipboard_info);
                if (!paramArticleSummary.msg_soft_ad_download_bar_info.has()) {
                  break label4898;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = new VideoInfo.SoftAdDownloadBarInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_title);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_sub_title);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_c_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_d_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_big_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_change_bigger_position.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramArticleSummary.msg_soft_ad_download_bar_info.msg_url_jump_info);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_Int = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_small_game_play_count.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_e_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_game_rsp_pack);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo = SmallMiniGameInfo.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_e_of_type_JavaLangString);
                if ((!localVideoInfo.jdField_c_of_type_Boolean) || (localVideoInfo.i != 2)) {
                  break label4939;
                }
                return null;
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  localJSONException2.printStackTrace();
                  continue;
                  bool = false;
                  continue;
                  bool = false;
                }
                if (!paramArticleSummary.msg_ecommerce_entrance_info.has()) {
                  break label5627;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = new VideoInfo.ECommerceEntranceInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_title);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_subtitle);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_thumbnail_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_d_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_link_icon_url);
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
                  break label5068;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
                  break label5099;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_g_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
                  break label5130;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_d_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
                  break label5161;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_f_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
                  break label5192;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_e_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_e_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_jump_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_f_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_common_data);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.video_play_length.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_style.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.appInfo.has()) {
                  break label5588;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_g_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
                if (!QLog.isColorLevel()) {
                  break label5627;
                }
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "commerceEntranceInfo: " + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.toString());
                if ((!paramRspBody.msg_ecommerce_entrance_config.has()) || (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) || (!paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has())) {
                  break label5676;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_Int = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
                localVideoInfo.x = a(paramArticleSummary.bytes_avatar_jump_url);
                if (!paramArticleSummary.uint64_recommend_seq.has()) {
                  break label6321;
                }
                l = paramArticleSummary.uint64_recommend_seq.get();
                localVideoInfo.jdField_e_of_type_Long = l;
                if (!paramArticleSummary.uint32_is_first_page_use_gif.has()) {
                  break label5746;
                }
                if (paramArticleSummary.uint32_is_first_page_use_gif.get() != 1) {
                  break label6327;
                }
                bool = true;
                localVideoInfo.jdField_g_of_type_Boolean = bool;
                localVideoInfo.jdField_s_of_type_JavaLangString = a(paramArticleSummary.bytes_first_page_gif_url);
                if (!paramArticleSummary.uint32_is_no_show_cover.has()) {
                  break label5789;
                }
                if (paramArticleSummary.uint32_is_no_show_cover.get() != 0) {
                  break label6333;
                }
                bool = true;
                localVideoInfo.jdField_h_of_type_Boolean = bool;
                VideoFeedsHelper.a(localVideoInfo);
                VideoFeedsAdTagHelper.a(paramArticleSummary, localVideoInfo);
                if (!paramArticleSummary.video_column_info.has()) {
                  break label6051;
                }
                paramRspBody = new VideoColumnInfo();
                paramRspBody.jdField_a_of_type_Int = paramArticleSummary.video_column_info.uint32_column_id.get();
                paramRspBody.jdField_b_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_column_name);
                paramRspBody.jdField_c_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_column_icon_url);
                paramRspBody.jdField_c_of_type_Int = paramArticleSummary.video_column_info.uint32_subscribe_count.get();
                if (paramArticleSummary.video_column_info.uint32_is_subscribed.get() != 1) {
                  break label6339;
                }
                bool = true;
                paramRspBody.jdField_a_of_type_Boolean = bool;
                paramRspBody.jdField_g_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_app_name);
                paramRspBody.jdField_h_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_app_icon_url);
                paramRspBody.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramArticleSummary.video_column_info.subscribe_jump_info);
                paramRspBody.d = a(paramArticleSummary.video_column_info.app_jump_info);
                paramRspBody.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramArticleSummary.video_column_info.default_jump_info);
                paramRspBody.jdField_e_of_type_Int = paramArticleSummary.video_column_info.uint32_style.get();
                paramRspBody.i = a(paramArticleSummary.video_column_info.bytes_from_txt);
                paramRspBody.jdField_b_of_type_Int = paramArticleSummary.video_column_info.uint32_video_count.get();
                paramRspBody.jdField_a_of_type_Long = paramArticleSummary.video_column_info.uint64_last_update_time.get();
                paramRspBody.jdField_f_of_type_Int = paramArticleSummary.video_column_info.uint32_update_count.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = paramRspBody;
                if ((!paramArticleSummary.uint32_forbid_reprint_flag.has()) || (paramArticleSummary.uint32_forbid_reprint_flag.get() != 1)) {
                  break label6345;
                }
                bool = true;
                localVideoInfo.jdField_l_of_type_Boolean = bool;
                localVideoInfo.jdField_v_of_type_JavaLangString = a(paramArticleSummary.bytes_wechat_share_url);
                if (paramArticleSummary.is_pgc_ahthor.get() != 1) {
                  break label6351;
                }
                for (bool = true;; bool = false)
                {
                  localVideoInfo.jdField_n_of_type_Boolean = bool;
                  paramRspBody = a(paramArticleSummary.bytes_title_with_topic);
                  if (!TextUtils.isEmpty(paramRspBody))
                  {
                    localVideoInfo.a(paramRspBody);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "decodeArticleSummary: richTitleJson=" + paramRspBody);
                    }
                  }
                  if (paramArticleSummary.msg_subscript_20.get() != null)
                  {
                    paramRspBody = a(paramArticleSummary.msg_subscript_20.bytes_subscript_txt);
                    if (!TextUtils.isEmpty(paramRspBody))
                    {
                      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo = new VideoInfo.SubscriptInfo();
                      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_a_of_type_JavaLangString = paramRspBody;
                      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_c_of_type_Int = paramArticleSummary.msg_subscript_20.uint32_subscript_type.get();
                      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_a_of_type_Int = Color.parseColor(a(paramArticleSummary.msg_subscript_20.bytes_subscript_color));
                      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_b_of_type_Int = Color.parseColor(a(paramArticleSummary.msg_subscript_20.bytes_background_color));
                    }
                  }
                  if (paramArticleSummary.uint32_share_count.has()) {
                    localVideoInfo.jdField_r_of_type_Int = paramArticleSummary.uint32_share_count.get();
                  }
                  a(a(paramArticleSummary.bytes_location_info), localVideoInfo);
                  return localVideoInfo;
                  l = 0L;
                  break;
                  bool = false;
                  break label5739;
                  bool = false;
                  break label5782;
                  bool = false;
                  break label5893;
                  bool = false;
                  break label6075;
                }
              }
            }
          }
        }
      }
      if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
        localVideoInfo.jdField_d_of_type_JavaLangString = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
      }
      if ((paramArticleSummary.rpt_dislike_list.has()) && (paramArticleSummary.rpt_dislike_list.get() != null))
      {
        localObject1 = paramArticleSummary.rpt_dislike_list.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          j = ((List)localObject1).size();
          localVideoInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label1818;
            }
            localObject4 = new DislikeInfo();
            ((DislikeInfo)localObject4).a((oidb_0x6cf.DisLikeInfo)((List)localObject1).get(i));
            if (!TextUtils.isEmpty(((DislikeInfo)localObject4).jdField_a_of_type_JavaLangString)) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject2 = null;
        continue;
        if ((k == 1) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)) && (!TextUtils.isEmpty(str10)) && (!TextUtils.isEmpty(str11)) && (!TextUtils.isEmpty(str12)))
        {
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo = new VideoInfo.UGDownloadInfo();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_JavaLangString = str1;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_JavaLangString = str2;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_d_of_type_JavaLangString = str3;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_e_of_type_JavaLangString = str4;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_f_of_type_JavaLangString = str5;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_g_of_type_JavaLangString = str6;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_h_of_type_JavaLangString = str7;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i = str8;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_j_of_type_JavaLangString = str9;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_k_of_type_JavaLangString = str10;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_l_of_type_JavaLangString = str11;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_m_of_type_JavaLangString = str12;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_Int = i;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_Int = j;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_n_of_type_JavaLangString = ((String)localObject5);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int = k;
        }
      }
    }
  }
  
  public VideoInfo.EntranceDownloadInfo a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    boolean bool = false;
    if (paramEntranceDownloadInfo == null) {
      return null;
    }
    VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = new VideoInfo.EntranceDownloadInfo();
    localEntranceDownloadInfo.jdField_a_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_icon_url);
    localEntranceDownloadInfo.jdField_b_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_small_icon_url);
    if (paramEntranceDownloadInfo.uint32_is_use_gif.has()) {}
    for (int i = paramEntranceDownloadInfo.uint32_is_use_gif.get();; i = 0)
    {
      if (i > 0) {
        bool = true;
      }
      localEntranceDownloadInfo.jdField_a_of_type_Boolean = bool;
      localEntranceDownloadInfo.jdField_c_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_common_data);
      localEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramEntranceDownloadInfo.msg_url_jump_info);
      return localEntranceDownloadInfo;
    }
  }
  
  public UrlJumpInfo a(oidb_0x6cf.UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      if (paramUrlJumpInfo.uint32_jump_type.has()) {}
      for (int i = paramUrlJumpInfo.uint32_jump_type.get();; i = 0)
      {
        localUrlJumpInfo.jdField_a_of_type_Int = i;
        localUrlJumpInfo.jdField_c_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_schema);
        localUrlJumpInfo.jdField_b_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_bundle);
        localUrlJumpInfo.jdField_a_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_url);
        localUrlJumpInfo.jdField_d_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_clipboard_info);
        localUrlJumpInfo.jdField_e_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_common_data);
        return localUrlJumpInfo;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, ArrayList<VideoInfo> paramArrayList2, int paramInt5)
  {
    a(paramVideoPlayRecommendObserver, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramArrayList2, null, paramInt5);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, ArrayList<VideoInfo> paramArrayList2, Bundle paramBundle, int paramInt5)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.1(this, paramVideoPlayRecommendObserver, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramArrayList2, paramBundle, paramInt5), 5, null, true);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<VideoInfo.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, ArrayList<VideoInfo> paramArrayList2, int paramInt7)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.2(this, paramArrayList, paramVideoPlayRecommendObserver, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramInt5, paramInt6, paramArrayList2, paramInt7), 5, null, true);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong, String paramString, int paramInt, VideoInfo paramVideoInfo)
  {
    ThreadManager.post(new VideoPlayRecommendHandler.3(this, paramLong, paramInt, paramString, paramVideoPlayRecommendObserver, paramVideoInfo), 5, null, true);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, String paramString, int paramInt, boolean paramBoolean)
  {
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    localReqBody.uint32_req_source.set(16);
    if (!TextUtils.isEmpty(paramString)) {
      localReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    localReqBody.uint32_req_sub_source.set(paramInt);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localReqBody.uint32_has_cache_pre_video.set(paramInt);
      localReqBody.uint32_req_sim_type.set(ReadInJoyHelper.d());
      if (VideoFeedsHelper.g())
      {
        int i = EntranceButtonExposureHelper.a().a();
        localReqBody.uint32_entrance_one_day_display_count.set(i);
      }
      paramString = ReadInJoyOidbHelper.a("OidbSvc.0x6cf", 1743, 1, localReqBody.toByteArray());
      paramString.addAttribute("is_from_first_recommend_video", Boolean.valueOf(true));
      paramString.addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramVideoPlayRecommendObserver.hashCode()));
      sendPbReq(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "has cache pre video: " + paramInt);
      }
      return;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return VideoPlayRecommendObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayRecommendHandler
 * JD-Core Version:    0.7.0.1
 */