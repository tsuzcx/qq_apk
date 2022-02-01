package com.tencent.biz.pubaccount.NativeAd.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.atlas.ReadInJoyAdAtlasUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ClassInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.KdTagItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.ClassInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.KdTagItem;
import tencent.im.oidb.cmd0x885.oidb_0x885.PosAdInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;

public class VideoFeedsAdTagHelper
{
  public static ArrayList<oidb_0x885.AdTagInfo> a(ArrayList<VideoInfo.AdTagInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (VideoInfo.AdTagInfo)paramArrayList.next();
      oidb_0x885.AdTagInfo localAdTagInfo = new oidb_0x885.AdTagInfo();
      localAdTagInfo.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(((VideoInfo.AdTagInfo)localObject1).jdField_a_of_type_JavaLangString));
      localAdTagInfo.int32_display_ad_flag.set(((VideoInfo.AdTagInfo)localObject1).jdField_a_of_type_Int);
      localAdTagInfo.int32_pos.set(((VideoInfo.AdTagInfo)localObject1).jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(((VideoInfo.AdTagInfo)localObject1).jdField_b_of_type_JavaLangString)) {
        localAdTagInfo.string_ad_feature_info.set(((VideoInfo.AdTagInfo)localObject1).jdField_b_of_type_JavaLangString);
      }
      Object localObject3 = ((VideoInfo.AdTagInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
      Object localObject2;
      if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty()))
      {
        localObject2 = new ArrayList(((ArrayList)localObject3).size());
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          VideoInfo.KdTagItem localKdTagItem = (VideoInfo.KdTagItem)((Iterator)localObject3).next();
          oidb_0x885.KdTagItem localKdTagItem1 = new oidb_0x885.KdTagItem();
          localKdTagItem1.bytes_name.set(ByteStringMicro.copyFromUtf8(localKdTagItem.jdField_a_of_type_JavaLangString));
          localKdTagItem1.uint64_tagid.set(localKdTagItem.jdField_a_of_type_Long);
          ((ArrayList)localObject2).add(localKdTagItem1);
        }
        localAdTagInfo.rpt_kd_tag_list.set((List)localObject2);
      }
      localObject1 = ((VideoInfo.AdTagInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo;
      if (localObject1 != null)
      {
        localObject2 = new oidb_0x885.ClassInfo();
        ((oidb_0x885.ClassInfo)localObject2).string_ch1.set(((VideoInfo.ClassInfo)localObject1).jdField_a_of_type_JavaLangString);
        ((oidb_0x885.ClassInfo)localObject2).uint64_ch1_id.set(((VideoInfo.ClassInfo)localObject1).jdField_a_of_type_Long);
        ((oidb_0x885.ClassInfo)localObject2).string_ch2.set(((VideoInfo.ClassInfo)localObject1).jdField_b_of_type_JavaLangString);
        ((oidb_0x885.ClassInfo)localObject2).uint64_ch2_id.set(((VideoInfo.ClassInfo)localObject1).jdField_b_of_type_Long);
        ((oidb_0x885.ClassInfo)localObject2).string_ch3.set(((VideoInfo.ClassInfo)localObject1).jdField_c_of_type_JavaLangString);
        ((oidb_0x885.ClassInfo)localObject2).uint64_ch3_id.set(((VideoInfo.ClassInfo)localObject1).jdField_c_of_type_Long);
        localAdTagInfo.msg_class_info.set((MessageMicro)localObject2);
      }
      localArrayList.add(localAdTagInfo);
    }
    return localArrayList;
  }
  
  public static void a(Bundle paramBundle, ArrayList<VideoInfo> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!paramArrayList.isEmpty())
        {
          ArrayList localArrayList = new ArrayList(paramArrayList.size());
          i = 0;
          if (i < paramArrayList.size())
          {
            VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(i);
            if ((localVideoInfo.a == null) || (localVideoInfo.a.jdField_a_of_type_Int != 0)) {
              break label134;
            }
            localVideoInfo.a.jdField_b_of_type_Int = i;
            localArrayList.add(localVideoInfo.a);
            break label134;
          }
          paramBundle.putParcelableArrayList("value_msg_kd_tag_info", localArrayList);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("handleGetRecommendList: parse tag info error,e=");
          paramArrayList.append(paramBundle.getMessage());
          QLog.d("VideoFeedsAdTagHelper", 2, paramArrayList.toString());
        }
      }
      return;
      label134:
      i += 1;
    }
  }
  
  public static void a(oidb_0x6cf.ArticleSummary paramArticleSummary, VideoInfo paramVideoInfo)
  {
    if (paramArticleSummary.msg_kd_tag_info.has())
    {
      paramVideoInfo.a = new VideoInfo.AdTagInfo();
      if (paramArticleSummary.msg_kd_tag_info.bytes_rowkey.has()) {
        paramVideoInfo.a.jdField_a_of_type_JavaLangString = paramArticleSummary.msg_kd_tag_info.bytes_rowkey.get().toStringUtf8();
      }
      if (paramArticleSummary.msg_kd_tag_info.int32_display_ad_flag.has()) {
        paramVideoInfo.a.jdField_a_of_type_Int = paramArticleSummary.msg_kd_tag_info.int32_display_ad_flag.get();
      }
      if (paramVideoInfo.a.jdField_a_of_type_Int == 0)
      {
        Object localObject3;
        Object localObject2;
        Object localObject1;
        long l;
        if (paramArticleSummary.msg_kd_tag_info.msg_class_info.has())
        {
          localObject3 = (oidb_0x885.ClassInfo)paramArticleSummary.msg_kd_tag_info.msg_class_info.get();
          paramVideoInfo.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo = new VideoInfo.ClassInfo();
          VideoInfo.ClassInfo localClassInfo = paramVideoInfo.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo;
          boolean bool = ((oidb_0x885.ClassInfo)localObject3).string_ch1.has();
          localObject2 = "";
          if (bool) {
            localObject1 = ((oidb_0x885.ClassInfo)localObject3).string_ch1.get();
          } else {
            localObject1 = "";
          }
          localClassInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localClassInfo = paramVideoInfo.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo;
          if (((oidb_0x885.ClassInfo)localObject3).string_ch2.has()) {
            localObject1 = ((oidb_0x885.ClassInfo)localObject3).string_ch2.get();
          } else {
            localObject1 = "";
          }
          localClassInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
          localClassInfo = paramVideoInfo.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo;
          localObject1 = localObject2;
          if (((oidb_0x885.ClassInfo)localObject3).string_ch3.has()) {
            localObject1 = ((oidb_0x885.ClassInfo)localObject3).string_ch3.get();
          }
          localClassInfo.jdField_c_of_type_JavaLangString = ((String)localObject1);
          localObject1 = paramVideoInfo.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo;
          if (((oidb_0x885.ClassInfo)localObject3).uint64_ch1_id.has()) {
            l = ((oidb_0x885.ClassInfo)localObject3).uint64_ch1_id.get();
          } else {
            l = 0L;
          }
          ((VideoInfo.ClassInfo)localObject1).jdField_a_of_type_Long = l;
          localObject1 = paramVideoInfo.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo;
          if (((oidb_0x885.ClassInfo)localObject3).uint64_ch2_id.has()) {
            l = ((oidb_0x885.ClassInfo)localObject3).uint64_ch2_id.get();
          } else {
            l = 0L;
          }
          ((VideoInfo.ClassInfo)localObject1).jdField_b_of_type_Long = l;
          localObject1 = paramVideoInfo.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ClassInfo;
          if (((oidb_0x885.ClassInfo)localObject3).uint64_ch3_id.has()) {
            l = ((oidb_0x885.ClassInfo)localObject3).uint64_ch3_id.get();
          } else {
            l = 0L;
          }
          ((VideoInfo.ClassInfo)localObject1).jdField_c_of_type_Long = l;
        }
        if (paramArticleSummary.msg_kd_tag_info.string_ad_feature_info.has()) {
          paramVideoInfo.a.jdField_b_of_type_JavaLangString = paramArticleSummary.msg_kd_tag_info.string_ad_feature_info.get();
        }
        if (paramArticleSummary.msg_kd_tag_info.rpt_kd_tag_list.has())
        {
          localObject1 = new ArrayList(paramArticleSummary.msg_kd_tag_info.rpt_kd_tag_list.size());
          paramArticleSummary = paramArticleSummary.msg_kd_tag_info.rpt_kd_tag_list.get().iterator();
          while (paramArticleSummary.hasNext())
          {
            localObject2 = (oidb_0x885.KdTagItem)paramArticleSummary.next();
            localObject3 = new VideoInfo.KdTagItem();
            if (((oidb_0x885.KdTagItem)localObject2).bytes_name.has()) {
              ((VideoInfo.KdTagItem)localObject3).jdField_a_of_type_JavaLangString = RIJPBFieldUtils.b(((oidb_0x885.KdTagItem)localObject2).bytes_name);
            }
            if (((oidb_0x885.KdTagItem)localObject2).uint64_tagid.has()) {
              l = ((oidb_0x885.KdTagItem)localObject2).uint64_tagid.get();
            } else {
              l = 0L;
            }
            ((VideoInfo.KdTagItem)localObject3).jdField_a_of_type_Long = l;
            ((ArrayList)localObject1).add(localObject3);
          }
          paramVideoInfo.a.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
      }
    }
  }
  
  public static void a(oidb_0x6cf.RspBody paramRspBody, Bundle paramBundle, long paramLong)
  {
    try
    {
      if (paramRspBody.msg_ad_rsp.has())
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdVideoDataLink", "parseTagInfoResult:rspBody.msg_ad_rsp is not null");
        paramRspBody = (oidb_0x885.RspBody)paramRspBody.msg_ad_rsp.get();
        if ((paramRspBody.rpt_msg_pos_ad_info.has()) && (!paramRspBody.rpt_msg_pos_ad_info.get().isEmpty()))
        {
          localObject1 = paramRspBody.rpt_msg_pos_ad_info.get();
          paramRspBody = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseTagInfoResult:rspBody.rpt_msg_pos_ad_info posAdInfos size >>");
          ((StringBuilder)localObject2).append(((List)localObject1).size());
          paramRspBody.d("AdVideoDataLink", ((StringBuilder)localObject2).toString());
          if (((List)localObject1).size() > 0)
          {
            paramRspBody = new ArrayList(((List)localObject1).size());
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject4 = (oidb_0x885.PosAdInfo)((Iterator)localObject1).next();
              if ((((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.has()) && (!((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.isEmpty()))
              {
                Object localObject3 = (oidb_0x885.AdInfo)((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.get(0);
                localObject2 = ((oidb_0x885.AdInfo)localObject3).bytes_rowkey.get().toStringUtf8();
                localObject3 = ReadInJoyAdAtlasUtil.a((oidb_0x885.AdInfo)localObject3);
                int i = ((oidb_0x885.PosAdInfo)localObject4).enum_pos_layout.get();
                long l1 = ((oidb_0x885.PosAdInfo)localObject4).uint64_pos_id.get();
                long l2 = ((oidb_0x885.PosAdInfo)localObject4).is_auto_play.get();
                ((AdvertisementInfo)localObject3).mAdFetchTime = paramLong;
                ((AdvertisementInfo)localObject3).mAdPosLayout = i;
                ((AdvertisementInfo)localObject3).mAdPosID = l1;
                ((AdvertisementInfo)localObject3).mADVideoAutoPlay = l2;
                ((AdvertisementInfo)localObject3).mRowKey = ((String)localObject2);
                ((AdvertisementInfo)localObject3).mChannelID = 3L;
                if (((AdvertisementInfo)localObject3).mSoftAdType == 1)
                {
                  localObject4 = ((AdvertisementInfo)localObject3).mAdExt;
                  try
                  {
                    localObject2 = new GameAdComData((String)localObject2, new JSONObject((String)localObject4));
                    if ((TextUtils.isEmpty(((GameAdComData)localObject2).s)) || (TextUtils.isEmpty(((GameAdComData)localObject2).d))) {
                      continue;
                    }
                    ((AdvertisementInfo)localObject3).gameAdComData = ((GameAdComData)localObject2);
                    paramRspBody.add(localObject3);
                  }
                  catch (Exception localException) {}
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoFeedsAdTagHelper", 2, localException.getMessage());
                  }
                }
                else
                {
                  if (((AdvertisementInfo)localObject3).mAdPosID <= 0L) {
                    ((AdvertisementInfo)localObject3).mAdPosID = 1L;
                  }
                  paramRspBody.add(localObject3);
                }
              }
            }
            if (!paramRspBody.isEmpty())
            {
              paramBundle.putParcelableArrayList("value_msg_game_ad_info", paramRspBody);
              paramBundle = new StringBuilder();
              paramBundle.append("parseTagInfoResult:rsp for softAd or gameComponent:");
              paramRspBody = paramRspBody.iterator();
              while (paramRspBody.hasNext())
              {
                localObject1 = (AdvertisementInfo)paramRspBody.next();
                paramBundle.append("rowKey = ");
                paramBundle.append(((AdvertisementInfo)localObject1).mRowKey);
                paramBundle.append(" adTitle = ");
                paramBundle.append(((AdvertisementInfo)localObject1).mTitle);
                paramBundle.append(" \n");
              }
              ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdVideoDataLink", paramBundle.toString());
              return;
            }
            ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdVideoDataLink", "parseTagInfoResult:no softAd or gameComponent");
          }
        }
        else
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdVideoDataLink", "parseTagInfoResult:rspBody.rpt_msg_pos_ad_info null ");
          return;
        }
      }
    }
    catch (Exception paramRspBody)
    {
      paramBundle = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetRecommendList: parse game ad info error, e= ");
      ((StringBuilder)localObject1).append(paramRspBody.getMessage());
      paramBundle.d("AdVideoDataLink", ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.VideoFeedsAdTagHelper
 * JD-Core Version:    0.7.0.1
 */