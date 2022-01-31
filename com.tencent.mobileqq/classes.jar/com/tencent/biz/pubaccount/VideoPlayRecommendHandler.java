package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdVideoPos;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ChannelInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsIdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCFeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCVideoInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoFloatInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VideoPlayRecommendHandler
  extends BusinessHandler
{
  private long jdField_a_of_type_Long;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  
  public VideoPlayRecommendHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public VideoPlayRecommendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private oidb_0x6cf.PhoneInfo a()
  {
    oidb_0x6cf.PhoneInfo localPhoneInfo = new oidb_0x6cf.PhoneInfo();
    String str1 = DeviceInfoUtil.a();
    String str2 = DeviceInfoUtil.c(BaseApplication.getContext());
    if (!TextUtils.isEmpty(str1))
    {
      str1 = MD5Utils.d(str1.toLowerCase()).toLowerCase();
      localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str1));
      localPhoneInfo.uint32_muid_type.set(1);
    }
    for (;;)
    {
      int i = PublicAccountAdUtil.a();
      localPhoneInfo.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.e();
        i = j;
      }
      catch (Exception localException)
      {
        label82:
        break label82;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str1 = DeviceInfoUtil.f();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str1));
      str1 = DeviceInfoUtil.d();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str1));
      i = AppSetting.jdField_a_of_type_Int;
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str1 = DatalineMathUtil.a(DatalineMathUtil.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str1));
      localPhoneInfo.uint32_os_type.set(2);
      localPhoneInfo.uint64_func_flag.set(1L);
      return localPhoneInfo;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = MD5Utils.d(str2.replaceAll(":", "").toUpperCase()).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str1));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
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
      if (paramVideoInfo.jdField_g_of_type_Int != 2) {
        break;
      }
    } while ((!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString)));
    while ((paramVideoInfo.jdField_g_of_type_Int != 1) || (TextUtils.isEmpty(paramVideoInfo.m)) || (TextUtils.isEmpty(paramVideoInfo.k)) || (TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4;
    Bundle localBundle;
    label126:
    Object localObject1;
    Object localObject2;
    label344:
    oidb_0x6cf.ArticleSummary localArticleSummary;
    Object localObject4;
    int j;
    int i;
    label521:
    Object localObject5;
    label638:
    boolean bool1;
    label1096:
    label1238:
    long l;
    label1205:
    Object localObject6;
    label1547:
    label2135:
    label2164:
    label2552:
    ArrayList localArrayList;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool4 = true;
      localBundle = new Bundle();
      paramFromServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList onReceive :" + bool4);
      }
      if (bool4)
      {
        break label2552;
        try
        {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 83))
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 热门长视频黑名单");
            }
            localBundle.putBoolean("VALUE_USER_IN_BLACK", true);
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
            localObject1 = new oidb_0x6cf.RspBody();
            ((oidb_0x6cf.RspBody)localObject1).mergeFrom(paramToServiceMsg);
            if (((oidb_0x6cf.RspBody)localObject1).uint64_pos_ad_time.has()) {
              this.jdField_a_of_type_Long = ((oidb_0x6cf.RspBody)localObject1).uint64_pos_ad_time.get();
            }
            if ((((oidb_0x6cf.RspBody)localObject1).bytes_cookie.has()) && (((oidb_0x6cf.RspBody)localObject1).bytes_cookie.get() != null)) {
              localBundle.putString("VALUE_COOKIE", ((oidb_0x6cf.RspBody)localObject1).bytes_cookie.get().toStringUtf8());
            }
            if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null) {
              this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
            if ((!((oidb_0x6cf.RspBody)localObject1).rpt_article_list.has()) || (((oidb_0x6cf.RspBody)localObject1).rpt_article_list.get() == null)) {
              break label2998;
            }
            paramObject = ((oidb_0x6cf.RspBody)localObject1).rpt_article_list.get();
            paramToServiceMsg = paramFromServiceMsg;
            if (paramObject == null) {
              break label2731;
            }
            paramToServiceMsg = paramFromServiceMsg;
            if (paramObject.isEmpty()) {
              break label2731;
            }
            paramFromServiceMsg = new ArrayList(paramObject.size());
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList recv article size=" + paramObject.size());
            }
            localObject2 = paramObject.iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label4456;
            }
            localArticleSummary = (oidb_0x6cf.ArticleSummary)((Iterator)localObject2).next();
            paramObject = null;
            localObject4 = new VideoInfo();
            if ((localArticleSummary.bytes_article_title.has()) && (localArticleSummary.bytes_article_title.get() != null)) {
              ((VideoInfo)localObject4).jdField_c_of_type_JavaLangString = localArticleSummary.bytes_article_title.get().toStringUtf8();
            }
            if ((localArticleSummary.bytes_article_summary.has()) && (localArticleSummary.bytes_article_summary.get() != null)) {
              ((VideoInfo)localObject4).jdField_d_of_type_JavaLangString = localArticleSummary.bytes_article_summary.get().toStringUtf8();
            }
            if ((!localArticleSummary.rpt_dislike_list.has()) || (localArticleSummary.rpt_dislike_list.get() == null)) {
              break label638;
            }
            paramToServiceMsg = localArticleSummary.rpt_dislike_list.get();
            if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
              break label638;
            }
            j = paramToServiceMsg.size();
            ((VideoInfo)localObject4).jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            i = 0;
            if (i >= j) {
              break label638;
            }
            localObject5 = new DislikeInfo();
            ((DislikeInfo)localObject5).a((oidb_0x6cf.DisLikeInfo)paramToServiceMsg.get(i));
            if (TextUtils.isEmpty(((DislikeInfo)localObject5).jdField_a_of_type_JavaLangString)) {
              break label4352;
            }
          }
          else
          {
            localBundle.putBoolean("VALUE_USER_IN_BLACK", false);
            break label126;
            super.a(1, bool4, localBundle);
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, ERROR e=" + paramToServiceMsg.getMessage());
          }
        }
        for (;;)
        {
          return;
          ((VideoInfo)localObject4).jdField_b_of_type_JavaUtilArrayList.add(localObject5);
          break label4352;
          if ((localArticleSummary.uint64_time.has()) && (localArticleSummary.uint64_time.get() != 0L))
          {
            ((VideoInfo)localObject4).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(localArticleSummary.uint64_time.get() * 1000L));
            ((VideoInfo)localObject4).jdField_a_of_type_Long = localArticleSummary.uint64_time.get();
          }
          if ((localArticleSummary.bytes_subscribe_id.has()) && (localArticleSummary.bytes_subscribe_id.get() != null)) {
            ((VideoInfo)localObject4).jdField_j_of_type_JavaLangString = localArticleSummary.bytes_subscribe_id.get().toStringUtf8();
          }
          if ((localArticleSummary.bytes_subscribe_name.has()) && (localArticleSummary.bytes_subscribe_name.get() != null)) {
            ((VideoInfo)localObject4).k = localArticleSummary.bytes_subscribe_name.get().toStringUtf8();
          }
          if ((localArticleSummary.bytes_article_content_url.has()) && (localArticleSummary.bytes_article_content_url.get() != null)) {
            ((VideoInfo)localObject4).jdField_f_of_type_JavaLangString = localArticleSummary.bytes_article_content_url.get().toStringUtf8();
          }
          if (localArticleSummary.uint32_strategy_id.has()) {
            ((VideoInfo)localObject4).jdField_j_of_type_Int = localArticleSummary.uint32_strategy_id.get();
          }
          if (localArticleSummary.uint64_algorithm_id.has()) {
            ((VideoInfo)localObject4).jdField_d_of_type_Long = localArticleSummary.uint64_algorithm_id.get();
          }
          if ((localArticleSummary.bytes_recommend_reason.has()) && (localArticleSummary.bytes_recommend_reason.get() != null)) {
            ((VideoInfo)localObject4).jdField_h_of_type_JavaLangString = localArticleSummary.bytes_recommend_reason.get().toStringUtf8();
          }
          if (localArticleSummary.uint32_video_comment_count.has())
          {
            ((VideoInfo)localObject4).jdField_e_of_type_Int = localArticleSummary.uint32_video_comment_count.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, uint32_video_comment_count :" + ((VideoInfo)localObject4).jdField_e_of_type_Int);
            }
          }
          if (localArticleSummary.uint32_like_count.has())
          {
            ((VideoInfo)localObject4).n = localArticleSummary.uint32_like_count.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, uint32_like_count :" + ((VideoInfo)localObject4).n);
            }
          }
          if (localArticleSummary.uint32_ads_guide_time.has()) {
            ((VideoInfo)localObject4).jdField_h_of_type_Int = localArticleSummary.uint32_ads_guide_time.get();
          }
          if (localArticleSummary.uint32_ads_jump_type.has()) {
            ((VideoInfo)localObject4).i = localArticleSummary.uint32_ads_jump_type.get();
          }
          if (localArticleSummary.uint32_video_source_type.has())
          {
            if (localArticleSummary.uint32_video_source_type.get() != 1) {
              break label4373;
            }
            bool1 = true;
            ((VideoInfo)localObject4).jdField_f_of_type_Boolean = bool1;
          }
          if ((localArticleSummary.bytes_video_subscript_txt.has()) && (localArticleSummary.bytes_video_subscript_txt.get() != null)) {
            ((VideoInfo)localObject4).o = localArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
          }
          if ((localArticleSummary.bytes_video_subscript_color.has()) && (localArticleSummary.bytes_video_subscript_color.get() != null)) {
            ((VideoInfo)localObject4).p = localArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
          }
          if (localArticleSummary.uint32_account_grade.has())
          {
            if (localArticleSummary.uint32_account_grade.get() != 1) {
              break label4379;
            }
            bool1 = true;
            ((VideoInfo)localObject4).jdField_a_of_type_Boolean = bool1;
          }
          if (localArticleSummary.uint32_myself_like_status.has())
          {
            if (localArticleSummary.uint32_myself_like_status.get() != 1) {
              break label4385;
            }
            bool1 = true;
            ((VideoInfo)localObject4).jdField_h_of_type_Boolean = bool1;
          }
          if (localArticleSummary.json_video_list.has())
          {
            paramToServiceMsg = localArticleSummary.json_video_list.get();
            if (paramToServiceMsg == null) {}
          }
          try
          {
            paramToServiceMsg = new JSONObject(localArticleSummary.json_video_list.get().toStringUtf8()).getJSONArray("videos").optJSONObject(0);
            if (paramToServiceMsg != null)
            {
              ((VideoInfo)localObject4).jdField_a_of_type_JavaLangString = paramToServiceMsg.optString("vid");
              if (paramToServiceMsg.has("width")) {
                ((VideoInfo)localObject4).jdField_b_of_type_Int = paramToServiceMsg.getInt("width");
              }
              if (paramToServiceMsg.has("height")) {
                ((VideoInfo)localObject4).jdField_c_of_type_Int = paramToServiceMsg.getInt("height");
              }
              bool1 = paramToServiceMsg.has("duration");
              if (!bool1) {}
            }
          }
          catch (JSONException paramToServiceMsg)
          {
            try
            {
              label1792:
              label2053:
              label2193:
              do
              {
                ((VideoInfo)localObject4).jdField_d_of_type_Int = Integer.parseInt(paramToServiceMsg.optString("duration"));
                ((VideoInfo)localObject4).jdField_b_of_type_JavaLangString = paramToServiceMsg.optString("picture");
                if (paramToServiceMsg.has("innerUniqueID")) {
                  ((VideoInfo)localObject4).jdField_g_of_type_JavaLangString = paramToServiceMsg.optString("innerUniqueID");
                }
                ((VideoInfo)localObject4).jdField_a_of_type_Int = 1;
                if (paramToServiceMsg.has("busiType")) {
                  ((VideoInfo)localObject4).jdField_a_of_type_Int = paramToServiceMsg.getInt("busiType");
                }
                if (((VideoInfo)localObject4).jdField_a_of_type_Int != 1)
                {
                  ((VideoInfo)localObject4).l = paramToServiceMsg.optString("thirdAction");
                  ((VideoInfo)localObject4).m = paramToServiceMsg.optString("thirdIcon");
                  if (!TextUtils.isEmpty(paramToServiceMsg.optString("thirdName"))) {
                    ((VideoInfo)localObject4).k = paramToServiceMsg.optString("thirdName");
                  }
                  if (!TextUtils.isEmpty(paramToServiceMsg.optString("third_uin"))) {
                    ((VideoInfo)localObject4).jdField_j_of_type_JavaLangString = paramToServiceMsg.optString("third_uin");
                  }
                }
                paramToServiceMsg = paramToServiceMsg.optJSONArray("video_info");
                if (paramToServiceMsg != null)
                {
                  i = 0;
                  if (i < paramToServiceMsg.length())
                  {
                    paramObject = paramToServiceMsg.optJSONObject(i);
                    if (paramObject == null) {
                      break label4391;
                    }
                    j = paramObject.optInt("network_type");
                    l = paramObject.optLong("file_size");
                    if (j != 2) {
                      break label4391;
                    }
                    ((VideoInfo)localObject4).jdField_b_of_type_Long = l;
                  }
                }
                if ((localArticleSummary.uint32_is_ugc.has()) && (localArticleSummary.uint32_is_ugc.get() == 1))
                {
                  ((VideoInfo)localObject4).jdField_b_of_type_Boolean = true;
                  if ((localArticleSummary.msg_ugc_feeds_info.has()) && (localArticleSummary.msg_ugc_feeds_info.get() != null))
                  {
                    paramToServiceMsg = (oidb_0x6cf.UGCFeedsInfo)localArticleSummary.msg_ugc_feeds_info.get();
                    if (paramToServiceMsg.has())
                    {
                      if ((paramToServiceMsg.ugc_feeds_info.has()) && (paramToServiceMsg.ugc_feeds_info.get() != null))
                      {
                        if (((oidb_0x6cf.FeedsIdInfo)paramToServiceMsg.ugc_feeds_info.get()).uint64_feeds_id.has()) {
                          ((VideoInfo)localObject4).jdField_c_of_type_Long = ((oidb_0x6cf.FeedsIdInfo)paramToServiceMsg.ugc_feeds_info.get()).uint64_feeds_id.get();
                        }
                        if (((oidb_0x6cf.FeedsIdInfo)paramToServiceMsg.ugc_feeds_info.get()).uint32_feeds_type.has()) {
                          ((VideoInfo)localObject4).jdField_f_of_type_Int = ((oidb_0x6cf.FeedsIdInfo)paramToServiceMsg.ugc_feeds_info.get()).uint32_feeds_type.get();
                        }
                      }
                      if (paramToServiceMsg.uint32_follow_status.has())
                      {
                        if (paramToServiceMsg.uint32_follow_status.get() != 2) {
                          break label4400;
                        }
                        bool1 = true;
                        ((VideoInfo)localObject4).jdField_g_of_type_Boolean = bool1;
                      }
                      if (paramToServiceMsg.uint64_cuin.has()) {
                        ((VideoInfo)localObject4).jdField_j_of_type_JavaLangString = String.valueOf(paramToServiceMsg.uint64_cuin.get());
                      }
                      if ((paramToServiceMsg.msg_ugc_video_info_list.has()) && (paramToServiceMsg.msg_ugc_video_info_list.get() != null))
                      {
                        paramToServiceMsg = (oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.msg_ugc_video_info_list.get();
                        if ((paramToServiceMsg.has()) && (paramToServiceMsg.get() != null))
                        {
                          if ((((oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.get()).bytes_title.has()) && (((oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.get()).bytes_title.get() != null)) {
                            ((VideoInfo)localObject4).jdField_c_of_type_JavaLangString = ((oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.get()).bytes_title.get().toStringUtf8();
                          }
                          if (((oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.get()).uint32_busi_type.has()) {
                            ((VideoInfo)localObject4).jdField_a_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.get()).uint32_busi_type.get();
                          }
                          if (((oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.get()).bytes_share_url.has()) {
                            ((VideoInfo)localObject4).jdField_f_of_type_JavaLangString = ((oidb_0x6cf.UGCVideoInfo)paramToServiceMsg.get()).bytes_share_url.get().toStringUtf8();
                          }
                        }
                      }
                    }
                  }
                  VideoFeedsHelper.a((VideoInfo)localObject4);
                }
                if ((!localArticleSummary.rpt_label_list.has()) || (localArticleSummary.rpt_label_list.get() == null)) {
                  break;
                }
                paramObject = localArticleSummary.rpt_label_list.get();
                if (paramObject.size() <= 0) {
                  break label4367;
                }
                ((VideoInfo)localObject4).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                break label4367;
                while (i < paramObject.size())
                {
                  localObject5 = (oidb_0x6cf.ChannelInfo)paramObject.get(i);
                  localObject6 = new VideoInfo.ChannelInfo();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_a_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_channel_id.get();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_b_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_channel_type.get();
                  if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_name.get() == null) {
                    break label4406;
                  }
                  paramToServiceMsg = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_name.get().toStringUtf8();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_a_of_type_JavaLangString = paramToServiceMsg;
                  if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_display_name.get() == null) {
                    break label4411;
                  }
                  paramToServiceMsg = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_display_name.get().toStringUtf8();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_b_of_type_JavaLangString = paramToServiceMsg;
                  if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_url.get() == null) {
                    break label4416;
                  }
                  paramToServiceMsg = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_url.get().toStringUtf8();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_c_of_type_JavaLangString = paramToServiceMsg;
                  ((VideoInfo.ChannelInfo)localObject6).jdField_c_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_is_topic.get();
                  ((VideoInfo)localObject4).jdField_a_of_type_JavaUtilArrayList.add(localObject6);
                  i += 1;
                }
                paramToServiceMsg = paramToServiceMsg;
                paramToServiceMsg = paramObject;
              } while (!QLog.isColorLevel());
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, jsonVideoList 解析出错");
              paramToServiceMsg = paramObject;
            }
            catch (NumberFormatException paramObject)
            {
              for (;;)
              {
                paramObject.printStackTrace();
              }
              if (!localArticleSummary.msg_feeds_info.has()) {
                break label2594;
              }
            }
          }
          if (((oidb_0x6cf.FeedsInfo)localArticleSummary.msg_feeds_info.get()).feeds_type.get() == 1)
          {
            ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = new VideoAdInfo(this.jdField_a_of_type_Long, (oidb_0x6cf.PosAdInfo)((oidb_0x6cf.FeedsInfo)localArticleSummary.msg_feeds_info.get()).msg_pos_ad_info.get());
            if (((oidb_0x6cf.FeedsInfo)localArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.has()) {
              ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.a(((oidb_0x6cf.FeedsInfo)localArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.get());
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList recv adInfo=" + ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.toString());
            }
            ((VideoInfo)localObject4).jdField_c_of_type_Boolean = true;
            i = ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_g_of_type_Int;
            if (i != 65) {
              break label4421;
            }
            ((VideoInfo)localObject4).jdField_g_of_type_Int = 2;
            if (!a((VideoInfo)localObject4))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidImageAd traceID=" + ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
              break;
              label2495:
              ((VideoInfo)localObject4).jdField_g_of_type_Int = 1;
              if (!a((VideoInfo)localObject4))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidVideoAd traceID=" + ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
                break;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isUnknownTypeAd traceID=" + ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
                break;
              }
            }
          }
          label2594:
          if ((localArticleSummary.bytes_recommend_barrage_text_list.has()) && (localArticleSummary.bytes_recommend_barrage_text_list.get() != null))
          {
            paramToServiceMsg = localArticleSummary.bytes_recommend_barrage_text_list.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendBarrageList recv bytes_recommend_barrage_text_list size=" + paramToServiceMsg.size());
            }
            paramToServiceMsg = paramToServiceMsg.iterator();
            while (paramToServiceMsg.hasNext())
            {
              paramObject = (ByteStringMicro)paramToServiceMsg.next();
              ((VideoInfo)localObject4).jdField_c_of_type_JavaUtilArrayList.add(paramObject.toStringUtf8());
            }
          }
          if ((((VideoInfo)localObject4).jdField_c_of_type_Boolean) && (((VideoInfo)localObject4).jdField_g_of_type_Int == 2)) {
            break;
          }
          paramFromServiceMsg.add(localObject4);
          break;
          label2731:
          if (((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) && (QLog.isColorLevel())) {
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list 中合法数据为空");
          }
          localBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", paramToServiceMsg);
          while ((((oidb_0x6cf.RspBody)localObject1).req_article_summary.has()) && (((oidb_0x6cf.RspBody)localObject1).req_article_summary.get() != null))
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList, 获取原文章标题");
            }
            localArticleSummary = (oidb_0x6cf.ArticleSummary)((oidb_0x6cf.RspBody)localObject1).req_article_summary.get();
            if ((!localArticleSummary.bytes_article_title.has()) || (localArticleSummary.bytes_article_title.get() == null)) {
              break label4347;
            }
            paramToServiceMsg = localArticleSummary.bytes_article_title.get().toStringUtf8();
            label2850:
            if ((!localArticleSummary.bytes_inner_id.has()) || (localArticleSummary.bytes_inner_id.get() == null)) {
              break label4342;
            }
            paramFromServiceMsg = localArticleSummary.bytes_inner_id.get().toStringUtf8();
            label2884:
            localObject5 = new ArrayList();
            if ((!localArticleSummary.bytes_recommend_barrage_text_list.has()) || (localArticleSummary.bytes_recommend_barrage_text_list.get() == null)) {
              break label3016;
            }
            paramObject = localArticleSummary.bytes_recommend_barrage_text_list.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendBarrageList recv bytes_recommend_barrage_text_list size=" + paramObject.size());
            }
            paramObject = paramObject.iterator();
            while (paramObject.hasNext()) {
              ((ArrayList)localObject5).add(((ByteStringMicro)paramObject.next()).toStringUtf8());
            }
            label2998:
            if (QLog.isColorLevel()) {
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null");
            }
          }
        }
        label3016:
        localObject6 = new ArrayList();
        if ((localArticleSummary.rpt_dislike_list.has()) && (localArticleSummary.rpt_dislike_list.get() != null))
        {
          paramObject = localArticleSummary.rpt_dislike_list.get();
          if ((paramObject != null) && (paramObject.size() > 0))
          {
            j = paramObject.size();
            i = 0;
            label3080:
            if (i < j)
            {
              localObject1 = new DislikeInfo();
              ((DislikeInfo)localObject1).a((oidb_0x6cf.DisLikeInfo)paramObject.get(i));
              if (TextUtils.isEmpty(((DislikeInfo)localObject1).jdField_a_of_type_JavaLangString)) {
                break label4461;
              }
              ((ArrayList)localObject6).add(localObject1);
              break label4461;
            }
          }
        }
        localArrayList = new ArrayList();
        if ((localArticleSummary.rpt_label_list.has()) && (localArticleSummary.rpt_label_list.get() != null))
        {
          localObject1 = localArticleSummary.rpt_label_list.get();
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            j = ((List)localObject1).size();
            i = 0;
            while (i < j)
            {
              localObject2 = (oidb_0x6cf.ChannelInfo)((List)localObject1).get(i);
              localObject4 = new VideoInfo.ChannelInfo();
              ((VideoInfo.ChannelInfo)localObject4).jdField_a_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject2).uint32_channel_id.get();
              ((VideoInfo.ChannelInfo)localObject4).jdField_b_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject2).uint32_channel_type.get();
              if (((oidb_0x6cf.ChannelInfo)localObject2).bytes_channel_name.get() == null) {
                break label4470;
              }
              paramObject = ((oidb_0x6cf.ChannelInfo)localObject2).bytes_channel_name.get().toStringUtf8();
              label3284:
              ((VideoInfo.ChannelInfo)localObject4).jdField_a_of_type_JavaLangString = paramObject;
              if (((oidb_0x6cf.ChannelInfo)localObject2).bytes_channel_display_name.get() == null) {
                break label4475;
              }
              paramObject = ((oidb_0x6cf.ChannelInfo)localObject2).bytes_channel_display_name.get().toStringUtf8();
              label3313:
              ((VideoInfo.ChannelInfo)localObject4).jdField_b_of_type_JavaLangString = paramObject;
              if (((oidb_0x6cf.ChannelInfo)localObject2).bytes_channel_url.get() == null) {
                break label4480;
              }
              paramObject = ((oidb_0x6cf.ChannelInfo)localObject2).bytes_channel_url.get().toStringUtf8();
              label3342:
              ((VideoInfo.ChannelInfo)localObject4).jdField_c_of_type_JavaLangString = paramObject;
              ((VideoInfo.ChannelInfo)localObject4).jdField_c_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject2).uint32_is_topic.get();
              localArrayList.add(localObject4);
              i += 1;
            }
          }
        }
        if ((!localArticleSummary.bytes_ads_jump_url.has()) || (localArticleSummary.bytes_ads_jump_url.get() == null)) {
          break label4337;
        }
        paramObject = localArticleSummary.bytes_ads_jump_url.get().toStringUtf8();
        label3412:
        if ((!localArticleSummary.bytes_ads_guide_txt.has()) || (localArticleSummary.bytes_ads_guide_txt.get() == null)) {
          break label4331;
        }
        localObject1 = localArticleSummary.bytes_ads_guide_txt.get().toStringUtf8();
        label3447:
        if (!localArticleSummary.uint32_ads_jump_type.has()) {
          break label4325;
        }
        i = localArticleSummary.uint32_ads_jump_type.get();
        label3468:
        if (!localArticleSummary.uint32_ads_guide_time.has()) {
          break label4319;
        }
        j = localArticleSummary.uint32_ads_guide_time.get();
        label3489:
        if (!localArticleSummary.uint32_video_source_type.has()) {
          break label4313;
        }
        if (localArticleSummary.uint32_video_source_type.get() != 1) {
          break label4505;
        }
        bool1 = true;
        break label4485;
        label3518:
        if (!localArticleSummary.uint32_myself_like_status.has()) {
          break label4307;
        }
        if (localArticleSummary.uint32_myself_like_status.get() != 1) {
          break label4511;
        }
        bool1 = true;
        break label4492;
      }
    }
    boolean bool2;
    for (;;)
    {
      if ((localArticleSummary.uint32_is_ugc.has()) && (localArticleSummary.uint32_is_ugc.get() == 1)) {
        if ((localArticleSummary.msg_ugc_feeds_info.has()) && (localArticleSummary.msg_ugc_feeds_info.get() != null))
        {
          localObject2 = (oidb_0x6cf.UGCFeedsInfo)localArticleSummary.msg_ugc_feeds_info.get();
          if (((oidb_0x6cf.UGCFeedsInfo)localObject2).uint32_follow_status.has())
          {
            if (((oidb_0x6cf.UGCFeedsInfo)localObject2).uint32_follow_status.get() != 2) {
              break label4517;
            }
            bool1 = true;
            break label4499;
          }
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(paramToServiceMsg)) && (QLog.isColorLevel())) {
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList 获取原文章标题, NULL ERROR");
        }
        if (localArticleSummary.json_video_list.has())
        {
          localObject2 = localArticleSummary.json_video_list.get();
          if (localObject2 != null) {
            localObject4 = null;
          }
        }
        for (;;)
        {
          try
          {
            localObject2 = new JSONObject(localArticleSummary.json_video_list.get().toStringUtf8()).getJSONArray("videos").optJSONObject(0);
            if (localObject2 == null) {
              break label4283;
            }
            localObject2 = ((JSONObject)localObject2).optJSONArray("video_info");
            if (localObject2 == null) {
              break label4283;
            }
            k = 0;
            if (k >= ((JSONArray)localObject2).length()) {
              break label4283;
            }
            localObject4 = ((JSONArray)localObject2).optJSONObject(k);
            if (localObject4 != null)
            {
              int m = ((JSONObject)localObject4).optInt("network_type");
              l = ((JSONObject)localObject4).optLong("file_size");
              if (m == 2)
              {
                k = 0;
                if (localArticleSummary.uint32_video_comment_count.has())
                {
                  m = localArticleSummary.uint32_video_comment_count.get();
                  k = m;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, req_article_summary uint32_video_comment_count :" + m);
                    k = m;
                  }
                }
                m = 0;
                if (localArticleSummary.uint32_like_count.has())
                {
                  int n = localArticleSummary.uint32_like_count.get();
                  m = n;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, req_article_summary uint32_like_count :" + n);
                    m = n;
                  }
                }
                if ((!localArticleSummary.bytes_video_subscript_txt.has()) || (localArticleSummary.bytes_video_subscript_txt.get() == null)) {
                  break label4277;
                }
                localObject2 = localArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
                if ((!localArticleSummary.bytes_video_subscript_color.has()) || (localArticleSummary.bytes_video_subscript_color.get() == null)) {
                  break label4271;
                }
                localObject4 = localArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
                if (!localArticleSummary.uint32_account_grade.has()) {
                  break label4265;
                }
                if (localArticleSummary.uint32_account_grade.get() != 1) {
                  continue;
                }
                bool3 = true;
                localBundle.putParcelableArrayList("VIDEO_DISLIKEINFO_LIST", (ArrayList)localObject6);
                localBundle.putString("VALUE_REQUEST_VIDEO_INFO", paramToServiceMsg);
                localBundle.putString("VALUE_REQUEST_VIDEO_ARTICLE_ID", paramFromServiceMsg);
                localBundle.putLong("VALUE_REQUEST_VIDEO_XG_FILE_SIZE", l);
                localBundle.putStringArrayList("VALUE_RECOMMAND_BARRAGE", (ArrayList)localObject5);
                localBundle.putInt("VALUE_COMMENT_COUNT", k);
                localBundle.putInt("VALUE_DIANZAN_COUNT", m);
                localBundle.putString("VALUE_ADS_JUMP_URL", paramObject);
                localBundle.putString("VALUE_ADS_GUIDE_TEXT", (String)localObject1);
                localBundle.putInt("VALUE_ADS_JUMP_TYPE", i);
                localBundle.putInt("VALUE_ADS_GUIDE_TIME", j);
                localBundle.putBoolean("VALUE_IS_WEISHI", bool5);
                localBundle.putString("VALUE_SUBS_TEXT", (String)localObject2);
                localBundle.putString("VALUE_SUBS_COLOR", (String)localObject4);
                localBundle.putBoolean("VALUE_IS_VERIFIED", bool3);
                localBundle.putBoolean("VALUE_IS_LIKE", bool6);
                localBundle.putBoolean("VALUE_IS_UGC_FOLLOW", bool1);
                localBundle.putBoolean("VALUE_IS_UGC", bool2);
                localBundle.putParcelableArrayList("VALUE_TIPIC_INFO_LIST", localArrayList);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            int k;
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList, jsonVideoList 解析出错");
            localObject3 = localObject4;
            continue;
            k += 1;
            continue;
            bool3 = false;
            continue;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null 或者直接出错了");
          break;
          label4265:
          boolean bool3 = false;
          continue;
          label4271:
          localObject4 = null;
          continue;
          label4277:
          Object localObject3 = null;
          continue;
          label4283:
          l = 0L;
        }
        bool1 = false;
        bool2 = true;
        continue;
        bool1 = false;
        bool2 = false;
      }
      label4307:
      boolean bool6 = false;
      continue;
      label4313:
      boolean bool5 = false;
      break label3518;
      label4319:
      j = 0;
      break label3489;
      label4325:
      i = 0;
      break label3468;
      label4331:
      localObject1 = null;
      break label3447;
      label4337:
      paramObject = null;
      break label3412;
      label4342:
      paramFromServiceMsg = null;
      break label2884;
      label4347:
      paramToServiceMsg = null;
      break label2850;
      label4352:
      i += 1;
      break label521;
      bool4 = false;
      break;
      label4367:
      i = 0;
      break label2053;
      label4373:
      bool1 = false;
      break label1096;
      label4379:
      bool1 = false;
      break label1205;
      label4385:
      bool1 = false;
      break label1238;
      label4391:
      i += 1;
      break label1547;
      label4400:
      bool1 = false;
      break label1792;
      label4406:
      paramToServiceMsg = null;
      break label2135;
      label4411:
      paramToServiceMsg = null;
      break label2164;
      label4416:
      paramToServiceMsg = null;
      break label2193;
      label4421:
      if ((i == 185) || (i == 350) || (i == 450)) {
        break label2495;
      }
      if (i != 1122) {
        break label344;
      }
      break label2495;
      label4456:
      paramToServiceMsg = paramFromServiceMsg;
      break label2731;
      label4461:
      i += 1;
      break label3080;
      label4470:
      paramObject = null;
      break label3284;
      label4475:
      paramObject = null;
      break label3313;
      label4480:
      paramObject = null;
      break label3342;
      label4485:
      bool5 = bool1;
      break label3518;
      label4492:
      bool6 = bool1;
    }
    for (;;)
    {
      label4499:
      bool2 = true;
      break;
      label4505:
      bool1 = false;
      break label4485;
      label4511:
      bool1 = false;
      break label4492;
      label4517:
      bool1 = false;
    }
  }
  
  protected Class a()
  {
    return VideoPlayRecommendObserver.class;
  }
  
  public void a(long paramLong1, VideoInfo paramVideoInfo, int paramInt, ArrayList paramArrayList, String paramString1, long paramLong2, boolean paramBoolean, String paramString2, String paramString3)
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
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  articleId = " + paramVideoInfo.jdField_g_of_type_JavaLangString + ", secondVideoArticleID = " + paramString1 + ", type = " + paramInt + ",polymericTopicId = " + paramLong2);
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    Object localObject = ByteStringMicro.copyFromUtf8(paramVideoInfo.jdField_g_of_type_JavaLangString);
    localReqBody.bytes_inner_id.set((ByteStringMicro)localObject);
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint32_req_source.set(paramInt);
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
    paramString2 = new oidb_0x6cf.ReqAdvertisePara();
    paramString2.msg_phone_info.set(a());
    paramString2.uint64_last_time.set(this.jdField_a_of_type_Long);
    paramString1 = new oidb_0x6cf.VideoFloatInfo();
    paramString1.uint32_ad_support.set(1);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      paramString1.uint32_info_num.set(0);
      paramString2.msg_video_float_info.set(paramString1);
      localReqBody.req_advertise_para.set(paramString2);
      localReqBody.uint32_req_dislike_type.set(1);
      paramArrayList = localReqBody.uint32_req_vertical_video;
      if (!paramBoolean) {
        break label786;
      }
      paramInt = 1;
      label360:
      paramArrayList.set(paramInt);
      paramArrayList = localReqBody.uint32_is_ugc;
      if (!paramVideoInfo.jdField_b_of_type_Boolean) {
        break label792;
      }
    }
    label786:
    label792:
    for (paramInt = 1;; paramInt = 0)
    {
      paramArrayList.set(paramInt);
      if (paramVideoInfo.jdField_b_of_type_Boolean)
      {
        paramArrayList = new oidb_0x6cf.FeedsIdInfo();
        paramArrayList.uint64_feeds_id.set(paramVideoInfo.jdField_c_of_type_Long);
        paramArrayList.uint32_feeds_type.set(paramVideoInfo.jdField_f_of_type_Int);
        localReqBody.ugc_feeds_info.set(paramArrayList);
      }
      if (!QLog.isColorLevel()) {
        break label808;
      }
      paramVideoInfo = new StringBuilder("getRecommendList AdvertiseParam:\n");
      paramVideoInfo.append("last_time=").append(this.jdField_a_of_type_Long).append(", info_num=").append(paramString1.uint32_info_num.get());
      if ((!paramString1.rpt_msg_ad_video_pos.has()) || (paramString1.rpt_msg_ad_video_pos.get() == null)) {
        break label798;
      }
      paramVideoInfo.append(", adList=\n");
      paramArrayList = paramString1.rpt_msg_ad_video_pos.get().iterator();
      while (paramArrayList.hasNext())
      {
        paramString1 = (oidb_0x6cf.AdVideoPos)paramArrayList.next();
        paramVideoInfo.append("[pos=").append(paramString1.int32_kd_pos.get()).append(", aid=").append(paramString1.uint64_aid.get()).append(", traceID=").append(paramString1.bytes_trace_id.get().toStringUtf8()).append("]\n");
      }
      paramString3 = new ArrayList();
      int i = 0;
      paramInt = 0;
      if (paramInt < paramArrayList.size())
      {
        localObject = (VideoInfo)paramArrayList.get(paramInt);
        if (!((VideoInfo)localObject).jdField_c_of_type_Boolean) {
          i += 1;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          oidb_0x6cf.AdVideoPos localAdVideoPos = new oidb_0x6cf.AdVideoPos();
          if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
          {
            localAdVideoPos.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString));
            localAdVideoPos.uint64_aid.set(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e);
          }
          localAdVideoPos.int32_kd_pos.set(paramInt);
          paramString3.add(localAdVideoPos);
        }
      }
      paramString1.uint32_info_num.set(i);
      if (paramString3.size() <= 0) {
        break;
      }
      paramString1.rpt_msg_ad_video_pos.set(paramString3);
      break;
      paramInt = 0;
      break label360;
    }
    label798:
    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramVideoInfo.toString());
    label808:
    super.b(super.a("OidbSvc.0x6cf", 1743, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayRecommendHandler
 * JD-Core Version:    0.7.0.1
 */