package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.GalleryPGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class SocializeFeedsInfo$PGCFeedsInfo
{
  public int a;
  public SocializeFeedsInfo.GalleryPGCFeedsInfo a;
  public String a;
  public ArrayList<SocializeFeedsInfo.PGCPicInfo> a;
  public boolean a;
  public int b;
  public ArrayList<SocializeFeedsInfo.PGCVideoInfo> b;
  public int c;
  
  public SocializeFeedsInfo$PGCFeedsInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    SocializeFeedsInfo.PGCPicInfo localPGCPicInfo;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localPGCPicInfo.toString() + "},") {
      localPGCPicInfo = (SocializeFeedsInfo.PGCPicInfo)localIterator.next();
    }
    return str + "]";
  }
  
  public static articlesummary.PGCFeedsInfo a(PGCFeedsInfo paramPGCFeedsInfo)
  {
    articlesummary.PGCFeedsInfo localPGCFeedsInfo = new articlesummary.PGCFeedsInfo();
    RIJPBFieldUtils.a(localPGCFeedsInfo.bytes_pgc_comments, paramPGCFeedsInfo.jdField_a_of_type_JavaLangString);
    if (paramPGCFeedsInfo.jdField_a_of_type_Boolean) {
      localPGCFeedsInfo.uint32_article_type.set(1);
    }
    RIJPBFieldUtils.a(localPGCFeedsInfo.uint32_myself_follow_status, paramPGCFeedsInfo.jdField_b_of_type_Int);
    RIJPBFieldUtils.a(localPGCFeedsInfo.uint32_follow_counts, paramPGCFeedsInfo.jdField_a_of_type_Int);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (a(paramPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SocializeFeedsInfo.PGCPicInfo)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCPicInfo();
        RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_JavaLangString);
        RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_b_of_type_JavaLangString);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_height.set(((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_b_of_type_Int);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_width.set(((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_Int);
        RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_c_of_type_JavaLangString);
        RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((SocializeFeedsInfo.PGCPicInfo)localObject3).d);
        RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_Long);
        if (((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo != null)
        {
          articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
          RIJPBFieldUtils.a(localPGCVideoInfo.bytes_vid, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.e);
          RIJPBFieldUtils.a(localPGCVideoInfo.bytes_video_url, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.jdField_b_of_type_JavaLangString);
          RIJPBFieldUtils.a(localPGCVideoInfo.bytes_video_md5, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.jdField_a_of_type_JavaLangString);
          RIJPBFieldUtils.a(localPGCVideoInfo.bytes_pic_md5, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.jdField_c_of_type_JavaLangString);
          RIJPBFieldUtils.a(localPGCVideoInfo.bytes_pic_url, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.d);
          localPGCVideoInfo.uint32_duration.set(((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.jdField_a_of_type_Int);
          localPGCVideoInfo.uint32_busi_type.set(((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.jdField_b_of_type_Int);
          ((articlesummary.PGCPicInfo)localObject4).msg_video_info.set(localPGCVideoInfo);
        }
        ((articlesummary.PGCPicInfo)localObject4).is_animation.set(((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_c_of_type_Int);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_pic_info_list.set((List)localObject1);
    }
    if (b(paramPGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramPGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SocializeFeedsInfo.PGCVideoInfo)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCVideoInfo();
        RIJPBFieldUtils.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_url, ((SocializeFeedsInfo.PGCVideoInfo)localObject3).jdField_b_of_type_JavaLangString);
        RIJPBFieldUtils.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5, ((SocializeFeedsInfo.PGCVideoInfo)localObject3).jdField_a_of_type_JavaLangString);
        RIJPBFieldUtils.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5, ((SocializeFeedsInfo.PGCVideoInfo)localObject3).jdField_c_of_type_JavaLangString);
        RIJPBFieldUtils.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url, ((SocializeFeedsInfo.PGCVideoInfo)localObject3).d);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_video_info_list.set((List)localObject1);
    }
    localPGCFeedsInfo.enum_pgc_feeds_type.set(paramPGCFeedsInfo.jdField_c_of_type_Int);
    if (paramPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo != null)
    {
      localObject1 = new articlesummary.GalleryPGCFeedsInfo();
      RIJPBFieldUtils.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_pic_count, paramPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_Long);
      RIJPBFieldUtils.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_source, paramPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.b);
      RIJPBFieldUtils.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_sub_source, paramPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.c);
      RIJPBFieldUtils.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).bytes_gallery_url, paramPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaLangString);
      if (a(paramPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList))
      {
        localObject2 = new ArrayList();
        paramPGCFeedsInfo = paramPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramPGCFeedsInfo.hasNext())
        {
          localObject3 = (SocializeFeedsInfo.PGCPicInfo)paramPGCFeedsInfo.next();
          localObject4 = new articlesummary.PGCPicInfo();
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_width, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_Int);
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_height, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_b_of_type_Int);
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_JavaLangString);
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_b_of_type_JavaLangString);
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_c_of_type_JavaLangString);
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).is_animation, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_c_of_type_Int);
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((SocializeFeedsInfo.PGCPicInfo)localObject3).d);
          RIJPBFieldUtils.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((SocializeFeedsInfo.PGCPicInfo)localObject3).jdField_a_of_type_Long);
          ((List)localObject2).add(localObject4);
        }
      }
      localPGCFeedsInfo.msg_gallery_feeds_info.set((MessageMicro)localObject1);
    }
    return localPGCFeedsInfo;
  }
  
  private static void a(articlesummary.PGCFeedsInfo paramPGCFeedsInfo, PGCFeedsInfo paramPGCFeedsInfo1)
  {
    paramPGCFeedsInfo = paramPGCFeedsInfo.msg_pgc_video_info_list.get().iterator();
    while (paramPGCFeedsInfo.hasNext())
    {
      articlesummary.PGCVideoInfo localPGCVideoInfo = (articlesummary.PGCVideoInfo)paramPGCFeedsInfo.next();
      SocializeFeedsInfo.PGCVideoInfo localPGCVideoInfo1 = new SocializeFeedsInfo.PGCVideoInfo();
      if (localPGCVideoInfo.bytes_pic_md5.has()) {
        localPGCVideoInfo1.jdField_c_of_type_JavaLangString = localPGCVideoInfo.bytes_pic_md5.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_pic_url.has()) {
        localPGCVideoInfo1.d = localPGCVideoInfo.bytes_pic_url.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_video_md5.has()) {
        localPGCVideoInfo1.jdField_a_of_type_JavaLangString = localPGCVideoInfo.bytes_video_md5.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_video_url.has()) {
        localPGCVideoInfo1.jdField_b_of_type_JavaLangString = localPGCVideoInfo.bytes_video_url.get().toStringUtf8();
      }
      paramPGCFeedsInfo1.jdField_b_of_type_JavaUtilArrayList.add(localPGCVideoInfo1);
    }
  }
  
  private static boolean a(List<SocializeFeedsInfo.PGCPicInfo> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  private static PGCFeedsInfo b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo)
  {
    PGCFeedsInfo localPGCFeedsInfo = new PGCFeedsInfo();
    if (paramPGCFeedsInfo.bytes_pgc_comments.has()) {
      localPGCFeedsInfo.jdField_a_of_type_JavaLangString = paramPGCFeedsInfo.bytes_pgc_comments.get().toStringUtf8();
    }
    if (paramPGCFeedsInfo.uint32_myself_follow_status.has()) {
      localPGCFeedsInfo.jdField_b_of_type_Int = paramPGCFeedsInfo.uint32_myself_follow_status.get();
    }
    if (paramPGCFeedsInfo.uint32_follow_counts.has()) {
      localPGCFeedsInfo.jdField_a_of_type_Int = paramPGCFeedsInfo.uint32_follow_counts.get();
    }
    if (paramPGCFeedsInfo.uint32_article_type.has()) {
      localPGCFeedsInfo.jdField_a_of_type_Boolean = true;
    }
    if (paramPGCFeedsInfo.msg_pgc_pic_info_list.has()) {
      b(paramPGCFeedsInfo, localPGCFeedsInfo);
    }
    if (paramPGCFeedsInfo.msg_pgc_video_info_list.has()) {
      a(paramPGCFeedsInfo, localPGCFeedsInfo);
    }
    if (paramPGCFeedsInfo.msg_gallery_feeds_info.has())
    {
      localPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo = new SocializeFeedsInfo.GalleryPGCFeedsInfo();
      paramPGCFeedsInfo = (articlesummary.GalleryPGCFeedsInfo)paramPGCFeedsInfo.msg_gallery_feeds_info.get();
      if (paramPGCFeedsInfo.uint64_pic_count.has()) {
        localPGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.jdField_a_of_type_Long = paramPGCFeedsInfo.uint64_pic_count.get();
      }
    }
    return localPGCFeedsInfo;
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    SocializeFeedsInfo.PGCVideoInfo localPGCVideoInfo;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localPGCVideoInfo.toString() + "},") {
      localPGCVideoInfo = (SocializeFeedsInfo.PGCVideoInfo)localIterator.next();
    }
    return str + "]";
  }
  
  private static void b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo, PGCFeedsInfo paramPGCFeedsInfo1)
  {
    paramPGCFeedsInfo = paramPGCFeedsInfo.msg_pgc_pic_info_list.get().iterator();
    while (paramPGCFeedsInfo.hasNext())
    {
      Object localObject = (articlesummary.PGCPicInfo)paramPGCFeedsInfo.next();
      SocializeFeedsInfo.PGCPicInfo localPGCPicInfo = new SocializeFeedsInfo.PGCPicInfo();
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_md5.has()) {
        localPGCPicInfo.jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject).bytes_pic_md5.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_url.has()) {
        localPGCPicInfo.jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject).bytes_pic_url.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint32_pic_height.has()) {
        localPGCPicInfo.jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject).uint32_pic_height.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint32_pic_width.has()) {
        localPGCPicInfo.jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject).uint32_pic_width.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).is_animation.has()) {
        localPGCPicInfo.jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject).is_animation.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_thumbnail_url.has()) {
        localPGCPicInfo.jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject).bytes_thumbnail_url.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_desc.has()) {
        localPGCPicInfo.d = ((articlesummary.PGCPicInfo)localObject).bytes_pic_desc.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint64_gallery_index.has()) {
        localPGCPicInfo.jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject).uint64_gallery_index.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).msg_video_info.has())
      {
        SocializeFeedsInfo.PGCVideoInfo localPGCVideoInfo = new SocializeFeedsInfo.PGCVideoInfo();
        localObject = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject).msg_video_info.get();
        if (((articlesummary.PGCVideoInfo)localObject).bytes_pic_md5.has()) {
          localPGCVideoInfo.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).bytes_pic_url.has()) {
          localPGCVideoInfo.d = ((articlesummary.PGCVideoInfo)localObject).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).bytes_vid.has()) {
          localPGCVideoInfo.e = ((articlesummary.PGCVideoInfo)localObject).bytes_vid.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).uint32_duration.has()) {
          localPGCVideoInfo.jdField_a_of_type_Int = ((articlesummary.PGCVideoInfo)localObject).uint32_duration.get();
        }
        if (((articlesummary.PGCVideoInfo)localObject).uint32_busi_type.has()) {
          localPGCVideoInfo.jdField_b_of_type_Int = ((articlesummary.PGCVideoInfo)localObject).uint32_busi_type.get();
        }
        localPGCPicInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo = localPGCVideoInfo;
      }
      paramPGCFeedsInfo1.jdField_a_of_type_JavaUtilArrayList.add(localPGCPicInfo);
    }
  }
  
  private static boolean b(List<SocializeFeedsInfo.PGCVideoInfo> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", followCount=" + this.jdField_a_of_type_Int + ", followStatus=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.jdField_c_of_type_Int + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */