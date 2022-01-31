package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BiuMultiLevel;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BiuOneLevelItem;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.GalleryPGCFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PGCFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PGCPicInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PGCVideoInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocializeFeedsExtInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocializeFeedsInfoUser;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UGCFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UGCPicInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UGCVideoInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfoUser;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendInfo;

public class SocializeFeedsInfo
  implements Cloneable
{
  public int a;
  public long a;
  public SocializeFeedsInfo.BiuInfo a;
  public SocializeFeedsInfo.FeedsInfoUser a;
  public SocializeFeedsInfo.PGCFeedsInfo a;
  public SocializeFeedsInfo.UGCFeedsInfo a;
  public TopicRecommendFeedsInfo a;
  public String a;
  public List a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public SocializeFeedsInfo()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser = new SocializeFeedsInfo.FeedsInfoUser(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static int a(PBEnumField paramPBEnumField)
  {
    if (paramPBEnumField.has()) {
      return paramPBEnumField.get();
    }
    return 0;
  }
  
  public static int a(PBUInt32Field paramPBUInt32Field)
  {
    if (paramPBUInt32Field.has()) {
      return paramPBUInt32Field.get();
    }
    return 0;
  }
  
  public static long a(PBUInt64Field paramPBUInt64Field)
  {
    if (paramPBUInt64Field.has()) {
      return paramPBUInt64Field.get();
    }
    return 0L;
  }
  
  public static SocializeFeedsInfo a(oidb_cmd0x68b.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null)
    {
      QLog.d("SocializeFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.jdField_a_of_type_Long = a(paramSocializeFeedsInfo.uint64_feeds_id);
    Object localObject1 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser;
    long l;
    label109:
    Object localObject3;
    label149:
    label359:
    Object localObject4;
    if (paramSocializeFeedsInfo.msg_master_uin.has())
    {
      l = a(((oidb_cmd0x68b.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint64_uin);
      ((SocializeFeedsInfo.FeedsInfoUser)localObject1).jdField_a_of_type_Long = l;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label481;
      }
      j = a(((oidb_cmd0x68b.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).enum_uin_type);
      ((SocializeFeedsInfo.FeedsInfoUser)localObject1).jdField_a_of_type_Int = j;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label486;
      }
      j = a(((oidb_cmd0x68b.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint32_star_style);
      ((SocializeFeedsInfo.FeedsInfoUser)localObject1).jdField_b_of_type_Int = j;
      localSocializeFeedsInfo.jdField_a_of_type_Int = a(paramSocializeFeedsInfo.uint32_feeds_style);
      localSocializeFeedsInfo.jdField_b_of_type_Int = a(paramSocializeFeedsInfo.uint32_like_count);
      localSocializeFeedsInfo.jdField_d_of_type_Int = a(paramSocializeFeedsInfo.uint32_comments_count);
      localSocializeFeedsInfo.jdField_e_of_type_Int = a(paramSocializeFeedsInfo.uint32_biu_time);
      localSocializeFeedsInfo.jdField_c_of_type_Int = a(paramSocializeFeedsInfo.uint32_myself_like_status);
      localSocializeFeedsInfo.i = a(paramSocializeFeedsInfo.uint32_follow_counts);
      localSocializeFeedsInfo.h = a(paramSocializeFeedsInfo.uint32_follow_status);
      QLog.d("SocializeFeedsInfo", 2, "create SocialFeedsInfo, feedsID : " + localSocializeFeedsInfo.jdField_a_of_type_Long + ", followCnt : " + localSocializeFeedsInfo.i + ", followStatus : " + localSocializeFeedsInfo.h + ", masterUin : " + localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long + ", followStatusHas : " + paramSocializeFeedsInfo.uint32_follow_status.has());
      if ((!paramSocializeFeedsInfo.rpt_recommend_list.has()) || (paramSocializeFeedsInfo.rpt_recommend_list.get() == null)) {
        break label501;
      }
      localObject1 = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label501;
      }
      localObject3 = (oidb_cmd0x68b.SocializeFeedsInfoUser)((Iterator)localObject1).next();
      localSocializeFeedsInfo.getClass();
      localObject4 = new SocializeFeedsInfo.FeedsInfoUser(localSocializeFeedsInfo);
      if ((!((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject3).has()) || (((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label491;
      }
      l = a(((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject3).uint64_uin);
      label423:
      ((SocializeFeedsInfo.FeedsInfoUser)localObject4).jdField_a_of_type_Long = l;
      if ((!((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject3).has()) || (((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label496;
      }
    }
    label481:
    label486:
    label491:
    label496:
    for (int j = a(((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject3).enum_uin_type);; j = 0)
    {
      ((SocializeFeedsInfo.FeedsInfoUser)localObject4).jdField_a_of_type_Int = j;
      localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localObject4);
      break label359;
      l = 0L;
      break;
      j = 0;
      break label109;
      j = 0;
      break label149;
      l = 0L;
      break label423;
    }
    label501:
    if ((paramSocializeFeedsInfo.bytes_comments.has()) && (paramSocializeFeedsInfo.bytes_comments.get() != null)) {}
    try
    {
      localObject1 = new String(paramSocializeFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      localSocializeFeedsInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = MessageUtils.b((String)localObject1);
      if ((!paramSocializeFeedsInfo.bytes_recommend_reason.has()) || (paramSocializeFeedsInfo.bytes_recommend_reason.get() == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        localSocializeFeedsInfo.jdField_c_of_type_JavaLangString = new String(paramSocializeFeedsInfo.bytes_recommend_reason.get().toByteArray(), "utf-8");
        if ((paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.has()) && (paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get() != null)) {
          localSocializeFeedsInfo.jdField_a_of_type_ArrayOfByte = ((oidb_cmd0x68b.SocializeFeedsExtInfo)paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get()).toByteArray();
        }
        localSocializeFeedsInfo.jdField_f_of_type_Int = a(paramSocializeFeedsInfo.uint32_biu_count);
        localSocializeFeedsInfo.g = a(paramSocializeFeedsInfo.uint32_myself_biu_status);
        if ((paramSocializeFeedsInfo.msg_biu_mutli_level.has()) && (paramSocializeFeedsInfo.msg_biu_mutli_level.get() != null)) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = localSocializeFeedsInfo.a((oidb_cmd0x68b.BiuMultiLevel)paramSocializeFeedsInfo.msg_biu_mutli_level.get());
        }
        if (paramSocializeFeedsInfo.uint64_article_id.has()) {
          localSocializeFeedsInfo.jdField_b_of_type_Long = paramSocializeFeedsInfo.uint64_article_id.get();
        }
        if (paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.has())
        {
          localObject1 = (oidb_cmd0x68b.UGCFeedsInfo)paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = new SocializeFeedsInfo.UGCFeedsInfo();
          if (((oidb_cmd0x68b.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int = ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.get();
          }
          if (((oidb_cmd0x68b.UGCFeedsInfo)localObject1).uint64_cuin.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long = ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).uint64_cuin.get();
          }
          if (((oidb_cmd0x68b.UGCFeedsInfo)localObject1).bytes_ugc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).bytes_ugc_comments.get().toStringUtf8();
          }
          if ((((oidb_cmd0x68b.UGCFeedsInfo)localObject1).msg_at_multi_level.has()) && (((oidb_cmd0x68b.UGCFeedsInfo)localObject1).msg_at_multi_level.get() != null)) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = localSocializeFeedsInfo.a((oidb_cmd0x68b.BiuMultiLevel)((oidb_cmd0x68b.UGCFeedsInfo)localObject1).msg_at_multi_level.get());
          }
          if (((oidb_cmd0x68b.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.has())
          {
            localObject3 = ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (oidb_cmd0x68b.UGCPicInfo)((Iterator)localObject3).next();
              localObject5 = new SocializeFeedsInfo.UGCPicInfo();
              if (((oidb_cmd0x68b.UGCPicInfo)localObject4).bytes_pic_md5.has()) {
                ((SocializeFeedsInfo.UGCPicInfo)localObject5).jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.UGCPicInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.UGCPicInfo)localObject4).bytes_pic_url.has()) {
                ((SocializeFeedsInfo.UGCPicInfo)localObject5).jdField_b_of_type_JavaLangString = ((oidb_cmd0x68b.UGCPicInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.UGCPicInfo)localObject4).uint32_pic_height.has()) {
                ((SocializeFeedsInfo.UGCPicInfo)localObject5).jdField_b_of_type_Int = ((oidb_cmd0x68b.UGCPicInfo)localObject4).uint32_pic_height.get();
              }
              if (((oidb_cmd0x68b.UGCPicInfo)localObject4).uint32_pic_width.has()) {
                ((SocializeFeedsInfo.UGCPicInfo)localObject5).jdField_a_of_type_Int = ((oidb_cmd0x68b.UGCPicInfo)localObject4).uint32_pic_width.get();
              }
              if (((oidb_cmd0x68b.UGCPicInfo)localObject4).bytes_thumbnail_url.has()) {
                ((SocializeFeedsInfo.UGCPicInfo)localObject5).jdField_c_of_type_JavaLangString = ((oidb_cmd0x68b.UGCPicInfo)localObject4).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.UGCPicInfo)localObject4).is_animation.has()) {
                ((SocializeFeedsInfo.UGCPicInfo)localObject5).jdField_c_of_type_Int = ((oidb_cmd0x68b.UGCPicInfo)localObject4).is_animation.get();
              }
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
              continue;
              localException1 = localException1;
              QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments failed ", localException1);
            }
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject5;
        for (;;)
        {
          QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments reason failed ", localException2);
        }
        Object localObject2;
        if (localException2.msg_ugc_video_info_list.has())
        {
          localObject2 = localException2.msg_ugc_video_info_list.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (oidb_cmd0x68b.UGCVideoInfo)((Iterator)localObject2).next();
            localObject4 = new SocializeFeedsInfo.UGCVideoInfo();
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_pic_md5.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_c_of_type_JavaLangString = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_pic_md5.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_pic_url.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_d_of_type_JavaLangString = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_pic_url.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_title.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_e_of_type_JavaLangString = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_title.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_uuid.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_f_of_type_JavaLangString = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_uuid.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_video_md5.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_video_md5.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_video_url.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_b_of_type_JavaLangString = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_video_url.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_share_url.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).h = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_share_url.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_vid.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).i = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_vid.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_uniq_id.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).g = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).bytes_uniq_id.get().toStringUtf8();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_busi_type.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_f_of_type_Int = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_busi_type.get();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_create_time.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_e_of_type_Int = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_create_time.get();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint64_duration.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_a_of_type_Long = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint64_duration.get();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_video_width.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_a_of_type_Int = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_video_width.get();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_video_height.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_b_of_type_Int = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_video_height.get();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_pic_width.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_c_of_type_Int = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_pic_width.get();
            }
            if (((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_pic_height.has()) {
              ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_d_of_type_Int = ((oidb_cmd0x68b.UGCVideoInfo)localObject3).uint32_pic_height.get();
            }
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject4);
          }
        }
        if (paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.has())
        {
          localObject2 = (oidb_cmd0x68b.PGCFeedsInfo)paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo = new SocializeFeedsInfo.PGCFeedsInfo();
          if (((oidb_cmd0x68b.PGCFeedsInfo)localObject2).bytes_pgc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.PGCFeedsInfo)localObject2).bytes_pgc_comments.get().toStringUtf8();
          }
          if (((oidb_cmd0x68b.PGCFeedsInfo)localObject2).uint32_myself_follow_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_b_of_type_Int = ((oidb_cmd0x68b.PGCFeedsInfo)localObject2).uint32_myself_follow_status.get();
          }
          if (((oidb_cmd0x68b.PGCFeedsInfo)localObject2).uint32_follow_counts.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_Int = ((oidb_cmd0x68b.PGCFeedsInfo)localObject2).uint32_follow_counts.get();
          }
          if (((oidb_cmd0x68b.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.has())
          {
            localObject3 = ((oidb_cmd0x68b.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (oidb_cmd0x68b.PGCPicInfo)((Iterator)localObject3).next();
              localObject5 = new SocializeFeedsInfo.PGCPicInfo();
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_pic_md5.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_pic_url.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_b_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).uint32_pic_height.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_b_of_type_Int = ((oidb_cmd0x68b.PGCPicInfo)localObject4).uint32_pic_height.get();
              }
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).uint32_pic_width.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_Int = ((oidb_cmd0x68b.PGCPicInfo)localObject4).uint32_pic_width.get();
              }
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).is_animation.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_c_of_type_Int = ((oidb_cmd0x68b.PGCPicInfo)localObject4).is_animation.get();
              }
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_thumbnail_url.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_c_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_pic_desc.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_d_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject4).bytes_pic_desc.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.PGCPicInfo)localObject4).uint64_gallery_index.has()) {
                ((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_Long = ((oidb_cmd0x68b.PGCPicInfo)localObject4).uint64_gallery_index.get();
              }
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
            }
          }
          if (((oidb_cmd0x68b.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.has())
          {
            localObject3 = ((oidb_cmd0x68b.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (oidb_cmd0x68b.PGCVideoInfo)((Iterator)localObject3).next();
              localObject5 = new SocializeFeedsInfo.PGCVideoInfo();
              if (((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_pic_md5.has()) {
                ((SocializeFeedsInfo.PGCVideoInfo)localObject5).jdField_c_of_type_JavaLangString = ((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_pic_url.has()) {
                ((SocializeFeedsInfo.PGCVideoInfo)localObject5).jdField_d_of_type_JavaLangString = ((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_video_md5.has()) {
                ((SocializeFeedsInfo.PGCVideoInfo)localObject5).jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_video_md5.get().toStringUtf8();
              }
              if (((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_video_url.has()) {
                ((SocializeFeedsInfo.PGCVideoInfo)localObject5).jdField_b_of_type_JavaLangString = ((oidb_cmd0x68b.PGCVideoInfo)localObject4).bytes_video_url.get().toStringUtf8();
              }
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
            }
          }
          if (((oidb_cmd0x68b.PGCFeedsInfo)localObject2).enum_pgc_feeds_type.has())
          {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int = ((oidb_cmd0x68b.PGCFeedsInfo)localObject2).enum_pgc_feeds_type.get();
            if ((((oidb_cmd0x68b.PGCFeedsInfo)localObject2).enum_pgc_feeds_type.get() == 1) && (((oidb_cmd0x68b.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.has()))
            {
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo = new SocializeFeedsInfo.GalleryPGCFeedsInfo();
              localObject2 = (oidb_cmd0x68b.GalleryPGCFeedsInfo)((oidb_cmd0x68b.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.get();
              if (((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.has()) {
                localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_Long = ((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.get();
              }
              if (((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).msg_pgc_pic_info_list.has())
              {
                localObject2 = ((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).msg_pgc_pic_info_list.get().iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (oidb_cmd0x68b.PGCPicInfo)((Iterator)localObject2).next();
                  localObject4 = new SocializeFeedsInfo.PGCPicInfo();
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).uint32_pic_width.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_Int = ((oidb_cmd0x68b.PGCPicInfo)localObject3).uint32_pic_width.get();
                  }
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).uint32_pic_height.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_b_of_type_Int = ((oidb_cmd0x68b.PGCPicInfo)localObject3).uint32_pic_height.get();
                  }
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_pic_md5.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_pic_md5.get().toStringUtf8();
                  }
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_pic_url.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_b_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_pic_url.get().toStringUtf8();
                  }
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_thumbnail_url.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_c_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_thumbnail_url.get().toStringUtf8();
                  }
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).is_animation.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_c_of_type_Int = ((oidb_cmd0x68b.PGCPicInfo)localObject3).is_animation.get();
                  }
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_pic_desc.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_d_of_type_JavaLangString = ((oidb_cmd0x68b.PGCPicInfo)localObject3).bytes_pic_desc.get().toStringUtf8();
                  }
                  if (((oidb_cmd0x68b.PGCPicInfo)localObject3).uint64_gallery_index.has()) {
                    ((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_Long = ((oidb_cmd0x68b.PGCPicInfo)localObject3).uint64_gallery_index.get();
                  }
                  localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
                }
              }
            }
          }
        }
        if (paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a((oidb_cmd0x68b.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
        }
        if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has()) {
          localSocializeFeedsInfo.jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
        }
      }
    }
    return localSocializeFeedsInfo;
  }
  
  public SocializeFeedsInfo.BiuInfo a(oidb_cmd0x68b.BiuMultiLevel paramBiuMultiLevel)
  {
    SocializeFeedsInfo.BiuInfo localBiuInfo = new SocializeFeedsInfo.BiuInfo(this);
    localBiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localBiuInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      for (;;)
      {
        if (paramBiuMultiLevel.hasNext())
        {
          Object localObject = (oidb_cmd0x68b.BiuOneLevelItem)paramBiuMultiLevel.next();
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo(this);
          localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(a(((oidb_cmd0x68b.BiuOneLevelItem)localObject).uint64_uin));
          localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(a(((oidb_cmd0x68b.BiuOneLevelItem)localObject).uint64_feeds_id));
          localBiuCommentInfo.jdField_a_of_type_Int = a(((oidb_cmd0x68b.BiuOneLevelItem)localObject).uint32_biu_time);
          localBiuCommentInfo.jdField_b_of_type_Int = a(((oidb_cmd0x68b.BiuOneLevelItem)localObject).feeds_type);
          localBiuCommentInfo.jdField_c_of_type_Int = a(((oidb_cmd0x68b.BiuOneLevelItem)localObject).op_type);
          if ((((oidb_cmd0x68b.BiuOneLevelItem)localObject).bytes_biu_comments.has()) && (((oidb_cmd0x68b.BiuOneLevelItem)localObject).bytes_biu_comments.get() != null)) {}
          try
          {
            localObject = new String(((oidb_cmd0x68b.BiuOneLevelItem)localObject).bytes_biu_comments.get().toByteArray(), "utf-8");
            localBiuCommentInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
            localBiuCommentInfo.jdField_a_of_type_JavaLangString = MessageUtils.b((String)localObject);
            localBiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("SocializeFeedsInfo", 1, "parse bytes_biu_comment failed ", localException);
            }
          }
        }
      }
    }
    return localBiuInfo;
  }
  
  public SocializeFeedsInfo a()
  {
    try
    {
      localSocializeFeedsInfo = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a();
        localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)localIterator.next();
          localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localFeedsInfoUser.a());
        }
        QLog.d("SocializeFeedsInfo", 1, "clone SocializeFeedsInfo failed ", localCloneNotSupportedException1);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      for (;;)
      {
        SocializeFeedsInfo localSocializeFeedsInfo = null;
      }
    }
    return localSocializeFeedsInfo;
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a();
    return localSocializeFeedsInfo;
  }
  
  public void a(oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null) {
      return;
    }
    this.jdField_b_of_type_Int = a(paramSocializeFeedsInfo.uint32_like_count);
    this.jdField_d_of_type_Int = a(paramSocializeFeedsInfo.uint32_comments_count);
    this.jdField_c_of_type_Int = a(paramSocializeFeedsInfo.uint32_myself_like_status);
    this.jdField_f_of_type_Int = a(paramSocializeFeedsInfo.uint32_biu_count);
    this.g = a(paramSocializeFeedsInfo.uint32_myself_biu_status);
    if (paramSocializeFeedsInfo.uint32_follow_count.has()) {
      this.i = a(paramSocializeFeedsInfo.uint32_follow_count);
    }
    if (paramSocializeFeedsInfo.uint32_follow_status.has()) {
      this.h = a(paramSocializeFeedsInfo.uint32_follow_status);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1;
    Object localObject2;
    if ((paramSocializeFeedsInfo.rpt_recommend_list.has()) && (paramSocializeFeedsInfo.rpt_recommend_list.get() != null))
    {
      localObject1 = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0x8c8.SocializeFeedsInfoUser)((Iterator)localObject1).next();
        SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = new SocializeFeedsInfo.FeedsInfoUser(this);
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {}
        for (long l = a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);; l = 0L)
        {
          localFeedsInfoUser.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_JavaUtilList.add(localFeedsInfoUser);
          break;
        }
      }
    }
    if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramSocializeFeedsInfo = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo = paramSocializeFeedsInfo.msg_topic_recommend_info.get();
        int j = 0;
        while ((j < paramSocializeFeedsInfo.size()) && (j < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo.get(j);
          localObject2 = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_b_of_type_Int = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
          }
          j += 1;
        }
      }
    }
    QLog.d("SocializeFeedsInfo", 2, "8c8 update followStatus : " + this.h + ", followCnt : " + this.h + ", feedsID : " + this.jdField_a_of_type_Long);
  }
  
  public byte[] a()
  {
    oidb_cmd0x68b.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x68b.SocializeFeedsInfo();
    localSocializeFeedsInfo.uint64_feeds_id.set(this.jdField_a_of_type_Long);
    localSocializeFeedsInfo.uint32_comments_count.set(this.jdField_d_of_type_Int);
    localSocializeFeedsInfo.uint32_biu_time.set(this.jdField_e_of_type_Int);
    localSocializeFeedsInfo.uint32_feeds_style.set(this.jdField_a_of_type_Int);
    localSocializeFeedsInfo.uint32_like_count.set(this.jdField_b_of_type_Int);
    localSocializeFeedsInfo.uint32_myself_like_status.set(this.jdField_c_of_type_Int);
    Object localObject1 = new oidb_cmd0x68b.SocializeFeedsInfoUser();
    ((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject1).uint64_uin.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
    ((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject1).enum_uin_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int);
    ((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject1).uint32_star_style.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_b_of_type_Int);
    localSocializeFeedsInfo.msg_master_uin.set((MessageMicro)localObject1);
    localSocializeFeedsInfo.uint32_follow_counts.set(this.i);
    localSocializeFeedsInfo.uint32_follow_status.set(this.h);
    localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject2).next();
      localObject4 = new oidb_cmd0x68b.SocializeFeedsInfoUser();
      ((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject4).uint64_uin.set(((SocializeFeedsInfo.FeedsInfoUser)localObject3).jdField_a_of_type_Long);
      ((oidb_cmd0x68b.SocializeFeedsInfoUser)localObject4).enum_uin_type.set(((SocializeFeedsInfo.FeedsInfoUser)localObject3).jdField_a_of_type_Int);
      ((List)localObject1).add(localObject4);
    }
    localSocializeFeedsInfo.rpt_recommend_list.set((List)localObject1);
    if (this.jdField_b_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_c_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    localSocializeFeedsInfo.uint32_myself_biu_status.set(this.g);
    localSocializeFeedsInfo.uint32_biu_count.set(this.jdField_f_of_type_Int);
    try
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        localSocializeFeedsInfo.msg_socialize_feeds_ext_info.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a());
      }
    }
    catch (Exception localException)
    {
      Object localObject5;
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
      }
      localException.msg_ugc_pic_info_list.set((List)localObject2);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1118;
      }
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SocializeFeedsInfo.UGCVideoInfo)((Iterator)localObject3).next();
        localObject5 = new oidb_cmd0x68b.UGCVideoInfo();
        ((oidb_cmd0x68b.UGCVideoInfo)localObject5).uint64_duration.set(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_b_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_a_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_f_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_c_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_d_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_e_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_title.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).g)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).g));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).h)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).h));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject4).i)) {
          ((oidb_cmd0x68b.UGCVideoInfo)localObject5).bytes_vid.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject4).i));
        }
        ((oidb_cmd0x68b.UGCVideoInfo)localObject5).uint32_create_time.set(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_e_of_type_Int);
        ((oidb_cmd0x68b.UGCVideoInfo)localObject5).uint32_busi_type.set(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_f_of_type_Int);
        ((oidb_cmd0x68b.UGCVideoInfo)localObject5).uint32_pic_height.set(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_d_of_type_Int);
        ((oidb_cmd0x68b.UGCVideoInfo)localObject5).uint32_pic_width.set(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_c_of_type_Int);
        ((oidb_cmd0x68b.UGCVideoInfo)localObject5).uint32_video_height.set(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_b_of_type_Int);
        ((oidb_cmd0x68b.UGCVideoInfo)localObject5).uint32_video_width.set(((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_a_of_type_Int);
        ((List)localObject2).add(localObject5);
      }
      localException.msg_ugc_video_info_list.set((List)localObject2);
      label1118:
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(localException);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) {
        break label2180;
      }
      oidb_cmd0x68b.PGCFeedsInfo localPGCFeedsInfo = new oidb_cmd0x68b.PGCFeedsInfo();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString)) {
        break label1171;
      }
      localPGCFeedsInfo.bytes_pgc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString));
      label1171:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_b_of_type_Int == -1) {
        break label1196;
      }
      localPGCFeedsInfo.uint32_myself_follow_status.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_b_of_type_Int);
      label1196:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_Int == -1) {
        break label1221;
      }
      localPGCFeedsInfo.uint32_follow_counts.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_Int);
      label1221:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1487;
      }
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SocializeFeedsInfo.PGCPicInfo)((Iterator)localObject3).next();
        localObject5 = new oidb_cmd0x68b.PGCPicInfo();
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCPicInfo)localObject5).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_b_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCPicInfo)localObject5).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_b_of_type_JavaLangString));
        }
        ((oidb_cmd0x68b.PGCPicInfo)localObject5).uint32_pic_height.set(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_b_of_type_Int);
        ((oidb_cmd0x68b.PGCPicInfo)localObject5).uint32_pic_width.set(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_c_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCPicInfo)localObject5).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_d_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCPicInfo)localObject5).bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_d_of_type_JavaLangString));
        }
        if (((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_Long != -1L) {
          ((oidb_cmd0x68b.PGCPicInfo)localObject5).uint64_gallery_index.set(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_a_of_type_Long);
        }
        ((oidb_cmd0x68b.PGCPicInfo)localObject5).is_animation.set(((SocializeFeedsInfo.PGCPicInfo)localObject4).jdField_c_of_type_Int);
        ((List)localObject2).add(localObject5);
      }
      localPGCFeedsInfo.msg_pgc_pic_info_list.set((List)localObject2);
      label1487:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1689;
      }
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SocializeFeedsInfo.PGCVideoInfo)((Iterator)localObject3).next();
        localObject5 = new oidb_cmd0x68b.PGCVideoInfo();
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_b_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCVideoInfo)localObject5).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_a_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCVideoInfo)localObject5).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_c_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCVideoInfo)localObject5).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_d_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.PGCVideoInfo)localObject5).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject4).jdField_d_of_type_JavaLangString));
        }
        ((List)localObject2).add(localObject5);
      }
      localPGCFeedsInfo.msg_pgc_video_info_list.set((List)localObject2);
      label1689:
      localPGCFeedsInfo.enum_pgc_feeds_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo == null) {
        break label2172;
      }
      localObject2 = new oidb_cmd0x68b.GalleryPGCFeedsInfo();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_Long == -1L) {
        break label1755;
      }
      ((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_Long);
      label1755:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_b_of_type_Long == -1L) {
        break label1789;
      }
      ((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).uint64_source.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_b_of_type_Long);
      label1789:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.c == -1L) {
        break label1823;
      }
      ((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).uint64_sub_source.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.c);
      label1823:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaLangString)) {
        break label1859;
      }
      ((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).bytes_gallery_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaLangString));
      label1859:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2164;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (SocializeFeedsInfo.PGCPicInfo)((Iterator)localObject4).next();
        oidb_cmd0x68b.PGCPicInfo localPGCPicInfo = new oidb_cmd0x68b.PGCPicInfo();
        if (((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_Int != -1) {
          localPGCPicInfo.uint32_pic_width.set(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_Int);
        }
        if (((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_b_of_type_Int != -1) {
          localPGCPicInfo.uint32_pic_height.set(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_b_of_type_Int);
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_JavaLangString)) {
          localPGCPicInfo.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_b_of_type_JavaLangString)) {
          localPGCPicInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_c_of_type_JavaLangString)) {
          localPGCPicInfo.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_c_of_type_JavaLangString));
        }
        if (((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_c_of_type_Int != -1) {
          localPGCPicInfo.is_animation.set(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_c_of_type_Int);
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_d_of_type_JavaLangString)) {
          localPGCPicInfo.bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_d_of_type_JavaLangString));
        }
        if (((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_Long != -1L) {
          localPGCPicInfo.uint64_gallery_index.set(((SocializeFeedsInfo.PGCPicInfo)localObject5).jdField_a_of_type_Long);
        }
        ((List)localObject3).add(localPGCPicInfo);
      }
      ((oidb_cmd0x68b.GalleryPGCFeedsInfo)localObject2).msg_pgc_pic_info_list.set((List)localObject3);
      label2164:
      localPGCFeedsInfo.msg_gallery_feeds_info.set((MessageMicro)localObject2);
      label2172:
      localSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(localPGCFeedsInfo);
      label2180:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo == null) {
        break label2201;
      }
      localSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a());
      label2201:
      if (this.jdField_d_of_type_JavaLangString == null) {
        break label2222;
      }
      localSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    }
    localSocializeFeedsInfo.uint64_article_id.set(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null)
    {
      localObject1 = new oidb_cmd0x68b.UGCFeedsInfo();
      ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString)) {
        ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) {
        ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).msg_at_multi_level.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a());
      }
      ((oidb_cmd0x68b.UGCFeedsInfo)localObject1).uint64_cuin.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (SocializeFeedsInfo.UGCPicInfo)((Iterator)localObject3).next();
          localObject5 = new oidb_cmd0x68b.UGCPicInfo();
          ((oidb_cmd0x68b.UGCPicInfo)localObject5).uint32_pic_width.set(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_a_of_type_Int);
          ((oidb_cmd0x68b.UGCPicInfo)localObject5).uint32_pic_height.set(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_b_of_type_Int);
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_b_of_type_JavaLangString)) {
            ((oidb_cmd0x68b.UGCPicInfo)localObject5).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_a_of_type_JavaLangString)) {
            ((oidb_cmd0x68b.UGCPicInfo)localObject5).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_c_of_type_JavaLangString)) {
            ((oidb_cmd0x68b.UGCPicInfo)localObject5).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_c_of_type_JavaLangString));
          }
          ((oidb_cmd0x68b.UGCPicInfo)localObject5).is_animation.set(((SocializeFeedsInfo.UGCPicInfo)localObject4).jdField_c_of_type_Int);
          ((List)localObject2).add(localObject5);
        }
      }
    }
    label2222:
    return localSocializeFeedsInfo.toByteArray();
  }
  
  public String toString()
  {
    return "SocializeFeedsInfo{mFeedStyle=" + this.jdField_a_of_type_Int + ", mRecommUinList=" + this.jdField_a_of_type_JavaUtilList + ", mLikeCount=" + this.jdField_b_of_type_Int + ", mLikeStatus=" + this.jdField_c_of_type_Int + ", mCommentCount=" + this.jdField_d_of_type_Int + ", mBiuTime=" + this.jdField_e_of_type_Int + ", mCommentWording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommReason='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mMasterUser.uin='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long + '\'' + ", mMasterUser.type='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int + '\'' + ", mMasterUser.starType='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_b_of_type_Int + '\'' + ", mBiuCount='" + this.jdField_f_of_type_Int + '\'' + ", mBiuStatus='" + this.g + '\'' + ", mBiuInfo='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo + '\'' + ", mFollowStatus='" + this.h + '\'' + ", mFollowCnt='" + this.i + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */