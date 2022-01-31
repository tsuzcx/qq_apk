package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
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
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
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
    } while ((!TextUtils.isEmpty(paramVideoInfo.jdField_m_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.f)));
    while ((paramVideoInfo.jdField_g_of_type_Int != 1) || (TextUtils.isEmpty(paramVideoInfo.jdField_m_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.k)) || (TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.f))) {
      return false;
    }
    return true;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2;
    Bundle localBundle;
    label126:
    Object localObject1;
    Object localObject2;
    label303:
    oidb_0x6cf.ArticleSummary localArticleSummary;
    Object localObject4;
    int j;
    int i;
    label480:
    Object localObject5;
    label597:
    boolean bool1;
    label1031:
    label1340:
    long l;
    label1446:
    Object localObject6;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      localBundle = new Bundle();
      paramFromServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList onReceive :" + bool2);
      }
      if (bool2)
      {
        break label1945;
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
            if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null) {
              this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
            if ((!((oidb_0x6cf.RspBody)localObject1).rpt_article_list.has()) || (((oidb_0x6cf.RspBody)localObject1).rpt_article_list.get() == null)) {
              break label2391;
            }
            paramObject = ((oidb_0x6cf.RspBody)localObject1).rpt_article_list.get();
            paramToServiceMsg = paramFromServiceMsg;
            if (paramObject == null) {
              break label2124;
            }
            paramToServiceMsg = paramFromServiceMsg;
            if (paramObject.isEmpty()) {
              break label2124;
            }
            paramFromServiceMsg = new ArrayList(paramObject.size());
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList recv article size=" + paramObject.size());
            }
            localObject2 = paramObject.iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label3263;
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
              break label597;
            }
            paramToServiceMsg = localArticleSummary.rpt_dislike_list.get();
            if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
              break label597;
            }
            j = paramToServiceMsg.size();
            ((VideoInfo)localObject4).jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            i = 0;
            if (i >= j) {
              break label597;
            }
            localObject5 = new DislikeInfo();
            ((DislikeInfo)localObject5).a((oidb_0x6cf.DisLikeInfo)paramToServiceMsg.get(i));
            if (TextUtils.isEmpty(((DislikeInfo)localObject5).jdField_a_of_type_JavaLangString)) {
              break label3177;
            }
          }
          else
          {
            localBundle.putBoolean("VALUE_USER_IN_BLACK", false);
            break label126;
            super.a(1, bool2, localBundle);
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
          break label3177;
          if ((localArticleSummary.uint64_time.has()) && (localArticleSummary.uint64_time.get() != 0L))
          {
            ((VideoInfo)localObject4).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(localArticleSummary.uint64_time.get() * 1000L));
            ((VideoInfo)localObject4).jdField_a_of_type_Long = localArticleSummary.uint64_time.get();
          }
          if ((localArticleSummary.bytes_subscribe_id.has()) && (localArticleSummary.bytes_subscribe_id.get() != null)) {
            ((VideoInfo)localObject4).j = localArticleSummary.bytes_subscribe_id.get().toStringUtf8();
          }
          if ((localArticleSummary.bytes_subscribe_name.has()) && (localArticleSummary.bytes_subscribe_name.get() != null)) {
            ((VideoInfo)localObject4).k = localArticleSummary.bytes_subscribe_name.get().toStringUtf8();
          }
          if ((localArticleSummary.bytes_article_content_url.has()) && (localArticleSummary.bytes_article_content_url.get() != null)) {
            ((VideoInfo)localObject4).f = localArticleSummary.bytes_article_content_url.get().toStringUtf8();
          }
          if (localArticleSummary.uint32_strategy_id.has()) {
            ((VideoInfo)localObject4).i = localArticleSummary.uint32_strategy_id.get();
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
            ((VideoInfo)localObject4).jdField_m_of_type_Int = localArticleSummary.uint32_like_count.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, uint32_like_count :" + ((VideoInfo)localObject4).jdField_m_of_type_Int);
            }
          }
          if (localArticleSummary.uint32_ads_guide_time.has()) {
            ((VideoInfo)localObject4).jdField_h_of_type_Int = localArticleSummary.uint32_ads_guide_time.get();
          }
          if (localArticleSummary.uint32_video_source_type.has())
          {
            if (localArticleSummary.uint32_video_source_type.get() != 1) {
              break label3198;
            }
            bool1 = true;
            ((VideoInfo)localObject4).jdField_d_of_type_Boolean = bool1;
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
              label1528:
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
                  ((VideoInfo)localObject4).jdField_m_of_type_JavaLangString = paramToServiceMsg.optString("thirdIcon");
                  if (!TextUtils.isEmpty(paramToServiceMsg.optString("thirdName"))) {
                    ((VideoInfo)localObject4).k = paramToServiceMsg.optString("thirdName");
                  }
                  if (!TextUtils.isEmpty(paramToServiceMsg.optString("third_uin"))) {
                    ((VideoInfo)localObject4).j = paramToServiceMsg.optString("third_uin");
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
                      break label3204;
                    }
                    j = paramObject.optInt("network_type");
                    l = paramObject.optLong("file_size");
                    if (j != 2) {
                      break label3204;
                    }
                    ((VideoInfo)localObject4).jdField_b_of_type_Long = l;
                  }
                }
                if ((!localArticleSummary.rpt_label_list.has()) || (localArticleSummary.rpt_label_list.get() == null)) {
                  break;
                }
                paramObject = localArticleSummary.rpt_label_list.get();
                if (paramObject.size() <= 0) {
                  break label3192;
                }
                ((VideoInfo)localObject4).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                break label3192;
                while (i < paramObject.size())
                {
                  localObject5 = (oidb_0x6cf.ChannelInfo)paramObject.get(i);
                  localObject6 = new VideoInfo.ChannelInfo();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_a_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_channel_id.get();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_b_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_channel_type.get();
                  if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_name.get() == null) {
                    break label3213;
                  }
                  paramToServiceMsg = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_name.get().toStringUtf8();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_a_of_type_JavaLangString = paramToServiceMsg;
                  if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_display_name.get() == null) {
                    break label3218;
                  }
                  paramToServiceMsg = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_display_name.get().toStringUtf8();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_b_of_type_JavaLangString = paramToServiceMsg;
                  if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_url.get() == null) {
                    break label3223;
                  }
                  paramToServiceMsg = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_url.get().toString();
                  ((VideoInfo.ChannelInfo)localObject6).jdField_c_of_type_JavaLangString = paramToServiceMsg;
                  ((VideoInfo.ChannelInfo)localObject6).jdField_c_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_is_topic.get();
                  ((VideoInfo)localObject4).jdField_a_of_type_JavaUtilArrayList.add(localObject6);
                  i += 1;
                }
                paramToServiceMsg = paramToServiceMsg;
                paramToServiceMsg = paramObject;
              } while (!QLog.isColorLevel());
              label1557:
              label1586:
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
                break label1987;
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
            ((VideoInfo)localObject4).jdField_a_of_type_Boolean = true;
            i = ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_g_of_type_Int;
            if (i != 65) {
              break label3228;
            }
            ((VideoInfo)localObject4).jdField_g_of_type_Int = 2;
            if (!a((VideoInfo)localObject4))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidImageAd traceID=" + ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
              break;
              label1888:
              ((VideoInfo)localObject4).jdField_g_of_type_Int = 1;
              if (!a((VideoInfo)localObject4))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidVideoAd traceID=" + ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
                break;
                label1945:
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isUnknownTypeAd traceID=" + ((VideoInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
                break;
              }
            }
          }
          label1987:
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
          if ((((VideoInfo)localObject4).jdField_a_of_type_Boolean) && (((VideoInfo)localObject4).jdField_g_of_type_Int == 2)) {
            break;
          }
          paramFromServiceMsg.add(localObject4);
          break;
          label2124:
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
              break label3172;
            }
            paramToServiceMsg = localArticleSummary.bytes_article_title.get().toStringUtf8();
            label2243:
            if ((!localArticleSummary.bytes_inner_id.has()) || (localArticleSummary.bytes_inner_id.get() == null)) {
              break label3167;
            }
            paramFromServiceMsg = localArticleSummary.bytes_inner_id.get().toStringUtf8();
            label2277:
            localObject5 = new ArrayList();
            if ((!localArticleSummary.bytes_recommend_barrage_text_list.has()) || (localArticleSummary.bytes_recommend_barrage_text_list.get() == null)) {
              break label2409;
            }
            paramObject = localArticleSummary.bytes_recommend_barrage_text_list.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendBarrageList recv bytes_recommend_barrage_text_list size=" + paramObject.size());
            }
            paramObject = paramObject.iterator();
            while (paramObject.hasNext()) {
              ((ArrayList)localObject5).add(((ByteStringMicro)paramObject.next()).toStringUtf8());
            }
            label2391:
            if (QLog.isColorLevel()) {
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null");
            }
          }
        }
        label2409:
        localObject6 = new ArrayList();
        if ((localArticleSummary.rpt_dislike_list.has()) && (localArticleSummary.rpt_dislike_list.get() != null))
        {
          paramObject = localArticleSummary.rpt_dislike_list.get();
          if ((paramObject != null) && (paramObject.size() > 0))
          {
            j = paramObject.size();
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject1 = new DislikeInfo();
        ((DislikeInfo)localObject1).a((oidb_0x6cf.DisLikeInfo)paramObject.get(i));
        if (!TextUtils.isEmpty(((DislikeInfo)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ArrayList)localObject6).add(localObject1);
        }
      }
      else
      {
        if ((localArticleSummary.bytes_ads_jump_url.has()) && (localArticleSummary.bytes_ads_jump_url.get() != null)) {}
        for (paramObject = localArticleSummary.bytes_ads_jump_url.get().toStringUtf8();; paramObject = null)
        {
          if ((localArticleSummary.bytes_ads_guide_txt.has()) && (localArticleSummary.bytes_ads_guide_txt.get() != null)) {}
          for (localObject1 = localArticleSummary.bytes_ads_guide_txt.get().toStringUtf8();; localObject1 = null)
          {
            if (localArticleSummary.uint32_ads_jump_type.has()) {}
            for (i = localArticleSummary.uint32_ads_jump_type.get();; i = 0)
            {
              if (localArticleSummary.uint32_ads_guide_time.has()) {}
              for (j = localArticleSummary.uint32_ads_guide_time.get();; j = 0)
              {
                if (localArticleSummary.uint32_video_source_type.has())
                {
                  if (localArticleSummary.uint32_video_source_type.get() != 1) {
                    break label3280;
                  }
                  bool1 = true;
                  break label3277;
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
                        break label3132;
                      }
                      localObject2 = ((JSONObject)localObject2).optJSONArray("video_info");
                      if (localObject2 == null) {
                        break label3132;
                      }
                      k = 0;
                      if (k >= ((JSONArray)localObject2).length()) {
                        break label3132;
                      }
                      localObject4 = ((JSONArray)localObject2).optJSONObject(k);
                      if (localObject4 != null)
                      {
                        m = ((JSONObject)localObject4).optInt("network_type");
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
                          if (!localArticleSummary.uint32_like_count.has()) {
                            break label3126;
                          }
                          int n = localArticleSummary.uint32_like_count.get();
                          m = n;
                          if (QLog.isColorLevel())
                          {
                            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, req_article_summary uint32_like_count :" + n);
                            m = n;
                          }
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
                          localBundle.putBoolean("VALUE_IS_WEISHI", bool1);
                        }
                      }
                    }
                    catch (JSONException localJSONException)
                    {
                      int k;
                      Object localObject3 = localObject4;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList, jsonVideoList 解析出错");
                      localObject3 = localObject4;
                      continue;
                      k += 1;
                      continue;
                    }
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null 或者直接出错了");
                    break;
                    label3126:
                    int m = 0;
                    continue;
                    label3132:
                    l = 0L;
                  }
                  bool1 = false;
                }
              }
            }
          }
        }
        label3167:
        paramFromServiceMsg = null;
        break label2277;
        label3172:
        paramToServiceMsg = null;
        break label2243;
        label3177:
        i += 1;
        break label480;
        bool2 = false;
        break;
        label3192:
        i = 0;
        break label1446;
        label3198:
        bool1 = false;
        break label1031;
        label3204:
        i += 1;
        break label1340;
        label3213:
        paramToServiceMsg = null;
        break label1528;
        label3218:
        paramToServiceMsg = null;
        break label1557;
        label3223:
        paramToServiceMsg = null;
        break label1586;
        label3228:
        if ((i == 185) || (i == 350) || (i == 450)) {
          break label1888;
        }
        if (i != 1122) {
          break label303;
        }
        break label1888;
        label3263:
        paramToServiceMsg = paramFromServiceMsg;
        break label2124;
      }
      i += 1;
    }
    for (;;)
    {
      label3277:
      break;
      label3280:
      bool1 = false;
    }
  }
  
  protected Class a()
  {
    return VideoPlayRecommendObserver.class;
  }
  
  public void a(long paramLong1, String paramString1, int paramInt, ArrayList paramArrayList, String paramString2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  articleId = " + paramString1 + ", secondVideoArticleID = " + paramString2 + ", type = " + paramInt + ",polymericTopicId = " + paramLong2);
    }
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    paramString1 = new oidb_0x6cf.ReqBody();
    localObject = ByteStringMicro.copyFromUtf8((String)localObject);
    paramString1.bytes_inner_id.set((ByteStringMicro)localObject);
    paramString1.uint64_uin.set(paramLong1);
    paramString1.uint32_req_source.set(paramInt);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = ByteStringMicro.copyFromUtf8(paramString2);
      paramString1.rpt_bytes_redo_inner_id.add(paramString2);
    }
    if (paramLong2 != -1L) {
      paramString1.uint32_req_topic_id.set((int)paramLong2);
    }
    localObject = new oidb_0x6cf.ReqAdvertisePara();
    ((oidb_0x6cf.ReqAdvertisePara)localObject).msg_phone_info.set(a());
    ((oidb_0x6cf.ReqAdvertisePara)localObject).uint64_last_time.set(this.jdField_a_of_type_Long);
    paramString2 = new oidb_0x6cf.VideoFloatInfo();
    paramString2.uint32_ad_support.set(1);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      paramString2.uint32_info_num.set(0);
      ((oidb_0x6cf.ReqAdvertisePara)localObject).msg_video_float_info.set(paramString2);
      paramString1.req_advertise_para.set((MessageMicro)localObject);
      paramString1.uint32_req_dislike_type.set(1);
      paramArrayList = paramString1.uint32_req_vertical_video;
      if (!paramBoolean) {
        break label630;
      }
    }
    label630:
    for (paramInt = 1;; paramInt = 0)
    {
      paramArrayList.set(paramInt);
      if (!QLog.isColorLevel()) {
        break label647;
      }
      paramArrayList = new StringBuilder("getRecommendList AdvertiseParam:\n");
      paramArrayList.append("last_time=").append(this.jdField_a_of_type_Long).append(", info_num=").append(paramString2.uint32_info_num.get());
      if ((!paramString2.rpt_msg_ad_video_pos.has()) || (paramString2.rpt_msg_ad_video_pos.get() == null)) {
        break label636;
      }
      paramArrayList.append(", adList=\n");
      paramString2 = paramString2.rpt_msg_ad_video_pos.get().iterator();
      while (paramString2.hasNext())
      {
        localObject = (oidb_0x6cf.AdVideoPos)paramString2.next();
        paramArrayList.append("[pos=").append(((oidb_0x6cf.AdVideoPos)localObject).int32_kd_pos.get()).append(", aid=").append(((oidb_0x6cf.AdVideoPos)localObject).uint64_aid.get()).append(", traceID=").append(((oidb_0x6cf.AdVideoPos)localObject).bytes_trace_id.get().toStringUtf8()).append("]\n");
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      paramInt = 0;
      if (paramInt < paramArrayList.size())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(paramInt);
        if (!localVideoInfo.jdField_a_of_type_Boolean) {
          i += 1;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          oidb_0x6cf.AdVideoPos localAdVideoPos = new oidb_0x6cf.AdVideoPos();
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
          {
            localAdVideoPos.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString));
            localAdVideoPos.uint64_aid.set(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e);
          }
          localAdVideoPos.int32_kd_pos.set(paramInt);
          localArrayList.add(localAdVideoPos);
        }
      }
      paramString2.uint32_info_num.set(i);
      if (localArrayList.size() <= 0) {
        break;
      }
      paramString2.rpt_msg_ad_video_pos.set(localArrayList);
      break;
    }
    label636:
    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramArrayList.toString());
    label647:
    super.b(super.a("OidbSvc.0x6cf", 1743, 0, paramString1.toByteArray()));
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