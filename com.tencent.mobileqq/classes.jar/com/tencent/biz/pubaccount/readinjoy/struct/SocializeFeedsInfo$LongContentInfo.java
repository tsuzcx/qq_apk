package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.oidb.articlesummary.articlesummary.ArticleBasicInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.OutsideLinkInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class SocializeFeedsInfo$LongContentInfo
{
  public int a;
  public SocializeFeedsInfo.ArticleBasicInfo a;
  public SocializeFeedsInfo.OutsideLinkInfo a;
  public SocializeFeedsInfo.PGCVideoInfo a;
  
  public SocializeFeedsInfo$LongContentInfo() {}
  
  public SocializeFeedsInfo$LongContentInfo(articlesummary.LongContentInfo paramLongContentInfo)
  {
    this.jdField_a_of_type_Int = paramLongContentInfo.enum_long_content_card_type.get();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ArticleBasicInfo = new SocializeFeedsInfo.ArticleBasicInfo(paramLongContentInfo.msg_article_basic_ingo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$OutsideLinkInfo = new SocializeFeedsInfo.OutsideLinkInfo(paramLongContentInfo.msg_outside_link_info);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo = new SocializeFeedsInfo.PGCVideoInfo(paramLongContentInfo.msg_pgc_video_info);
  }
  
  public articlesummary.LongContentInfo a()
  {
    articlesummary.LongContentInfo localLongContentInfo = new articlesummary.LongContentInfo();
    localLongContentInfo.enum_long_content_card_type.set(this.jdField_a_of_type_Int);
    localLongContentInfo.msg_article_basic_ingo.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ArticleBasicInfo.a());
    localLongContentInfo.msg_outside_link_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$OutsideLinkInfo.a());
    localLongContentInfo.msg_pgc_video_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.a());
    localLongContentInfo.setHasFlag(true);
    return localLongContentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo
 * JD-Core Version:    0.7.0.1
 */