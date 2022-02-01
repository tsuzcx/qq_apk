package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;

public class SocializeFeedsInfo$UGCFeedsInfo
{
  public int a;
  public long a;
  public SocializeFeedsInfo.AccountProfileInfo a;
  public SocializeFeedsInfo.BiuInfo a;
  public String a;
  public ArrayList<SocializeFeedsInfo.UGCPicInfo> a;
  public int b;
  public String b;
  public ArrayList<SocializeFeedsInfo.UGCVideoInfo> b;
  public String c;
  public ArrayList<SocializeFeedsInfo.UGCVoiceInfo> c;
  
  public SocializeFeedsInfo$UGCFeedsInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  static void a(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    if ((paramUGCFeedsInfo.jdField_c_of_type_JavaUtilArrayList != null) && (paramUGCFeedsInfo.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        SocializeFeedsInfo.UGCVoiceInfo localUGCVoiceInfo = (SocializeFeedsInfo.UGCVoiceInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCVoiceInfo localUGCVoiceInfo1 = new articlesummary.UGCVoiceInfo();
        localUGCVoiceInfo1.uint32_duration.set(localUGCVoiceInfo.duration);
        localUGCVoiceInfo1.uint32_file_size.set(localUGCVoiceInfo.fileSize);
        if (!TextUtils.isEmpty(localUGCVoiceInfo.voiceUrl)) {
          localUGCVoiceInfo1.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localUGCVoiceInfo.voiceUrl));
        }
        localArrayList.add(localUGCVoiceInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_voice_info_list.set(localArrayList);
    }
  }
  
  private static UGCFeedsInfo b(SocializeFeedsInfo paramSocializeFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    UGCFeedsInfo localUGCFeedsInfo = new UGCFeedsInfo();
    localUGCFeedsInfo.jdField_a_of_type_Int = RIJPBFieldUtils.a(paramUGCFeedsInfo.enum_ugc_feeds_card_type, 0);
    localUGCFeedsInfo.jdField_a_of_type_Long = RIJPBFieldUtils.a(paramUGCFeedsInfo.uint64_cuin, 0L);
    localUGCFeedsInfo.jdField_b_of_type_Int = RIJPBFieldUtils.a(paramUGCFeedsInfo.enum_ugc_feeds_src, 0);
    localUGCFeedsInfo.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramUGCFeedsInfo.bytes_ugc_comments);
    if ((paramUGCFeedsInfo.msg_at_multi_level.has()) && (paramUGCFeedsInfo.msg_at_multi_level.get() != null)) {
      localUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = paramSocializeFeedsInfo.a(paramUGCFeedsInfo.msg_at_multi_level);
    }
    if (paramUGCFeedsInfo.account_profile.has()) {
      localUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo = SocializeFeedsInfo.AccountProfileInfo.a((feeds_info.AccountProfile)paramUGCFeedsInfo.account_profile.get());
    }
    Object localObject1;
    Object localObject2;
    if (paramUGCFeedsInfo.msg_ugc_pic_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_pic_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCPicInfo)paramSocializeFeedsInfo.next();
        localObject2 = new SocializeFeedsInfo.UGCPicInfo();
        ((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5);
        ((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_url);
        ((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_b_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_height);
        ((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_a_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_width);
        ((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url);
        ((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_c_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).is_animation);
        localUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_video_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_video_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVideoInfo)paramSocializeFeedsInfo.next();
        localObject2 = new SocializeFeedsInfo.UGCVideoInfo();
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_d_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_e_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_title);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_f_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uuid);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_url);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).h = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_share_url);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).i = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_vid);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).g = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_f_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_e_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_create_time);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_a_of_type_Long = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint64_duration);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_a_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_width);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_b_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_height);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_c_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width);
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_d_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height);
        localUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_voice_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_voice_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVoiceInfo)paramSocializeFeedsInfo.next();
        localObject2 = new SocializeFeedsInfo.UGCVoiceInfo();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).voiceUrl = ((articlesummary.UGCVoiceInfo)localObject1).bytes_voice_url.get().toStringUtf8();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).duration = ((articlesummary.UGCVoiceInfo)localObject1).uint32_duration.get();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).fileSize = ((articlesummary.UGCVoiceInfo)localObject1).uint32_file_size.get();
        localUGCFeedsInfo.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    localUGCFeedsInfo.jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(paramUGCFeedsInfo.bytes_jump_url);
    return localUGCFeedsInfo;
  }
  
  private static articlesummary.UGCFeedsInfo b(UGCFeedsInfo paramUGCFeedsInfo)
  {
    articlesummary.UGCFeedsInfo localUGCFeedsInfo = new articlesummary.UGCFeedsInfo();
    d(paramUGCFeedsInfo, localUGCFeedsInfo);
    c(paramUGCFeedsInfo, localUGCFeedsInfo);
    b(paramUGCFeedsInfo, localUGCFeedsInfo);
    a(paramUGCFeedsInfo, localUGCFeedsInfo);
    return localUGCFeedsInfo;
  }
  
  static void b(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    if ((paramUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList != null) && (paramUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        SocializeFeedsInfo.UGCVideoInfo localUGCVideoInfo = (SocializeFeedsInfo.UGCVideoInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCVideoInfo localUGCVideoInfo1 = new articlesummary.UGCVideoInfo();
        localUGCVideoInfo1.uint64_duration.set(localUGCVideoInfo.jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_b_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_video_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_a_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_f_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_uuid.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_c_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_d_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_e_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_title.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.g)) {
          localUGCVideoInfo1.bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.g));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.h)) {
          localUGCVideoInfo1.bytes_share_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.h));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.i)) {
          localUGCVideoInfo1.bytes_vid.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.i));
        }
        localUGCVideoInfo1.uint32_create_time.set(localUGCVideoInfo.jdField_e_of_type_Int);
        localUGCVideoInfo1.uint32_busi_type.set(localUGCVideoInfo.jdField_f_of_type_Int);
        localUGCVideoInfo1.uint32_pic_height.set(localUGCVideoInfo.jdField_d_of_type_Int);
        localUGCVideoInfo1.uint32_pic_width.set(localUGCVideoInfo.jdField_c_of_type_Int);
        localUGCVideoInfo1.uint32_video_height.set(localUGCVideoInfo.jdField_b_of_type_Int);
        localUGCVideoInfo1.uint32_video_width.set(localUGCVideoInfo.jdField_a_of_type_Int);
        localArrayList.add(localUGCVideoInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_video_info_list.set(localArrayList);
    }
  }
  
  static void c(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    if ((paramUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        SocializeFeedsInfo.UGCPicInfo localUGCPicInfo = (SocializeFeedsInfo.UGCPicInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCPicInfo localUGCPicInfo1 = new articlesummary.UGCPicInfo();
        localUGCPicInfo1.uint32_pic_width.set(localUGCPicInfo.jdField_a_of_type_Int);
        localUGCPicInfo1.uint32_pic_height.set(localUGCPicInfo.jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(localUGCPicInfo.jdField_b_of_type_JavaLangString)) {
          localUGCPicInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCPicInfo.jdField_a_of_type_JavaLangString)) {
          localUGCPicInfo1.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCPicInfo.jdField_c_of_type_JavaLangString)) {
          localUGCPicInfo1.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.jdField_c_of_type_JavaLangString));
        }
        localUGCPicInfo1.is_animation.set(localUGCPicInfo.jdField_c_of_type_Int);
        localArrayList.add(localUGCPicInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_pic_info_list.set(localArrayList);
    }
  }
  
  private static void d(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    paramUGCFeedsInfo1.enum_ugc_feeds_card_type.set(paramUGCFeedsInfo.jdField_a_of_type_Int);
    paramUGCFeedsInfo1.enum_ugc_feeds_src.set(paramUGCFeedsInfo.jdField_b_of_type_Int);
    paramUGCFeedsInfo1.uint64_cuin.set(paramUGCFeedsInfo.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString)) {
      paramUGCFeedsInfo1.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString));
    }
    if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) {
      paramUGCFeedsInfo1.msg_at_multi_level.set(paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a());
    }
    if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo != null) {
      paramUGCFeedsInfo1.account_profile.set(paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo.a());
    }
    if (!TextUtils.isEmpty(paramUGCFeedsInfo.jdField_c_of_type_JavaLangString)) {
      paramUGCFeedsInfo1.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramUGCFeedsInfo.jdField_c_of_type_JavaLangString));
    }
  }
  
  public String toString()
  {
    return "UGCFeedsInfo{ugcFeedsCardType=" + this.jdField_a_of_type_Int + ", ugcPicInfos=" + this.jdField_a_of_type_JavaUtilArrayList + ", ugcVideoInfos=" + this.jdField_b_of_type_JavaUtilArrayList + ", ugcVoiceInfos=" + this.jdField_c_of_type_JavaUtilArrayList + ", cuin=" + this.jdField_a_of_type_Long + ", ugcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", nickName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", ugcAtComments=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo + ", ugcFeedsSrc=" + this.jdField_b_of_type_Int + ", jumpUrl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", accountProfileInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */